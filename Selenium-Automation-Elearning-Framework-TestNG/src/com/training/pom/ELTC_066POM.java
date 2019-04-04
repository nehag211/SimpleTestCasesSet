package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ELTC_066POM {
	private WebDriver driver;

	public ELTC_066POM(WebDriver driver) {// PageFactory Constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Tests")// Test Link
	private WebElement testLink;
	
	@FindBy(xpath="//img[@title='Create a new test']")// Create a new test
	private WebElement createNewTest;
	
	@FindBy(name="exerciseTitle")// Test name
	private WebElement testName;
	
	@FindBy(xpath="//button[@id='advanced_params']")// Advance Setting buuton
	private WebElement advanceSettings;
	
	@FindBy(xpath="//input[@id='exerciseType_0']")//Checkbox feedback
	private WebElement feedbackCheckBox;
	
	@FindBy(name="activate_start_date_check")// Start time checkbox
	private WebElement startCheckBox;
	
	@FindBy(name="activate_end_date_check")// Start time checkbox
	private WebElement endCheckBox;
	
	@FindBy(id="start_time_alt_text")// Click on Date Textbox
	private WebElement dateTextBox;
	
	@FindBy(className="ui-datepicker-month")// Month drop down
	private WebElement monthdropdown;
	
	@FindBy(className="ui-datepicker-year")// Year drop down
	private WebElement yeardropdown;
	
	@FindBy(xpath="//td/a[contains(text(),'18')]")// Select date
	private WebElement date;
	
	@FindBy(xpath="//button[contains(text(),'Done')]")// Click on date done button
	private WebElement dateDone;
	
	@FindBy(id="pass_percentage")// Pass percentage
	private WebElement passPercentage;
	
	@FindBy(name="submitExercise")// Proceed to quest
	private WebElement proceedToQuestion;
	
	@FindBy(xpath="//img[@title='Multiple choice']")// Multiple choice
	private WebElement mulChoice;
	
	@FindBy(name="questionName")// Question Name
	private WebElement questionName;
	
	@FindBy(xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement firstFrame;
	
	@FindBy(xpath="//span[@class='cke_arrow']")
	private WebElement firstOptionFrame;
	
	@FindBy(xpath="//body/p[@xpath='1']")
	private WebElement firstOption;
	
	public void clickOnTestLink()// Click on Test Link
	{
		testLink.click();
	}
	public void clickOnNewTestLink()// Click on New Test Link
	{
		createNewTest.click();
	}
	public void enterTestName(String name)// Enter test name
	{
		testName.sendKeys(name);
	}
	public void clickOnAdvanceSetting()// Click on Advnace setting
	{
		advanceSettings.click();
	}
	public void clickOnfeedBackCheckBox()// Click on Feedback Checkbox
	{
		if(!(feedbackCheckBox.isSelected()))
		{
			feedbackCheckBox.click();
		}
	}
	public void clickOnStartTimeCheckBox()//Click on start time
	{
		startCheckBox.click();
	}
	public void clickOnEndTimeCheckBox()// Click on end time 
	{
		endCheckBox.click();
	}
	public void clickOnDateTextBox()// Click on date text box
	{
		dateTextBox.click();
	}
	public void clickOnMonthDropdown()// Click on month drop down
	{
		Select sel= new Select(monthdropdown);
		sel.selectByVisibleText("Apr");
	}
	public void clickOnYearDropdown()// Click on year drop down
	{
		Select sel= new Select(yeardropdown);
		sel.selectByVisibleText("2019");
	}
	public void clickOnDate() {// Click on date
		date.click();
	}
	public void clickOnDatedone() {// Click on date done button
		dateDone.click();
	}
	public void enterPassPercentage(String value)//enter pass % 
	{
		passPercentage.clear();
		passPercentage.sendKeys(value);
	}
	public void clickOnProceedToQues()// Click on procced to quest
	{
		proceedToQuestion.click();
	}
	public void clickOnMulChoice() {// Click on multiple choice
		mulChoice.click();
	}
	public void enterQuestionName(String name)// Enter Quetion name
	{
		questionName.clear();
		questionName.sendKeys(name);
	}
	public void enterFirstOption()// Enter Quetion name
	{
		firstOptionFrame.click();
		//driver.switchTo().frame(firstFrame);
		firstOption.click();
		driver.switchTo().activeElement().sendKeys("Selenium");
	}
}
