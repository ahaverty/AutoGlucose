/**
 * 
 */
package com.ahaverty.autoglucose.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.joda.time.DateTime;

import com.ahaverty.autoglucose.data.Measurement;
import com.ahaverty.autoglucose.rest.pojo.Log;

/**
 * @author Alan Haverty
 *
 */
public class BackupUtility {
	Logger logger = Logger.getLogger("BackupUtility");
	File backupDir;

	public BackupUtility() {
		backupDir = new File("backups");

		if (!backupDir.exists()) {
			backupDir.mkdirs();
		}
	}

	private String getCurrentEpoch() {
		return Long.toString(DateTime.now().getMillis());
	}
	
	private void writeObjectToFile(File file, Object object) {
		try {
			FileOutputStream fout = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(object);
			oos.close();
		} catch (Exception ex) {
			logger.log(Level.SEVERE, "Failed to serialize object of type " + object.getClass().getSimpleName() + " to backup file.");
		}
	}

	public void backupLogToFile(Log log) {
		String filename = "logs_backup_" + getCurrentEpoch() + ".ser";
		
		File logBackupFile = new File(backupDir, filename);

		try {
			logBackupFile.createNewFile();
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Failed to create log backup file!");
		}

		writeObjectToFile(logBackupFile, log);

		logger.info("Backing up Log to file complete.");
	}
	
	public void backupMeasurementsToFile(List<Measurement> measurements) {
		String filename = "measurements_backup_" + getCurrentEpoch() + ".ser";
		
		File measurementsBackupFile = new File(backupDir, filename);

		try {
			measurementsBackupFile.createNewFile();
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Failed to create measurements backup file!");
		}

		writeObjectToFile(measurementsBackupFile, measurements);

		logger.info("Backing up measurements to file complete.");
	}
	
	
}