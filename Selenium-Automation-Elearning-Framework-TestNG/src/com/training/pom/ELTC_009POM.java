package com.training.pom;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELTC_009POM {
	
	private WebDriver driver;
	
	public ELTC_009POM(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName = "a")// Created courselink locator
	private List<WebElement> addedCourseLink;
	
	@FindBy(linkText = "Users")// Created courselink locator
	private WebElement userLink;
	
	@FindBy(xpath="//input[@type=\"checkbox\"]")// ChecBox Locator
	private List<WebElement> courseCheckBox;
	
	@FindBy(linkText="Unsubscribe")// UnSubscribe for Course Locator
	private WebElement unSubscribeButton;
	
	public void clickOnCourseLink(String courseName) {// CourseLink Code
		List<WebElement> courseListValue= addedCourseLink;// Get all values in list
		for (WebElement courseList : courseListValue) {
			if (courseList.getText().equalsIgnoreCase(courseName)) {// select value as mentioned in the properties files
				courseList.click();
				break;
			}
		}
	}
	
	public void clickOnUserLink()// Click on User Link
	{
		userLink.click();
	}
	public void selectCourseCheckBox()// Select the checkBox
	{
		List<WebElement> courseCheckBoxList= courseCheckBox;
		for(WebElement courseLink: courseCheckBoxList)
		{
			courseLink.click();
			break;
		}
	}
	public void clickOnUnSubscribe() throws InterruptedException//Click on Subscribe button
	{
		unSubscribeButton.click();
		Thread.sleep(2000);
		Alert alert= driver.switchTo().alert();
		alert.accept();
		
	}
}
