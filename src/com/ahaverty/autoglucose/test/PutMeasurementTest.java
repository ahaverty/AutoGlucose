/**
 * 
 */
package com.ahaverty.autoglucose.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;

import com.ahaverty.autoglucose.file.CsvUtility;
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

		FileReader fileReader = null;
		try {
			//Convert to prop file setting;
			//TODO fix file input and setup in properties file
			fileReader = new FileReader("/test_csv_data/DiaryU100834463.csv");
		} catch (FileNotFoundException e) {
			System.err.println("Unable to find csv file");
		}
		
		CsvUtility.extractMeasurementsFromCsvData(CsvUtility.readCsvFile(fileReader));

//		RequestCreator requestCreator = new RequestCreator();

//		JSONObject putMeasurementPayload = requestCreator.measurementReading(id, currentDateTime, utcOffset, location, convertMmolToMgdl(glucoseMeasurement), points);
//		System.out.println(putMeasurementPayload);

//		RestSender sender = new RestSender();
//		int returnCode = sender.sendReading(id, putMeasurementPayload);

//		System.out.println("Return Code: " + returnCode);
	}

}
