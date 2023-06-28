package org.example.AbstractComponent;

import org.example.pageobjects.testWindow;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AbstractComponent {
	
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

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


	public void waitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	public void waitForNumberOfWindowsToBe(int numberTabs) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(numberTabs));
	}
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	public void scrollToElement (WebElement myElement) throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOf(myElement));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", myElement);
		Thread.sleep(500);
	}
	public void waitForWebElementToBeClickable(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(findBy));
	}

	public void clickCookies(WebElement ele) throws InterruptedException{
		//queda revisar el como hacerlo con zoom o pantallas mas pequenas
		waitForWebElementToAppear(ele);
		ele.click();
		waitForElementToDisappear(ele);
	}

	public void switchToframe(WebElement frame){
		driver.switchTo().frame(frame);
	}

	public List<String> enableSwitchToWindow (){
		driver.switchTo().newWindow(WindowType.WINDOW);

		Set<String> handles=driver.getWindowHandles();

		Iterator<String> it=handles.iterator();

		List<String> stringList = new ArrayList<>();

		for (; it.hasNext() ; ) {
			stringList.add(driver.switchTo().window(it.next()).getTitle());
		}
		return stringList;
	}

	public void windowHandletoChild(){
		Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]

		Iterator<String>it = windows.iterator();

		String parentId = it.next();

		String childId = it.next();

		System.out.println("parent: "+driver.getTitle());

		driver.switchTo().window(childId);
		System.out.println("child: "+driver.getTitle());
		// driver.switchTo().window(parentId);
	}
	public void windowHandleToParent(){
		Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]

		Iterator<String>it = windows.iterator();

		String parentId = it.next();

		String childId = it.next();

		System.out.println("parent: "+driver.getTitle());

		//driver.switchTo().window(childId);

		driver.switchTo().window(parentId);
		System.out.println("child: "+driver.getTitle());
	}

	public int windowHandleCloseAllMinusMain(){
		int count = 0;

		Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]

		Iterator<String>it = windows.iterator();

		String parentId = it.next();
		System.out.println("parent: "+driver.getTitle());

		for (; it.hasNext() ; ) {
			count++;
			String childId = it.next();
			driver.switchTo().window(childId);
			System.out.println("child: "+driver.getTitle());
			driver.close();
		}
		 driver.switchTo().window(parentId);
		return count;
	}

	public void goTo(String url)
	{
		driver.get(url);
	}

	public void close(){
		driver.close();
	}

}
