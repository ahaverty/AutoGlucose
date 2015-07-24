/**
 * 
 */
package com.ahaverty.autoglucose.rest;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;

import com.ahaverty.autoglucose.config.AppProperties;
import com.ahaverty.autoglucose.rest.pojo.Log;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.json.JSONConfiguration;

/**
 * @author Alan Haverty
 *
 */
public class RestUtility {

	private Logger logger = Logger.getLogger("RestLogger");
	private AppProperties prop = new AppProperties();
	
	final private String baseUri = prop.getBaseUri();
	final private String logEntriesUri = prop.getLogEntriesUri();
	final private String getMeasurementsUri = "?sortKey=dateOfEntryLocal&sortDirection=desc";

	private Client client;
	private ObjectMapper mapper;

	/**
	 * Initialise the Rest Sender instance by setting up the client connection
	 * and authentication filters
	 */
	public RestUtility() {
		setup();
	}

	private void setup() {
		
		// Create Jersey client
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        client = Client.create(clientConfig);
		client.addFilter(new HTTPBasicAuthFilter(prop.getUsername(), prop.getPassword()));
		
		mapper = new ObjectMapper();
	}
	
	private boolean isResponseSuccess(ClientResponse response) {
		boolean responseSuccessful = false;
		if (response.getStatus() == 200) {
			responseSuccessful = true;
		} else {
			logger.log(Level.SEVERE, "Response returned status: " + response.getStatus() + " @ " + response.getLocation());
		}
		return responseSuccessful;
	}

	/**
	 * @param id
	 *            The UUID to associate with the measurement
	 * @param payload
	 *            The JSON object with the measurement data payload
	 * @return The return code returned by the server
	 */
	public boolean putMeasurement(String id, JSONObject payload) {
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

		return isResponseSuccess(response);
	}
	
	
	public Log getLogEntry() {
		
		Log log = new Log();
		
		String apiGet = baseUri + logEntriesUri + getMeasurementsUri;
		
		WebResource webResource = client.resource(apiGet);
		ClientResponse response = null;

		try {
			response = webResource.accept(MediaType.APPLICATION_JSON_TYPE).type(MediaType.APPLICATION_JSON_TYPE).get(ClientResponse.class);
		} catch (UniformInterfaceException | ClientHandlerException e) {
			logger.log(Level.SEVERE, "Failed after accept");
		}

		if(isResponseSuccess(response)) {
			log = response.getEntity(Log.class);
		} else {
			logger.log(Level.SEVERE, "Failed to parse Log response");
		}
		
		return log;
		
	}
	
}
