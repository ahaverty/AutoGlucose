/**
 * 
 */
package com.ahaverty.autoglucose.data;

import org.joda.time.Period;

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

		double measurementDifferencePrecision = 0.5;	//TODO add to config file or static var class
		int timeDifferencePrecision = 1;

		boolean exists = false;

		for (LogEntry logEntry : log.getLogEntry()) {
			
			if(logEntry.getBloodGlucoseMeasurement() != null){
			
				//TODO change to looser comparison due to live server using seconds
				
				Period timeDifference = new Period(measurement.getDateTime(), logEntry.getDateTimeLocal());
				
				boolean timeMatches = timeDifference.getMinutes() < timeDifferencePrecision;
				
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
