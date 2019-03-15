/*
 **** author: Neha
 */
package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePOM {
	// Create WebDriver Instance
	private WebDriver driver;

	// PageFactory Initialization Constructor
	public HomePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WelcomeMessage Reference Locator
	@FindBy(xpath = "//div[@class=\"normal-message\"]/p")
	private WebElement welcomeMessage;

	// Reterive welcome message
	public String getWelcomeMessage() {
		return welcomeMessage.getText();
	}

}
