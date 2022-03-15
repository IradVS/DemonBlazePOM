package steps;

import org.openqa.selenium.WebDriver;

import pages.HomeStorePage;

public class HomeStoreSteps {
	WebDriver driver;
	HomeStorePage home;
	
	public HomeStoreSteps(WebDriver driver) {
		this.driver=driver;
	}
	public void selectAPhone() {
		home=new HomeStorePage(driver);
		home.clickOnNokiaPhone();
	}
}
