/**
 * 
 */
package com.ahaverty.autoglucose.test;

import java.util.ArrayList;
import java.util.List;

import com.ahaverty.autoglucose.rest.RestUtility;
import com.ahaverty.autoglucose.rest.pojo.Log;
import com.ahaverty.autoglucose.rest.pojo.LogEntry;

/**
 * @author Alan Haverty
 *
 */
public class DeleteDuplicateReadings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RestUtility restUtility = new RestUtility();
		
		Log log = restUtility.getMeasurements();
		
		List<String> removedIds = new ArrayList<String>();
		
		
		for(LogEntry logEntry : log.getLogEntry()) {
			innerloop:
			for(LogEntry logEntry2 : log.getLogEntry()) {
				try{
					if((logEntry.getBloodGlucoseMeasurement() > 1) && removedIds.contains(logEntry.getId()) == false && logEntry.getId().equals(logEntry2.getId()) == false && logEntry.getBloodGlucoseMeasurement().equals(logEntry2.getBloodGlucoseMeasurement()) && logEntry.getDateOfEntry().equals(logEntry2.getDateOfEntry())) {
						System.out.println("Deleting entry: " + logEntry.getBloodGlucoseMeasurement() + " at " + logEntry.getDateOfEntry());
						
						restUtility.deleteMeasurement(logEntry);
						
						removedIds.add(logEntry.getId());
						removedIds.add(logEntry2.getId());
						
						break innerloop;
					}
				} catch(NullPointerException e) {
				}
			}
		}
		

	}

}
