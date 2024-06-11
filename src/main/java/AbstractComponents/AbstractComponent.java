package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobjects.CartPage;

public class AbstractComponent {
	WebDriver driver;

	public AbstractComponent(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);
	}

	public void waitforelementtoapper(By wait) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(wait));

	}
	public void waitforelementtoapper1(WebElement  wait) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(wait));

	}

	public void sleeping() throws InterruptedException {
		Thread.sleep(1000);
	}

	@FindBy(css = "button[routerlink*='cart']")
	WebElement cart;

	public CartPage clicktocart() {
		cart.click();
		CartPage cart = new CartPage(driver);
		return cart;
	}
}
