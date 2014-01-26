package com.expedia.zipcode.model.form;

import java.io.Serializable;

/**
 * The Class CountryForm contains the input field of form
 */
public class CountryForm implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4560880362532453155L;

	/** The zip code. */
	private String zipCode;

	/**
	 * Gets the ZIP code.
	 *
	 * @return the zip code
	 */
	public String getZipCode() {
		return this.zipCode;
	}

	/**
	 * Sets the ZIP code.
	 *
	 * @param zipCode the new zip code
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


}
