package com.expedia.zipcode;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.expedia.zipcode.model.validator.CountryValiator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext_test.xml" })
public class ValidationTest {

    @Autowired
    private CountryValiator countryValidator;
    
	@Test
	public void validateZIPCode() {
	    boolean isValid = this.countryValidator.validateZIPCode("94117");
	    Assert.assertTrue("Valid ZIP code", isValid);
	}

}
