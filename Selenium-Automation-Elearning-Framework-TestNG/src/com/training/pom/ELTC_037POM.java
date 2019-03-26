package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELTC_037POM {

	private WebDriver driver;

	public ELTC_037POM(WebDriver driver) {// PageFactory Constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class='content']/a[contains(text(),'Reporting')]")// Report Link Locator
	private WebElement reportLink;
	
	@FindBy(xpath="//img[@title='Details']")// Arrow Locator
	private WebElement reportArrow;
	
	@FindBy(xpath="//img[@title='All attempts']")// Quiz Icon Locator
	private WebElement quizIcon;
	
	@FindBy(xpath="//img[@title='Edit']")// Edit button locator
	private WebElement editIcon;
	
	@FindBy(xpath="//input[@type='checkbox']")// Send email checkbox locator
	private WebElement sendEmailCheckBox;
	
	@FindBy(name="submit")// Submit button locator
	private WebElement correctTest;

	public void clickOnReportLink() {// Click on report link
		reportLink.click();
	}
	public void clickOnreportArrow()// Click on Arrow link
	{
		reportArrow.click();
	}
	public void clickOnQuizIcon()// Click on Quiz Icon
	{
		quizIcon.click();
	}
	public void clickOnEditIcon()// Click on Edit Icon
	{
		editIcon.click();
	}
	public void checkSendEmail()// Select Send Email Ceckbox
	{
		sendEmailCheckBox.click();
	}
	public void clickOnSendEmail()// Clickon send email
	{
		correctTest.click();
	}
	public String getPageTitle()// Get page title
	{
		return driver.getTitle();
	}

}
