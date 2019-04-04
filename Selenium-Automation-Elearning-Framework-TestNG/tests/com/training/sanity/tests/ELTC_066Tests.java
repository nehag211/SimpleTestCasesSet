package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ELTC_007POM;
import com.training.pom.ELTC_008POM;
import com.training.pom.ELTC_066POM;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_066Tests {
	// Varibale/Object Reference
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private HomePOM homePOM;
	private ELTC_008POM eltc_008POM;
	private ELTC_066POM eltc_066POM;
	private static Properties properties;
	private ScreenShot screenShot;

	// Pre-Condition: Read Properties Files
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	// Pre Condition: Launch and Open the browser; Enter UserName and Password.
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);// Launch the broswer
		loginPOM = new LoginPOM(driver);
		eltc_008POM= new ELTC_008POM(driver);
		eltc_066POM = new ELTC_066POM(driver);
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
		//driver.quit();// Quit the browser
	}
	@Test
	public void createTestAndReport()
	{
		eltc_008POM.clickOnCourseLink(properties.getProperty("searchCourseName"));// Click on Course created
		eltc_066POM.clickOnTestLink();// Click on Test Link
		eltc_066POM.clickOnNewTestLink();// Click on New Test link
		eltc_066POM.enterTestName(properties.getProperty("testName"));// Enter test name
		eltc_066POM.clickOnAdvanceSetting();// Click on advance setting
		eltc_066POM.clickOnfeedBackCheckBox();// Click on feedback link
		eltc_066POM.clickOnStartTimeCheckBox();// Click on enabl start time
		eltc_066POM.clickOnDateTextBox();// Click on date textbox
		eltc_066POM.clickOnMonthDropdown();// Select the month
		eltc_066POM.clickOnYearDropdown();// Select the year
		eltc_066POM.clickOnDate();// Select date
		eltc_066POM.clickOnDatedone();// Click on done date button
		eltc_066POM.enterPassPercentage(properties.getProperty("percentage"));// Enter pass percentage
		eltc_066POM.clickOnProceedToQues();// Click on proceed to questions
		eltc_066POM.clickOnMulChoice();// Click oN mulChoice
		eltc_066POM.enterQuestionName(properties.getProperty("quetsionName"));
		eltc_066POM.enterFirstOption();
	}
}
