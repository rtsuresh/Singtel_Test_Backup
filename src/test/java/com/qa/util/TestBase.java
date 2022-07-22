package com.qa.util;

import static org.hamcrest.MatcherAssert.assertThat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

public class TestBase {

	// Driver instantiation
	public static WebDriver driver = null;

	public static Properties prop;
	public static String strPath;
	public static boolean blnFirstScenario= true;
	
	@Before
	public static void setupSteps() throws Exception 
	{
		UtilityFunctions.ifProcessExistsKill("chrome.exe");

		System.setProperty("webdriver.chrome.driver","/QA/Singtel_CodingTest/Reference/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://todomvc.com/examples/vue/");

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}	

	public static void initialization() throws Exception {
}

	public static byte[] logdump(String path)
	{		
	    // Write code here that turns the phrase above into concrete actions
		byte[] bArray = null;
		Path path1 = Paths.get(path); 
		try { 
			bArray =  Files.readAllBytes(path1); // reading content from byte array
		    
		  } catch (IOException e) 
		  { // TODO Auto-generated catch block
		  e.printStackTrace(); 
		  }
		  return bArray;
	}
	
	public static void cleanupDrivers() throws Exception
	{
		try
		{
			// Close Window
			driver.quit();
		}
		catch(Exception e)
		{
			
		}
		UtilityFunctions.ifProcessExistsKill("chrome.exe");
		
	
	}
	

	@After
	public static void TearDown(Scenario scenario) throws Exception {
						
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		// embed it in the report.
		scenario.embed(screenshot, "image/png","screnshot of desktop");
		cleanupDrivers();
	}
	

}
