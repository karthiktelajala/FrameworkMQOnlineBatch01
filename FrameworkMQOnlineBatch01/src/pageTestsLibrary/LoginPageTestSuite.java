package pageTestsLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import genericActionsLibrary.ExcelFile;
import genericActionsLibrary.Screenshot;
import pageActionsLibrary.LoginPageActions;
import testBaseLibrary.TestBase;

public class LoginPageTestSuite extends TestBase
{
	LoginPageActions loginPageActions;
	String url = "http://opensource.demo.orangehrmlive.com/";
	String filePath = "./testData/Credentials.xlsx";
	@Parameters(value="browser")
	@BeforeMethod
	public void startTest(String browser)
	{
		intialize(browser,url);
	}
	@Test(priority=1)
	public void orangeHRMLoginWithValidCredentials()
	{		
		loginPageActions = new LoginPageActions(driver);
		
		Screenshot.captureScreenshot(driver, "LoginPage");
		String username = ExcelFile.readExcel(filePath, 0, 1, 0);
		String password = ExcelFile.readExcel(filePath, 0, 1, 1);
		loginPageActions.enterUsername(username);
		loginPageActions.enterPassword(password);
		loginPageActions.clickLoginButton();
		
		Screenshot.captureScreenshot(driver, "HomePage");
		
		String expTitle = "OrangeHRM";
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, expTitle);	
	}
	
	@Test(priority=2)
	public void orangeHRMLoginWithInvalidCredentials()
	{
		loginPageActions = new LoginPageActions(driver);
		
		String username = ExcelFile.readExcel(filePath, 0, 2, 0);
		String password = ExcelFile.readExcel(filePath, 0, 2, 1);
		loginPageActions.enterUsername(username);
		loginPageActions.enterPassword(password);
		loginPageActions.clickLoginButton();
		
		Screenshot.captureScreenshot(driver, "ErrorLogin");
		
		String expError = "Invalid credentials";
		String actError = loginPageActions.getErrorMessage();
		Assert.assertEquals(actError, expError);
	}
	
	@AfterMethod
	public void testClosure()
	{
		closeBrowser();
	}
}
