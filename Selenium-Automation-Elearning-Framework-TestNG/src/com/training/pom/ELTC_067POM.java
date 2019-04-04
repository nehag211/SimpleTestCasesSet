package com.training.pom;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELTC_067POM {
	private WebDriver driver;

	public ELTC_067POM(WebDriver driver) {// PageFactory Initialization Constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Administration")
	private WebElement adminTab;
	
	@FindBy(linkText="Add a user")
	private WebElement addNewUser;
	
	@FindBy(id="firstname")
	private WebElement firstName;
	
	@FindBy(name="lastname")
	private WebElement lastName;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="phone")
	private WebElement phone;
	
	@FindBy(id="username")
	private WebElement userName;
	
	@FindBy(xpath="//input[@name='password[password_auto]']")
	private WebElement passwordRadioButton;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='button']/span[@class='bs-caret']/span[1]")
	private WebElement profileDropdown;
	
	@FindBy(xpath="//ul[@role='listbox']/li")
	private List<WebElement> profileList;
	
	@FindBy(name="submit")
	private WebElement addUser;
	
	@FindBy(xpath="//div[contains(text(),'The user has been added: ')]")
	private WebElement addUserMessage;
	
	@FindBy(xpath="//div[contains(text(),'The email address is not complete or contains some invalid characters')]")
	private WebElement addUserErroMessage;
	
	public void clickOnAdminTab()
	{
		adminTab.click();
	}
	
	public void clickOnAddNewUser()
	{
		addNewUser.click();
	}
	public void enterFirstName(String name)
	{
		firstName.clear();
		firstName.sendKeys(name);
	}
	public void enterLastName(String name)
	{
		lastName.clear();
		lastName.sendKeys(name);
	}
	public void enterEmail(String name)
	{
		email.clear();
		email.sendKeys(name);
	}
	public void enterPhone(String name)
	{
		phone.clear();
		phone.sendKeys(name);
	}
	public void enterUserName(String name)
	{
		userName.clear();
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmmss");
		String strDate = name+ dateFormat.format(date);
		userName.sendKeys(strDate);
	}
	public void enterPassword(String name)
	{
		passwordRadioButton.click();
		password.clear();
		password.sendKeys(name);
	}
	
	public void clickOnProfileDropDwon()
	{
		profileDropdown.click();
		List<WebElement> profile= profileList;
		for(WebElement profilepotion: profile)
		{
			if(profilepotion.getText().equalsIgnoreCase("Trainer"))
			{
				profilepotion.click();
				break;
			}
		}
		
	}
	public void clickOnAddUser()
	{
		addUser.click();
	}
	
	public String getAddUserMessage()
	{
		return addUserMessage.getText();
	}
	public String getAddUserErrorMessage()
	{
		return addUserErroMessage.getText();
	}

}
