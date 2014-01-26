package com.expedia.zipcode.service;

import java.util.Map;

/**
 * The Interface IZIPCodeService contains the method to reterieve the JSON data from the weather API
 */
public interface IZIPCodeService {

    /**
     * This API retrieve the data from weather API on the basis of ZIP code and set the required data from the JSON
     * results into Map
     * 
     * @param zipCode
     *            the ZIP code entered by user
     * @return the weather details
     */
    public Map<String, String> getWeatherDetails(String zipCode);
}
