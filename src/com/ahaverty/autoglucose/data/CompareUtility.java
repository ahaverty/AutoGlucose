/**
 * 
 */
package com.ahaverty.autoglucose.data;

import com.ahaverty.autoglucose.rest.pojo.Log;
import com.ahaverty.autoglucose.rest.pojo.LogEntry;

/**
 * @author Alan Haverty
 *
 */
public class CompareUtility {

	/**
	 * Checks if a measurement exists in the provided log by comparing the time
	 * and blood glucose measurement.
	 * 
	 * @param measurement
	 * @param log
	 * @return True if the time and measurement matches
	 */
	public static boolean doesMeasurementExist(Measurement measurement, Log log) {

		double differencePrecision = 0.5;	//TODO add to config file or static var class

		boolean exists = false;

		for (LogEntry logEntry : log.getLogEntry()) {

			boolean timeMatches = measurement.getDateTime().equals(logEntry.getDateTimeLocal());
			if (timeMatches) {
				
				//Convert negative values to positive for comparison checker
				double measurementDifference =  Math.abs(measurement.getReadingMgdl() - logEntry.getBloodGlucoseMeasurement());
				
				boolean readingMatches = measurementDifference < differencePrecision;
				if (readingMatches) {
					exists = true;
					//Break out of the for loop if a match is found
					break;
				}
			}
		}
		return exists;
	}
}
