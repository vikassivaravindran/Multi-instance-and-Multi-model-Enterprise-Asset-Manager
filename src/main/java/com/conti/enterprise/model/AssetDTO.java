/**
 * 
 */
package com.conti.enterprise.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Vikas Siva Ravindran
 *
 */
@Entity(name="Assets")
public class AssetDTO {

	@Id
	private int id;

	private String name;

	private String asset_tag;

	private int status_id;

	private int model_id;

	private String serial;

	private String _snipeit_hpam_reference_3;

	public AssetDTO(int id, String name, String asset_tag, int status_id, int model_id, String serial,
			String _snipeit_hpam_reference_3) {
		super();
		this.id = id;
		this.name = name;
		this.asset_tag = asset_tag;
		this.status_id = status_id;
		this.model_id = model_id;
		this.serial = serial;
		this._snipeit_hpam_reference_3 = _snipeit_hpam_reference_3;
	}

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

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public int getModel_id() {
		return model_id;
	}

	public void setModel_id(int model_id) {
		this.model_id = model_id;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String get_snipeit_hpam_reference_3() {
		return _snipeit_hpam_reference_3;
	}

	public void set_snipeit_hpam_reference_3(String _snipeit_hpam_reference_3) {
		this._snipeit_hpam_reference_3 = _snipeit_hpam_reference_3;
	}

	@Override
	public String toString() {
		return "AssetDTO [id=" + id + ", " + (name != null ? "name=" + name + ", " : "")
				+ (asset_tag != null ? "asset_tag=" + asset_tag + ", " : "") + "status_id=" + status_id + ", model_id="
				+ model_id + ", " + (serial != null ? "serial=" + serial + ", " : "")
				+ (_snipeit_hpam_reference_3 != null ? "_snipeit_hpam_reference_3=" + _snipeit_hpam_reference_3 : "")
				+ "]";
	}

	public AssetDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
