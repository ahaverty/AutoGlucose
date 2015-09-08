/**
 * 
 */
package com.ahaverty.autoglucose.rest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

import org.json.simple.JSONObject;

import com.ahaverty.autoglucose.data.Measurement;
import com.ahaverty.autoglucose.rest.pojo.Log;
import com.ahaverty.autoglucose.rest.pojo.LogEntry;

/**
 * @author Alan Haverty
 *
 */
public class RestUtility {

	private RestService restService;

	public RestUtility() {
		restService = new RestService();
	}

	public boolean putMeasurement(Measurement measurement, long utcOffset, String location, int points) {
		// TODO configure utcOffset and points from properties file!
		// TODO handle non unique response for UUID
		String id = UUID.randomUUID().toString();
		JSONObject putMeasurementPayload = new RequestCreator().measurementReading(id, measurement.getDateTime(), utcOffset, location, measurement.getReadingMgdl(), points);
		return restService.putMeasurement(id, putMeasurementPayload);
	}

	public Log getMeasurements() {
		return restService.getLogEntry();
	}
	
	public void deleteMeasurement(LogEntry logEntry) {
		restService.deleteMeasurement(logEntry.getId());
	}

	/**
	 * Test whether a successful response of 200 is returned from the url.
	 * 
	 * @param urlString
	 * @return
	 */
	public boolean verifyConnection(String urlString) {
		boolean canConnect = false;

		try {
			URL url = new URL(urlString);
			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
			urlConn.connect();

			canConnect = HttpURLConnection.HTTP_OK == urlConn.getResponseCode();
		} catch (IOException e) {
			System.err.println("Error creating HTTP connection");
			canConnect = false;
		}
		return canConnect;
	}

}
