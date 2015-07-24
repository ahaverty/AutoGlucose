
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

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "logEntry"
})
public class Measurement {

    @JsonProperty("logEntry")
    private List<LogEntry> logEntry = new ArrayList<LogEntry>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The logEntry
     */
    @JsonProperty("logEntry")
    public List<LogEntry> getLogEntry() {
        return logEntry;
    }

    /**
     * 
     * @param logEntry
     *     The logEntry
     */
    @JsonProperty("logEntry")
    public void setLogEntry(List<LogEntry> logEntry) {
        this.logEntry = logEntry;
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
        return new HashCodeBuilder().append(logEntry).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Measurement) == false) {
            return false;
        }
        Measurement rhs = ((Measurement) other);
        return new EqualsBuilder().append(logEntry, rhs.logEntry).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
