/**
 * 
 */
package com.ahaverty.autoglucose.file;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alan Haverty
 *
 */
public class DriveWatch {

	final static long pollInterval = 1000; // TODO set in properties file
	final static String reportFolderPath = "ACCU-CHEK Mobile\\Reports";

	public static List<File> getCsvFilesOnceMeterConnects() {

		boolean meterFound = false;
		
		List<File> csvFiles = new ArrayList<File>();

		try {

			List<Path> roots = asList(FileSystems.getDefault().getRootDirectories());
			while (meterFound == false) {
				Thread.sleep(pollInterval);

				List<Path> newRoots = asList(FileSystems.getDefault().getRootDirectories());
				for (Path newRoot : newRoots) {

					// Check if any of the polled roots was not in the list of
					// previous polled roots
					if (!roots.contains(newRoot)) {
						// Do something when new route found in here
						System.out.println("New drive detected: " + newRoot);
						meterFound = true;

						Path reportFolder = Paths.get(newRoot.toString(), reportFolderPath);

						if (Files.isDirectory(reportFolder)) {
							System.out.println("Found report folder");
							csvFiles = getCsvFiles(reportFolder);
						} else {
							System.out.println("Did not find report folder");
						}

					}
				}
				roots = newRoots;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		return csvFiles;
	}

	private static <T> List<T> asList(Iterable<T> i) {
		if (i instanceof List) {
			return (List<T>) i;
		}

		List<T> l = new ArrayList<>();
		for (T t : i) {
			l.add(t);
		}
		return l;
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
