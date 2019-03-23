package com.stackflow.testCases;


import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.stackflow.pageObjects.StackFlowHomePage;
import com.stackflow.pageObjects.StackFlowLoginPage;
import com.stackflow.pageObjects.StackFlowMyProfilePage;

public class TC02_UploadPhotoTest extends BaseClass {
	
	@Test
	public void uploadPhotoCheck() throws Exception {
		StackFlowHomePage homePage = new StackFlowHomePage(driver);
		logger.info("StackFlow url opened and Home Page is displayed");
		
		StackFlowLoginPage loginPage = homePage.loginButtonClick();
		logger.info("Login Screen is displayed");
		loginPage.getLoginEmailId(LogineID);
		logger.info("User entered email Id");
		
		loginPage.getLoginPassword(password);
		logger.info("User entered password");
		
		StackFlowHomePage homePage1 = loginPage.loginButtonClick();
		logger.info("User logged into the StackFlow and Home Page is displayed");
		
		StackFlowMyProfilePage myprofile = homePage1.myProfileButtonClick();
		logger.info("User navigated to the My profile Page");
		
		myprofile.editProfileLinkClick();
		logger.info("User click on the edit Profile link");
		
		myprofile.editPicLinClick();
		logger.info("User clikc on the change picture link");
		
		myprofile.avatarUploadButtonClick();
		logger.info("User click on the add picture button");
		
		myprofile.uploadPicButton(picturePath);
		logger.info("User upload the picture");
		
		myprofile.addPicButtonClick();
		logger.info("User click on the Add picture button");
		
		myprofile.saveProfileButtonClick();
		logger.info("User save the profile page");
		
		if(myprofile.savedTextMsg()==true)
		{
			AssertJUnit.assertTrue(true);
			logger.info("Photo Uploaded successfully and profile saved....");
			logger.info("Test Case Passed....");
		} else {
			logger.info("Photo upload is failed. Please check");
			logger.info("Test Case Failed....");
			captureScreen(driver, "userSignUpCheck");
			AssertJUnit.assertTrue(false);
		}
		
	}
}
