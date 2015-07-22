/**
 * 
 */
package com.ahaverty.autoglucose.test;

import java.util.UUID;

import org.joda.time.DateTime;
import org.json.simple.JSONObject;

import com.ahaverty.autoglucose.config.AppProperties;
import com.ahaverty.autoglucose.rest.RequestCreator;
import com.ahaverty.autoglucose.rest.RestSender;

/**
 * @author Alan Haverty
 *
 */
public class PutMeasurementTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AppProperties prop = new AppProperties();
		
		//Site Data
		final String baseUri = prop.getBaseUri();
		
		//Test Data
		String id = UUID.randomUUID().toString();
		DateTime currentDateTime = new DateTime();
		long utcOffset = 3600;
		String location = "15 Seabury Lawns";
		double glucoseMeasurement = 13.97;
		int points = 2;
		
		RequestCreator requestCreator = new RequestCreator();
		
		JSONObject putMeasurementPayload = requestCreator.measurementReading(id, currentDateTime, utcOffset, location, convertMmolToMgdl(glucoseMeasurement), points);
		
		System.out.println(putMeasurementPayload);
		
		RestSender sender = new RestSender(baseUri);
		int returnCode = sender.sendReading(id, putMeasurementPayload);
		
		System.out.println("Return Code: " + returnCode);
	}
	
	private static double convertMmolToMgdl(double mmolMeasurement) {
		return mmolMeasurement * 18;
	}

}
