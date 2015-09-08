/**
 * 
 */
package com.ahaverty.autoglucose;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ahaverty.autoglucose.config.AppProperties;
import com.ahaverty.autoglucose.data.CompareUtility;
import com.ahaverty.autoglucose.data.Measurement;
import com.ahaverty.autoglucose.file.BackupUtility;
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
		
		int fileLastLines = -1;
		
		while (true) {
			List<File> csvFiles = DriveWatchUnix.getCsvFilesOnceMeterConnects();

			if(csvFiles.size() != 1) {
				logger.log(Level.WARNING, "Expecting just 1 csv file, found " + csvFiles.size() + " csv files instead.");
			}
			
			File firstCsvFile = csvFiles.get(0);
			
			int fileLines = 0;
			try {
				fileLines = CsvUtility.countLines(firstCsvFile);
			} catch (IOException e) {
				logger.log(Level.SEVERE, "Failed to count lines in the csv file.");
			}
			
			if(fileLastLines != fileLines) {
				logger.info("New CSV file found, with length: " + fileLines + " lines.");

				fileLastLines = fileLines;
				
				compareAndSend(firstCsvFile);
			}
			
		}

	}

	private static void compareAndSend(File file) {

		BackupUtility backupUtility = new BackupUtility();
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
			return;
		}

		// Wait until connection appears
		while (restUtility.verifyConnection(baseUri) == false) {
			logger.log(Level.WARNING, "Waiting for connection to compare and post measurements");
		}

		Log log = restUtility.getMeasurements();
		
		//Backup everything before doing any work!
		backupUtility.backupLogToFile(log);
		backupUtility.backupMeasurementsToFile(measurements);
		
		//Ensure the GET worked before comparing local to no readings
		if(log.getLogEntry().size() > 0) {

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
				logger.info(newMeasurementsCount + " new measurements were POSTed.\n\n");
			}
		} else {
			logger.info("Failed to GET measurements from server.");
		}
	}

}
