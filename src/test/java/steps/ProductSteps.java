package steps;

import org.openqa.selenium.WebDriver;

import pages.ProductPage;

public class ProductSteps {
	WebDriver driver;
	ProductPage productPage;
	
	public ProductSteps(WebDriver driver) {
		this.driver=driver;
	}
	
	public void addPhoneToCar() {
		productPage=new ProductPage(driver);
		productPage.clickOnAddToCart();
		productPage.aceptAlert();
	}
	public void goToCartPage() {
		productPage=new ProductPage(driver);
		productPage.clickOnCartTab();
		
	}
}
