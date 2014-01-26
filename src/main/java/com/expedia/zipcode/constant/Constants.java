package com.expedia.zipcode.constant;

/**
 * The Class Constants contains all the constant used application wide.
 */
public final class Constants {

    /** Constant for URL of weather API with parameterized for city code */
    public static final String WEATHER_API_URL = "http://api.wunderground.com/api/ed044d75b91fb500/conditions/q/%s.json";

    /** Constant for Error key in JSON response of weather API */
    public static final String ERROR_KEY = "error";

    /** Constant for Response key in JSON response of weather API */
    public static final String RESPONSE_KEY = "response";

    /** Constant for Current Observation key in JSON response of weather API */
    public static final String CURRENT_OBS_KEY = "current_observation";

    /** Constant for Display Location key in JSON response of weather API */
    public static final String DISPLAY_LOCATION_KEY = "display_location";

    /** Constant for City Name key in JSON response of weather API */
    public static final String CITY_NAME_KEY = "city";

    /** Constant for State Name key in JSON response of weather API */
    public static final String STATE_NAME_KEY = "state_name";

    /** Constant for Temperature in JSON response of weather API */
    public static final String TEMPERATURE_KEY = "temp_f";
    
    /** Error message for invalid zip code. */
    public static final String INVALID_ZIP_CODE = "invalid zip code format";
    
    /** The zipcode not found. */
    public static final String ZIPCODE_NOT_FOUND = "zipcode not found";
}
