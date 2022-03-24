package paginas;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {
	@FindBy(id="email")
	WebElement txtEmail;
	
	@FindBy(name="passwd")
	WebElement txtContrasenia;
	
	@FindBy(css="#SubmitLogin")
	WebElement btnSignIn;
	
	@FindBy(id="search_query_top")
	WebElement txtSearch;
	
	@FindBy(linkText="Contact us")
	WebElement lnkContactUs;
	
	public PaginaLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void ingresarCredenciales(String email, String contrasenia) {
		txtEmail.sendKeys(email);
		txtContrasenia.sendKeys(contrasenia);
	}
	
	public void clicEnSignIn() {
		btnSignIn.click();
	}
	
	public void escribirValorABuscar(String valor) {
		txtSearch.sendKeys(valor);
	}
	
	public void hacerClicEnBuscar() {
		txtSearch.sendKeys(Keys.ENTER);
	}
	
	public void hacerClicEnContactUs() {
		lnkContactUs.click();
	}
}
