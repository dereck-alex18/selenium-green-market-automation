package JunitTest;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class MyClassTest {
	private WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/home/dereck/Documents/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	}
	
	@Test
	public void checkPageTitle(){
		
		String title = driver.getTitle();
		assertTrue(title.contains("QAClickJet"));
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
}
