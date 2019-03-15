/*
 * author: Neha Gupta
 */
package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELTC_010POM {

	WebDriver driver;
	//PageFactory Constrctor Initilization
	public ELTC_010POM(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Course catalog")// CourseCatalog Locator
	private WebElement courseCataloglink;
	
	@FindBy(name="search_term")// Search Textbox locator
	private WebElement searchCourseText;
	
	@FindBy(xpath="//button[@type=\"submit\"]")// Submit search button locator
	private WebElement submitButton;
	
	@FindBy(xpath="//Strong[contains(text(),'Search results for:')]")// get serach text locator
	private WebElement serachResult;
	
	public void clickOnCourseCatalog()// Click on Course catalog 
	{
		courseCataloglink.click();
	}
	public void enterSearchCatalogText(String catalogName)// Enter Catalog Search
	{
		searchCourseText.clear();
		searchCourseText.sendKeys(catalogName);
	}
	public void clickOnSubmitButton()// Click on Submit button
	{
		submitButton.click();
	}
	public String getSerachResults()// get the search result text
	{
		return serachResult.getText();
	}
	
}
