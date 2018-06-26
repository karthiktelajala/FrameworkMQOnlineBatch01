package genericActionsLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions 
{
	static Actions act;
	public static void mouseHover(WebDriver driver,WebElement element)
	{
		act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	
	public static void dragAndDrop(WebDriver driver,WebElement dragElement, WebElement dropElement)
	{
		act = new Actions(driver);
//		act.clickAndHold(dragElement).moveToElement(dropElement).release().build().perform();
		//or
		act.dragAndDrop(dragElement, dropElement).build().perform();	
	}
	
	public static void rightMouseClick(WebDriver driver,WebElement element)
	{
		act = new Actions(driver);
		act.contextClick(element).build().perform();
	}
	
	public static void doubleClick(WebDriver driver,WebElement element)
	{
		act = new Actions(driver);
		act.doubleClick(element).build().perform();
	}
}
