package Edit.EducacionIT21Feb2022;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio3 {
	String driverPath = "..\\EducacionIT21Feb2022\\Drivers\\chromedriver.exe";
	String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	WebDriver driver;
	
	@Test
	public void registrarUsuario() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		// Escribir el correo y hacer clic en el boton Create an account
		driver.findElement(By.id("email_create")).sendKeys("correo07Mar2022@mailinator.com");
		driver.findElement(By.name("SubmitCreate")).click();
		
		// Completar el formulario y hacer en el boton Register
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='customer_firstname']")));
		
		// Firstname
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Ana");
		
		// LastName
		driver.findElement(By.id("customer_lastname")).sendKeys("Hernandez");
		
		// Password
		driver.findElement(By.name("passwd")).sendKeys("1q2w3e4r5t");
		
		// Title
		driver.findElement(By.id("id_gender1")).click();
		
		// newsletter
		driver.findElement(By.cssSelector("#newsletter")).click();
		
		// dia
		Select dias = new Select(driver.findElement(By.name("days")));
		dias.selectByValue("18");
		
		// mes
		Select mes = new Select(driver.findElement(By.id("months")));
		mes.selectByValue("6");
		
		// año
		Select anio = new Select(driver.findElement(By.xpath("//select[@id='years']")));
		anio.selectByValue("1990");
		
		// Direccion
		driver.findElement(By.cssSelector("#address1")).sendKeys("MiCalle 123 4B");
		
		// City
		driver.findElement(By.id("city")).sendKeys("Cordoba");
		
		// Estado
		Select state = new Select(driver.findElement(By.name("id_state")));
		state.selectByVisibleText("Arkansas");
		
		// zipCode
		driver.findElement(By.id("postcode")).sendKeys("90450");
		
		// mobile
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("4756768687");
		
		// alias
		WebElement alias = driver.findElement(By.id("alias"));
		alias.clear();
		alias.sendKeys("Casa");
		
		// botón
		driver.findElement(By.cssSelector("#submitAccount")).click();
	}
}
