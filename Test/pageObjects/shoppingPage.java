package pageObjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class shoppingPage {
	private WebDriver driver;

	public shoppingPage(WebDriver driver) {
		this.driver = driver;
	}

	public List<WebElement> getAllElementsOnShoppingPage() {
		return driver.findElements(By.cssSelector("h4.product-name"));
	}

	public List<WebElement> getAllAddToCartBtn() {
		return driver.findElements(By.cssSelector("div.product-action button"));
	}

	public shoppingPage cartIcon() {
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		return this;
	}
	
	public String getTextWhenCartIsEmpty() {
		return driver.findElement(By.cssSelector("div.empty-cart h2")).getText();
	}
	
	public WebElement getItensList() {
		return driver.findElement(By.cssSelector("ul.cart-items"));
	}

	public WebElement getCheckoutBtnElement() {
		return driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']"));
	}

	public ChekoutPage checkoutBtn() {
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		return new ChekoutPage(driver);
	}

	public shoppingPage addItensToCart(String[] myVegetables) {

		List<WebElement> vegetableNames = getAllElementsOnShoppingPage();
		List<WebElement> addToCartBtns = getAllAddToCartBtn();
		int counter = 0;

		// Loops through all the elements in the list
		for (int i = 0; i < vegetableNames.size(); i++) {
			// Get the text of each element and split it into 2 based on the "-"
			String[] vegetableName = vegetableNames.get(i).getText().split("-");
			// Convert the array of elements into a list
			List<String> myVegetablesList = Arrays.asList(myVegetables);
			// Check if the current element is in the list of my vegetables. Remove the
			// white space too
			if (myVegetablesList.contains(vegetableName[0].trim())) {
				addToCartBtns.get(i).click();
				counter++;
				if (counter == myVegetablesList.size())
					break;

			}

		}
		return this;
	}
}
