/**
 * 
 */
package com.ahaverty.autoglucose.test;

import org.joda.time.DateTime;

import com.ahaverty.autoglucose.data.Measurement;
import com.ahaverty.autoglucose.data.Measurement.ReadingCategory;

/**
 * @author Alan Haverty
 *
 */
public class SampleDataCreator {

	public static Measurement generateSampleMeasurement(DateTime dateTime, double readingMgdl) {
		Measurement measurement = new Measurement();
		measurement.setDateTime(dateTime);
		measurement.setReadingCategory(ReadingCategory.AFTER_MEAL);
		measurement.setReadingMgdl(readingMgdl);
		measurement.setOutOfTargetRange(true);
		return measurement;
	}

}
