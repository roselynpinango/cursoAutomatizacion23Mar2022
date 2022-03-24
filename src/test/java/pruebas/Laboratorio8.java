package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio8 {
	String driverPath = "..\\EducacionIT21Feb2022\\Drivers\\chromedriver.exe";
	String url = "https://demo.guru99.com/test/table.html"; //"https://demo.guru99.com/test/upload";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void subirArchivo() {
		driver.findElement(By.id("uploadfile_0")).sendKeys("C:\\addIntegerData.txt");
		
	}
	
	@Test
	public void imprimirValor8() {
		String valor = driver.findElement(By.xpath("//tbody/tr[4]/td[3]")).getText();
		System.out.println("Valor de la celda = " + valor);
	}
}
