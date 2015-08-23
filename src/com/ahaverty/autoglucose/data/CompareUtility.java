/**
 * 
 */
package com.ahaverty.autoglucose.data;

import org.joda.time.Minutes;

import com.ahaverty.autoglucose.config.AppProperties;
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
		AppProperties prop = new AppProperties();

		double measurementDifferencePrecision = prop.getMeasurementPrecision();
		double timeDifferencePrecisionInMinutes = prop.getTimePrecision();

		boolean exists = false;

		for (LogEntry logEntry : log.getLogEntry()) {
			
			if(logEntry.getBloodGlucoseMeasurement() != null){
			
				int minutesBetween = Minutes.minutesBetween(measurement.getDateTime(), logEntry.getDateTimeLocal()).getMinutes();
				boolean timeMatches = Math.abs(minutesBetween) < timeDifferencePrecisionInMinutes;
				
				if (timeMatches) {
					
					//Convert negative values to positive for comparison checker
					double measurementDifference =  Math.abs(measurement.getReadingMgdl() - logEntry.getBloodGlucoseMeasurement());
					
					boolean readingMatches = measurementDifference < measurementDifferencePrecision;
					if (readingMatches) {
						exists = true;
						//Break out of the for loop if a match is found
						break;
					}
				}
			}
		}
		return exists;
	}
}
