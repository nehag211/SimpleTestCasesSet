package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELTC_036POM {

	private WebDriver driver;
	
	public ELTC_036POM(WebDriver driver) {//PageFactory Constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Tests")//TestLink Locator
	private WebElement textLink;
	
	@FindBy(xpath="//img[contains(@title,'Results and feedback')]")//Reslt and Feedback locator
	private List<WebElement> feedbackLink;
	
	@FindBy(xpath="//img[@title='Grade activity']")//Grade Link locator
	private List<WebElement> gradeLink;
	
	@FindBy(xpath="//button[@type='submit']")// Correct button locator
	private WebElement correctButton;
	
	@FindBy(xpath="//h4")// Congratulation messgae
	private WebElement congMessage;
	
	@FindBy(xpath="//input[@type='checkbox']")// Checkbox locator
	private WebElement checkBoxselect;

	public void clickOnTestLink() {// Click on Test Link
		textLink.click();
	}

	public void selectParticularTest(String testName) {// Select perticulat test and click on test link
		List<WebElement> testList = feedbackLink;
		int i=0;
		for (WebElement testListTable : testList) {
			if(i==1)
			{
				testListTable.click();	
				break;
			}
			i++;
		}
	}
	
	public void selectGradeLink() {// Click on grade link to send email
		List<WebElement> gradeList = gradeLink;
		for (WebElement testListTable : gradeList) {
				testListTable.click();	
				break;
		}
	}
	
	public String getMessge()// get congratulatory message
	{
		return congMessage.getText();
	}
	
	public void selectCheckBox() {// Select Checkbox
		checkBoxselect.click();
	}
	public void clickOnCorrectButton() {	// Click on Send email button
		correctButton.click();
	}
	
}
