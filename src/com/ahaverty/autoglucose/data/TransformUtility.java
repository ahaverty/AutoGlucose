/**
 * 
 */
package com.ahaverty.autoglucose.data;

import java.util.ArrayList;
import java.util.List;

import com.ahaverty.autoglucose.data.Measurement.ReadingCategory;
import com.ahaverty.autoglucose.rest.pojo.LogEntry;
import com.ahaverty.autoglucose.rest.pojo.Tag;

/**
 * Utility class for converting between different objects
 * 
 * @author Alan Haverty
 *
 */
public class TransformUtility {

	/**
	 * Converts a Measurement object into a Log Entry object
	 * 
	 * @param measurement
	 * @return a LogEntry object with the DateOfEntryLocal, Tags,
	 *         BloodGlucoseMeasurement fields set from the provided Measurement
	 *         object
	 */
	public static LogEntry convertMeasurementToLogEntry(Measurement measurement) {
		LogEntry logEntry = new LogEntry();

		List<Tag> tags = new ArrayList<Tag>();
		tags.add(convertReadingCategoryToTag(measurement.getReadingCategory()));

		logEntry.setDateOfEntryLocal(measurement.getDateTime().getMillis());
		logEntry.setTags(tags);
		logEntry.setBloodGlucoseMeasurement(measurement.getReadingMgdl());

		return logEntry;
	}

	/**
	 * Converts a ReadingCategory enum to a Tag used to set the live server
	 * 
	 * @param readingCategory
	 * @return
	 */
	public static Tag convertReadingCategoryToTag(ReadingCategory readingCategory) {
		Tag tag = new Tag();
		
		if(readingCategory != null){
			switch (readingCategory) {
			case AFTER_MEAL:
				tag.setName("after_meal");
				break;
			case BEFORE_MEAL:
				tag.setName("before_meal");
				break;
			case CONTROL_TEST:
				break;
			case OTHER:
				tag.setName("general");
				break;
			default:
				break;
			}
		}

		return tag;
	}

	public static Measurement convertLogEntryToMeasurement(LogEntry logEntry) {
		Measurement measurement = new Measurement();

		// measurement.setDateTime(new
		// DateTime(logEntry.getDateOfEntryLocal()));
		// measurement.

		return measurement;
	}

}
