package setUp;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilities.Folder_FileNames;

public class setup extends Folder_FileNames {

	public static Properties property;
	public static WebDriver driver;
	public static ExtentSparkReporter exthtml;
	public static ExtentTest exttest;
	public static ExtentTest exttest1;
	public static ExtentReports report;
	public static WebDriverWait wait;

	// SetUp Text Input from the properties file
	public static String text() {
		property = new Properties();
		try {
			property.load(new FileInputStream("config\\config.properties")); // File Input from properties file : This
																				// line contains path of properties file
																				// and
																				// returns
		} catch (IOException e) {
			System.out.println("File Not Found");
		}
		String text = property.getProperty("text");
		return text; // Return the Text as in the properties file
	}

	// Close the Browser
	public void CloseBrowser() {
		driver.quit();
		report.flush();
		System.out.println("Driver Closed Successfully \n");

	}

	// Driver SetUp for multiple browser drivers viz Chrome, Edge and FireFox
	public void driverSetup() {

		property = new Properties();
		try {
			property.load(new FileInputStream("config\\config.properties")); // File Input from properties file : This
																				// line contains path of properties file
																				// and
																				// returns
		} catch (IOException e) {
			System.out.println("File Not Found");
		}
		if (property.getProperty("browser").matches("chrome")) {
			driver = new ChromeDriver();
			System.setProperty("webdriver.Chrome.driver", "Drivers/chromedriver.exe"); // Setup for Chrome Browser

		} else if (property.getProperty("browser").matches("firefox")) {
			driver = new FirefoxDriver();
			System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe"); // Setup for Firefox Browser

		} else if (property.getProperty("browser").matches("edge")) {
			driver = new EdgeDriver();
			System.setProperty("webdriver.edge.driver", "Drivers/msedgedriver.exe"); // Setup for MSEdge Browser

		} else {
			System.out.println("driver not available");
		}

		System.out.println("Browser Opened Successfully");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120)); // Page Load TimeOut of 50 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200)); // Implicit Wait of 60 seconds
		driver.get(property.getProperty("url")); // Setup URL from properties File

		exthtml = new ExtentSparkReporter(System.getProperty("IdentifyCourses\\Reports")
				+ "/ExtentReport.html");
		 report= new ExtentReports();
		report.attachReporter(exthtml);
	}
	// Function to Put Wait
		public void wait(int sec, By locator) {
			wait = new WebDriverWait(driver, sec);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}

}
