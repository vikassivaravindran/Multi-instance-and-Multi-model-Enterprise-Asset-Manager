/**
 * 
 */
package com.conti.enterprise.model;

import java.io.Serializable;

/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;*/

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Vikas Siva Ravindran
 *
 */
//@Entity(name = "assets")
public class Asset implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//@Id
	@JsonProperty(value="id")
	private int id;

	@JsonProperty(value="name")
	private String name;

	@JsonProperty(value="asset_tag")
	private String asset_tag;

	@JsonProperty(value="serial")
	private String serial;

	@JsonProperty(value="model")
	private Model model;
	
	@JsonProperty(value="status_label")
	private StatusLabel status_label;
	
	 @JsonProperty(value="custom_fields")
	private CustomFields customFields;

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

	public String getAsset_tag() {
		return asset_tag;
	}

	public void setAsset_tag(String asset_tag) {
		this.asset_tag = asset_tag;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public StatusLabel getStatus_label() {
		return status_label;
	}

	public void setStatus_label(StatusLabel status_label) {
		this.status_label = status_label;
	}

	public CustomFields getCustomFields() {
		return customFields;
	}

	public void setCustomFields(CustomFields customFields) {
		this.customFields = customFields;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Asset(int id, String name, String asset_tag, String serial, Model model, StatusLabel status_label,
			CustomFields customFields) {
		super();
		this.id = id;
		this.name = name;
		this.asset_tag = asset_tag;
		this.serial = serial;
		this.model = model;
		this.status_label = status_label;
		this.customFields = customFields;
	}

	public Asset() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Asset [id=" + id + ", " + (name != null ? "name=" + name + ", " : "")
				+ (asset_tag != null ? "asset_tag=" + asset_tag + ", " : "")
				+ (serial != null ? "serial=" + serial + ", " : "") + (model != null ? "model=" + model + ", " : "")
				+ (status_label != null ? "status_label=" + status_label + ", " : "")
				+ (customFields != null ? "customFields=" + customFields : "") + "]";
	}
	 
	 
	
}
	
	