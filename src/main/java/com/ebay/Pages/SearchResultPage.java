package com.ebay.Pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ebay.Base.TestBase;

public class SearchResultPage extends TestBase {

	By firstProduct = By.xpath("//*[@id=\"srp-river-results\"]/ul/li[2]/div/div[2]/a/div/span");

	public boolean ValidateSelectProduct() {
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window: " + parentWindow);

		driver.findElement(firstProduct).click();
		wait(2000);

		Set<String> allWindows = driver.getWindowHandles();

		for (String eachWindow : allWindows) 
		
		{
			System.out.println(parentWindow + "\t" + eachWindow);
			
			if (!parentWindow.equals(eachWindow)) {
				System.out.println("Child Window " + eachWindow);

				driver.switchTo().window(eachWindow);
				System.out.println(
						driver.findElement(By.xpath("//*[@id=\"LeftSummaryPanel\"]/div[1]/div[1]/div/h1/span"))
								.getText());

			}
		}

		boolean actResult = true;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"LeftSummaryPanel\"]/div[1]/div[1]/div/h1/span")));
		} catch (TimeoutException te) {
			actResult = false;
			System.out.println("screenshot for SelectRoom failure");
			captureScreenshot();
		}
		return actResult;

	}

}
