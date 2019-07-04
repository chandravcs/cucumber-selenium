package uk.co.stepdefs;

import uk.co.util.AppConstants;
import uk.co.util.AppProperties;
import uk.co.util.WebDriverUtil;

public class Home {

	public void navigateToHomePage() {

		WebDriverUtil.getDriver().get(AppProperties.get(AppConstants.APP_URL));
		System.out.println("Starting Automation Test on Aplication (URL) : "+AppProperties.get(AppConstants.APP_URL));
	
	}

}
