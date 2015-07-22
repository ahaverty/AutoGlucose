/**
 * 
 */
package com.ahaverty.autoglucose.rest;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;

import com.ahaverty.autoglucose.config.AppProperties;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

/**
 * @author Alan Haverty
 *
 */
public class RestSender {

	Logger logger = Logger.getLogger("RestLogger");
	AppProperties prop = new AppProperties();

	private Client client;
	private String baseUri;

	final private String logEntriesUri = prop.getLogEntriesUri();

	public RestSender(String baseUri) {
		this.baseUri = baseUri;
		setup();
	}

	private void setup() {
		client = Client.create();
		// loggerToFileSetup();
		client.addFilter(new HTTPBasicAuthFilter(prop.getUsername(), prop.getPassword()));
	}

	private void loggerToFileSetup() {
		FileHandler fh;

		try {
			// This block configure the logger with handler and formatter
			fh = new FileHandler("rest.log", true);
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param id
	 *            The UUID to associate with the measurement
	 * @param payload
	 *            The JSON object with the measurement data payload
	 * @return The return code
	 */
	public int sendReading(String id, JSONObject payload) {
		ObjectMapper mapper = new ObjectMapper();

		String apiUri = baseUri + logEntriesUri + id;
		
		logger.info("API URI: " +apiUri);

		WebResource webResource = client.resource(apiUri);
		ClientResponse response = null;

		try {
			response = webResource.accept(MediaType.APPLICATION_JSON_TYPE).type(MediaType.APPLICATION_JSON_TYPE).put(ClientResponse.class, mapper.writeValueAsString(payload));
		} catch (UniformInterfaceException | ClientHandlerException
				| IOException e) {
			
			logger.log(Level.SEVERE, "Failed after accept");
			
			e.printStackTrace();
		}

		// check response status code
		if (response.getStatus() == 200) {
			System.out.println("POST success!");
		} else {
			logger.log(Level.SEVERE, "Failed : HTTP error code : "
					+ response.getStatus());
			
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		logger.info(response.getEntity(String.class));

		return response.getStatus();

	}

}
