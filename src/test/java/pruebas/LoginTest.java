package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaHome;
import paginas.PaginaLogin;

public class LoginTest {
	String driverPath = "..\\EducacionIT21Feb2022\\Drivers\\chromedriver.exe";
	String url = "http://automationpractice.com";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void login() {
		// Paso 1 - Hacer clic en el hipervinculo "Sign In"
		PaginaHome inicio = new PaginaHome(driver);
		inicio.clicEnSignIn();
		
		// Paso 2 - Completar las credenciales
		PaginaLogin login = new PaginaLogin(driver);
		login.ingresarCredenciales("correo0.7325625277880763@mailinator.com", "1q2w3e4r5t");
		
		// Paso 3 - Hacer clic en el botón "Sign In"
		login.clicEnSignIn();
	}
	
	@Test
	public void buscarPalabra() {
		// Paso 1 - Escribir palabra
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirValorABuscar("skirt");
		
		// Paso 2 - Hacer la búsqueda
		login.hacerClicEnBuscar();
	}
	
	@Test
	public void irAContactUs() {
		PaginaLogin login = new PaginaLogin(driver);
		login.hacerClicEnContactUs();
	}
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
}
