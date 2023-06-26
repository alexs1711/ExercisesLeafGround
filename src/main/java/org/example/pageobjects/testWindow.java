package org.example.pageobjects;

import org.example.AbstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	public LandingPage openTestClickAndConfirmWindow()
	{
		newWindowOpensBt.click();
		LandingPage testClickConfirmW = new LandingPage(driver);
		return testClickConfirmW;
	}





}