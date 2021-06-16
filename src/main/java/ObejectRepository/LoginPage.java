package ObejectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

	
	@FindBy (id="username")
	WebElement username;
	
	@FindBy (id="password")
	WebElement password;
	
	@FindBy (id="Login")
	WebElement buttonLog;
	
	
	public WebElement LogUsername() {
		
		return username;
	}
	
	public WebElement LogPassword() {
		
		return password;
	}
	
	public WebElement LogButton() {
		
		return buttonLog;
	}
	
}
