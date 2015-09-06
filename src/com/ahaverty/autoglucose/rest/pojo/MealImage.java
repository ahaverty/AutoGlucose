
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
    "id",
    "uploadedAt",
    "takenAt"
})
public class MealImage implements Serializable {

	private static final long serialVersionUID = 990888157620752264L;
	@JsonProperty("id")
    private String id;
    @JsonProperty("uploadedAt")
    private Integer uploadedAt;
    @JsonProperty("takenAt")
    private Integer takenAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The uploadedAt
     */
    @JsonProperty("uploadedAt")
    public Integer getUploadedAt() {
        return uploadedAt;
    }

    /**
     * 
     * @param uploadedAt
     *     The uploadedAt
     */
    @JsonProperty("uploadedAt")
    public void setUploadedAt(Integer uploadedAt) {
        this.uploadedAt = uploadedAt;
    }

    /**
     * 
     * @return
     *     The takenAt
     */
    @JsonProperty("takenAt")
    public Integer getTakenAt() {
        return takenAt;
    }

    /**
     * 
     * @param takenAt
     *     The takenAt
     */
    @JsonProperty("takenAt")
    public void setTakenAt(Integer takenAt) {
        this.takenAt = takenAt;
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
        return new HashCodeBuilder().append(id).append(uploadedAt).append(takenAt).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MealImage) == false) {
            return false;
        }
        MealImage rhs = ((MealImage) other);
        return new EqualsBuilder().append(id, rhs.id).append(uploadedAt, rhs.uploadedAt).append(takenAt, rhs.takenAt).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
