/**
 * 
 */
package com.ahaverty.autoglucose.test;

import com.ahaverty.autoglucose.rest.LogEntry;
import com.ahaverty.autoglucose.rest.RestService;

/**
 * @author Alan Haverty
 *
 */
public class PutMeasurementTest {

	/**
	 * Creates a measurement using PUT
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Test Data
//		DateTime currentDateTime = new DateTime();
//		long utcOffset = 3600;
//		String location = "15 Seabury Lawns";
//		double glucoseMeasurement = 13.97;
//		int points = 2;
		
		
		RestService restService = new RestService();
		LogEntry logEntry = restService.getMeasurements();
		System.out.println(logEntry);

//		RequestCreator requestCreator = new RequestCreator();

//		JSONObject putMeasurementPayload = requestCreator.measurementReading(id, currentDateTime, utcOffset, location, convertMmolToMgdl(glucoseMeasurement), points);
//		System.out.println(putMeasurementPayload);

//		RestSender sender = new RestSender();
//		int returnCode = sender.sendReading(id, putMeasurementPayload);

//		System.out.println("Return Code: " + returnCode);
	}

}
