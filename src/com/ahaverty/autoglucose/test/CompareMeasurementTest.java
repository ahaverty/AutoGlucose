/**
 * 
 */
package com.ahaverty.autoglucose.test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.joda.time.DateTime;

import com.ahaverty.autoglucose.data.CompareUtility;
import com.ahaverty.autoglucose.data.Measurement;
import com.ahaverty.autoglucose.rest.RestService;
import com.ahaverty.autoglucose.rest.pojo.Log;
import com.ahaverty.autoglucose.rest.pojo.LogEntry;

/**
 * @author Alan Haverty
 *
 */
public class CompareMeasurementTest {
	
	private static Logger logger = Logger.getLogger("CompareMeasurementTestLogger");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		FileReader fileReader = null;
//		try {
//			String filePath = PutMeasurementTest.class.getClassLoader().getResource("test_csv_data/DiaryU100834463.csv").getPath();
//			logger.info("filePath: " + filePath);
//			fileReader = new FileReader(filePath);
//		} catch (FileNotFoundException e) {
//			logger.log(Level.SEVERE, "Unable to find csv file");
//		}
		
		Measurement testMeasurement = SampleDataCreator.generateSampleMeasurement(new DateTime(1438070439 * 1000L), 151.2);
		List<Measurement> measurements = new ArrayList<Measurement>();
		measurements.add(testMeasurement);
		
		RestService restService = new RestService();
		Log log = restService.getMeasurements();
		
		Log resizedLog = new Log();
		
		List<LogEntry> logEntries = new ArrayList<LogEntry>();
		logEntries.add(log.getLogEntry().get(0));
		logEntries.add(log.getLogEntry().get(1));
		logEntries.add(log.getLogEntry().get(2));
		
		resizedLog.setLogEntry(logEntries);
		
		//List<Measurement> measurements = CsvUtility.extractMeasurementsFromCsvData(CsvUtility.readCsvFile(fileReader));
		
		for(Measurement measurement : measurements) {
			boolean exists = CompareUtility.doesMeasurementExist(measurement, resizedLog);
			if(exists) {
				logger.info("exists: " + exists);
			}
		}

	}

}
