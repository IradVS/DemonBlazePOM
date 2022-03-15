package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	WebDriver driver;
	WebDriverWait wait;

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait=new WebDriverWait(this.driver, Duration.ofSeconds(10));
	}

	@FindBy(xpath = "//*[@id='tbodyid']/div[2]/div/a")
	public WebElement addToCartBtn;
	
	@FindBy(xpath = "//*[@id='cartur']")
	public WebElement cartTab;

	public void clickOnAddToCart() {
		addToCartBtn.click();
		
	}
	public void aceptAlert() {
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	public void clickOnCartTab() {
		cartTab.click();
	}
}
