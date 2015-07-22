/**
 * 
 */
package com.ahaverty.autoglucose.rest;

import org.joda.time.DateTime;
import org.json.simple.JSONObject;

/**
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
	
	@SuppressWarnings("unchecked")
	public JSONObject measurementReading(String id, DateTime time, long utcOffset, String location, double glucoseMeasurement, int points) {
		JSONObject inner = new JSONObject();
		
		long adjustedTime = time.getMillis()/1000;
		
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
