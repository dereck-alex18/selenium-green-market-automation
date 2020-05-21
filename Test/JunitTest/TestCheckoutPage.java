package JunitTest;

import static org.testng.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import Foundation.Web;
import pageObjects.ChekoutPage;
import pageObjects.shoppingPage;

public class TestCheckoutPage {
	private static WebDriver driver;

	@Before
	public void setUp() {
		driver = Web.creatingChrome();
		String[] myVegetables = { "Cucumber", "Cauliflower", "Carrot", "Potato", "Beetroot" };
		new shoppingPage(driver)
			.addItensToCart(myVegetables)
			.cartIcon()
			.checkoutBtn();
	}
	
	@Test
	public void test01applyDiscount(){
		
	   String applyCodeText = new ChekoutPage(driver)
			.enterPromoCode()
			.clickApllyCodeBtn()
			.getApllyCodeText();
	   assertTrue(applyCodeText.contains("Code applied"));
			
	}
}
