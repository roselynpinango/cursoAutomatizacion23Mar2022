package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaHome {
	// Elementos
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement lnkSignIn;
	
	@FindBy(linkText="Sign out")
	WebElement lnkSignOut;
	
	WebDriver driver;
	
	// Constructor
	public PaginaHome(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Acciones
	public void clicEnSignIn() {
		lnkSignIn.click();
	}
	
	public void clicEnSignOut() {
		lnkSignOut.click();
	}
}
