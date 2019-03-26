package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ELTC_007POM;
import com.training.pom.ELTC_008POM;
import com.training.pom.ELTC_036POM;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_036Tests {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private HomePOM homePOM;
	private ELTC_036POM eltc_036POM;
	private ELTC_008POM eltc_008POM;
	private static Properties properties;
	private ScreenShot screenShot;
	// Read Properties file
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	// Launching/Opening with E-learning URL
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);//Launch Browser
		loginPOM = new LoginPOM(driver);
		eltc_008POM= new ELTC_008POM(driver);
		eltc_036POM= new ELTC_036POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);// Opening Browser
		loginPOM.sendUserName(properties.getProperty("username"));// Enter Username
		loginPOM.sendPassword(properties.getProperty("password"));// Enter Password
		loginPOM.clickLoginBtn();// Click on Login Button
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();// Quiting the browser
	}
	//Add New Course Details
	@Test
	public void addNewCourseTest() throws InterruptedException {
		eltc_008POM.clickOnCourseLink(properties.getProperty("searchCourseName"));// Search for CourseName
		eltc_036POM.clickOnTestLink();// Click on particular Test
		eltc_036POM.selectParticularTest(properties.getProperty("testName"));//Click on testName
		eltc_036POM.selectGradeLink();// Select Grade link
		String expectedMessage="Congratulations you passed the test!";
		String actualMessage= eltc_036POM.getMessge();// Get Actual Message
		Assert.assertEquals(actualMessage, expectedMessage);// Perform Assertion on Message
		eltc_036POM.selectCheckBox();// Select Checkbox
		eltc_036POM.clickOnCorrectButton();//Click on Send Email, As we have not configured email so just clicking on the button
		}

}
