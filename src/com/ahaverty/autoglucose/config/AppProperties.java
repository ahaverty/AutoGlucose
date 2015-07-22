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

	private String baseUri;
	private String logEntriesUri;
	private String username;
	private String password;

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

}
