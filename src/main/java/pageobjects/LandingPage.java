package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement userEmail;
	@FindBy(id = "userPassword")
	WebElement password;
	@FindBy(id = "login")
	WebElement submit;

	public ProductCatalog loginApplication(String useremail, String password1) {
		userEmail.sendKeys(useremail);
		password.sendKeys(password1);
		submit.click();
		ProductCatalog productcatalog = new ProductCatalog(driver);
		return productcatalog;
	}
	public void gotourl() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	@FindBy(css="div[class*='toast-message']")
	WebElement textingerror;
	public String validatinggettexterror() {
		waitforelementtoapper1(textingerror);
		return textingerror.getText();
		}
	

}
