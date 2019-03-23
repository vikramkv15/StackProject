package com.stackflow.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class StackFlowMyProfilePage extends BasePage{
	
	@FindBy(how=How.LINK_TEXT, linkText="Edit Profile & Settings")
	@CacheLookup
	WebElement editProfileLink;
	
	@FindBy(how=How.ID, id="change-picture")
	@CacheLookup
	WebElement changePicLink;
	
	@FindBy(how=How.ID, id="avatar-upload")
	@CacheLookup
	WebElement avatarUploadButton;
	
	@FindBy(how=How.NAME, name="file")
	@CacheLookup
	WebElement uploadPic;
	
	@FindBy(how=How.XPATH, xpath="//input[@value='Add picture']")
	@CacheLookup
	WebElement addPicButton;
	
	@FindBy(how=How.XPATH, xpath="//input[@value='Save Profile']")
	@CacheLookup
	WebElement saveProfileButton;
	
	@FindBy(how=How.XPATH, xpath="//span[@title='success']")
	@CacheLookup
	WebElement savedText;
	
	public StackFlowMyProfilePage(WebDriver driver) {
		super(driver);
	}
	
	public void editProfileLinkClick() {
		waitForVisible(driver, editProfileLink, 25);
		editProfileLink.click();
	}
	
	public void editPicLinClick() {
		waitForVisible(driver, changePicLink, 25);
		changePicLink.click();
	}
	
	public void avatarUploadButtonClick() {
		waitForClickable(driver, avatarUploadButton, 35);
		avatarUploadButton.click();
	}
	
	public void uploadPicButton(String picPath) {
		waitForVisible(driver, uploadPic, 75);
		uploadPic.sendKeys(picPath);
	}
	
	public void addPicButtonClick() {
		waitForClickable(driver, addPicButton, 65);
		addPicButton.click();
	}
	
	public void saveProfileButtonClick() {
		waitForVisible(driver, saveProfileButton,35);
		saveProfileButton.click();
	}
	
	public boolean savedTextMsg() {
		waitForVisible(driver, savedText, 35);
		return savedText.isDisplayed();
	}
}
