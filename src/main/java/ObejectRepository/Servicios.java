package ObejectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Servicios {

	WebDriver driver;
	
	
	public Servicios(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	
	
	@FindBy (xpath="//span[text()='Cuentas']")
	WebElement cuentasTab;
	
	@FindBy (xpath="//span[text()='Chatter']")
	WebElement chatterTab;
	
	@FindBy (xpath="//span[text()='Contactos']")
	WebElement contactosTab;
	
	@FindBy (xpath="//span[text()='Casos']")
	WebElement casosTab;
	
	@FindBy (xpath="//span[text()='Informes']")
	WebElement informesTab;
	
	@FindBy (css="span[data-aura-class='folderActionBar'] ul li a")
	WebElement frame;

	
	public WebElement Frame() {
		
		return frame;
		
	}
	
	
	public WebElement TabCuentas() {
		
		return cuentasTab;
		
	}
	
	public WebElement TabChatter() {
		
		return chatterTab;
		
	}
	public WebElement TabContactos() {
		
		return contactosTab;
		
	}

	public WebElement TabCasos() {
		
		return casosTab;
		
	}
	public WebElement TabInformes() {
		
		return informesTab;
		
	}


	
	
	
}
