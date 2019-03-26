package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELTC_040POM {
	private WebDriver driver;

	public ELTC_040POM(WebDriver driver) {// PageFactory Constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Projects") // Project Link
	private WebElement projectLink;

	@FindBy(xpath = "//img[@title='Create a new project']") // Create a new project
	private WebElement createNewProject;

	@FindBy(name = "blog_name") // Project titile locator
	private WebElement projectTitle;

	@FindBy(name = "blog_subtitle") // Project Subtitile locator
	private WebElement projectSubTitle;

	@FindBy(name = "submit") // Submit button locator
	private WebElement saveProjectButton;

	@FindBy(xpath = "//div[@class='actions']//following-sibling::div") // Get the confirmaton message for project
	private WebElement projectAddedMessage;

	@FindBy(xpath = "//table/tbody") // Project Table
	private List<WebElement> projectTableData;

	@FindBy(xpath = "//a[contains(text(),'E-learning')]") // Click on project Name
	private WebElement projectName;

	@FindBy(xpath = "//a[@title='Welcome !']") // Welcome message
	private WebElement welcomeMessgae;

	@FindBy(xpath = "//img[@title='New task']") // Add new task
	private WebElement projectTask;

	@FindBy(id = "add_post_title") // New Task title
	private WebElement taskTitle;

	@FindBy(name = "save") // Save New task
	private WebElement saveTask;

	@FindBy(xpath = "//div[@class='alert alert-success']") // Task Added Messgae
	private WebElement taskMessage;

	@FindBy(xpath = "//img[@title='Roles management']") // Role and Management Locator
	private WebElement roleAndManagement;

	@FindBy(xpath = "//div[@class='actions']/a") // Add new role
	private WebElement addNewRole;//

	@FindBy(name = "task_name") // Add role title
	private WebElement addRoleTitle;//

	@FindBy(name = "Submit") // Click on Role Save button
	private WebElement saveRoleButton;//

	@FindBy(xpath = "//div[@class='alert alert-success']") // Get role added message
	private WebElement roleAddedMessgae;

	@FindBy(xpath = "//img[@title='Assign roles']") // Click on assign role
	private WebElement assignRole;

	@FindBy(xpath = "//span[@class='bs-caret']/span") // Clickon Role dropdown
	private WebElement roleDropDown;

	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu inner')]/li/a/span") // All drop down value
	private List<WebElement> roleDropDownList;
	
	@FindBy(name = "submit") // Clickon Role dropdown
	private WebElement validateRole;

	@FindBy(xpath="//div[@class='alert alert-success']")// Get user-role validate message
	private WebElement validateRoleMessage;
	
	@FindBy(xpath="//img[@title='Users management']")// User managment locator
	private WebElement userManagementButton;
	
	@FindBy(xpath="//td[contains(text(),'Neha')]//preceding-sibling::td")// CheckBox Locator
	private WebElement userNameCheckBox;
	
	@FindBy(xpath="//td[contains(text(),'Neha')]//following-sibling::td[3]")// Register Button
	private WebElement registerButton;
	
	@FindBy(xpath="//div[@class='alert alert-success']")// Get user-role validate message
	private WebElement validateRegisterMessage;
	
	public void clickOnProjectLink()// Click On project Link
	{
		projectLink.click();
	}

	public void clickOnNewProject()// Click on create a new project
	{
		createNewProject.click();
	}

	public void enterProjectTitle(String projectTitleName)// Enter Project title
	{
		projectTitle.clear();
		projectTitle.sendKeys(projectTitleName);
	}

	public void enterProjectSubTitle(String projectSubTitleName)// Enter Project title
	{
		projectSubTitle.clear();
		projectSubTitle.sendKeys(projectSubTitleName);
	}

	public void clickOnSaveProject()// Click on save project
	{
		saveProjectButton.click();
	}

	public String getProectAddedConfirmationMessage() {

		return projectAddedMessage.getText();
	}

	public void clickOnProjectName() {
		projectName.click();
	}

	public String getWelcomeMessage()// Click on save project
	{
		return welcomeMessgae.getText();
	}

	public void clickOnAddNewTask() {// Click on add new task
		projectTask.click();
	}

	public void enterTaskTitle(String name)// Enter Task Title
	{
		taskTitle.sendKeys(name);
	}

	public void clickOnsaveTask()// Click on save task
	{
		saveTask.click();
	}

	public String getTaskAddedMessage() {// Get task message
		return taskMessage.getText();
	}

	public void clickOnRolesAndManaement()// Click on Roles and Management
	{
		roleAndManagement.click();
	}

	public void addNewRole()// Click on Add new role
	{
		addNewRole.click();
	}

	public void addRoleTitle(String name)// Add Role title
	{
		addRoleTitle.sendKeys(name);
	}

	public void clickOnSaverole()// Click on save roles
	{
		saveRoleButton.click();
	}

	public String getRoleAddedMessage()// Get Role added message
	{
		return roleAddedMessgae.getText();
	}

	public void clickOnAssignRole()// Click on Assign role
	{
		assignRole.click();
	}

	public void clickOnRoleDropDown(String name)// Select Neha Gupta from drop down
	{
		roleDropDown.click();
		for (WebElement dropDownListValue : roleDropDownList) {
			if (dropDownListValue.getText().equalsIgnoreCase(name)) {
				dropDownListValue.click();
				break;
			}
		}

	}
	public void clickOnValidateRole()// Click on Validate role
	{
		validateRole.click();
	}
	
	public String getRoleValidatedMessage() {// Get task message
		return validateRoleMessage.getText();
	}
	
	public void clickOnUserManagementButton()// Click on User Management button
	{
		userManagementButton.click();
	}
	public void clickOnUserNameCheckBox()// Clickon userName checkbox
	{
		userNameCheckBox.click();
	}
	public void clickOnRegisterButton()// Click On Register Button
	{
		registerButton.click();
	}
	public String getUserRegisteredMessage() {// Get Register message
		return validateRegisterMessage.getText();
	}
}
