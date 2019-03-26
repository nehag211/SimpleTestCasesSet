package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ELTC_038POM {
	
	private WebDriver driver;

	public ELTC_038POM(WebDriver driver) {// PageFactory Constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Groups")// GroupLink Locator
	private WebElement groupLink;
	
	@FindBy(xpath="//img[@title='Create new group(s)']")// Create a new group locator
	private WebElement createNewGroup;
	
	@FindBy(id="create_groups_number_of_groups")// Number of group textbox locator
	private WebElement numofGroups;
	
	@FindBy(id="create_groups_submit")// Proceed to group creation locator
	private WebElement createGroupButton;
	
	@FindBy(name="group_0_name")// Group Name locator
	private WebElement groupName;
	
	@FindBy(name="submit")// Create Group locator
	private WebElement createGroup;
	
	@FindBy(xpath="//a[contains(text(),'MediumTestCase')]//parent::td//following-sibling::td[3]/a[@title='Group members']")// Add Group memebr Link
	private WebElement addGroupMemberLink;
	
	@FindBy(xpath="//select[@id='group_members']")// Select members to be added
	private WebElement addNewMembers;
	
	@FindBy(name="add")// Add button locator
	private WebElement addButton;
	
	@FindBy(id="group_edit_submit")//Save Setting locator
	private WebElement saveSetting;
	
	@FindBy(xpath="//a[contains(text(),'MediumTestCase')]//parent::td//following-sibling::td[3]/a[@title='Edit']")// Edit setting locator
	private WebElement editSettings;
	
	@FindBy(name="self_registration_allowed")// Self registartion CheckBox
	private WebElement selfRegistration;
	
	@FindBy(name="self_unregistration_allowed")// Selg Unregistration CheckBox
	private WebElement selfUnregistration;
	
	@FindBy(id="group_edit_submit")
	private WebElement saveFinalSettings;
	
	public void clickOnGroupsLink()//Click on Group link
	{
		groupLink.click();
	}
	
	public void clickOnNewCroup()// Click on create new group
	{
		createNewGroup.click();
	}

	public void enterNumOfGroup(String num)// Pass number of group
	{
		numofGroups.clear();
		numofGroups.sendKeys(num);
	}
	public void proccedToCreateGroup()// Proceed to Group creation
	{
		createGroupButton.click();
	}
	public void enterGroupName(String name)// Enter Group name to be cretaed
	{
		groupName.clear();
		groupName.sendKeys(name);
	}
	public void clickOnCreateGroup()// Clcik on create a group after entering name
	{
		createGroup.click();
	}
	public void clickOnAddGroupMemLink()// Click on add new members
	{
		addGroupMemberLink.click();
	}
	public void selectNewMembers()// Select members from the listbox
	{
		Select sel= new Select(addNewMembers);
		sel.selectByIndex(0);
		addButton.click();
	}
	public void clickOnSaveSetting()// Click On save setting button
	{
		saveSetting.click();
	}
	
	public void clickOnEditSetting()// Click On Edit Settings
	{
		editSettings.click();
	}
	public void clickOnSelfRegistration()// Check the Self registration CheckBox
	{
		if(!(selfRegistration.isSelected()))
		{
			selfRegistration.click();
		}
	}
	public void clickOnSelfUnRegistration()// Check the Self Unregistration CheckBox
	{
		if(!(selfUnregistration.isSelected()))
		{
			selfUnregistration.click();
		}
	}
	public void clickOnSaveFinalSetting()
	{
		saveFinalSettings.click();
	}
	public String getPageTitle() {
		return driver.getTitle();
	}
}
