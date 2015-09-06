
package com.ahaverty.autoglucose.rest.pojo;

import java.io.Serializable;
import java.util.HashMap;
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

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "date",
    "logEntryAttribute",
    "verifiesDateOfEntry",
    "sourceClass",
    "sourceType",
    "sourceId",
    "recordReference"
})
public class Verification implements Serializable {

	private static final long serialVersionUID = 6440837728390037934L;
	@JsonProperty("date")
    private Integer date;
    @JsonProperty("logEntryAttribute")
    private String logEntryAttribute;
    @JsonProperty("verifiesDateOfEntry")
    private Boolean verifiesDateOfEntry;
    @JsonProperty("sourceClass")
    private String sourceClass;
    @JsonProperty("sourceType")
    private String sourceType;
    @JsonProperty("sourceId")
    private String sourceId;
    @JsonProperty("recordReference")
    private String recordReference;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The date
     */
    @JsonProperty("date")
    public Integer getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    @JsonProperty("date")
    public void setDate(Integer date) {
        this.date = date;
    }

    /**
     * 
     * @return
     *     The logEntryAttribute
     */
    @JsonProperty("logEntryAttribute")
    public String getLogEntryAttribute() {
        return logEntryAttribute;
    }

    /**
     * 
     * @param logEntryAttribute
     *     The logEntryAttribute
     */
    @JsonProperty("logEntryAttribute")
    public void setLogEntryAttribute(String logEntryAttribute) {
        this.logEntryAttribute = logEntryAttribute;
    }

    /**
     * 
     * @return
     *     The verifiesDateOfEntry
     */
    @JsonProperty("verifiesDateOfEntry")
    public Boolean getVerifiesDateOfEntry() {
        return verifiesDateOfEntry;
    }

    /**
     * 
     * @param verifiesDateOfEntry
     *     The verifiesDateOfEntry
     */
    @JsonProperty("verifiesDateOfEntry")
    public void setVerifiesDateOfEntry(Boolean verifiesDateOfEntry) {
        this.verifiesDateOfEntry = verifiesDateOfEntry;
    }

    /**
     * 
     * @return
     *     The sourceClass
     */
    @JsonProperty("sourceClass")
    public String getSourceClass() {
        return sourceClass;
    }

    /**
     * 
     * @param sourceClass
     *     The sourceClass
     */
    @JsonProperty("sourceClass")
    public void setSourceClass(String sourceClass) {
        this.sourceClass = sourceClass;
    }

    /**
     * 
     * @return
     *     The sourceType
     */
    @JsonProperty("sourceType")
    public String getSourceType() {
        return sourceType;
    }

    /**
     * 
     * @param sourceType
     *     The sourceType
     */
    @JsonProperty("sourceType")
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    /**
     * 
     * @return
     *     The sourceId
     */
    @JsonProperty("sourceId")
    public String getSourceId() {
        return sourceId;
    }

    /**
     * 
     * @param sourceId
     *     The sourceId
     */
    @JsonProperty("sourceId")
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * 
     * @return
     *     The recordReference
     */
    @JsonProperty("recordReference")
    public String getRecordReference() {
        return recordReference;
    }

    /**
     * 
     * @param recordReference
     *     The recordReference
     */
    @JsonProperty("recordReference")
    public void setRecordReference(String recordReference) {
        this.recordReference = recordReference;
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
        return new HashCodeBuilder().append(date).append(logEntryAttribute).append(verifiesDateOfEntry).append(sourceClass).append(sourceType).append(sourceId).append(recordReference).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Verification) == false) {
            return false;
        }
        Verification rhs = ((Verification) other);
        return new EqualsBuilder().append(date, rhs.date).append(logEntryAttribute, rhs.logEntryAttribute).append(verifiesDateOfEntry, rhs.verifiesDateOfEntry).append(sourceClass, rhs.sourceClass).append(sourceType, rhs.sourceType).append(sourceId, rhs.sourceId).append(recordReference, rhs.recordReference).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
