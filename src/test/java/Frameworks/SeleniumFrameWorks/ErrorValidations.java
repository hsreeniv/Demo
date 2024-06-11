package Frameworks.SeleniumFrameWorks;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import pageobjects.CartPage;
import pageobjects.CheckoutPage;
import pageobjects.ConfirmPage;
import pageobjects.LandingPage;
import pageobjects.ProductCatalog;

public class ErrorValidations extends BaseTest {
@Test
public void LoginValidation() throws IOException, InterruptedException {
		
		ProductCatalog productcatalog =landing.loginApplication("hareesh12334@gmail.com", "Hari@799");
		Assert.assertEquals(landing.validatinggettexterror(), "Incorrect email or password.");
		
	}
@Test(dependsOnMethods="LoginValidation()")
public void ProductErrorValidation() throws InterruptedException {
	String productName = "ZARA COAT 3";
	ProductCatalog productcatalog =landing.loginApplication("harish234@gmail.com", "Hari@799");
	List<WebElement> products = productcatalog.getproductslist();
	WebElement product1 = productcatalog.getproduct(productName);
	productcatalog.addtocart(productName);
	CartPage cart =productcatalog.clicktocart();
	List<WebElement> cartList = cart.getlist();
	boolean value = cart.validating("ZARA COAT 33");
	Assert.assertTrue(value);
	
}

}

