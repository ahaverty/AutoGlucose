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

import com.ahaverty.autoglucose.data.CompareUtility;
import com.ahaverty.autoglucose.data.Measurement;
import com.ahaverty.autoglucose.file.CsvUtility;
import com.ahaverty.autoglucose.file.DriveWatch;
import com.ahaverty.autoglucose.rest.RestService;
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

		while(true) {
			List<File> csvFiles = DriveWatch.getCsvFilesOnceMeterConnects();
			
			for(File file : csvFiles){
				compareAndSend(file);
			}
		}
		
	}
	
	private static void compareAndSend(File file) {
		RestService restService = new RestService();
		Log log = restService.getMeasurements();
		
		List<Measurement> measurements = null;
		
		try {
			measurements = CsvUtility.extractMeasurementsFromCsvData(CsvUtility.readCsvFile(new FileReader(file)));
		} catch (FileNotFoundException e) {
			logger.log(Level.SEVERE, "File was not found: " + file.getAbsolutePath());
		}
		
		for(Measurement measurement : measurements) {
			boolean exists = CompareUtility.doesMeasurementExist(measurement, log);
			
			if(exists == false) {
				restService.putMeasurement(measurement, 3600, null, 4);
				logger.info("PUT Measurement: " + measurement.toString());
			}
			
			//logger.info("exists: " + exists + "meas: " + measurement.toString());
		}
	}

}
