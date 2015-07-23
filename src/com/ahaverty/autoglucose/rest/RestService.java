/**
 * 
 */
package com.ahaverty.autoglucose.rest;

import java.util.List;
import java.util.UUID;

import org.json.simple.JSONObject;

import com.ahaverty.autoglucose.data.Measurement;

/**
 * @author Alan Haverty
 *
 */
public class RestService {

	private RestUtility restUtility;

	public RestService() {
		restUtility = new RestUtility();
	}

	public boolean putMeasurement(Measurement measurement, long utcOffset, String location, int points) {
		// TODO configure utcOffset and points from properties file!
		String id = UUID.randomUUID().toString(); // TODO handle non unique
													// response for UUID
		JSONObject putMeasurementPayload = new RequestCreator().measurementReading(id, measurement.getDateTime(), utcOffset, location, measurement.getReadingMgdl(), points);
		return restUtility.putMeasurement(id, putMeasurementPayload);
	}

	public List<MeasurementEntry> getMeasurements() {
		return restUtility.getMeasurements();
	}

}
