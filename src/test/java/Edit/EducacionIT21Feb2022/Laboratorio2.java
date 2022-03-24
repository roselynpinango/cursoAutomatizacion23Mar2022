package Edit.EducacionIT21Feb2022;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Laboratorio2 {
	String driverPath = "..\\EducacionIT21Feb2022\\Drivers\\chromedriver.exe";
	String driverPathFirefox = "..\\EducacionIT21Feb2022\\Drivers\\geckodriver.exe";
	String url = "http://automationpractice.com";
	
	@Test
	public void buscarPalabraEnChrome() {
		// 1. Configurar el driver que vamos a utilizar
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		// 2. Abrir la pagina de AutomationPractice.com
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		// 2.1 Maximizar la pagina
		driver.manage().window().maximize();
		
		// 2.2 Borrar las cookies
		driver.manage().deleteAllCookies();
		
		// 3. Escribir la frase/palabra a buscar
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// 4. Hacer la busqueda
		txtBuscador.sendKeys(Keys.ENTER);
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		// 5. Cerrar el navegador
		driver.close();
	}
	
	@Test
	public void buscarPalabraEnFirefox() {
		// 1. Configurar el driver que vamos a utilizar
		System.setProperty("webdriver.gecko.driver", driverPathFirefox);
		
		// 2. Abrir la pagina de AutomationPractice.com
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		
		// 3. Escribir la frase/palabra a buscar
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// 4. Hacer la busqueda
		txtBuscador.sendKeys(Keys.ENTER);
		
		// 5. Cerrar el navegador
		//driver.close();
	}
}
