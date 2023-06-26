package org.example.pageobjects;

import org.example.AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent{

	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver); //acceder al driver del parent (abstract component)
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	//WebElement userEmails = driver.findElement(By.id("userEmail"));
	//PageFactory


	@FindBy(css = ".pi.pi-globe.layout-menuitem-icon")
	WebElement globeIconBt;

	@FindBy(css = ".pi.pi-fw.pi-window-maximize.layout-menuitem-icon")
	WebElement windowTestBt;

	@FindBy(css = ".pi.pi-fw.pi-stop.layout-menuitem-icon")
	WebElement frameTestBt;

	@FindBy(css = " .pi.pi-fw.pi-clone.layout-menuitem-icon")
	WebElement alertTestBt;

	@FindBy(css = " a[href='/drag.xhtml'] .pi.pi-fw.pi-calendar.layout-menuitem-icon ")
	WebElement dragTestBt;

	public testWindow openTestWindow()
	{
		globeIconBt.click();
		windowTestBt.click();
		testWindow testW = new testWindow(driver);
		return testW;
	}
	public void goTo()
	{
		driver.get("https://www.leafground.com/dashboard.xhtml");
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
}
