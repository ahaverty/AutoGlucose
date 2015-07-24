/**
 * 
 */
package com.ahaverty.autoglucose.test;

import com.ahaverty.autoglucose.rest.RestService;
import com.ahaverty.autoglucose.rest.pojo.Log;
import com.ahaverty.autoglucose.rest.pojo.LogEntry;

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
		Log log = restService.getMeasurements();
		System.out.println(log);
		
		for(LogEntry logEntry : log.getLogEntry()) {
			System.out.println(logEntry.getBloodGlucoseMeasurement());
		}

//		RequestCreator requestCreator = new RequestCreator();

//		JSONObject putMeasurementPayload = requestCreator.measurementReading(id, currentDateTime, utcOffset, location, convertMmolToMgdl(glucoseMeasurement), points);
//		System.out.println(putMeasurementPayload);

//		RestSender sender = new RestSender();
//		int returnCode = sender.sendReading(id, putMeasurementPayload);

//		System.out.println("Return Code: " + returnCode);
	}

}
