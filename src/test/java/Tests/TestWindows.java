package Tests;

import TestsComponents.BaseTest;
import org.testng.annotations.Test;

import org.example.pageobjects.*;


public class TestWindows extends BaseTest {

	String windowUrl = "https://www.leafground.com/window.xhtml";

	@Test()
	public void testConfirmNewWindowOpen()
	{
		testWindow testW = new testWindow(driver);
		testW.goTo(windowUrl);
		LandingPage landPa = testW.openLandingTestClickAndConfirmWindow();
		testW.windowHandletoChild();
		landPa.sendEmailMessage("pepe@gmail.com","Hi pepe.");
		landPa.close();
	}
	@Test()
	public void testCloseAllWindowsExceptPrimary()
	{
		testWindow testW = new testWindow(driver);
		testW.goTo(windowUrl);
		testW.openCloseAllWindowsExceptPrimary();
	}

	@Test()
	public void openMultipleTabs()
	{
		testWindow testW = new testWindow(driver);
		testW.goTo(windowUrl);
		int count = testW.openCloseAllWindowsExceptPrimaryAndFindNumber();
		System.out.println("The number of opened windows is :"+count);
	}

	@Test()
	public void openWaitMultipleTabs()
	{
		testWindow testW = new testWindow(driver);
		testW.goTo(windowUrl);
		testW.waitForNewTabsToOpen(3);
	}






	/*@DataProvider
	public Object[][] getData(){

		HashMap<String,String> map = new HashMap<String,String>();
	map.put("email", "anshika@gmail.com");
	map.put("password", "Iamking@000");
	map.put("product", "ZARA COAT 3");

		return new Object[][] {{map}};
	}*/
	
	
	
	


}
