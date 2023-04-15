package com.ebay.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ebay.Base.TestBase;

public class SearchProductPage extends TestBase {

	By Search = By.xpath("//*[@id=\"gh-ac\"]");
	By btnTopSearch = By.xpath("//*[@id=\"gh-btn\"]");

	public boolean ValidateSearchProduct(String ProductName) {

		driver.findElement(Search).sendKeys(ProductName);// mobile
		wait(2000);
		driver.findElement(btnTopSearch).click();
		wait(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		boolean actResult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"srp-river-results\"]/ul/li[2]/div/div[2]/a/div/span")));
		} catch (TimeoutException te) {
			actResult = false;
			System.out.println("screenshot for SearchProduct failure");
			captureScreenshot();
		}
		return actResult;

	}

}
