/*
 * author: Neha Gupta
 */
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

import com.training.bean.ELTC_007Bean;
import com.training.generics.ScreenShot;
import com.training.pom.ELTC_007POM;
import com.training.pom.ELTC_008POM;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_008Tests {
	//Varibale/Object Reference 
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private HomePOM homePOM;
	private ELTC_007POM eltc_007POM;
	private ELTC_008POM eltc_008POM;
	private static Properties properties;
	private ScreenShot screenShot;

	// Pre-Condition: Read Properties Files
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	//Pre Condition: Launch and Open the browser; Enter UserName and Password. 
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);// Launch the broswer
		loginPOM = new LoginPOM(driver);
		homePOM = new HomePOM(driver);
		eltc_007POM= new ELTC_007POM(driver);
		eltc_008POM= new ELTC_008POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);// Open the broswer
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		loginPOM.sendUserName(properties.getProperty("username"));// Enter UserName
		loginPOM.sendPassword(properties.getProperty("password"));// Enter Password
		loginPOM.clickLoginBtn();// Click on Login Button
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();// Quit the browser
	}
	@Test
	public void addCourseTitleAndDes() throws InterruptedException
	{
		eltc_008POM.clickOnCourseLink(properties.getProperty("searchCourseName"));// Click on Course created
		eltc_008POM.clickOnCourseNameLink();// Click on click name
		eltc_008POM.clickOnCourseDesLink();// Click on des link
		eltc_008POM.enterCourseTitle(properties.getProperty("courseTitle"));// Enter Course Title
		Thread.sleep(2000);
		//eltc_008POM.enterCourseContent(properties.getProperty("courseContent"));// Enter Course Content
		eltc_008POM.clickOnSaveButton();// Click on save button
		String actual= eltc_008POM.getUpdatedDesConfirmationMessage();// Get Updated des message
		String expected="The description has been updated";
		Assert.assertEquals(actual, expected);// Validating that Des has been updated sucessfully.
	}
}
