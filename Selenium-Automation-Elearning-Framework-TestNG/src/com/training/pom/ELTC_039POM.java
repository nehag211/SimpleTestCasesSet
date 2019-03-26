package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELTC_039POM {
	private WebDriver driver;

	public ELTC_039POM(WebDriver driver) {// PageFactory Constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Reporting")// Reporting link locator
	private WebElement reportingLink;
	
	@FindBy(linkText="Followed students")// followed Student Link
	private WebElement followedStudentLink;
	
	@FindBy(id="search_user_keyword")// serach Text Locator
	private WebElement searchKeyword;
	
	@FindBy(id="search_user_submit")// Search Button Button
	private WebElement serachButton;
	
	@FindBy(xpath="//a[contains(text(),'Neha')]//parent::td//following-sibling::td[4]/a")// Student arrow button
	private WebElement studentArrowbutton;
	
	@FindBy(xpath="//a[contains(text(),'Selenium WebDriver')]//parent::td//following-sibling::td[6]/a")// CourseArrow button
	private WebElement courseArrowLink;
	
	@FindBy(xpath="//td[contains(text(),'Test 1')]//following-sibling::td[5]/a")// Quiz button link
	private WebElement quizButton;
	
	@FindBy(xpath="//img[@title='Edit']")// edit Button Locator
	private WebElement editButton;
	
	@FindBy(name="send_notification")// Send Email Checkbox
	private WebElement checkSendEmail;
	
	@FindBy(id="form-email_submit")// Send Email Button
	private WebElement sendEmailButton;
	
	public void clickOnReportingLink() {//Click on Reporting link
		reportingLink.click();
	}
	
	public void clickonFollowedStudent() {//Click on Followed Student
		followedStudentLink.click();
	}

	public void enterSearchStudentName(String uname) {// Click on Search Student Name
		searchKeyword.clear();
		searchKeyword.sendKeys(uname);
	}
	public void clickOnSearchButton()//Click on serch button
	{
		serachButton.click();
	}
	public void clickonStudentArrowButton() {//Click on Student Arrow button
		studentArrowbutton.click();
	}
	public void clickOnCourseArrowButton()// Click on Course arrow link
	{
		courseArrowLink.click();
	}
	public void clickOnQuizButton()// Clickon Quz Icon
	{
		quizButton.click();
	}
	public void clickOnEditButton()// Click on edit buton
	{
		editButton.click();
	}
	public void clickOnSendEmailCheckBox()// Click on Send Email Checkbox
	{
		checkSendEmail.click();
	}
	public void clickOnSendEmailButton()// Click on Send Email Button
	{
		sendEmailButton.click();
	}
	public String getPageTitle()// Get page title
	{
		return driver.getTitle();
	}
}
