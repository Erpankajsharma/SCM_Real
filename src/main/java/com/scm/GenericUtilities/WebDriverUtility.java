package com.scm.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void maximizeWindow(WebDriver d)
	{
		d.manage().window().maximize();
	}
	
	public void implicitWait(WebDriver d)
	{
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void elementToBeVisible(WebDriver d, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(d, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void selectByValue(WebElement element, String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	
	public void selectByIndex(WebElement element, int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	public void selectByVisibleText(WebElement element, String visibleText)
	{
		Select s=new Select(element);
		s.selectByVisibleText(visibleText);
	}
	
	public void mouseHover(WebDriver d, WebElement element)
	{
		Actions a=new Actions(d);
		a.moveToElement(element).perform();
	}
	
	public void dragAndDrop(WebDriver d, WebElement src, WebElement dest)
	{
		Actions a=new Actions(d);
		a.dragAndDrop(src, dest).perform();
	}
	
	public void doubleClick(WebDriver d)
	{
		Actions a=new Actions(d);
		a.doubleClick().perform();
	}
	
	public void rightClick(WebDriver d)
	{
		Actions a=new Actions(d);
		a.contextClick().perform();
	}
	
	public void rightClick(WebDriver d, WebElement element)
	{
		Actions a=new Actions(d);
		a.contextClick(element).perform();
	}
	
	public void enterKeyPress(WebDriver d)
	{
		Actions a=new Actions(d);
		a.sendKeys(Keys.ENTER).perform();
	}
	
	public void enterKey(WebDriver d) throws AWTException
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	
	public void enterKeyRelease(WebDriver d) throws AWTException
	{
		Robot r=new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void switchToFrame(WebDriver d, int index)
	{
		d.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver d, String nameOrId)
	{
		d.switchTo().frame(nameOrId);
	}
	
	public void switchToFrame(WebDriver d, WebElement address)
	{
		d.switchTo().frame(address);
	}
	
	public void acceptAlert(WebDriver d)
	{
		d.switchTo().alert().accept();
	}
	
	public void dismissAlert(WebDriver d)
	{
		d.switchTo().alert().dismiss();
	}
	
	public void switchToWindow(WebDriver d, String partialTitle)
	{
		Set<String> windows = d.getWindowHandles();
		
		Iterator<String> it=windows.iterator();
		
		while(it.hasNext())
		{
			String winID = it.next();
			
			String currentWinTitle = d.switchTo().window(winID).getTitle();
			
			if(currentWinTitle.contains(partialTitle))
			{
				break;
			}
		}
	}
	
	
	
	
	public void switchWindow(WebDriver d, String desiredTitle)
	{
		Set<String> allwh = d.getWindowHandles();
		for(String s : allwh)
		{
			d.switchTo().window(s);
			String aTitle = d.getTitle();
			//System.out.println(aTitle);
			
			
			if(aTitle.equals(desiredTitle))
			{
				String desiredWh = d.getWindowHandle();
				d.switchTo().window(desiredWh);
			}
		}
	}
	
	
	
	
	public static String getScreenShot(WebDriver d, String screenShotName) throws IOException
	{
		TakesScreenshot tss = (TakesScreenshot) d;
		File src = tss.getScreenshotAs(OutputType.FILE);
		String path = ".\\screenshot\\"+screenShotName+".png";
		File dest=new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}
	
	public void scrollBarAction(WebDriver d)
	{
		JavascriptExecutor jse = (JavascriptExecutor) d;
		jse.executeScript("window.scrollBy(0,800)", "");
	}
	
	public void scrollBarAction(WebDriver d, WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor) d;
		int y = element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")", element);
	}
}
