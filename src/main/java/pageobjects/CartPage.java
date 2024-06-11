package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy(css="div[class='cartSection'] h3")
	List<WebElement> productlist;
	public List<WebElement> getlist(){
		return productlist;
	}
	public boolean validating(String productName) {
	boolean value = getlist().stream().anyMatch(s -> s.getText().equalsIgnoreCase(productName));
	return value;
	}
	@FindBy(css="button[type='button']:nth-child(1)")
	WebElement submit;
	public CheckoutPage checkoutbtn() {
		submit.click();
		CheckoutPage checkout = new CheckoutPage(driver);
		return checkout;
	}
}
