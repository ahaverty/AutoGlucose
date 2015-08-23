/**
 * 
 */
package com.ahaverty.autoglucose.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ahaverty.autoglucose.data.Measurement;
import com.ahaverty.autoglucose.file.CsvUtility;


/**
 * @author Alan Haverty
 *
 */
public class PutMeasurementTest {

	private static Logger logger = Logger.getLogger("PutMeasurementTestLogger");

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
		
		
//		RestUtility restService = new RestUtility();
//		Log log = restService.getMeasurements();
//		logger.log(Level.INFO, log.toString());
//		
//		for(LogEntry logEntry : log.getLogEntry()) {
//			logger.log(Level.INFO, logEntry.getBloodGlucoseMeasurement().toString());
//		}

		FileReader fileReader = null;
		try {
			//Convert to prop file setting;
			//TODO fix file input and setup in properties file
			String filePath = PutMeasurementTest.class.getClassLoader().getResource("test_csv_data/DiaryU100834463.csv").getPath();
			logger.info("filePath: " + filePath);
			fileReader = new FileReader(filePath);
		} catch (FileNotFoundException e) {
			logger.log(Level.SEVERE, "Unable to find csv file");
		}
		
		List<Measurement> measurements = CsvUtility.extractMeasurementsFromCsvData(CsvUtility.readCsvFile(fileReader));
		
		for (Measurement measurement : measurements) {
			logger.info(measurement.toString());
		}

//		RequestCreator requestCreator = new RequestCreator();

//		JSONObject putMeasurementPayload = requestCreator.measurementReading(id, currentDateTime, utcOffset, location, convertMmolToMgdl(glucoseMeasurement), points);
//		System.out.println(putMeasurementPayload);

//		RestSender sender = new RestSender();
//		int returnCode = sender.sendReading(id, putMeasurementPayload);

//		System.out.println("Return Code: " + returnCode);
	}

}
