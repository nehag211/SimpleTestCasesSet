/*
 * author: Neha Gupta
 */
package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELTC_008POM {

	private WebDriver driver;

	public ELTC_008POM(WebDriver driver) {//Page Factory Intilaiztion Constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(tagName = "a")// Created courselink locator
	private List<WebElement> addedCourseLink;

	@FindBy(xpath = "//a[@id=\"istooldesc_7563\"]")// Coursename link locator
	private WebElement courseNameLink;
	
	@FindBy(xpath="//div[@class=\"actions\"]/a")// CourseDes locator
	private WebElement courseDesLink;
	
	@FindBy(id="course_description_title")// Course Des Title locator
	private WebElement courseTitle;
	
	@FindBy(xpath="//body/p[@xpath=\"1\"]")// CourseContent Locator
	private WebElement courseContent;
	
	@FindBy(name="submit")// Submit Button Locator
	private WebElement saveButton;
	
	@FindBy(xpath="//div[contains(text(),'The description has been updated')]")// Updated des confirmation locator
	private WebElement desUpdatedConfimrationMessage;

	public void clickOnCourseLink(String courseName) {// CourseLink Code
		List<WebElement> courseListValue= addedCourseLink;// Get all values in list
		for (WebElement courseList : courseListValue) {
			if (courseList.getText().equalsIgnoreCase(courseName)) {// select value as mentioned in the properties files
				courseList.click();
				break;
			}
		}
	}
	public void clickOnCourseNameLink()// click on CourseName created
	{
		courseNameLink.click();
	}
	public void clickOnCourseDesLink()// Enter Course Description
	{
		courseDesLink.click();
	}
	public void enterCourseTitle(String titleName)// Enter Course Title
	{
		courseTitle.clear();
		courseTitle.sendKeys(titleName);
	}
	public void enterCourseContent(String contentName)// Enter Content Name
	{
		courseContent.clear();
		courseContent.sendKeys(contentName);
	}
	public void clickOnSaveButton()// Click on save button
	{
		saveButton.click();
	}
	public String getUpdatedDesConfirmationMessage()// Get the updated description confirmation message
	{
		return desUpdatedConfimrationMessage.getText();
	}
}
