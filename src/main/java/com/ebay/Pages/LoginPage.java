package com.ebay.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ebay.Base.TestBase;

public class LoginPage extends TestBase {

	By SignInLink = By.xpath("//*[@id=\"gh-ug\"]/a");
	By email = By.name("userid");
	By Continue = By.xpath("//*[@id=\"signin-continue-btn\"]");
	By password = By.name("pass");
	By SignInBtn = By.id("sgnBt");

	public boolean ValidateLogin(String Uname, String Pwd) {

		driver.findElement(SignInLink).click();
		wait(2000);
		driver.findElement(email).sendKeys(Uname);
		driver.findElement(Continue).click();
		wait(10000);
		driver.findElement(password).sendKeys(Pwd);
		driver.findElement(SignInBtn).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		boolean actResult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gh-ug\"]/b[1]")));
		} catch (TimeoutException te) {
			actResult = false;
			System.out.println("screenshot for login failure");
			captureScreenshot();
		}
		return actResult;

	}

}
