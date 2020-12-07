package automationfc.com;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Element {
	WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.edge.driver", ".\\browserDriver\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://automationfc.github.io/basic-form/index.html");
	}

	@Test
	public void TC_01_Verify_Element_isDisplayed() {
		WebElement email = driver.findElement(By.xpath("//input[@id='mail']"));
		if (email.isDisplayed()) {
			System.out.println("Email có hiển thị");
			email.sendKeys("Automation Testing");
		}
		;

		WebElement age = driver.findElement(By.xpath("//label[@for='under_18']"));
		if (age.isDisplayed()) {
			driver.findElement(By.xpath("//input[@id='under_18']")).click();
		}
		;

		WebElement edu = driver.findElement(By.xpath("//label[@for='edu']"));
		if (edu.isDisplayed()) {
			driver.findElement(By.xpath("//textarea[@id='edu']")).sendKeys("Automation Testing");
		}
		;
		// Sử dụng list Elements
		List<WebElement> test = driver.findElements(By.xpath("//label[@for='edu123']"));
		if (test.size() > 0) {
			driver.findElement(By.xpath("//textarea[@id='edu']")).sendKeys("Automation Testing");
		}

		else {
			System.out.println("Test trường hợp không hiển thị");
		}
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
