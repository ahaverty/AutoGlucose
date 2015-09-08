/**
 * 
 */
package com.ahaverty.autoglucose.file;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.ahaverty.autoglucose.config.AppProperties;

/**
 * @author Alan Haverty
 *
 */
public class DriveWatchUnix {
	
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger("DriveWatchUnix");
	
	static AppProperties prop = new AppProperties();

	final static long pollInterval = prop.getPollInterval();
	final static String reportFolderPath = prop.getFolderToMonitor();

	public static List<File> getCsvFilesOnceMeterConnects() {

		boolean meterFound = false;
		
		List<File> csvFiles = new ArrayList<File>();

		try {
			Path reportFolder = Paths.get(reportFolderPath);

			while (meterFound == false) {
				Thread.sleep(pollInterval);

				if (Files.isDirectory(reportFolder)) {
					meterFound = true;
					//Disabling logger due to too much activity
					//logger.info("Found report folder");
					csvFiles = getCsvFiles(reportFolder);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		return csvFiles;
	}

	private static List<File> getCsvFiles(Path path) {
		List<File> listOfFiles = new ArrayList<File>();

		File dir = path.toFile();

		if (!dir.isDirectory()) {
			throw new IllegalStateException("Path is not a directory");
		}

		for (File file : dir.listFiles(new RegexFileFilter("@*\\.csv"))) {
			listOfFiles.add(file);
		}

		return listOfFiles;
	}

}
