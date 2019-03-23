package com.stackflow.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class StackFlowLoginPage extends BasePage {
	
	@FindBy(how=How.ID, id="email")
	@CacheLookup
	WebElement loginEmailId;
	
	@FindBy(how=How.ID, id="password")
	@CacheLookup
	WebElement loginPassword;
	
	@FindBy(how=How.ID, id="submit-button")
	@CacheLookup
	WebElement loginSubmitButton;

	public StackFlowLoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void getLoginEmailId(String loginemailId) {
		waitForVisible(driver, loginEmailId, 25);
		loginEmailId.sendKeys(loginemailId);
	}
	
	public void getLoginPassword(String loginpwd) {
		waitForVisible(driver, loginPassword, 25);
		loginPassword.sendKeys(loginpwd);
	}
	
	public StackFlowHomePage loginButtonClick() {
		waitForVisible(driver, loginSubmitButton, 25);
		loginSubmitButton.click();
		return new StackFlowHomePage(driver);
	}
}
