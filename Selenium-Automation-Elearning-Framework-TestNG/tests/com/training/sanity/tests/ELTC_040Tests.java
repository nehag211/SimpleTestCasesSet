package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ELTC_008POM;
import com.training.pom.ELTC_039POM;
import com.training.pom.ELTC_040POM;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_040Tests {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ELTC_008POM eltc_008POM;
	private ELTC_040POM eltc_040POM;
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
		eltc_040POM= new ELTC_040POM(driver);
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
		driver.quit();// Quiting the browser
	}
	
	@Test
	public void generateReport()
	{
		eltc_008POM.clickOnCourseLink(properties.getProperty("searchCourseName"));//Click on Course name
		eltc_040POM.clickOnProjectLink();// Click on proejct link
		eltc_040POM.clickOnNewProject();// Click on new project
		eltc_040POM.enterProjectTitle(properties.getProperty("projectTitle"));// Enter project title
		eltc_040POM.enterProjectSubTitle(properties.getProperty("projectSubTitle"));// Enter project Subtitle
		eltc_040POM.clickOnSaveProject();// Click on Save button
		String actualMessage= eltc_040POM.getProectAddedConfirmationMessage();// Get current page title
		String expectedMessage= "The project has been added.";
		Assert.assertEquals(actualMessage, expectedMessage);// Assertion on Page Title
		eltc_040POM.clickOnProjectName();// Click on particular project
		String actualWelMessage=eltc_040POM.getWelcomeMessage();
		Assert.assertEquals(actualWelMessage, "Welcome !");
		eltc_040POM.clickOnAddNewTask();// Click on Add new task
		eltc_040POM.enterTaskTitle(properties.getProperty("tasktitle"));// Enter task title
		eltc_040POM.clickOnsaveTask();// Click on Save task
		String actualTaskMessage= eltc_040POM.getTaskAddedMessage();// Get Task Added message
		String expectedTaskMessage= "The article has been added.";
		Assert.assertEquals(actualTaskMessage, expectedTaskMessage);// Assertion on Task added message
		eltc_040POM.clickOnRolesAndManaement();// Click oN Roles and management
		eltc_040POM.addNewRole();// Click on Add new role
		eltc_040POM.addRoleTitle(properties.getProperty("roleTitle"));// enter Role title
		eltc_040POM.clickOnSaverole();// Click on Save role button
		String actualRoleMessage= eltc_040POM.getRoleAddedMessage();// Get Role Added message
		String expectedRoleMessage= "The task has been created";
		Assert.assertEquals(actualRoleMessage, expectedRoleMessage);// Assertion on role added message
		eltc_040POM.clickOnAssignRole();// Click on assign role
		eltc_040POM.clickOnRoleDropDown(properties.getProperty("roleNameValue"));// Click on Role Drop down
		eltc_040POM.clickOnValidateRole();// Click on Validate role
		String actualRoleValidatedMessage= eltc_040POM.getRoleAddedMessage();// Get Role Added message
		String expectedRoleValidatedMessage= "The task has been assigned.";
		Assert.assertEquals(actualRoleValidatedMessage, expectedRoleValidatedMessage);// Assertion on role added message
		eltc_040POM.clickOnUserManagementButton();// Click on User and Management
		eltc_040POM.clickOnUserNameCheckBox();// Clickon user CheckBox
		eltc_040POM.clickOnRegisterButton();// Clickon Register button
		/*String actualRegisterMessage= eltc_040POM.getUserRegisteredMessage();// Get Role Added message
		String expectedRegisterMessage= "The user has been registered";
		Assert.assertEquals(actualRegisterMessage, expectedRegisterMessage);// Assertion on role added message*/
	}

}
