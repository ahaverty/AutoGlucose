/**
 * 
 */
package com.ahaverty.autoglucose.rest;

import java.util.List;

/**
 * @author Alan Haverty
 *
 */
public class LogEntry {
	
	private List<MeasurementEntry> logEntry;

	public List<MeasurementEntry> getLogEntry() {
		return logEntry;
	}

	public void setLogEntry(List<MeasurementEntry> logEntry) {
		this.logEntry = logEntry;
	}

}
