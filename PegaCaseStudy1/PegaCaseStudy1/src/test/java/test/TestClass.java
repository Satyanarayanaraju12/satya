package test;

import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.CaseStudyPega1;
import base.LaunchInstance;
import base.LoginPega;
import setUp.setup;

public class TestClass {
	setup set = new setup();
	LoginPega logPega = new LoginPega();
	LaunchInstance launch = new LaunchInstance();
	CaseStudyPega1 csp = new CaseStudyPega1();

	@BeforeTest
	public void driverSetup() {

		set.driverSetup();

	}

	@AfterTest
	public void closeBrowser() {

		set.CloseBrowser();
	}

	@Test(priority = 1)
	public void pegaLogin() throws IOException {

		logPega.login();

	}

	@Test(priority = 2)
	public void launchInstance() throws IOException, InterruptedException {
		launch.launchInstance();

	}

	@Test(priority = 3)
	public void startAnInteraction() {
		csp.task1();

	}

	@Test(priority = 4)
	public void pegaDisputeTransaction() {
		csp.task2();

	}

	@Test(priority = 5)
	public void wrapUpInteraction() {
		csp.task3();

	}

}
