package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeStorePage {
	WebDriver driver;

	public HomeStorePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(xpath = "//a[text()='Nokia lumia 1520']")
	public WebElement nokiaLink;

	public void clickOnNokiaPhone() {
		nokiaLink.click();
	}
}
