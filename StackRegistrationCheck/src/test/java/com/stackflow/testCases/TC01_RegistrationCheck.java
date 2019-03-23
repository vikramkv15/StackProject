package com.stackflow.testCases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.stackflow.pageObjects.GmailLogin;
import com.stackflow.pageObjects.StackFlowEmailSentPage;
import com.stackflow.pageObjects.StackFlowHomePage;
import com.stackflow.pageObjects.StackFlowSignUpPage;


public class TC01_RegistrationCheck extends BaseClass {

	@Test
	public void userSignUpCheck() throws Exception {
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		StackFlowHomePage homepage = new StackFlowHomePage(driver);
		StackFlowSignUpPage signup = homepage.signUpButtonClick();
		logger.info("User Click on the Sign Up button");
		
		signup.getDisplayName(displayname);
		logger.info("User enter the display name");
		
		signup.emailId(signUpEmID);
		logger.info("User enter the email Id");
		
		signup.passwordKey(password);
		logger.info("User entered password");
		
		StackFlowEmailSentPage emailst = new StackFlowEmailSentPage(driver);
		logger.info("Waiting for the user to finish the recaptcha. Once done Please click on sign up button ");
		if (emailst.getSuccessEmailSent() == true) {
			AssertJUnit.assertTrue(true);
			logger.info("Email sent successfully....");
			logger.info("Test Case Passed....");
		} else {
			logger.info("Email sent is failed...");
			logger.info("Test Case Failed....");
			captureScreen(driver, "userSignUpCheck");
			AssertJUnit.assertTrue(false);
		}
	}

	@Test(groups = { "A" }, dependsOnMethods = { "userSignUpCheck" })
	public void gmailUserActivate() throws Exception {

		driver.get(gmUrl);
		logger.info("Gmail url opened.");

		GmailLogin gmail = new GmailLogin(driver);

		// logging into gmail using the parent email ID.
		gmail.enterEmailID(gmailParent);
		gmail.enterPassword(password);
		logger.info(signUpEmID + " is the email");
		logger.info("User Logged in to the Gmail");

		// Searching for the email based on the child mail id and text of the mail
		// subject
		gmail.searchEmail(signUpEmID);
		logger.info("User searched email");

		gmail.clickEmail(emailSub);
		logger.info("User clicked on the mail");
		try {
			StackFlowHomePage everified = gmail.openLink();
			logger.info("User clicked on the activate link");
			Thread.sleep(500);
			String MainWindow = driver.getWindowHandle();

			// To handle all new opened window.
			Set<String> s1 = driver.getWindowHandles();
			Iterator<String> i1 = s1.iterator();

			while (i1.hasNext()) {
				String ChildWindow = i1.next();

				if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

					// Switching to Child window
					driver.switchTo().window(ChildWindow);
					boolean result = everified.askQuestion();
					if (result == true) {
						AssertJUnit.assertTrue(true);
						logger.info("Successfully user account is activated");
						logger.info("Test Case Passed....");

					} else {
						logger.info("Email sent is failed...");
						logger.info("Test Case Failed....");
						captureScreen(driver, "gmailUserActivate");
						AssertJUnit.assertTrue(false);
					}

				}
			}
			
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			StackFlowHomePage everified1 = gmail.openLink();
			logger.info("User clicked on the activate link");
			String MainWindow = driver.getWindowHandle();

			// To handle all new opened window.
			Set<String> s1 = driver.getWindowHandles();
			Iterator<String> i1 = s1.iterator();

			while (i1.hasNext()) {
				String ChildWindow = i1.next();

				if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

					// Switching to Child window
					driver.switchTo().window(ChildWindow);
					boolean result = everified1.askQuestion();
					if (result == true) {
						AssertJUnit.assertTrue(true);
						logger.info("Successfully user account is activated");
						logger.info("Test Case Passed....");

					} else {
						logger.info("Email sent is failed...");
						logger.info("Test Case Failed....");
						captureScreen(driver, "gmailUserActivate");
						AssertJUnit.assertTrue(false);
					}

				}
			}
		}
	}
}
