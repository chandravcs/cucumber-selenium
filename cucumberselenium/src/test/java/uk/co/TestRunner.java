package uk.co;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/", glue = { "uk.co.stepdefs" }, plugin = {
		"com.cucumber.listener.ExtentCucumberFormatter:target/extent-reports/extent-report.html" }, monochrome = true)
public class TestRunner {

	@BeforeClass
	public static void setup() {
//		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
//		extentProperties.setReportPath("output/myreport.html");
//		extentProperties.setProjectName("MyProject");
	}

	@AfterClass
	public static void writeExtentReport() {
		System.out.println(">> " + System.getProperty("user.dir") + "/src/test/resources/extent-config.xml");
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir") + "/src/test/resources/extent-config.xml"));
	}

}
