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

	@FindBy(css = "#email")
	WebElement emailInput;

	@FindBy(css = "#message")
	WebElement messageInput;

	@FindBy(css = "button[id='j_idt130'] span[class='ui-button-text ui-c']")
	WebElement sendEmailMessageButton;

	public void goToDashboard()
	{
		driver.get("https://www.leafground.com/dashboard.xhtml");
	}

	public void setEmail(String email){
		emailInput.click();
		emailInput.sendKeys(email);
	}
	public void setMessage(String message){
		messageInput.click();
		messageInput.sendKeys(message);
	}
	public void sendEmailMessage (String email,String message){
		setEmail(email);
		setMessage(message);
		sendEmailMessageButton.click();
	}
	
	
	
	
	
	
	

	
	
	
	
	
	
	
}
