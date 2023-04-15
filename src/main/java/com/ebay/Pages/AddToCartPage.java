package com.ebay.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ebay.Base.TestBase;

public class AddToCartPage extends TestBase {
	By firstProduct = By.xpath("//*[@id=\"LeftSummaryPanel\"]/div[1]/div[1]/div/h1/span");

	By AddToCart = By.xpath("//*[@id=\"mainContent\"]/form/div[2]/div/div[1]/div[2]/ul/li[2]/div/a/span/span");
	

	public boolean ValidateAddToCart() {

		System.out.println("First Product Name = " +driver.findElement(firstProduct).getText());
		wait(2000);
		
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("window.scrollBy(0,100)");
		
		wait(2000);

		driver.findElement(AddToCart).click();
		wait(2000);
	
	

	boolean actResult = true;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	try
	{
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"mainContent\"]/div/div[3]/div/div[1]/button")));
	}catch(
	TimeoutException te)
	{
		actResult = false;
		System.out.println("screenshot for AddTocart failure");
		captureScreenshot();
	}return actResult;

}

}
