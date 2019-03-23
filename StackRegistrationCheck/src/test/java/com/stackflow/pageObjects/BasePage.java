package com.stackflow.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForVisible(WebDriver driver, WebElement element, int TimeUnit) {
		try {

			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, TimeUnit);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitForClickable(WebDriver driver, WebElement element, int TimeUnit) {
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, TimeUnit);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}