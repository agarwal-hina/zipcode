package com.expedia.zipcode.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.expedia.zipcode.model.form.CountryForm;
import com.expedia.zipcode.model.validator.CountryValiator;
import com.expedia.zipcode.service.IZIPCodeService;

/**
 * The Class MainController contains the method to show and retrieve details of Weather API.
 */
@Controller
public class MainController {

    @Autowired
    private CountryValiator countryValidator;

    @Autowired
    private IZIPCodeService zipCodeService;

    /** The Constant VIEW_NAME. */
    private static final String VIEW_NAME = "zipcodePage";

    /** The Constant MODEL_FORM_NAME. */
    private static final String MODEL_FORM_NAME = "country";

    /**
     * This method returns view page to enter the zip code
     * 
     * @param countryForm
     *            the country form
     * @return the main page
     */
    @RequestMapping(method = RequestMethod.GET, value = "/mainpage")
    public ModelAndView getMainPage(@ModelAttribute(MODEL_FORM_NAME) CountryForm countryForm) {
        ModelAndView modelAndView = new ModelAndView(VIEW_NAME);
        modelAndView.addObject(MODEL_FORM_NAME, countryForm);
        return modelAndView;
    }

    /**
     * This API is to retrieve the response from the UI
     * 
     * @param countryForm
     *            the country form
     * @param bindingResult
     *            the binding result
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.POST, value = "/weatherdetails")
    public ModelAndView retrieveResponse(@Validated @ModelAttribute(MODEL_FORM_NAME) CountryForm countryForm,
        final BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView(VIEW_NAME);
        this.countryValidator.validate(countryForm, bindingResult);
        if (!bindingResult.hasErrors()) {
            Map<String, String> weatherDetails = this.zipCodeService.getWeatherDetails(countryForm.getZipCode());
            modelAndView.addObject("weatherDetails", weatherDetails);
        }
        return modelAndView;
    }
}
