package com.ahaverty.autoglucose.rest.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "id", "tags", "modifiedAt", "dateOfEntry",
		"dateOfEntryUtcOffset", "dateOfEntryUtcOffsetSeconds",
		"dateOfEntryLocal", "points", "bloodGlucoseMeasurement",
		"penBolusInjectionUnits", "penBasalInjectionUnits",
		"mealCarbohydrates", "mealDescriptionText", "exerciseDescriptionText",
		"exerciseDuration", "stepsCount", "bloodPressureSystolic",
		"bloodPressureDiastolic", "bodyWeight", "hbA1c", "ketones",
		"locationText", "note", "nutritionalConstituents",
		"bolusFoodInsulinUnits", "locationType", "locationLatitude",
		"locationLongitude", "bolusCorrectionInsulinUnits", "verifications",
		"mealImages" })
public class LogEntry {

	@JsonProperty("id")
	private String id;
	@JsonProperty("tags")
	private List<Tag> tags = new ArrayList<Tag>();
	@JsonProperty("modifiedAt")
	private Long modifiedAt;
	@JsonProperty("dateOfEntry")
	private Long dateOfEntry;
	@JsonProperty("dateOfEntryUtcOffset")
	private Long dateOfEntryUtcOffset;
	@JsonProperty("dateOfEntryUtcOffsetSeconds")
	private Long dateOfEntryUtcOffsetSeconds;
	@JsonProperty("dateOfEntryLocal")
	private Long dateOfEntryLocal;
	@JsonProperty("points")
	private Integer points;
	@JsonProperty("bloodGlucoseMeasurement")
	private Double bloodGlucoseMeasurement;
	@JsonProperty("penBolusInjectionUnits")
	private Integer penBolusInjectionUnits;
	@JsonProperty("penBasalInjectionUnits")
	private Integer penBasalInjectionUnits;
	@JsonProperty("mealCarbohydrates")
	private Integer mealCarbohydrates;
	@JsonProperty("mealDescriptionText")
	private String mealDescriptionText;
	@JsonProperty("exerciseDescriptionText")
	private String exerciseDescriptionText;
	@JsonProperty("exerciseDuration")
	private Integer exerciseDuration;
	@JsonProperty("stepsCount")
	private Integer stepsCount;
	@JsonProperty("bloodPressureSystolic")
	private Integer bloodPressureSystolic;
	@JsonProperty("bloodPressureDiastolic")
	private Integer bloodPressureDiastolic;
	@JsonProperty("bodyWeight")
	private Integer bodyWeight;
	@JsonProperty("hbA1c")
	private Double hbA1c;
	@JsonProperty("ketones")
	private Double ketones;
	@JsonProperty("locationText")
	private String locationText;
	@JsonProperty("note")
	private String note;
	@JsonProperty("nutritionalConstituents")
	private List<NutritionalConstituent> nutritionalConstituents = new ArrayList<NutritionalConstituent>();
	@JsonProperty("bolusFoodInsulinUnits")
	private Integer bolusFoodInsulinUnits;
	@JsonProperty("locationType")
	private String locationType;
	@JsonProperty("locationLatitude")
	private Double locationLatitude;
	@JsonProperty("locationLongitude")
	private Double locationLongitude;
	@JsonProperty("bolusCorrectionInsulinUnits")
	private Integer bolusCorrectionInsulinUnits;
	@JsonProperty("verifications")
	private List<Verification> verifications = new ArrayList<Verification>();
	@JsonProperty("mealImages")
	private List<MealImage> mealImages = new ArrayList<MealImage>();
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	/**
	 * Non-json property used for comparing dateTime easily with other objects
	 */
	private DateTime dateTimeLocal;

	/**
	 * 
	 * @return The id
	 */
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @return The tags
	 */
	@JsonProperty("tags")
	public List<Tag> getTags() {
		return tags;
	}

	/**
	 * 
	 * @param tags
	 *            The tags
	 */
	@JsonProperty("tags")
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	/**
	 * 
	 * @return The modifiedAt
	 */
	@JsonProperty("modifiedAt")
	public Long getModifiedAt() {
		return modifiedAt;
	}

	/**
	 * 
	 * @param modifiedAt
	 *            The modifiedAt
	 */
	@JsonProperty("modifiedAt")
	public void setModifiedAt(Long modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	/**
	 * 
	 * @return The dateOfEntry
	 */
	@JsonProperty("dateOfEntry")
	public Long getDateOfEntry() {
		return dateOfEntry;
	}

	/**
	 * 
	 * @param dateOfEntry
	 *            The dateOfEntry
	 */
	@JsonProperty("dateOfEntry")
	public void setDateOfEntry(Long dateOfEntry) {
		this.dateTimeLocal = new DateTime(dateOfEntry * 1000L);
		this.dateOfEntry = dateOfEntry;
	}

	/**
	 * 
	 * @return The dateOfEntryUtcOffset
	 */
	@JsonProperty("dateOfEntryUtcOffset")
	public Long getDateOfEntryUtcOffset() {
		return dateOfEntryUtcOffset;
	}

	/**
	 * 
	 * @param dateOfEntryUtcOffset
	 *            The dateOfEntryUtcOffset
	 */
	@JsonProperty("dateOfEntryUtcOffset")
	public void setDateOfEntryUtcOffset(Long dateOfEntryUtcOffset) {
		this.dateOfEntryUtcOffset = dateOfEntryUtcOffset;
	}

	/**
	 * 
	 * @return The dateOfEntryUtcOffsetSeconds
	 */
	@JsonProperty("dateOfEntryUtcOffsetSeconds")
	public Long getDateOfEntryUtcOffsetSeconds() {
		return dateOfEntryUtcOffsetSeconds;
	}

	/**
	 * 
	 * @param dateOfEntryUtcOffsetSeconds
	 *            The dateOfEntryUtcOffsetSeconds
	 */
	@JsonProperty("dateOfEntryUtcOffsetSeconds")
	public void setDateOfEntryUtcOffsetSeconds(Long dateOfEntryUtcOffsetSeconds) {
		this.dateOfEntryUtcOffsetSeconds = dateOfEntryUtcOffsetSeconds;
	}

	/**
	 * 
	 * @return The dateOfEntryLocal
	 */
	@JsonProperty("dateOfEntryLocal")
	public Long getDateOfEntryLocal() {
		return dateOfEntryLocal;
	}

	/**
	 * 
	 * @param dateOfEntryLocal
	 *            The dateOfEntryLocal
	 */
	@JsonProperty("dateOfEntryLocal")
	public void setDateOfEntryLocal(Long dateOfEntryLocal) {
		this.dateOfEntryLocal = dateOfEntryLocal;
	}

	/**
	 * Get the joda date time object set in the setDateOfEntryLocal setter
	 * 
	 * @return the local date time
	 */
	public DateTime getDateTimeLocal() {
		return this.dateTimeLocal.minus(this.dateOfEntryUtcOffsetSeconds);
	}

	/**
	 * 
	 * @return The points
	 */
	@JsonProperty("points")
	public Integer getPoints() {
		return points;
	}

	/**
	 * 
	 * @param points
	 *            The points
	 */
	@JsonProperty("points")
	public void setPoints(Integer points) {
		this.points = points;
	}

	/**
	 * 
	 * @return The bloodGlucoseMeasurement
	 */
	@JsonProperty("bloodGlucoseMeasurement")
	public Double getBloodGlucoseMeasurement() {
		return bloodGlucoseMeasurement;
	}

	/**
	 * Blood glucose measurement as MGDL
	 * 
	 * @param bloodGlucoseMeasurement
	 *            The bloodGlucoseMeasurement
	 */
	@JsonProperty("bloodGlucoseMeasurement")
	public void setBloodGlucoseMeasurement(Double bloodGlucoseMeasurement) {
		this.bloodGlucoseMeasurement = bloodGlucoseMeasurement;
	}

	/**
	 * 
	 * @return The penBolusInjectionUnits
	 */
	@JsonProperty("penBolusInjectionUnits")
	public Integer getPenBolusInjectionUnits() {
		return penBolusInjectionUnits;
	}

	/**
	 * 
	 * @param penBolusInjectionUnits
	 *            The penBolusInjectionUnits
	 */
	@JsonProperty("penBolusInjectionUnits")
	public void setPenBolusInjectionUnits(Integer penBolusInjectionUnits) {
		this.penBolusInjectionUnits = penBolusInjectionUnits;
	}

	/**
	 * 
	 * @return The penBasalInjectionUnits
	 */
	@JsonProperty("penBasalInjectionUnits")
	public Integer getPenBasalInjectionUnits() {
		return penBasalInjectionUnits;
	}

	/**
	 * 
	 * @param penBasalInjectionUnits
	 *            The penBasalInjectionUnits
	 */
	@JsonProperty("penBasalInjectionUnits")
	public void setPenBasalInjectionUnits(Integer penBasalInjectionUnits) {
		this.penBasalInjectionUnits = penBasalInjectionUnits;
	}

	/**
	 * 
	 * @return The mealCarbohydrates
	 */
	@JsonProperty("mealCarbohydrates")
	public Integer getMealCarbohydrates() {
		return mealCarbohydrates;
	}

	/**
	 * 
	 * @param mealCarbohydrates
	 *            The mealCarbohydrates
	 */
	@JsonProperty("mealCarbohydrates")
	public void setMealCarbohydrates(Integer mealCarbohydrates) {
		this.mealCarbohydrates = mealCarbohydrates;
	}

	/**
	 * 
	 * @return The mealDescriptionText
	 */
	@JsonProperty("mealDescriptionText")
	public String getMealDescriptionText() {
		return mealDescriptionText;
	}

	/**
	 * 
	 * @param mealDescriptionText
	 *            The mealDescriptionText
	 */
	@JsonProperty("mealDescriptionText")
	public void setMealDescriptionText(String mealDescriptionText) {
		this.mealDescriptionText = mealDescriptionText;
	}

	/**
	 * 
	 * @return The exerciseDescriptionText
	 */
	@JsonProperty("exerciseDescriptionText")
	public String getExerciseDescriptionText() {
		return exerciseDescriptionText;
	}

	/**
	 * 
	 * @param exerciseDescriptionText
	 *            The exerciseDescriptionText
	 */
	@JsonProperty("exerciseDescriptionText")
	public void setExerciseDescriptionText(String exerciseDescriptionText) {
		this.exerciseDescriptionText = exerciseDescriptionText;
	}

	/**
	 * 
	 * @return The exerciseDuration
	 */
	@JsonProperty("exerciseDuration")
	public Integer getExerciseDuration() {
		return exerciseDuration;
	}

	/**
	 * 
	 * @param exerciseDuration
	 *            The exerciseDuration
	 */
	@JsonProperty("exerciseDuration")
	public void setExerciseDuration(Integer exerciseDuration) {
		this.exerciseDuration = exerciseDuration;
	}

	/**
	 * 
	 * @return The stepsCount
	 */
	@JsonProperty("stepsCount")
	public Integer getStepsCount() {
		return stepsCount;
	}

	/**
	 * 
	 * @param stepsCount
	 *            The stepsCount
	 */
	@JsonProperty("stepsCount")
	public void setStepsCount(Integer stepsCount) {
		this.stepsCount = stepsCount;
	}

	/**
	 * 
	 * @return The bloodPressureSystolic
	 */
	@JsonProperty("bloodPressureSystolic")
	public Integer getBloodPressureSystolic() {
		return bloodPressureSystolic;
	}

	/**
	 * 
	 * @param bloodPressureSystolic
	 *            The bloodPressureSystolic
	 */
	@JsonProperty("bloodPressureSystolic")
	public void setBloodPressureSystolic(Integer bloodPressureSystolic) {
		this.bloodPressureSystolic = bloodPressureSystolic;
	}

	/**
	 * 
	 * @return The bloodPressureDiastolic
	 */
	@JsonProperty("bloodPressureDiastolic")
	public Integer getBloodPressureDiastolic() {
		return bloodPressureDiastolic;
	}

	/**
	 * 
	 * @param bloodPressureDiastolic
	 *            The bloodPressureDiastolic
	 */
	@JsonProperty("bloodPressureDiastolic")
	public void setBloodPressureDiastolic(Integer bloodPressureDiastolic) {
		this.bloodPressureDiastolic = bloodPressureDiastolic;
	}

	/**
	 * 
	 * @return The bodyWeight
	 */
	@JsonProperty("bodyWeight")
	public Integer getBodyWeight() {
		return bodyWeight;
	}

	/**
	 * 
	 * @param bodyWeight
	 *            The bodyWeight
	 */
	@JsonProperty("bodyWeight")
	public void setBodyWeight(Integer bodyWeight) {
		this.bodyWeight = bodyWeight;
	}

	/**
	 * 
	 * @return The hbA1c
	 */
	@JsonProperty("hbA1c")
	public Double getHbA1c() {
		return hbA1c;
	}

	/**
	 * 
	 * @param hbA1c
	 *            The hbA1c
	 */
	@JsonProperty("hbA1c")
	public void setHbA1c(Double hbA1c) {
		this.hbA1c = hbA1c;
	}

	/**
	 * 
	 * @return The ketones
	 */
	@JsonProperty("ketones")
	public Double getKetones() {
		return ketones;
	}

	/**
	 * 
	 * @param ketones
	 *            The ketones
	 */
	@JsonProperty("ketones")
	public void setKetones(Double ketones) {
		this.ketones = ketones;
	}

	/**
	 * 
	 * @return The locationText
	 */
	@JsonProperty("locationText")
	public String getLocationText() {
		return locationText;
	}

	/**
	 * 
	 * @param locationText
	 *            The locationText
	 */
	@JsonProperty("locationText")
	public void setLocationText(String locationText) {
		this.locationText = locationText;
	}

	/**
	 * 
	 * @return The note
	 */
	@JsonProperty("note")
	public String getNote() {
		return note;
	}

	/**
	 * 
	 * @param note
	 *            The note
	 */
	@JsonProperty("note")
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * 
	 * @return The nutritionalConstituents
	 */
	@JsonProperty("nutritionalConstituents")
	public List<NutritionalConstituent> getNutritionalConstituents() {
		return nutritionalConstituents;
	}

	/**
	 * 
	 * @param nutritionalConstituents
	 *            The nutritionalConstituents
	 */
	@JsonProperty("nutritionalConstituents")
	public void setNutritionalConstituents(List<NutritionalConstituent> nutritionalConstituents) {
		this.nutritionalConstituents = nutritionalConstituents;
	}

	/**
	 * 
	 * @return The bolusFoodInsulinUnits
	 */
	@JsonProperty("bolusFoodInsulinUnits")
	public Integer getBolusFoodInsulinUnits() {
		return bolusFoodInsulinUnits;
	}

	/**
	 * 
	 * @param bolusFoodInsulinUnits
	 *            The bolusFoodInsulinUnits
	 */
	@JsonProperty("bolusFoodInsulinUnits")
	public void setBolusFoodInsulinUnits(Integer bolusFoodInsulinUnits) {
		this.bolusFoodInsulinUnits = bolusFoodInsulinUnits;
	}

	/**
	 * 
	 * @return The locationType
	 */
	@JsonProperty("locationType")
	public String getLocationType() {
		return locationType;
	}

	/**
	 * 
	 * @param locationType
	 *            The locationType
	 */
	@JsonProperty("locationType")
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	/**
	 * 
	 * @return The locationLatitude
	 */
	@JsonProperty("locationLatitude")
	public Double getLocationLatitude() {
		return locationLatitude;
	}

	/**
	 * 
	 * @param locationLatitude
	 *            The locationLatitude
	 */
	@JsonProperty("locationLatitude")
	public void setLocationLatitude(Double locationLatitude) {
		this.locationLatitude = locationLatitude;
	}

	/**
	 * 
	 * @return The locationLongitude
	 */
	@JsonProperty("locationLongitude")
	public Double getLocationLongitude() {
		return locationLongitude;
	}

	/**
	 * 
	 * @param locationLongitude
	 *            The locationLongitude
	 */
	@JsonProperty("locationLongitude")
	public void setLocationLongitude(Double locationLongitude) {
		this.locationLongitude = locationLongitude;
	}

	/**
	 * 
	 * @return The bolusCorrectionInsulinUnits
	 */
	@JsonProperty("bolusCorrectionInsulinUnits")
	public Integer getBolusCorrectionInsulinUnits() {
		return bolusCorrectionInsulinUnits;
	}

	/**
	 * 
	 * @param bolusCorrectionInsulinUnits
	 *            The bolusCorrectionInsulinUnits
	 */
	@JsonProperty("bolusCorrectionInsulinUnits")
	public void setBolusCorrectionInsulinUnits(Integer bolusCorrectionInsulinUnits) {
		this.bolusCorrectionInsulinUnits = bolusCorrectionInsulinUnits;
	}

	/**
	 * 
	 * @return The verifications
	 */
	@JsonProperty("verifications")
	public List<Verification> getVerifications() {
		return verifications;
	}

	/**
	 * 
	 * @param verifications
	 *            The verifications
	 */
	@JsonProperty("verifications")
	public void setVerifications(List<Verification> verifications) {
		this.verifications = verifications;
	}

	/**
	 * 
	 * @return The mealImages
	 */
	@JsonProperty("mealImages")
	public List<MealImage> getMealImages() {
		return mealImages;
	}

	/**
	 * 
	 * @param mealImages
	 *            The mealImages
	 */
	@JsonProperty("mealImages")
	public void setMealImages(List<MealImage> mealImages) {
		this.mealImages = mealImages;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(tags).append(modifiedAt).append(dateOfEntry).append(dateOfEntryUtcOffset).append(dateOfEntryUtcOffsetSeconds).append(dateOfEntryLocal).append(points).append(bloodGlucoseMeasurement).append(penBolusInjectionUnits).append(penBasalInjectionUnits).append(mealCarbohydrates).append(mealDescriptionText).append(exerciseDescriptionText).append(exerciseDuration).append(stepsCount).append(bloodPressureSystolic).append(bloodPressureDiastolic).append(bodyWeight).append(hbA1c).append(ketones).append(locationText).append(note).append(nutritionalConstituents).append(bolusFoodInsulinUnits).append(locationType).append(locationLatitude).append(locationLongitude).append(bolusCorrectionInsulinUnits).append(verifications).append(mealImages).append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof LogEntry) == false) {
			return false;
		}
		LogEntry rhs = ((LogEntry) other);
		return new EqualsBuilder().append(id, rhs.id).append(tags, rhs.tags).append(modifiedAt, rhs.modifiedAt).append(dateOfEntry, rhs.dateOfEntry).append(dateOfEntryUtcOffset, rhs.dateOfEntryUtcOffset).append(dateOfEntryUtcOffsetSeconds, rhs.dateOfEntryUtcOffsetSeconds).append(dateOfEntryLocal, rhs.dateOfEntryLocal).append(points, rhs.points).append(bloodGlucoseMeasurement, rhs.bloodGlucoseMeasurement).append(penBolusInjectionUnits, rhs.penBolusInjectionUnits).append(penBasalInjectionUnits, rhs.penBasalInjectionUnits).append(mealCarbohydrates, rhs.mealCarbohydrates).append(mealDescriptionText, rhs.mealDescriptionText).append(exerciseDescriptionText, rhs.exerciseDescriptionText).append(exerciseDuration, rhs.exerciseDuration).append(stepsCount, rhs.stepsCount).append(bloodPressureSystolic, rhs.bloodPressureSystolic).append(bloodPressureDiastolic, rhs.bloodPressureDiastolic).append(bodyWeight, rhs.bodyWeight).append(hbA1c, rhs.hbA1c).append(ketones, rhs.ketones).append(locationText, rhs.locationText).append(note, rhs.note).append(nutritionalConstituents, rhs.nutritionalConstituents).append(bolusFoodInsulinUnits, rhs.bolusFoodInsulinUnits).append(locationType, rhs.locationType).append(locationLatitude, rhs.locationLatitude).append(locationLongitude, rhs.locationLongitude).append(bolusCorrectionInsulinUnits, rhs.bolusCorrectionInsulinUnits).append(verifications, rhs.verifications).append(mealImages, rhs.mealImages).append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}
