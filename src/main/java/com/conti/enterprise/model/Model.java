/**
 * 
 */
package com.conti.enterprise.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Vikas Siva Ravindran
 *
 */
public class Model {
	
	@JsonProperty(value="id")
	private int id;
	
	@JsonProperty(value="name")
	private String name;

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

	public Model(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Model() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Model [id=" + id + ", " + (name != null ? "name=" + name : "") + "]";
	}

	
	
}
