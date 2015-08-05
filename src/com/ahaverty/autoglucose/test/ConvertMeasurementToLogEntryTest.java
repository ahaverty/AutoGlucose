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
import com.ahaverty.autoglucose.data.TransformUtility;
import com.ahaverty.autoglucose.file.CsvUtility;
import com.ahaverty.autoglucose.rest.pojo.LogEntry;

/**
 * @author Alan Haverty
 *
 */
public class ConvertMeasurementToLogEntryTest {
	
	private static Logger logger = Logger.getLogger("ConvertMeasurementToLogEntryTestLogger");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileReader fileReader = null;
		try {
			String filePath = PutMeasurementTest.class.getClassLoader().getResource("test_csv_data/DiaryU100834463.csv").getPath();
			logger.info("filePath: " + filePath);
			fileReader = new FileReader(filePath);
		} catch (FileNotFoundException e) {
			logger.log(Level.SEVERE, "Unable to find csv file");
		}
		
		List<Measurement> measurements = CsvUtility.extractMeasurementsFromCsvData(CsvUtility.readCsvFile(fileReader));
		
		for (Measurement measurement : measurements) {
			LogEntry logEntry = TransformUtility.convertMeasurementToLogEntry(measurement);
			logger.info("logEntry: " + logEntry.toString());
			logger.info("measurement: " + measurement.toString());
		}

	}

}
