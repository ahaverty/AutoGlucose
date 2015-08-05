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
	public static boolean isMeasurementExist(Measurement measurement, Log log) {

		boolean exists = false;

		for (LogEntry logEntry : log.getLogEntry()) {
			
			//TODO time millis format differs and blood glucose measurement is rounded on live server. Make comparison looser/smarter

			boolean timeMatches = measurement.getDateTime().getMillis() == logEntry.getDateOfEntryLocal();
			if (timeMatches) {

				boolean readingMatches = measurement.getReadingMgdl() == logEntry.getBloodGlucoseMeasurement();
				if (readingMatches) {
					exists = true;
				}
			}
		}
		return exists;
	}
}
