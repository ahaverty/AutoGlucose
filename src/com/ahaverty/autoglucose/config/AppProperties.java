/**
 * 
 */
package com.ahaverty.autoglucose.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Getting property values from the property file in /resources/config.properties
 * @author Alan Haverty
 *
 */
public class AppProperties {

	//TODO add error handling and defaults to properties class
	private String baseUri;
	private String logEntriesUri;
	private String username;
	private String password;
	private String folderToMonitor;
	private String pollInterval;
	private String ignoreTopRows;
	private String ignoreBottomRows;
	private String measurementPrecision;
	private String timePrecision;

	public AppProperties() {

		Properties prop = new Properties();

		try {
			InputStream input = this.getClass().getResourceAsStream("/config.properties");

			if (input == null) {
				throw new RuntimeException("Unable to find config.properties file");
			}

			prop.load(input);

			input.close();

			this.baseUri = prop.getProperty("baseUri");
			this.logEntriesUri = prop.getProperty("logEntriesUri");
			this.username = prop.getProperty("username");
			this.password = prop.getProperty("password");
			this.folderToMonitor = prop.getProperty("folderToMonitor");
			this.pollInterval = prop.getProperty("pollInterval");
			this.ignoreTopRows = prop.getProperty("ignoreTopRows");
			this.ignoreBottomRows = prop.getProperty("ignoreBottomRows");
			this.measurementPrecision = prop.getProperty("measurementPrecision");
			this.timePrecision = prop.getProperty("timePrecision");

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public String getBaseUri() {
		return baseUri;
	}

	public String getLogEntriesUri() {
		return logEntriesUri;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFolderToMonitor() {
		return folderToMonitor;
	}

	public long getPollInterval() {
		return Long.parseLong(pollInterval);
	}

	public int getIgnoreTopRows() {
		return Integer.parseInt(ignoreTopRows);
	}

	public int getIgnoreBottomRows() {
		return Integer.parseInt(ignoreBottomRows);
	}

	public double getMeasurementPrecision() {
		return Double.parseDouble(measurementPrecision);
	}

	public double getTimePrecision() {
		return Double.parseDouble(timePrecision);
	}

}
