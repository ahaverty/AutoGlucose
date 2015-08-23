/**
 * 
 */
package com.ahaverty.autoglucose.data;

import org.joda.time.DateTime;

/**
 * Measurement class for storing a measurement taken from the accu cheks csv file
 * @author Alan Haverty
 *
 */
public class Measurement {
	
	final private int unitDifference = 18;

	public enum ReadingCategory {
		BEFORE_MEAL, AFTER_MEAL, OTHER, CONTROL_TEST;
	};

	public enum Unit {
		MMOL("mmol/l"), MGDL("mg/dl");
		private final String value;

		private Unit(String s) {
			value = s;
		}

		public boolean equalsName(String otherName) {
			return (otherName == null) ? false : value.equals(otherName);
		}

		public String toString() {
			return this.value;
		}
	};


	private DateTime dateTime;
	private double readingMgdl;
	private Unit unit;
	private boolean temperatureWarning;
	private boolean outOfTargetRange;
	private boolean other;
	private ReadingCategory readingCategory;
	
	
	public DateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	public boolean isTemperatureWarning() {
		return temperatureWarning;
	}
	public void setTemperatureWarning(boolean temperatureWarning) {
		this.temperatureWarning = temperatureWarning;
	}
	public boolean isOutOfTargetRange() {
		return outOfTargetRange;
	}
	public void setOutOfTargetRange(boolean outOfTargetRange) {
		this.outOfTargetRange = outOfTargetRange;
	}
	public boolean isOther() {
		return other;
	}
	public void setOther(boolean other) {
		this.other = other;
	}
	public ReadingCategory getReadingCategory() {
		return readingCategory;
	}
	public void setReadingCategory(ReadingCategory readingCategory) {
		this.readingCategory = readingCategory;
	}
	public double getReadingMgdl() {
		return readingMgdl;
	}
	public void setReadingMgdl(double readingMgdl) {
		this.readingMgdl = readingMgdl;
	}
	public double getReadingMmol() {
		return readingMgdl/unitDifference;
	}
	public void setReadingMmol(double readingMmol) {
		this.readingMgdl = readingMmol*unitDifference;
	}
	@Override
	public String toString() {
		return "Measurement [dateTime=" + dateTime + ", readingMgdl="
				+ readingMgdl + ", unit=" + unit + ", temperatureWarning="
				+ temperatureWarning + ", outOfTargetRange=" + outOfTargetRange
				+ ", other=" + other + ", readingCategory=" + readingCategory
				+ "]";
	}
	
	

}
