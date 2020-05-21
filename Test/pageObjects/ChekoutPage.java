package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChekoutPage{
	private WebDriver driver;
	
	public ChekoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public ChekoutPage enterPromoCode() {
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		return this;
	}
	
	public ChekoutPage clickApllyCodeBtn() {
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		return this;
	}
	
	public String getApllyCodeText() {
		return driver.findElement(By.cssSelector("span.promoInfo")).getText();
	}
}
