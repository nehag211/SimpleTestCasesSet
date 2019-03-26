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
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_038Tests {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private HomePOM homePOM;
	private ELTC_008POM eltc_008POM;
	private ELTC_038POM eltc_038POM;
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
		eltc_038POM= new ELTC_038POM(driver);
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
	//Create Group
	@Test
	public void createStudentGroup() {
		eltc_008POM.clickOnCourseLink(properties.getProperty("searchCourseName"));//Click on Course name
		eltc_038POM.clickOnGroupsLink();// Click on Group Link
		eltc_038POM.clickOnNewCroup();// Click on Create a new Group
		eltc_038POM.enterNumOfGroup(properties.getProperty("groupNumber"));// Pass Number of groups
		eltc_038POM.proccedToCreateGroup();// Click on Proceed to group cretaion
		eltc_038POM.enterGroupName(properties.getProperty("groupName"));// Enter the group name
		eltc_038POM.clickOnCreateGroup();// Click on Create Group after entring grou name
		eltc_038POM.clickOnAddGroupMemLink();// Click on Add new members
		eltc_038POM.selectNewMembers();// Select members
		eltc_038POM.clickOnSaveSetting();// Click on save Setting 
		eltc_038POM.clickOnEditSetting();// Click on Edit Setting
		eltc_038POM.clickOnSelfRegistration();// Click on Self Registration
		eltc_038POM.clickOnSelfUnRegistration();//Click on self-unregistration
		eltc_038POM.clickOnSaveFinalSetting();// Click on afte saving the Settings
		String actualTitle= eltc_038POM.getPageTitle();// Get page Title
		String expectedTitle="eLearning - eLearning - Selenium WebDriver - Groups";
		Assert.assertEquals(actualTitle, expectedTitle);// Assert on Page title
	}

}
