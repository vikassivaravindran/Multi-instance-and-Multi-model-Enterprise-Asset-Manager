/**
 * 
 */
package com.conti.enterprise.model;

import java.io.Serializable;

/**
 * @author Vikas Siva Ravindran
 *
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "HPAM Reference" })
public class CustomFields implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("HPAM Reference")
	private HPAMReference hPAMReference;

	@JsonProperty("HPAM Reference")
	public HPAMReference getHPAMReference() {
		return hPAMReference;
	}

	@JsonProperty("HPAM Reference")
	public void setHPAMReference(HPAMReference hPAMReference) {
		this.hPAMReference = hPAMReference;
	}
	
	
}
