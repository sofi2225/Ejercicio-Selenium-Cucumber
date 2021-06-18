package ObejectRepository;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
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

	@FindBy (css="a[title*='Nuevo']")
	WebElement buttonsNuevo;
	
	@FindBy (xpath="//button[@title='Cancelar']|//button[text()='Cancelar']")
	WebElement buttonsCancelar;
	
	@FindBy (xpath="//div[@title='Nuevo informe']")
	List<WebElement> nuevoInformeIsPresent;
	
	@FindBy (css="a[title='Nuevo']")
	List<WebElement> buttonNewPresent;
	
	
	@FindBy (xpath="//button[@class='slds-button slds-button_neutral cancelBtn']")
	WebElement botonCancelarPanel;
	
	@FindBy (xpath="//button[@title='Close']")
	WebElement botonCancelarInforme;
	
	@FindBy (xpath=	"//iframe[@title='dashboard']")
	WebElement frameDashboard;
	
	@FindBy (tagName="iframe")
	WebElement frame;
	
	
	@FindBys (value=@FindBy (xpath="//div[@title='Nuevo informe']"))
	List<WebElement> primertab;
	
	@FindBys (value=@FindBy (xpath="//one-app-nav-bar-item-root[@data-assistive-id='operationId']/a"))
	List<WebElement> listaelementosmenu;
	


	public WebElement Frame() {
		
		return frame;
		
	}
	
	public List<WebElement> listaElementosMenu() {
		
		return listaelementosmenu;
		
	}
	
	public List<WebElement> pirmerTab() {
		
		return primertab;
		
	}
	
	public WebElement frameDashboard() {
		
		return frameDashboard;
		
	}
	
	
	public WebElement BotonCancelarPanel() {
		
		return botonCancelarPanel;
		
	}
	
	public WebElement BotonCancelarInforme() {
		
		return botonCancelarInforme;
		
	}
	
	public int buttonNewPresent() {
		
		int newIsPresent = buttonNewPresent.size();
		return newIsPresent ;
		
	}
	
	
	public int InformeIsPresent() {
		
		int informeIsPresent = nuevoInformeIsPresent.size();
		return informeIsPresent ;
		
	}
	


public WebElement ButtonsCancelar() {
		
		return buttonsCancelar;
		
	}
	
	public WebElement ButtonsNuevo() {
		
		return buttonsNuevo;
		
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