/**
 * 
 */
package com.ahaverty.autoglucose.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ahaverty.autoglucose.data.CompareUtility;
import com.ahaverty.autoglucose.data.Measurement;
import com.ahaverty.autoglucose.file.CsvUtility;
import com.ahaverty.autoglucose.rest.RestService;
import com.ahaverty.autoglucose.rest.pojo.Log;

/**
 * @author Alan Haverty
 *
 */
public class CompareLiveMeasurementTest {
	
	private static Logger logger = Logger.getLogger("CompareMeasurementTestLogger");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileReader fileReader = null;
		try {
			String filePath = PutMeasurementTest.class.getClassLoader().getResource("test_csv_data/DiaryU100834463.csv").getPath();
			fileReader = new FileReader(filePath);
		} catch (FileNotFoundException e) {
			logger.log(Level.SEVERE, "Unable to find csv file");
		}
		
		
		RestService restService = new RestService();
		Log log = restService.getMeasurements();
		
		List<Measurement> measurements = CsvUtility.extractMeasurementsFromCsvData(CsvUtility.readCsvFile(fileReader));
		
		for(Measurement measurement : measurements) {
			boolean exists = CompareUtility.doesMeasurementExist(measurement, log);
			if(exists) {
				logger.info("exists: " + exists);
			}
		}

	}

}
