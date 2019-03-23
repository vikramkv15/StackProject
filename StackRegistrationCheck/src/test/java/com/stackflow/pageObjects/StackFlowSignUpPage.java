package com.stackflow.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class StackFlowSignUpPage extends BasePage {
	
	@FindBy(how=How.ID, id="display-name")
	WebElement displayName;
	
	@FindBy(how=How.ID, id="email")
	WebElement email;
	
	@FindBy(how=How.ID, id="password")
	WebElement password;
	
	
	@FindBy(how=How.ID, id="submit-button")
	WebElement submitButton;
	
	public StackFlowSignUpPage(WebDriver driver)
	{
		super(driver);
	}
	
	public void getDisplayName(String fullname)
	{	
		waitForVisible(driver, displayName,25);
		displayName.sendKeys(fullname);
	}
	
	public void emailId(String eId)
	{	
		waitForVisible(driver, email, 25);
		email.sendKeys(eId);
	}
	
	public void passwordKey(String pwd)
	{	waitForVisible(driver, password,25);
		password.sendKeys(pwd);
	}
	
	public StackFlowEmailSentPage submitButtonClick() 
	{	
		waitForClickable(driver, submitButton,25);
		submitButton.click();
		return new StackFlowEmailSentPage(driver);
	}
	
}
