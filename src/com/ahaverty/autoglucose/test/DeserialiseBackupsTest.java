/**
 * 
 */
package com.ahaverty.autoglucose.test;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

import com.ahaverty.autoglucose.data.Measurement;
import com.ahaverty.autoglucose.rest.pojo.Log;

/**
 * @author Alan Haverty
 *
 */
public class DeserialiseBackupsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			FileInputStream fin = new FileInputStream("C:\\Users\\Alan\\workspace\\AutoGlucose\\resources\\test_ser\\logs_backup_1441502820308.ser");
			ObjectInputStream ois = new ObjectInputStream(fin);
			Log log = (Log) ois.readObject();
			ois.close();

			System.out.println(log.toString());
			
			
			
			FileInputStream fin2 = new FileInputStream("C:\\Users\\Alan\\workspace\\AutoGlucose\\resources\\test_ser\\measurements_backup_1441502827301.ser");
			ObjectInputStream ois2 = new ObjectInputStream(fin2);
			List<Measurement> measurements = (List<Measurement>) ois2.readObject();
			ois2.close();

			System.out.println(measurements.toString());

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
