/**
 * 
 */
package com.conti.enterprise.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Vikas Siva Ravindran
 *
 */
public class StatusLabel {

	@JsonProperty(value = "id")
	private int id;

	@JsonProperty(value = "name")
	private String name;

	@JsonProperty(value = "status_type")
	private String status_type;

	@JsonProperty(value = "status_meta")
	private String status_meta;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus_type() {
		return status_type;
	}

	public void setStatus_type(String status_type) {
		this.status_type = status_type;
	}

	public String getStatus_meta() {
		return status_meta;
	}

	public void setStatus_meta(String status_meta) {
		this.status_meta = status_meta;
	}

	public StatusLabel(int id, String name, String status_type, String status_meta) {
		super();
		this.id = id;
		this.name = name;
		this.status_type = status_type;
		this.status_meta = status_meta;
	}

	public StatusLabel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "StatusLabel [id=" + id + ", " + (name != null ? "name=" + name + ", " : "")
				+ (status_type != null ? "status_type=" + status_type + ", " : "")
				+ (status_meta != null ? "status_meta=" + status_meta : "") + "]";
	}

}
