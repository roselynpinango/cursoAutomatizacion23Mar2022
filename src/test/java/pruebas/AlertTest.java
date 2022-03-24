package pruebas;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AlertTest {
	String driverPath = "..\\EducacionIT21Feb2022\\Drivers\\chromedriver.exe";
	String url = "https://demoqa.com/alerts";
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void alert1() {
		driver.findElement(By.id("alertButton")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	@Test
	public void alert2() {
		driver.findElement(By.id("timerAlertButton")).click();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void alert3() {
		driver.findElement(By.id("confirmButton")).click();
		
		driver.switchTo().alert().dismiss();
	}
	
	@Test
	public void alert4() {
		driver.findElement(By.id("promtButton")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Hola Clase!");
		alert.accept();
	}
}
