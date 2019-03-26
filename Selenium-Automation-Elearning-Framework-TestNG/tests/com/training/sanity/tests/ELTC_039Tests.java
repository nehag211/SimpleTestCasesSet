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
import com.training.pom.ELTC_008POM;
import com.training.pom.ELTC_038POM;
import com.training.pom.ELTC_039POM;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_039Tests {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private HomePOM homePOM;
	private ELTC_039POM eltc_039POM;
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
		eltc_039POM= new ELTC_039POM(driver);
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
	@Test
	public void generateStudentReport()
	{
		eltc_039POM.clickOnReportingLink();// Click on Reporting Link
		eltc_039POM.clickonFollowedStudent();// Click on Followed student Link
		eltc_039POM.enterSearchStudentName(properties.getProperty("studentName"));// Enter Student name
		eltc_039POM.clickOnSearchButton();// Click on Search Button
		eltc_039POM.clickonStudentArrowButton();// Click on Sudent Arrow button
		eltc_039POM.clickOnCourseArrowButton();// Click on Course Arrow button
		eltc_039POM.clickOnQuizButton();// Click on quiz button
		eltc_039POM.clickOnEditButton();// Click on Edit button
		eltc_039POM.clickOnSendEmailCheckBox();//Clickon Send Email CheckBox
		eltc_039POM.clickOnSendEmailButton();
		String expectedTitle="eLearning - eLearning - Selenium WebDriver - Learner score";
		String actualTitle= eltc_039POM.getPageTitle();// Get the Actual title
		Assert.assertEquals(actualTitle, expectedTitle);// Perform Assertion on title
	}

}
