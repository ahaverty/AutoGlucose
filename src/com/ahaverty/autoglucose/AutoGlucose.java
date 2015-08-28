/**
 * 
 */
package com.ahaverty.autoglucose;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ahaverty.autoglucose.config.AppProperties;
import com.ahaverty.autoglucose.data.CompareUtility;
import com.ahaverty.autoglucose.data.Measurement;
import com.ahaverty.autoglucose.file.CsvUtility;
import com.ahaverty.autoglucose.file.DriveWatchUnix;
import com.ahaverty.autoglucose.rest.RestUtility;
import com.ahaverty.autoglucose.rest.pojo.Log;

/**
 * @author Alan Haverty
 *
 */
public class AutoGlucose {

	private static Logger logger = Logger.getLogger("AutoGlucose");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		logger.info("Starting AutoGlucose.");

		while (true) {
			List<File> csvFiles = DriveWatchUnix.getCsvFilesOnceMeterConnects();

			for (File file : csvFiles) {
				compareAndSend(file);
			}
		}

	}

	private static void compareAndSend(File file) {
		int newMeasurementsCount = 0;
		AppProperties prop = new AppProperties();
		String baseUri = prop.getBaseUri();

		RestUtility restUtility = new RestUtility();

		List<Measurement> measurements = null;

		try {
			measurements = CsvUtility.extractMeasurementsFromCsvData(CsvUtility.readCsvFile(new FileReader(file)));
		} catch (FileNotFoundException e) {
			logger.log(Level.SEVERE, "File was not found: "
					+ file.getAbsolutePath());
		}

		// Wait until connection appears
		while (restUtility.verifyConnection(baseUri) == false) {
			logger.log(Level.WARNING, "Waiting for connection to compare and post measurements");
		}

		Log log = restUtility.getMeasurements();

		for (Measurement measurement : measurements) {
			boolean exists = CompareUtility.doesMeasurementExist(measurement, log);

			if (exists == false) {
				restUtility.putMeasurement(measurement, 3600, null, 4);
				logger.info("PUT Measurement: " + measurement.toString());
				newMeasurementsCount++;
			}
		}
		
		if(newMeasurementsCount < 1){
			logger.info("No new measurements were POSTed.");
		} else {
			logger.info(newMeasurementsCount + " new measurements were POSTed.");
		}
	}

}
