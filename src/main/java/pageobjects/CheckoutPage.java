package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[placeholder*='Country']")
	WebElement country;
	By result = By.cssSelector("section[class*='ta-results']");
	@FindBy(css = "button[type='button']:last-child")
	WebElement selecting;

	public void selectCountry(String country1) {
		Actions a = new Actions(driver);
		a.sendKeys(country, country1).build().perform();
		waitforelementtoapper(result);
		selecting.click();
	}

	@FindBy(css = "a[class*='ng-star']")
	WebElement btn;

	public ConfirmPage checkoutbtn() {
		btn.click();
		ConfirmPage confirm=new ConfirmPage(driver);
		return confirm;
	}
}
