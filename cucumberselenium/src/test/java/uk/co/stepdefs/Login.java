package uk.co.stepdefs;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.co.util.WebDriverUtil;

public class Login extends Home {

	@Given("^user is on homepage$")
	public void user_is_on_homepage() throws Throwable {
		navigateToHomePage();
	}

	@When("^user navigates to Login Page$")
	public void user_navigates_to_Login_Page() throws Throwable {
		System.out.println(">> user_navigates_to_Login_Page ********************* ");
	}

	@And("^user enters username and Password$")
	public void user_enters_username_and_Password() throws Throwable {
		System.out.println(">> user_enters_username_and_Password ********************* ");
	}

	@Then("^success message is displayed$")
	public void success_message_is_displayed() throws Throwable {
		System.out.println(">> success_message_is_displayed ********************* ");
	}

	@After
	public void embedScreenshot(Scenario scenario) {
		try {
			WebDriver driver = WebDriverUtil.getDriver();
			File scr = ((TakesScreenshot) WebDriverUtil.getDriver()).getScreenshotAs(OutputType.FILE);
			
			String date = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
			final String scnName = scenario.getName().replace(" ", "_");
			File dest = new File(
					(System.getProperty("user.dir") + "/target/extent-reports/"+scnName+"_" + date + ".png"));
			FileUtils.copyFile(scr, dest);
			Thread.sleep(3000);
			System.out.println(">> Taking Screen shot : " + dest);
			Reporter.addScreenCaptureFromPath(dest.getAbsolutePath());

		} catch (Exception somePlatformsDontSupportScreenshots) {
			scenario.write(somePlatformsDontSupportScreenshots.getMessage());
			somePlatformsDontSupportScreenshots.printStackTrace();
		}
	}
}
