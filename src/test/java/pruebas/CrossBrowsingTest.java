package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import paginas.PaginaHome;
import paginas.PaginaLogin;

public class CrossBrowsingTest {
	WebDriver driver;
	String chromeDriverPath = "..\\EducacionIT21Feb2022\\Drivers\\chromedriver.exe";
	String firefoxDriverPath = "..\\EducacionIT21Feb2022\\Drivers\\geckodriver.exe";
	String url = "http://automationpractice.com";
	
	@BeforeClass
	@Parameters("navegador")
	public void setUp(String navegador) {
		if (navegador.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
		} else if (navegador.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			driver = new FirefoxDriver();
		}
				
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void login() {
		PaginaHome home = new PaginaHome(driver);
		home.clicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.ingresarCredenciales("correo0.7325625277880763@mailinator.com", "1q2w3e4r5t");
		login.clicEnSignIn();
	}
}
