package pageObjectsLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects 
{
	@FindBy(name="txtUsername")
	public WebElement txtUsername;
	
	@FindBy(xpath="//input[@type='password']")
	public WebElement txtPassword;
	
	@FindBy(id="btnLogin")
	public WebElement btnLoginButton;
	
	@FindBy(id="spanMessage")
	public WebElement msgErrorLogin;
	
	public LoginPageObjects(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
