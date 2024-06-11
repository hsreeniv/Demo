package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import pageobjects.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landing;

	public WebDriver initializedriver() throws IOException {
		Properties ps = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\Global.properties");
		ps.load(fs);
		String browserName = ps.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}

	public List<HashMap<String, String>> getData1(String filepath) throws IOException {
		// Converting JSON to String
		String jsonDocument = FileUtils.readFileToString(new File(filepath));
		// Converting String
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonDocument,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public String getScreenshot(String testcasename,WebDriver driver) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		File s = new File(System.getProperty("user.dir") + "\\reports" + testcasename + ".png");
		FileUtils.copyFile(source, s);
		return System.getProperty("user.dir") + "\\reports" + testcasename + ".png";
	}

	@BeforeMethod
	public LandingPage launchingtheapplication() throws IOException {
		driver = initializedriver();
		landing = new LandingPage(driver);
		landing.gotourl();
		return landing;
	}

	@AfterMethod
	public void closingbrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
}
