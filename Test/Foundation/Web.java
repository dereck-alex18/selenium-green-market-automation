package Foundation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web {
	public static WebDriver creatingChrome() {
	System.setProperty("webdriver.chrome.driver", "/home/dereck/Documents/chromedriver");
	WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get("https://rahulshettyacademy.com/seleniumPractise"); 
	return driver;
	}

}
