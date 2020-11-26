package automationfc.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Xpath_FindElement {
	
	WebDriver driver;
	
	@BeforeClass
	public void TC_001_openEdge() {
		System.setProperty("webdriver.edge.driver",".\\browserDriver\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://live.demoguru99.com/");
	}
	
	@Test
	public void TC_01_Login_with_emptyEmailandPassword(){
	// Login form displayed
	Assert.assertTrue(driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).isDisplayed());
	driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	driver.findElement(By.id("send2")).click();
	String abc = driver.findElement(By.id("advice-required-entry-email")).getText();
	String bcd = driver.findElement(By.id("advice-required-entry-pass")).getText();
	Assert.assertEquals(abc, "This is a required field.");
	Assert.assertEquals(bcd, "This is a required field.");
	
	}
	 
	@Test
	public void TC_02_Login_with_invalidEmail() {
	// Login form displayed
	Assert.assertTrue(driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).isDisplayed());
	driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	driver.findElement(By.id("email")).sendKeys("123123@123.123");
	driver.findElement(By.id("pass")).sendKeys("1234567");
	driver.findElement(By.id("send2")).click();
	String yxz = driver.findElement(By.id("advice-validate-email-email")).getText();
	Assert.assertEquals(yxz, "Please enter a valid email address. For example johndoe@domain.com.");
	}
	
	@Test
	public void TC_03_Login_with_invalidPassword() {
	// Login form displayed
	Assert.assertTrue(driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).isDisplayed());
	driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	driver.findElement(By.id("email")).sendKeys("truongnx@gmail.com");
	driver.findElement(By.id("pass")).sendKeys("123");
	driver.findElement(By.id("send2")).click();
	String yxz = driver.findElement(By.id("advice-validate-password-pass")).getText();
	Assert.assertEquals(yxz, "Please enter 6 or more characters without leading or trailing spaces.");
	}
	
	@Test
	public void TC_04_Login_with_IncorrectEmailPassword() {
	// Login form displayed
	Assert.assertTrue(driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).isDisplayed());
	driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	driver.findElement(By.id("email")).sendKeys("truongnx@gmail.com");
	driver.findElement(By.id("pass")).sendKeys("1234567");
	driver.findElement(By.id("send2")).click();
	String yxz = driver.findElement(By.xpath("//ul[@class='messages']//span")).getText();
	Assert.assertEquals(yxz, "Invalid login or password.");
	}
	
	@Test
	
	public void TC_05() {
		// test slack
	}
	
	@AfterClass
	public void afterClass() {
	driver.quit();
	}
}
