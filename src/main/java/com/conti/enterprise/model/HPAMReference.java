/**
 * 
 */
package com.conti.enterprise.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "field", "value", "field_format" })
public class HPAMReference implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("field")
	private String field;
	@JsonProperty("value")
	private String value;
	@JsonProperty("field_format")
	private String fieldFormat;

	@JsonProperty("field")
	public String getField() {
		return field;
	}

	@JsonProperty("field")
	public void setField(String field) {
		this.field = field;
	}

	@JsonProperty("value")
	public String getValue() {
		return value;
	}

	@JsonProperty("value")
	public void setValue(String value) {
		this.value = value;
	}

	@JsonProperty("field_format")
	public String getFieldFormat() {
		return fieldFormat;
	}

	@JsonProperty("field_format")
	public void setFieldFormat(String fieldFormat) {
		this.fieldFormat = fieldFormat;
	}
}
