package steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pages.CartPage;

public class CartSteps {
	WebDriver driver;
	CartPage cartPage;
	
	public CartSteps(WebDriver driver) {
		this.driver=driver;
	}
	
	public void placeTheOrder(){
		cartPage=new CartPage(driver);
		Assert.assertEquals(cartPage.getAmountDisplayed(), cartPage.getAmountFromTableCol());
		cartPage.clickPlaceOrder();
	}
	
	public void fillSendData(String name, String country, String city, String cCard, String month, String year) {
		cartPage=new CartPage(driver);
		cartPage.fillName(name);
		cartPage.fillCountry(country);
		cartPage.fillCity(city);
		cartPage.fillCard(cCard);
		cartPage.fillMonth(month);
		cartPage.fillYear(year);
		cartPage.clickPurchase();
		Assert.assertTrue(cartPage.thankYouVisible());
	}
	
	public void finishPurchase() {
		cartPage=new CartPage(driver);
		cartPage.clickOkBtn();
	}
	
}
