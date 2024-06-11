package Frameworks.SeleniumFrameWorks;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import pageobjects.CartPage;
import pageobjects.CheckoutPage;
import pageobjects.ConfirmPage;
import pageobjects.LandingPage;
import pageobjects.ProductCatalog;

public class StandAlone2 extends BaseTest {
	@Test(dataProvider = "getData")
	public void submitorder(HashMap<String, String> input) throws IOException, InterruptedException {
		ProductCatalog productcatalog = landing.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productcatalog.getproductslist();
		WebElement product1 = productcatalog.getproduct(input.get("productName"));
		productcatalog.addtocart(input.get("productName"));
		CartPage cart = productcatalog.clicktocart();
		List<WebElement> cartList = cart.getlist();
		boolean value = cart.validating(input.get("productName"));
		Assert.assertTrue(value);
		CheckoutPage checkout = cart.checkoutbtn();
		checkout.selectCountry("India");
		ConfirmPage confirm = checkout.checkoutbtn();
		String ss = confirm.gettext();
		String placeorder = ss.toUpperCase();
		Assert.assertEquals(placeorder, "THANKYOU FOR THE ORDER.");
	}

	@DataProvider
	public Object[][] getData() throws IOException {
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "hareesh123@gmail.com");
//		map.put("password", "Hari@799");
//		map.put("productName", "ZARA COAT 3");
//		HashMap<String,String> map1=new HashMap<String,String>();
//		map1.put("email", "harish234@gmail.com");
//		map1.put("password", "Hari@799");
//		map1.put("productName", "ADIDAS ORIGINAL");
		List<HashMap<String,String>> map=getData1(System.getProperty("user.dir") + "\\src\\test\\java\\DataReader\\SubmitOrder.json");
		return new Object[][] { { map.get(0) }, { map.get(1) } };
		
	}
}
