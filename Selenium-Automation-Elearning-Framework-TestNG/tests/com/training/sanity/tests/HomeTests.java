/*
 **** author: Neha
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

import com.training.generics.ScreenShot;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class HomeTests {
	//Varaible/Object declarartion
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private HomePOM homePOM;
	private static Properties properties;
	private ScreenShot screenShot;

	//Read and Load Properties files
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	
	// Launching and Opening browser 
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);//Launch broswer based on input provided in properties file
		loginPOM = new LoginPOM(driver);
		homePOM = new HomePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		loginPOM.sendUserName(properties.getProperty("username"));// Enter username
		loginPOM.sendPassword(properties.getProperty("password"));// Enter password
		loginPOM.clickLoginBtn(); // click on login button
		screenShot.captureScreenShot("Login Screen Title");// take screen shot
	}
	
	//Clean Up method: closing/quiting the browser
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	// read Welcomemessage and do the validation
	@Test
	public void verifyWelcomeMsgTest() {
		String expectedWelcomeMessage="Hello"+ properties.getProperty("welcomeMessage") +"and welcome,";
		String actualWelcomeMessage= loginPOM.getWelcomeMessage();
		Assert.assertEquals(actualWelcomeMessage, expectedWelcomeMessage);
	}

}
