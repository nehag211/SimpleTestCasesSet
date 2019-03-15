/*
 * author: Neha Gupta
 */
package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.bean.ELTC_007Bean;
import com.training.generics.ScreenShot;
import com.training.pom.ELTC_007POM;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_007Tests {
	// Variable/Object Reference declaration
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private HomePOM homePOM;
	private ELTC_007POM eltc_007POM;
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
		homePOM = new HomePOM(driver);
		eltc_007POM=new ELTC_007POM(driver);
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
		
		eltc_007POM.clickCreateCourse();
		eltc_007POM.enterCourseName(properties.getProperty("courseName"));// Enter CouserName
		eltc_007POM.clickAdvancedSetting();
		eltc_007POM.selectCategory(properties.getProperty("categoryName"));// Enter Category Nae
		eltc_007POM.selectCouserCode(properties.getProperty("courseCode"));// Enter Course Code
		eltc_007POM.selectCourseLang(properties.getProperty("courseLanguage"));// Enter Course Language
		screenShot.captureScreenShot("Course Details Entered");
		eltc_007POM.clickOnSubmit();// Click on Submit button
		eltc_007POM.clickOnAddIntroIcon();//Clickon add intro Icon
		eltc_007POM.addIntroText(properties.getProperty("introText"));// Enter Text
		Thread.sleep(2000);
		eltc_007POM.clickOnSaveIntroTextIcon();// Click on Save intro button
		String actual= eltc_007POM.getUpdatedTextMesage();// get updated text confirmation message
		String expected= "Intro was updated";
		Assert.assertEquals(actual, expected);// Sucessfully text updation message
	}

}
