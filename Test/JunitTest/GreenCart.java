package JunitTest;

import static org.junit.Assert.*;
import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Foundation.Web;
import pageObjects.shoppingPage;

public class GreenCart {
	private static WebDriver driver;

	@Before
	public void setUp() {
		driver = Web.creatingChrome();
	}

	@Test
	public void test01AddItensToCart() {
		String[] myVegetables = { "Cucumber", "Cauliflower", "Carrot", "Potato", "Beetroot" };
		new shoppingPage(driver).addItensToCart(myVegetables).cartIcon();
		
		assertTrue(new shoppingPage(driver).getItensList().isEnabled());

	}
	
	@Test
	public void test02checkButtonWhenThereIsNoElementInTheCart() {
		 assertFalse(new shoppingPage(driver).getCheckoutBtnElement().isEnabled());		
	}
	
	
	@Test
	public void test04checkIfCartIsNotEmpty() {
		new shoppingPage(driver).cartIcon();
		assertEquals(new shoppingPage(driver).getTextWhenCartIsEmpty(), "You cart is empty!");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}