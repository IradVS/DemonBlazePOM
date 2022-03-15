package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import steps.CartSteps;
import steps.HomeStoreSteps;
import steps.ProductSteps;

public class TestRunner {

	WebDriver driver;
	
	HomeStoreSteps homeStore;
	ProductSteps product;
	CartSteps cart;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/index.html");
		homeStore=new HomeStoreSteps(driver);
		product=new ProductSteps(driver);
		cart=new CartSteps(driver);
	}
	
	@Test
	public void testBuyAPhone(){
		homeStore.selectAPhone();
		product.addPhoneToCar();
		product.goToCartPage();
		cart.placeTheOrder();
		cart.fillSendData("Jose", "Mexico", "Guadalajara", "1111-2222-3333-4444", "03", "2022");
		cart.finishPurchase();
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
}
