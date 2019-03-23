package com.stackflow.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class StackFlowEmailSentPage extends BasePage{
	
	@FindBy(how=How.XPATH, xpath="//span[contains(@title,'success')]")
	@CacheLookup
	WebElement successEmailSent;

	public StackFlowEmailSentPage(WebDriver driver) 
	{
		super(driver);
	}
	
	public boolean getSuccessEmailSent()
	{	
		waitForVisible(driver, successEmailSent, 250);
		return successEmailSent.isDisplayed();
	}

}
