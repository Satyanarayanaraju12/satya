package base;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import setUp.setup;
import utilities.HighLightElement;

public class CaseStudyPega1 extends setup {

	By newtask = By.name("NewInteraction_pyDisplayHarness_1");
	By demoScrnPOP = By.xpath("//span[contains(text(),'Demo Screen Pops')]");
	By demoPOPConner = By.xpath("//li[@title='Launch a new interaction with Connor']//a[@role='menuitem']");
	By acceptCall = By.name("IncomingCallPop_CallInteraction_64");
	By addTask = By.xpath("//button[@title='Add task']");
	By dispTrans = By.xpath("//a[@class='Add_task'][normalize-space()='Dispute transaction']");
	By conAddTask = By.xpath("//button[normalize-space()='Add tasks']");
	By taskinprog = By.xpath("//aside[@aria-label='Left Panel']//a[1]");
	By disptrans = By.xpath("//*[@class='checkbox chkBxCtl']");
	By submitDisp = By.xpath("//button[@title='Complete this assignment']");
	By dispReason = By.id("DisputeReason");
	By submitReason = By.xpath("//button[@title='Complete this assignment']");
	By dispReason2 = By.id("DisputeReason");
	By submitReason2 = By.xpath("//button[@title='Complete this assignment']");
	By verifyMSG = By.xpath(
			"//body//div//section[@aria-label='Center Panel']//span//span//div//div[@name='BASE_REF']//div//span//div[@bsimplelayout='true']//div[2]");
	By completeDispute = By.xpath("//button[@title='Confirm']");
	By wrapUp = By.xpath("//button[@title='Wrap up']");
	By interactionReason = By.id("ReasonForInteraction");
	By submitInteract = By.xpath("//div[@data-keyboard='....']");
	By homePage = By.xpath("//div[contains(text(),'My Work')]");

	public void task1() {
		
		exttest = report.createTest("Task 1: Start an interaction in Pega");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='PegaGadget0Ifr']")));
		wait(40, homePage);
		driver.switchTo().parentFrame();
		// Click on New Task
		driver.findElement(newtask).click();
		// Get Demo Screen Pop Up
		WebElement demoscrpop = driver.findElement(demoScrnPOP);
		Actions action = new Actions(driver);
		action.moveToElement(demoscrpop).perform();
		// Capture Screenshot
		Screenshot screenshot1 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500))
				.takeScreenshot(driver);
		String fname1 = "ScreenShots\\ArrangeCall_" + fileName() + ".jpg";
		try {
			ImageIO.write(screenshot1.getImage(), "jpg", new File(fname1));
		} catch (IOException e) {
			System.out.println("File not found");
		}
		wait(4, demoPOPConner);
		driver.findElement(demoPOPConner).click();
		exttest.log(Status.PASS, "Call Initiated");
		wait(15, acceptCall);
		// Capture Screenshot
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500))
				.takeScreenshot(driver);
		String fname2 = "ScreenShots\\AcceptCall_" + fileName() + ".jpg";
		try {
			ImageIO.write(screenshot.getImage(), "jpg", new File(fname2));
		} catch (IOException e) {
			System.out.println("File not found");
		}
		driver.findElement(acceptCall).click();
		exttest.log(Status.PASS, "Call Accepted");
	}

	public void task2() {
		
		exttest = report.createTest("Task 2: Complete a Pega Dispute Transaction service case");
		
		// Switch Frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='PegaGadget1Ifr']")));
		// Click on add Task
		driver.findElement(addTask).click();
		System.out.println("task added");
		wait(10, dispTrans);
		// Double Click on Dispute Transaction
		WebElement dispute = driver.findElement(dispTrans);
		HighLightElement.highlightElement(dispute);
		dispute.click();
		// Capture Screenshot
		Screenshot screenshot1 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500))
				.takeScreenshot(driver);
		String fname3 = "ScreenShots\\DisputeTransaction_" + fileName() + ".jpg";
		try {
			ImageIO.write(screenshot1.getImage(), "jpg", new File(fname3));
		} catch (IOException e) {
			System.out.println("File not found");
		}
		driver.findElement(conAddTask).click();
		exttest.log(Status.PASS, "Dispute Transaction added to Tasks");
		wait(10, disptrans);
		// Click on 2 Transactions
		List<WebElement> tr1 = driver.findElements(disptrans);
		WebElement trf1 = tr1.get(0);
		WebElement trf2 = tr1.get(1);
		HighLightElement.highlightElement(trf1);
		trf1.click();
		HighLightElement.highlightElement(trf2);
		trf2.click();
		// Capture Screenshot
		Screenshot screenshot2 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500))
				.takeScreenshot(driver);
		String fname1 = "ScreenShots\\TransactionID_" + fileName() + ".jpg";
		try {
			ImageIO.write(screenshot2.getImage(), "jpg", new File(fname1));
		} catch (IOException e) {
			System.out.println("File not found");
		}
		driver.findElement(submitDisp).click();

		// Select Reason 1 from dropdown
		wait(10, dispReason);
		WebElement dr = driver.findElement(dispReason);
		Select reason1 = new Select(dr);
		reason1.selectByIndex(1);
		HighLightElement.highlightElement(dr);
		
		// Capture Screenshot
		Screenshot screenshot3 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500))
				.takeScreenshot(driver);
		String fname4 = "ScreenShots\\DispTransaction1_" + fileName() + ".jpg";
		try {
			ImageIO.write(screenshot3.getImage(), "jpg", new File(fname4));
		} catch (IOException e) {
			System.out.println("File not found");
		}
		driver.findElement(submitReason).click();

		// Select Reason 2 from dropdown
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement dr2 = driver.findElement(dispReason2);
		Select reason2 = new Select(dr2);
		reason2.selectByIndex(2);
		HighLightElement.highlightElement(dr2);
		// Capture Screenshot
		Screenshot screenshot4 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500))
				.takeScreenshot(driver);
		String fname5 = "ScreenShots\\DispTransaction2_" + fileName() + ".jpg";
		try {
			ImageIO.write(screenshot4.getImage(), "jpg", new File(fname5));
		} catch (IOException e) {
			System.out.println("File not found");
		}
		driver.findElement(submitReason2).click();
		exttest.log(Status.PASS, "Two Dispute Transactions are selected");
		// Verify Message
		wait(10, verifyMSG);
		String verifyTxt = driver.findElement(verifyMSG).getText();
		// Capture Screenshot
		Screenshot screenshot5 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500))
				.takeScreenshot(driver);
		String fname6 = "ScreenShots\\ClaimMessage_" + fileName() + ".jpg";
		try {
			ImageIO.write(screenshot5.getImage(), "jpg", new File(fname6));
		} catch (IOException e) {
			System.out.println("File not found");
		}
		System.out.println("The Message displayed is: "+verifyTxt);
		if(verifyTxt=="Claim(s) successfully created,Please confirm!") {
		exttest.log(Status.PASS, "The Message: Claim(s) successfully created,Please confirm! is Displayed");
		System.out.println("The Message Displayed is correct");
		}else {
			System.out.println("The displayed message is wrong");
		}
		// Complete Dispute
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Confirm button was not clickable");
		}
		driver.findElement(completeDispute).click();
		exttest.log(Status.PASS, "Completed Dispute");
	}

	public void task3() {
		
		exttest = report.createTest("Task 3: Wrap up the interaction");
		
		// Wrap Up
		WebElement wrapup = driver.findElement(wrapUp);
		HighLightElement.highlightElement(wrapup);
		// Capture Screenshot
		Screenshot screenshot3 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500))
				.takeScreenshot(driver);
		String fname4 = "ScreenShots\\WrapUp_" + fileName() + ".jpg";
		try {
			ImageIO.write(screenshot3.getImage(), "jpg", new File(fname4));
		} catch (IOException e) {
			System.out.println("File not found");
		}
		wrapup.click();
		exttest.log(Status.PASS, "Dispute Wrapped Up");
		// Verify Interaction Reason
		WebElement drpdwn = driver.findElement(interactionReason);
		Select intReason = new Select(drpdwn);
		intReason.selectByVisibleText("Dispute transaction");
		WebElement verifyReason = intReason.getFirstSelectedOption();
		String selectedReason = verifyReason.getText();
		HighLightElement.highlightElement(drpdwn);
		// Capture Screenshot
		Screenshot screenshot6 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500))
				.takeScreenshot(driver);
		String fname6 = "ScreenShots\\CheckReason_" + fileName() + ".jpg";
		try {
			ImageIO.write(screenshot6.getImage(), "jpg", new File(fname6));
		} catch (IOException e) {
			System.out.println("File not found");
		}
		if (selectedReason == "Dispute transaction") {
		System.out.println("Selected Reason for interaction is: "+selectedReason);
		exttest.log(Status.PASS, "Reason for Interaction is selected as: Dispute transaction");
		}else {
			System.out.println("Reason for Interaction is not selected as Dispute transaction");
		}
		driver.findElement(submitInteract).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='PegaGadget0Ifr']")));
		wait(10, homePage);
		driver.findElement(homePage);
		// Capture Screenshot
		Screenshot screenshot7 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500))
				.takeScreenshot(driver);
		String fname7 = "ScreenShots\\HomePage_" + fileName() + ".jpg";
		try {
			ImageIO.write(screenshot7.getImage(), "jpg", new File(fname7));
		} catch (IOException e) {
			System.out.println("File not found");
		}
		System.out.println("Returned to HomeScreen");
		exttest.log(Status.PASS, "Returned to HomePage");
	}

}
