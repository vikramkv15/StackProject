package com.stackflow.pageObjects;



import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class GmailLogin extends BasePage{
	
	
	@FindBy(how=How.XPATH, xpath="//input[@id='identifierId']")
	WebElement emailfield;
	
	@FindBy(how=How.XPATH, xpath="//*[@id='password']/div[1]/div/div[1]/input")
	WebElement passwordfield;
	
	@FindBy(how=How.XPATH, xpath="//span[@class='bqe']")
	List<WebElement> emailThreads;
	
	@FindBy(how=How.XPATH, xpath="//span[@class='gb_ya gbii']")
	WebElement profilelogo;
	
	@FindBy(how=How.CSS, css="input.gb_3e")
	@CacheLookup
	WebElement searchBox;
	
	@FindBy(how=How.LINK_TEXT, linkText="Click here to complete your registration")
	@CacheLookup
	WebElement activatelink;
	
	@FindBy(how=How.LINK_TEXT, linkText= "Anmelden")
	@CacheLookup
	WebElement loginLink;
	
	@FindBy(how=How.XPATH, xpath= "//*[contains(text(),'Produktiver arbeiten mit Gmail')]")
	@CacheLookup
	WebElement googleProductTxt;
	
	public GmailLogin(WebDriver driver)
	{
		super(driver);
	}
	
	public void enterEmailID(String emailID) throws Exception
	{
		waitForVisible(driver, emailfield, 25);
		Thread.sleep(2000);
		Actions actions=new Actions(driver);
		actions.moveToElement(emailfield);
		actions.click();
		actions.sendKeys(emailID + Keys.ENTER);
		actions.build().perform();
			
	}
	
	public void enterPassword(String password) throws Exception
	{
		waitForVisible(driver, passwordfield, 25);
		Thread.sleep(2000);
		Actions actions=new Actions(driver);
		actions.moveToElement(passwordfield);
		actions.click();
		actions.sendKeys(password + Keys.ENTER);
		actions.build().perform();
	
	}
	
	public void clickEmail(String emailSubject)
	{
		waitForVisible(driver, profilelogo, 25);
		
		for (int i = 0; i < emailThreads.size(); i++) {
			if (emailThreads.get(i).getText().contains(emailSubject)) {
				emailThreads.get(i).click();
				break;
			}
		}
	}
	
	public void searchEmail(String emailIdChild)
	{	
		waitForVisible(driver, searchBox, 25);
		searchBox.sendKeys("to:"+emailIdChild + Keys.ENTER);
	}
	
	public StackFlowHomePage openLink() throws Exception 
	{	
		waitForVisible(driver, activatelink, 25);
		activatelink.click();
		return new StackFlowHomePage(driver);
	}
	
	public void loginGmailLink()
	{
		loginLink.click();
	}
	
	public boolean googleProductText()
	{
		return googleProductTxt.isDisplayed();
	}
}


