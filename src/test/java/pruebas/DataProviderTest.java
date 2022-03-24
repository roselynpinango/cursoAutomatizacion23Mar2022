package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.DatosExcel;
import paginas.PaginaHome;
import paginas.PaginaLogin;

public class DataProviderTest {
	String driverPath = "..\\EducacionIT21Feb2022\\Drivers\\chromedriver.exe";
	String url = "http://automationpractice.com";
	String excelPath = "..\\EducacionIT21Feb2022\\datos\\datos_Login.xlsx";
	String nombreHoja = "Hoja1";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="Datos Login Excel")
	public void login(String email, String contrasenia) {
		// Paso 1 - Hacer clic en el hipervinculo "Sign In"
		PaginaHome inicio = new PaginaHome(driver);
		inicio.clicEnSignIn();
		
		// Paso 2 - Completar las credenciales
		PaginaLogin login = new PaginaLogin(driver);
		login.ingresarCredenciales(email, contrasenia);
		
		// Paso 3 - Hacer clic en el botón "Sign In"
		login.clicEnSignIn();
		
		Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=my-account");
		
		// Sign Out
		inicio.clicEnSignOut();
	}
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
	
	@DataProvider(name="Datos Login Excel")
	public Object[][] getExcelData() throws Exception {
		return DatosExcel.leerExcel(excelPath, nombreHoja);
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] getData() {
		// Devuelva los datos a utilizar en la prueba (Arreglo bidimensional)
		Object[][] datos = new Object[3][2];
		
		datos[0][0] = "correo0.7325625277880763@mailinator.com"; // Email
		datos[0][1] = "1q2w3e4r5t"; // Contraseña
		
		datos[1][0] = "";
		datos[1][1] = "3wrw34r3wf43wr";
		
		datos[2][0] = "correo@micorreo.com";
		datos[2][1] = "67yi7yuikyt7";
		
		return datos;
	}
}
