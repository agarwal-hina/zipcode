package com.expedia.zipcode.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.expedia.zipcode.constant.Constants;
import com.expedia.zipcode.service.IZIPCodeService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * The Class ZIPCodeServiceImpl {@link IZIPCodeService}
 */
@Service
public class ZIPCodeServiceImpl implements IZIPCodeService {

    @Autowired
    private RestTemplate restTemplate;

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, String> getWeatherDetails(String zipCode) {

        Map<String, String> weatherDetails = new HashMap<String, String>();

        String jsonString = this.restTemplate.getForObject(String.format(Constants.WEATHER_API_URL, zipCode),
            String.class);
        
        Map<String, Object> map = new Gson().fromJson(jsonString, new TypeToken<Map<String, Object>>() {
        }.getType());
        
        Map<String, Object> responseMap = (com.google.gson.internal.LinkedTreeMap<String, Object>) map
            .get(Constants.RESPONSE_KEY);
        
        // This lock will check for error key in response
        if (!responseMap.containsKey(Constants.ERROR_KEY)) {

            Map<String, Object> obsMap = (com.google.gson.internal.LinkedTreeMap<String, Object>) map
                .get(Constants.CURRENT_OBS_KEY);

            Map<String, Object> locMap = ((com.google.gson.internal.LinkedTreeMap<String, Object>) obsMap
                .get(Constants.DISPLAY_LOCATION_KEY));
            weatherDetails.put("cityName", (String) locMap.get(Constants.CITY_NAME_KEY));
            weatherDetails.put("stateName", (String) locMap.get(Constants.STATE_NAME_KEY));
            weatherDetails.put("temperature", String.valueOf(obsMap.get(Constants.TEMPERATURE_KEY)));
        } else {
            weatherDetails.put("error", "zipcode not found");
        }
        return weatherDetails;
    }

}
