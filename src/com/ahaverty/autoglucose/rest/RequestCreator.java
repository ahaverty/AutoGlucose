/**
 * 
 */
package com.ahaverty.autoglucose.rest;

import org.joda.time.DateTime;
import org.json.simple.JSONObject;

/**
 * Class for creating the REST payloads
 * @author Alan Haverty
 *
 */
public class RequestCreator {

	private String logEntry = "logEntry";
	private String id = "id";
	private String dateOfEntry = "dateOfEntry";
	private String dateOfEntryUtcOffsetSeconds = "dateOfEntryUtcOffsetSeconds";
	private String location = "location";
	private String glucoseMeasurement = "bloodGlucoseMeasurement";
	private String points = "points";

	/**
	 * Creates the JSON payload for creating a new measurement reading
	 * @param id The unique UUID to associate with the reading
	 * @param time The UTC time the reading was taken
	 * @param utcOffset The offset in seconds for the current time zone
	 * @param location The string label for the current location
	 * @param glucoseMeasurement The value for the blood glusoce measurement in MGDL
	 * @param points The amount of mysugr points to assign to this entry
	 * @return The JSON object
	 */
	@SuppressWarnings("unchecked")
	public JSONObject measurementReading(String id, DateTime time, long utcOffset, String location, double glucoseMeasurement, int points) {
		JSONObject inner = new JSONObject();

		long adjustedTime = time.getMillis() / 1000;

		inner.put(this.id, id);
		inner.put(this.dateOfEntry, adjustedTime);
		inner.put(this.dateOfEntryUtcOffsetSeconds, utcOffset);
		inner.put(this.location, location);
		inner.put(this.glucoseMeasurement, glucoseMeasurement);
		inner.put(this.points, points);

		JSONObject outer = new JSONObject();
		outer.put(logEntry, inner);

		return outer;
	}

}
