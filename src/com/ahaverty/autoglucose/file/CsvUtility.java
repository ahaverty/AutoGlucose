/**
 * 
 */
package com.ahaverty.autoglucose.file;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.ahaverty.autoglucose.data.Measurement;
import com.ahaverty.autoglucose.data.Measurement.ReadingCategory;
import com.ahaverty.autoglucose.data.Measurement.Unit;

/**
 * @author Alan Haverty
 *
 */
public class CsvUtility {

	private static Logger logger = Logger.getLogger("CsvUtilityLogger");

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
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withDelimiter(';').withHeader(FILE_HEADER_MAPPING);

		try {
			csvFileParser = new CSVParser(fileReader, csvFileFormat);
			csvRecords = csvFileParser.getRecords();

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error in CsvFileReader.");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
				csvFileParser.close();
			} catch (IOException e) {
				logger.log(Level.SEVERE, "Error while closing fileReader/csvFileParser.");
				e.printStackTrace();
			}
		}

		return csvRecords;
	}

	public static List<Measurement> extractMeasurementsFromCsvData(List<CSVRecord> csvRecords) {
		List<Measurement> measurements = new ArrayList<Measurement>();

		// Start on 3rd row
		for (int i = 3; i < csvRecords.size(); i++) {
			CSVRecord record = csvRecords.get(i);

			logger.info(record.get(0));

			Measurement measurement = new Measurement();

			DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
			DateTime dateTime = extractDateTime(record.get(date), record.get(time));

			measurement.setDateTime(dateTime);

			double resultReading = Double.parseDouble(record.get(result));

			// TODO add better error handling, possibly separate into new method
			// to extract each csv record
			if (record.get(unit).equalsIgnoreCase("mmol/l")) {
				measurement.setUnit(Unit.MMOL);
				measurement.setReadingMmol(resultReading);
			} else {
				measurement.setUnit(Unit.MGDL);
				measurement.setReadingMgdl(resultReading);
			}

			if (record.get(beforeMeal).equalsIgnoreCase("x")) {
				measurement.setReadingCategory(ReadingCategory.BEFORE_MEAL);
			} else if (record.get(afterMeal).equalsIgnoreCase("x")) {
				measurement.setReadingCategory(ReadingCategory.AFTER_MEAL);
			} else if (record.get(controlTest).equalsIgnoreCase("x")) {
				measurement.setReadingCategory(ReadingCategory.CONTROL_TEST);
			}

			if (record.get(outOfTargetRange).equalsIgnoreCase("x")) {
				measurement.setOutOfTargetRange(true);
			}

			if (record.get(temperatureWarning).equalsIgnoreCase("x")) {
				measurement.setTemperatureWarning(true);
			}

			if (record.get(other).equalsIgnoreCase("x")) {
				measurement.setOther(true);
			}

			measurements.add(measurement);
		}
		
		return measurements;
	}

	/**
	 * Pass in date and time as strings to return a DateTime object
	 * 
	 * @param date
	 *            in the format dd.MM.yyyy
	 * @param time
	 *            in the format HH:mm
	 * @return a date time object parsed with the provided date and time
	 *         provided
	 */
	private static DateTime extractDateTime(String date, String time) {
		String dateTimeCombined = date + " " + time;
		// TODO add better error handling for converting to a date from string
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd.MM.yyyy HH:mm");
		return dateTimeFormatter.parseDateTime(dateTimeCombined);
	}
}
