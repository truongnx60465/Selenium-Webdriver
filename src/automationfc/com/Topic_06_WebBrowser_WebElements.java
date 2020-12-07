package automationfc.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_WebBrowser_WebElements {
	WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.edge.driver", ".\\browserDriver\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://live.demoguru99.com");
	}

	@Test
	public void TC_01_Verify_Url() {
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		System.out.println("Url 1: " + driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().equals("http://live.demoguru99.com/index.php/customer/account/login/"),
				"Wrong URL 1");
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		Assert.assertTrue(
				driver.getCurrentUrl().equals("http://live.demoguru99.com/index.php/customer/account/create/"),
				"Wrong URL 2");
	}

	@Test
	public void TC_02_Verify_Title() {
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		System.out.println("Url 1: " + driver.getTitle());
		Assert.assertTrue(driver.getTitle().equals("Customer Login"), "Wrong title 1");
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		Assert.assertTrue(driver.getTitle().equals("Create New Customer Account"), "Wrong title 2");
	}

	@Test
	public void TC_03_Navigate_Function() {
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		Assert.assertTrue(
				driver.getCurrentUrl().equals("http://live.demoguru99.com/index.php/customer/account/create/"),
				"Wrong URL 2");
		// Back
		driver.navigate().back();
		Assert.assertTrue(driver.getCurrentUrl().equals("http://live.demoguru99.com/index.php/customer/account/login/"),
				"Wrong URL 1");
		// forward
		driver.navigate().forward();
		Assert.assertTrue(
				driver.getCurrentUrl().equals("http://live.demoguru99.com/index.php/customer/account/create/"),
				"Wrong URL 2");
	}

	@Test
	public void TC_04_getPage_SourceCode() {
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		Assert.assertTrue(
				driver.getPageSource().contains("Login or Create an Account"),"Missing text");
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		Assert.assertTrue(
				driver.getPageSource().contains("Create an Account"),"Missing text");
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
