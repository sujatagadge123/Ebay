package com.ebay.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ebay.Base.TestBase;

public class LogOffPage extends TestBase {
	
	By Arrow = By.xpath("//*[@id=\"gh-ug\"]/b[2]");
	By SignOut = By.xpath("//*[@id=\"gh-uo\"]/a");
	
	
	public boolean validateLogOff() {
		
		driver.findElement(Arrow).click();		
		wait(2000);
		driver.findElement(SignOut).click();
		wait(2000);
		
		
		
		
		boolean actResult = true;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try
		{
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@id=\"signout-banner-text\"]/h1")));
		}catch(
		TimeoutException te)
		{
			actResult = false;
			System.out.println("screenshot for LogOff failure");
			captureScreenshot();
		}return actResult;

		
		
	}
	}

