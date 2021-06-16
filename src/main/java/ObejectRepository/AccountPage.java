package ObejectRepository;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	WebDriver driver;
	
	
	public AccountPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (css="[title='Nuevo']")
	WebElement buttonNew;
	
	@FindBy (xpath="//input[@name='Name']")
	WebElement inputName;
	

	@FindBy (xpath="//label[text()='Valoración']//parent::lightning-combobox/div")
	WebElement valoracion;

	
	@FindBy (xpath="//label[text()='Tipo']//parent::lightning-combobox/div")
	WebElement tipo;
	
	@FindBy (xpath="//label[text()='Empleados']//parent::lightning-input/div/input")
	WebElement empleados;

	@FindBy (xpath="//label[text()='Upsell Opportunity']//parent::lightning-combobox/div")
	WebElement oportunidad;
	
	@FindBy (xpath="//label[text()='SLA Expiration Date']//parent::div/div/input")
	WebElement fecha;

	@FindBy (xpath="/html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/td[6]/span/div/a/span/span[1]")
	WebElement menuModificar;
	
	@FindBy (xpath="//a[@title='Modificar']")
	WebElement modificar;
	
	@FindBy (xpath="//*[@id='brandBand_1']/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/th/span/a")
	WebElement firstItem;
	
	@FindBy (xpath="//button[@name=\"SaveEdit\"]")
	WebElement save;
	
	@FindBy (xpath="//a[@data-tab-value='detailTab']")
	WebElement details;
	
	@FindBy (xpath="//span[text()='Valoración']//parent::div//parent::div/div[2]/span/slot/slot/lightning-formatted-text")
	WebElement detailsValoracion;
	
	@FindBy (xpath="//span[text()='Tipo']//parent::div//parent::div/div[2]/span/slot/slot/lightning-formatted-text")
	WebElement detailsTipo;
	
	@FindBy (xpath="//span[text()='Upsell Opportunity']//parent::div//parent::div/div[2]/span/slot/slot/lightning-formatted-text")
	WebElement detailsOpportunity;
	
	@FindBy (xpath="//table[@role='grid']/tbody/tr/th/span/a")
	WebElement getNameDetail;
	
	@FindBy (xpath="//div[@class='actionBody']")
	WebElement blankClick;
	
	@FindBy (xpath="//label[text()='Valoración']//parent::lightning-combobox/div/lightning-base-combobox/div/div/input")
	WebElement validacionText; 
	
	@FindBy (xpath="//label[text()='Empleados']//parent::lightning-input/div[2]")
	WebElement textoError;
	
	
public WebElement TextoError() {
		
		return textoError;
	}

	public WebElement ButtonNew() {
		
		return buttonNew;
	}
	
	public WebElement InputName() {
		
		return inputName;
	}
	
	public WebElement InputValoracion() {
		
		return valoracion;	
	}

	public WebElement InputTipo() {
		
		return tipo;	
	}
	
	public WebElement InputEmpleados() {
		
		return empleados;	
	}

	public WebElement 	InputOportunidad() {
		
		return oportunidad;	
	}
	
	public WebElement 	InputFecha() {
		
		return fecha;	
	}
	
	public WebElement ButtonSave() {
		
		return save;	
	}

	public WebElement ButtonModificar() {
		
		return modificar;	
	}
	
	public WebElement ButtonMenuModificar() {
		
		return menuModificar;	
	}

	public WebElement FirstListItem() {
		
		return firstItem;	
	}

	public WebElement DetailsAccount() {
		
		return details;	
	}
	
	public WebElement DetailsValoracion() {
		
		return detailsValoracion;	
	}
	
	public WebElement DetailsTipo() {
		
		return detailsTipo;	
	}

	public WebElement DetailsOpportunity() {
	
		return detailsOpportunity;	
	}
	
	public WebElement GetNameDetail() {
		
		return getNameDetail;	
	}
	
	public WebElement BlankClick() {
		
		return blankClick;	
	}

	public WebElement ValidacionText() {
		
		return validacionText;	
	}



	
	
}
