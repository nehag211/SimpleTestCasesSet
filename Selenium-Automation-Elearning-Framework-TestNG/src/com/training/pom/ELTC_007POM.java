/*
 * author: Neha Gupta
 */
package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ELTC_007POM {
	private WebDriver driver;

	public ELTC_007POM(WebDriver driver) {// PageFactory Initialization Constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Create a course")// Create a course locator
	private WebElement createCourse;

	@FindBy(name = "title")// Course name locator
	private WebElement courseName;
	
	@FindBy(id = "advanced_params")// Advancesetting locator
	private WebElement advanceSettingButton;

	@FindBy(xpath = "//select[@name=\"category_code\"]")// Cateogry locator
	private WebElement category;

	@FindBy(id = "add_course_wanted_code")// Course code locator
	private WebElement courseCode;

	@FindBy(xpath = "//select[@name=\"course_language\"]")// Course Language locator
	private WebElement courseLanguage;

	@FindBy(name = "submit")// Submit button locator
	private WebElement submitButton;

	@FindBy(xpath = "//em[@class=\"fa fa-file-text\"]")// Add Intro Icon locator
	private WebElement addIntroIcon;

	@FindBy(tagName = "iframe")// Add Intro text locator
	private WebElement addIntroText;

	@FindBy(name = "intro_cmdUpdate")// Save Intro Text locator
	private WebElement saveIntroText;
	
	@FindBy(xpath="//div[contains(text(),'Intro was updated')]")// Updated text confirmation message
	private WebElement getUpdatedTextMessage; 

	public void clickCreateCourse() {// Click on course creation
		createCourse.click();
	}

	public void enterCourseName(String name) {// Enter Course Name
		courseName.clear();
		courseName.sendKeys(name);
	}

	public void clickAdvancedSetting() {// Click on Advance setting button
		advanceSettingButton.click();
	}

	public void selectCategory(String categoryName) {// Select Cateogry from drop down
		Select selCategory = new Select(category);
		selCategory.selectByVisibleText(categoryName);
	}

	public void selectCouserCode(String courseCodeName) {// Enter CourseCode
		courseCode.clear();
		courseCode.sendKeys(courseCodeName);
	}

	public void selectCourseLang(String languageName) {// Select Language from drop down
		Select selCategory = new Select(courseLanguage);
		selCategory.selectByVisibleText(languageName);
	}

	public void clickOnSubmit() {// click on submit button
		submitButton.click();
	}

	public void clickOnAddIntroIcon() {// Click on Add Intro Button
		addIntroIcon.click();
	}

	public void addIntroText(String introText) {// Enter Intro Text
//		driver.switchTo().frame(0);
		addIntroText.click();
		addIntroText.sendKeys(introText);
	}

	public void clickOnSaveIntroTextIcon() {// Click on save button
		saveIntroText.click();
	}
	
	public String getUpdatedTextMesage() {// Click on save button
		return getUpdatedTextMessage.getText();
}
}
