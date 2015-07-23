/**
 * 
 */
package com.ahaverty.autoglucose.rest;

import java.io.IOException;
import java.util.UUID;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;

import com.ahaverty.autoglucose.config.AppProperties;
import com.ahaverty.autoglucose.data.Measurement;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

/**
 * Setup REST connection and methods for making service calls
 * 
 * @author Alan Haverty
 *
 */
public class RestService {

	Logger logger = Logger.getLogger("RestLogger");
	AppProperties prop = new AppProperties();

	final private String baseUri = prop.getBaseUri();
	final private String logEntriesUri = prop.getLogEntriesUri();

	private Client client;

	/**
	 * Initialise the Rest Sender instance by setting up the client connection
	 * and authentication filters
	 */
	public RestService() {
		setup();
	}

	private void setup() {
		client = Client.create();
		// loggerToFileSetup();
		client.addFilter(new HTTPBasicAuthFilter(prop.getUsername(), prop.getPassword()));
	}

	@SuppressWarnings("unused")
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
	 * @return The return code returned by the server
	 */
	private boolean sendReading(String id, JSONObject payload) {

		boolean postSuccess = false;
		ObjectMapper mapper = new ObjectMapper();
		String apiPut = baseUri + logEntriesUri + id;

		logger.info("API URI: " + apiPut);

		WebResource webResource = client.resource(apiPut);
		ClientResponse response = null;

		try {
			response = webResource.accept(MediaType.APPLICATION_JSON_TYPE).type(MediaType.APPLICATION_JSON_TYPE).put(ClientResponse.class, mapper.writeValueAsString(payload));
		} catch (UniformInterfaceException | ClientHandlerException
				| IOException e) {
			logger.log(Level.SEVERE, "Failed after accept");
		}

		if (response.getStatus() == 200) {
			postSuccess = true;
		}

		return postSuccess;

	}

	public boolean postMeasurement(Measurement measurement, long utcOffset, String location, int points) {
		// TODO configure utcOffset and points from properties file!
		String id = UUID.randomUUID().toString();
		JSONObject putMeasurementPayload = new RequestCreator().measurementReading(id, measurement.getDateTime(), utcOffset, location, measurement.getReadingMgdl(), points);
		return sendReading(id, putMeasurementPayload);
	}

}
