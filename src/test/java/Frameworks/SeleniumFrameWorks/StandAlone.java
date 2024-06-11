package Frameworks.SeleniumFrameWorks;

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

public class StandAlone {
	public static void main(String[] args) throws InterruptedException {
		String productName = "ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("hareesh123@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Hari@799");
		driver.findElement(By.id("login")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Login Successfully']")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement product1 = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName))
				.findAny().orElse(null);
		product1.findElement(By.cssSelector("div[class='card-body'] button:last-child")).click();
		//w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ngx-spinner-overlay.ng-tns-c31-11.ng-trigger.ng-trigger-fadeIn.ng-star-inserted")));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[aria-label='Product Added To Cart']")));
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		List<WebElement> cartList = driver.findElements(By.cssSelector("div[class='cartSection'] h3"));
		boolean value = cartList.stream().anyMatch(s -> s.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(value);
		driver.findElement(By.cssSelector("button[type='button']:nth-child(1)")).click();
		Actions a=new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder*='Country']")),"India").build().perform();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[class*='ta-results']")));
		driver.findElement(By.cssSelector("button[type='button']:last-child")).click();
		driver.findElement(By.cssSelector("a[class*='ng-star']")).click();
		String ss = driver.findElement(By.cssSelector("td[align='center'] h1")).getText();
		String placeorder = ss.toUpperCase();
		Assert.assertEquals(placeorder, "THANKYOU FOR THE ORDER.");
	}

}
