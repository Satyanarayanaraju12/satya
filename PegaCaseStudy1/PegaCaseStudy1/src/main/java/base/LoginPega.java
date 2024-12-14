package base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;

import setUp.setup;
import utilities.ExcelUtils;

public class LoginPega extends setup {

	ExcelUtils form = new ExcelUtils();

	By profile = By.xpath(
			"//body/div[@class='dialog-off-canvas-main-canvas']/div[@class='c-bolt-site']/header[@class='js-global-header c-bolt-page-header js-bolt-sticky-page-header']/div[@class='c-bolt-page-header__primary']/div[@class='c-bolt-page-header__toolbar']/nav[@id='js-bolt-page-header-primary-nav']/div[@class='c-bolt-page-header__nav-list-group']/ul[@class='js-account-info__anonymous js-bolt-page-header-nav c-bolt-page-header__nav-list js-bolt-page-header-nav--user c-bolt-page-header__nav-list--user']/li[1]/button[1]/span[2]");
	By logIn = By.xpath(
			"//body[1]/div[1]/div[1]/header[1]/div[1]/div[1]/nav[1]/div[1]/ul[3]/li[1]/ul[1]/li[1]/div[1]/p[1]/a[1]");
	By myDashboard = By.xpath("//body/div/div/header/div/div/nav[@aria-label='Main Site']/div/ul[1]/li[1]/button[1]");
	By myDashSub = By.xpath(
			"//a[@title='View your Pega Academy dashboard to continue learning']//span[contains(text(),'My Dashboard')]");
	By comEmail = By.xpath("//input[@name='identifier']");
	By comEmailNext = By.xpath("//input[@value='Next']");
	By pass = By.xpath("//input[@name='credentials.passcode']");
	By passVerify = By.xpath("//input[@value='Verify']");

	public void login() throws IOException {
		
		exttest = report.createTest("Log in to Pega");

		WebElement Profile = driver.findElement(profile);
		Actions action = new Actions(driver);
		action.moveToElement(Profile).perform();
		driver.findElement(logIn).click();
		// Enter Company Email
		String commail = form.comLogin(1, 0);
		driver.findElement(comEmail).sendKeys(commail);
		driver.findElement(comEmailNext).click();
		// Enter Password
		String compass = form.comLogin(1, 1);
		driver.findElement(pass).sendKeys(compass);
		driver.findElement(passVerify).click();
		System.out.println("Login To Pega Academy Successful");
		exttest.log(Status.PASS, "Logged in To Pega Academy");

	}

}
