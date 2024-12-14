package base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import setUp.setup;
import utilities.ExcelUtils;

public class LaunchInstance extends setup {
	ExcelUtils form = new ExcelUtils();

	By search = By.xpath("//body/div/div/header/div/div/button[1]/span[2]//*[name()='svg']");
	By searchBox = By.xpath("//input[@placeholder='Search here']");
	By conductInteract = By.xpath("//bolt-list-item[1]//bolt-card-replacement[1]");
	By reset = By.xpath(
			"//button[@class='c-bolt-button c-bolt-button--medium c-bolt-button--secondary c-bolt-button--border-radius-full c-bolt-button--center']");
	By confirmReset = By.name("op");
	By launchInstance = By.xpath("//bolt-button[@color='primary']//a");
	By CRMSuite = By.xpath("//span[normalize-space()='Pega CRM suite']");
	By closeHint = By.xpath("//span[@class='close']");
	By userName = By.id("txtUserID");
	By CRMpass = By.id("txtPassword");
	By CRMLogin = By.id("sub");

	// Launching the Pega Instance for Customer Interaction
	public void launchInstance() throws IOException, InterruptedException {
		
		exttest = report.createTest("Launching Pega Instance");

		// Search for Conduct an interaction
		driver.findElement(search).click();
		WebElement srch = driver.findElement(searchBox);
		srch.sendKeys(property.getProperty("search"));
		srch.sendKeys(Keys.ENTER);
		System.out.println("Search for Conducting an Interaction successful");
		// Click on Conduct an Interaction Challenge
		driver.findElement(conductInteract).click();
		System.out.println("Conducting an Interaction Challenge opened successfully");

		driver.findElement(By.id("truste-consent-button")).click();
		wait(300, launchInstance);
		driver.findElement(launchInstance).click();
		System.out.println("Pega Instance Initialized");
		exttest.log(Status.PASS, "Pega Instance Initialized");
		Thread.sleep(5000);
		// switch to next window
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(1));
		// Click on Pega CRM Suite
		wait(900, CRMSuite);
		driver.findElement(CRMSuite).click();
		// Switch to next window
		ArrayList<String> newTab1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab1.get(2));
		// Close Hint popup
		List<WebElement> Hint = driver.findElements(closeHint);
		if (Hint != null) {
			driver.findElement(closeHint).click();
		}
		// Enter PDN UserName
		String UserName = form.PDNlogin(1, 0);
		driver.findElement(userName).sendKeys(UserName);
		// Enter PDN Password
		String PDNpass = form.PDNlogin(1, 1);
		driver.findElement(CRMpass).sendKeys(PDNpass);
		// Login to PDN
		driver.findElement(CRMLogin).click();
		System.out.println("Logged in To Pega CRM Suite");
		exttest.log(Status.PASS, "Logged in To Pega CRM Suite");
		

	}
}
