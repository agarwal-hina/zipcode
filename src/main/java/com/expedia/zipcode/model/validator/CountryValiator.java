/*
 * 
 */
package com.expedia.zipcode.model.validator;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.expedia.zipcode.constant.Constants;
import com.expedia.zipcode.model.form.CountryForm;

/**
 * The Class CountryValiator contains the method to validate the zip code enterd by user from UI
 */
@Component
public class CountryValiator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return CountryForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CountryForm form = (CountryForm) target;
        this.validateZIPCode(form.getZipCode(), errors);
    }

    /**
     * This method validates the ZIP code for below conditions:
     * <ul>
     * <li>ZIP code is not empty</li>
     * <li>ZIP code is Numeric</li>
     * <li>ZIP code is of length 5</li>
     * </ul>
     * 
     * In all exceptional case it will add error to reject the value
     * 
     * @param zipCode
     *            the zip code entered by user on UI
     * @param errors
     *            the errors
     */
    public void validateZIPCode(String zipCode, Errors errors) {
        if (!this.validateZIPCode(zipCode)) {
            errors.rejectValue("zipCode", Constants.INVALID_ZIP_CODE, Constants.INVALID_ZIP_CODE);
        }
    }

    /**
     * This is helping method of validateZipCode.
     * 
     * @param zipCode
     *            the zip code
     * @return true, if successful
     */
    public boolean validateZIPCode(String zipCode) {
        boolean flag = Boolean.TRUE;
        if (StringUtils.isNotEmpty(zipCode)) {
            if (zipCode.length() != 5 || !StringUtils.isNumeric(zipCode)) {
                flag = Boolean.FALSE;
            }
        } else {
            if (zipCode.length() != 5 || !StringUtils.isNumeric(zipCode)) {
                flag = Boolean.FALSE;
            }
        }
        return flag;
    }
}
