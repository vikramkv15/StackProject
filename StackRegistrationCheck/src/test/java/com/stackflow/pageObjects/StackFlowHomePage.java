package com.stackflow.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class StackFlowHomePage extends BasePage{
	
	@FindBy(how=How.XPATH,  xpath="//a[contains(@href,'https://stackoverflow.com/users/signup?ssrc=head&returnurl=%2fusers%2fstory%2fcurrent')]")
	@CacheLookup
	WebElement signUButton;
	
	@FindBy(how=How.LINK_TEXT, linkText="Log In")
	@CacheLookup
	WebElement loginButton;
	
	@FindBy(how=How.LINK_TEXT, linkText="Ask Question")
	@CacheLookup
	WebElement askQuestionButton;
	
	@FindBy(how=How.XPATH, xpath="//div[@class='gravatar-wrapper-24']")
	@CacheLookup
	WebElement myProfileButton;
	public StackFlowHomePage(WebDriver driver) {
		super(driver);
	}
	
	public StackFlowSignUpPage signUpButtonClick() {
		waitForVisible(driver, signUButton, 100);
		signUButton.click();
		return new StackFlowSignUpPage(driver);
	}
	
	public StackFlowLoginPage loginButtonClick() {
		waitForVisible(driver, loginButton, 25);
		loginButton.click();
		return new StackFlowLoginPage(driver);
	}
	public boolean askQuestion() {
		return askQuestionButton.isDisplayed();
	}
	
	public StackFlowMyProfilePage myProfileButtonClick() {
		waitForVisible(driver, myProfileButton, 25);
		myProfileButton.click();
		return new StackFlowMyProfilePage(driver);
	}
}
