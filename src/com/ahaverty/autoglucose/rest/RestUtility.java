/**
 * 
 */
package com.ahaverty.autoglucose.rest;

import java.util.UUID;

import org.json.simple.JSONObject;

import com.ahaverty.autoglucose.data.Measurement;
import com.ahaverty.autoglucose.rest.pojo.Log;

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
		String id = UUID.randomUUID().toString(); // TODO handle non unique
													// response for UUID
		JSONObject putMeasurementPayload = new RequestCreator().measurementReading(id, measurement.getDateTime(), utcOffset, location, measurement.getReadingMgdl(), points);
		return restService.putMeasurement(id, putMeasurementPayload);
	}

	public Log getMeasurements() {
		return restService.getLogEntry();
	}

}
