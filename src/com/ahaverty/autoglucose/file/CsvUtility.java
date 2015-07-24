/**
 * 
 */
package com.ahaverty.autoglucose.file;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.ahaverty.autoglucose.data.Measurement;

/**
 * @author Alan Haverty
 *
 */
public class CsvUtility {

	final static private String date = "Date";
	final static private String time = "Time";
	final static private String result = "Result";
	final static private String unit = "Unit";
	final static private String temperatureWarning = "Temperature warning";
	final static private String outOfTargetRange = "Out of target range";
	final static private String other = "Other";
	final static private String beforeMeal = "Before meal";
	final static private String afterMeal = "After meal";
	final static private String controlTest = "Control test";

	// CSV file header
	private static final String[] FILE_HEADER_MAPPING = { date, time, result,
			unit, temperatureWarning, outOfTargetRange, other, beforeMeal,
			afterMeal, controlTest };

	public static List<CSVRecord> readCsvFile(Reader fileReader) {

		CSVParser csvFileParser = null;
		List<CSVRecord> csvRecords = null;
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);

		try {
			csvFileParser = new CSVParser(fileReader, csvFileFormat);
			csvRecords = csvFileParser.getRecords();
			
		} catch (Exception e) {
			System.out.println("Error in CsvFileReader.");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
				csvFileParser.close();
			} catch (IOException e) {
				System.out.println("Error while closing fileReader/csvFileParser.");
				e.printStackTrace();
			}
		}
		
		return csvRecords;
	}
	
	
	public static void extractMeasurementsFromCsvData(List<CSVRecord> csvRecords) {
		List<Measurement> measurements = new ArrayList<Measurement>();
		
		//Start on 3rd row
		for (int i = 3; i < csvRecords.size(); i++) {
			CSVRecord record = csvRecords.get(i);
			
			System.out.println(record.get(1));

			Measurement measurement = new Measurement();
			//measurement.set(record.get(1));
			
			measurements.add(measurement);
		}
		
		
	}
}
