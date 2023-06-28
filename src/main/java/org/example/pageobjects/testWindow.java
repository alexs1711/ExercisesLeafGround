package org.example.pageobjects;

import org.example.AbstractComponent.AbstractComponent;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class testWindow extends AbstractComponent {

	WebDriver driver;

	public testWindow(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "button[id='j_idt88:new'] span[class='ui-button-text ui-c']")
	WebElement newWindowOpensBt;

	@FindBy(css = "button[id='j_idt88:j_idt91'] span[class='ui-button-text ui-c']")
	WebElement openMultipleWindowsBt;

	@FindBy(css = "button[id='j_idt88:j_idt93'] span[class='ui-button-text ui-c']")
	WebElement closeAllWindowsExceptPrimBt;

	@FindBy(css = "button[id='j_idt88:j_idt95'] span[class='ui-button-text ui-c']")
	WebElement openWindowDelayBt;

	public LandingPage openLandingTestClickAndConfirmWindow()
	{
		newWindowOpensBt.click();
		//windowHandle();
		LandingPage testClickConfirmW = new LandingPage(driver);
		return testClickConfirmW;
	}
	public void openCloseAllWindowsExceptPrimary()
	{
		closeAllWindowsExceptPrimBt.click();
		windowHandleCloseAllMinusMain();
	}

	public int openCloseAllWindowsExceptPrimaryAndFindNumber()
	{
		openMultipleWindowsBt.click();
		int count = windowHandleCloseAllMinusMain();
		return count;
	}

	public void waitForNewTabsToOpen(int numberTabs){
		openWindowDelayBt.click();
		waitForNumberOfWindowsToBe(numberTabs);
		System.out.println("Successfully waited for "+numberTabs+ " new tabs");
	}

}