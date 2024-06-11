package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent {
	WebDriver driver;

	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	By waiting = By.xpath("//div[@aria-label='Login Successfully']");

	public List<WebElement> getproductslist() {
		waitforelementtoapper(waiting);
		return products;
	}

	By list = By.cssSelector("b");

	public WebElement getproduct(String productName) {
		WebElement product1 = getproductslist().stream()
				.filter(product -> product.findElement(list).getText().equalsIgnoreCase(productName)).findAny()
				.orElse(null);
		return product1;
	}

	By add = By.cssSelector("div[class='card-body'] button:last-child");
    By wait=By.cssSelector("div[aria-label='Product Added To Cart']");
	public void addtocart(String productName) throws InterruptedException {
	WebElement prod=	getproduct(productName);
		prod.findElement(add).click();
		waitforelementtoapper(wait);
		sleeping();
	}
}
