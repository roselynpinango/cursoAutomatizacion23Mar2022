package Edit.EducacionIT21Feb2022;

import org.testng.annotations.Test;

import Utilities.CapturaEvidencia;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Laboratorio4 {
	String driverPath = "..\\EducacionIT21Feb2022\\Drivers\\chromedriver.exe";
	String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	WebDriver driver;
	File screen;
	String screenPath = "..\\EducacionIT21Feb2022\\Evidencias\\";
	String docPath = "..\\EducacionIT21Feb2022\\Evidencias\\";

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(description="Ir a Contactanos AutomationPractice",priority=4)
	public void IrAContactUs() throws IOException {
		driver.findElement(By.linkText("Contact us")).click();
		
		// Capturar pantalla
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(screenPath + "01_PantallaContactUs.jpg"));
	}
	
	@Test(description="Registrar Usuario AutomationPractice", priority=0)
	public void registrarUsuario () throws InvalidFormatException, IOException, InterruptedException {
		String nombreDocumento = "documentoEvidencias" + Math.random() + ".docx";
		CapturaEvidencia.escribirTituloEnDocumento(docPath + nombreDocumento, "Caso de Prueba - Registrar Usuario", 16);
		
		// Escribir el correo y hacer clic en el boton Create an account
		driver.findElement(By.id("email_create")).sendKeys("correo" + Math.random() + "@mailinator.com");
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, screenPath + "img.png", docPath + nombreDocumento, "Ingresando el correo");
		
		driver.findElement(By.name("SubmitCreate")).click();
				
		// Completar el formulario y hacer en el boton Register
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='customer_firstname']")));
				
		CapturaEvidencia.capturarPantallaEnDocumento(driver, screenPath + "img.png", docPath + nombreDocumento, "Formulario a Completar");
		
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
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, screenPath + "img.png", docPath + nombreDocumento, "Formulario lleno");
		
		// botón
		driver.findElement(By.cssSelector("#submitAccount")).click();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, screenPath + "img.png", docPath + nombreDocumento, "Resultado del Registro");
		
		// Comprobar que luego del registro el título de la pagina es My account - My Store
		Assert.assertEquals(driver.getTitle(), "My account - My Store");
		
		// Comprobar que la URL luego del registro cambió
		Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=my-account");
	
		// Ir a la base de datos a buscar al usuario (Conector SQL) : resultadoConsulta = "SELECT COUNT(*) FROM usuario WHERE EMAIL = 'correo@mailinator.com';
		// Invocar una API y leer los resultados (Rest-Assured)
		// Assert.assertTrue(resultadoConsulta > 0);
	}
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
}
