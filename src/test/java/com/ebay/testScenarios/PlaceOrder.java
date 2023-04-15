package com.ebay.testScenarios;

import org.testng.annotations.Test;

import com.ebay.Pages.AddToCartPage;
import com.ebay.Pages.LoginPage;
import com.ebay.Base.TestBase;
import com.ebay.Pages.SearchProductPage;
import com.ebay.Pages.SearchResultPage;
import com.ebay.Pages.LogOffPage;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class PlaceOrder extends TestBase {
	@Test(priority = 1)
	public void LoginTest() {
		LoginPage loginTest = new LoginPage();
		boolean actResult = loginTest.ValidateLogin("sujatapgadge123@gmail.com", "Sujatap@99");
		Assert.assertTrue(actResult);
	}

	@Test(priority = 2)
	public void SearchProductPage() {
		SearchProductPage searchProductTest = new SearchProductPage();
		boolean actResult = searchProductTest.ValidateSearchProduct("mobile");
		Assert.assertTrue(actResult);
	}

	@Test(priority = 3)
	public void SearchResultPage() {
		SearchResultPage searchResult = new SearchResultPage();
		boolean actResult = searchResult.ValidateSelectProduct();
		Assert.assertTrue(actResult);
	}

	@Test(priority = 4)
	public void AddToCart() {
		AddToCartPage addToCart = new AddToCartPage();
		boolean actResult = addToCart.ValidateAddToCart();
		Assert.assertTrue(actResult);
		
	}

	@Test(priority = 5)
	public void LogOffpage() {
		LogOffPage LogOff = new LogOffPage();
		boolean actResult = LogOff.validateLogOff();
		Assert.assertTrue(actResult);
	}

	@BeforeClass
	public void beforeClass() {
		launchBrowser();
		navigateToURL();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
