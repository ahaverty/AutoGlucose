/**
 * 
 */
package com.ahaverty.autoglucose.rest;

/**
 * @author Alan Haverty
 *
 */
public class Verifications {
	private long date;
	private String logEntryAttribute;
	private boolean verifiesDateOfEntry;
	private String sourceClass;
	private String sourceType;
	private String sourceId;
	private String recordReference;
	
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public String getLogEntryAttribute() {
		return logEntryAttribute;
	}
	public void setLogEntryAttribute(String logEntryAttribute) {
		this.logEntryAttribute = logEntryAttribute;
	}
	public boolean isVerifiesDateOfEntry() {
		return verifiesDateOfEntry;
	}
	public void setVerifiesDateOfEntry(boolean verifiesDateOfEntry) {
		this.verifiesDateOfEntry = verifiesDateOfEntry;
	}
	public String getSourceClass() {
		return sourceClass;
	}
	public void setSourceClass(String sourceClass) {
		this.sourceClass = sourceClass;
	}
	public String getSourceType() {
		return sourceType;
	}
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	public String getRecordReference() {
		return recordReference;
	}
	public void setRecordReference(String recordReference) {
		this.recordReference = recordReference;
	}
}
