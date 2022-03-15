package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	WebDriver driver;
	WebDriverWait wait;

	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

		this.driver = driver;

		wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
	}

	@FindBy(xpath = "//*[@id='page-wrapper']/div/div[2]/button")
	WebElement placeOrderBtn;

	@FindBy(xpath = "//*[@id='orderModal']/div/div/div[3]/button[2]")
	WebElement purchaseBtn;

	@FindBy(id = "name")
	WebElement inputName;

	@FindBy(id = "country")
	WebElement inputCountry;

	@FindBy(id = "city")
	WebElement inputCity;

	@FindBy(id = "card")
	WebElement inputCreditCard;

	@FindBy(id = "month")
	WebElement inputMonth;

	@FindBy(id = "year")
	WebElement inputYear;

	@FindBy(xpath = "/html/body/div[10]/h2")
	WebElement thankYouBanner;

	@FindBy(xpath = "/html/body/div[10]/div[7]/div/button")
	WebElement okBtn;

	@FindBy(xpath = "//*[@id='totalp']")
	WebElement total;

	public void clickPlaceOrder() {
		placeOrderBtn.click();
	}

	public void fillName(String name) {
		inputName.sendKeys(name);
	}

	public void fillCountry(String country) {
		inputCountry.sendKeys(country);
	}

	public void fillCity(String city) {
		inputCity.sendKeys(city);
	}

	public void fillCard(String card) {
		inputCreditCard.sendKeys(card);
	}

	public void fillMonth(String month) {
		inputMonth.sendKeys(month);
	}

	public void fillYear(String year) {
		inputYear.sendKeys(year);
	}

	public void clickPurchase() {
		purchaseBtn.click();
	}

	public boolean thankYouVisible() {
		return thankYouBanner.isDisplayed();
	}

	public void clickOkBtn() {
		okBtn.click();
	}

	public String getAmountDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(total));
		return total.getText();
	}

	public String getAmountFromTableCol(){
		int rows = driver.findElements(By.xpath("//*[@id='page-wrapper']/div/div[1]/div/table/thead/tr/th")).size();
		int cols = driver.findElements(By.xpath("//*[@id='tbodyid']/tr")).size();
		int amount = 0;

		for (int i = 1; i < rows + 1; i++) {
			if (driver.findElement(By.xpath("//*[@id='page-wrapper']/div/div[1]/div/table/thead/tr/th[" + i + "]"))
					.getText().equals("Price")) {
				for (int j = 0; j < cols; j++) {
					amount += Integer.parseInt(driver
							.findElement(By.xpath("//*[@id='tbodyid']/tr[" + j + 1 + "]/td[" + i + "]")).getText());
				}
			}
		}
		return amount + "";
	}
}
