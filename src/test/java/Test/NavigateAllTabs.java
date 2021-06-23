package Test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ObejectRepository.HomePage;
import ObejectRepository.LoginPage;
import ObejectRepository.Servicios;
import Resources.base;

public class NavigateAllTabs extends base{
	

	public  WebDriver driver;

	
@BeforeTest
	
	public void initialize() throws IOException {
		
		driver = initializeDriver();	
		driver.get("https://login.salesforce.com");
		executor = (JavascriptExecutor)driver;
		
		LoginPage log = new LoginPage(driver);
		HomePage home = new HomePage(driver);

		//Login
		System.out.println(log.LogUsername());
		log.LogUsername().sendKeys("sofi@tdc.com");
		log.LogPassword().sendKeys("SSALES1234");
		log.LogButton().click();
		
		//Menu
		home.ButtonWaffle().click();
		home.ButtonService().click();
	}
	
	

	@Test 

	public void Clicks() throws InterruptedException {
		Servicios serv = new Servicios(driver);
		 WebDriverWait w = new WebDriverWait(driver , 8);


		for (WebElement i : serv.listaElementosMenu()) {
			
			String tabName = (i.getText());
			jsClick(i);
			
				List<WebElement> botonesFrames = framesPresent(tabName);
			
				if ( serv.buttonNewPresent()!= 0 && botonesFrames.size() == 0 ) {
					
					jsClick(serv.ButtonsNuevo());
					serv.ButtonsCancelar().click();
				}
				
				 if  ( botonesFrames.size() != 0 ) {
				
					jsClick(BotonFrames(tabName));
														
						if (serv.pirmerTab().size()==0) {
							w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(serv.frameDashboard()));
							jsClick(serv.BotonCancelarPanel());

						} else {
							w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(serv.Frame()));
							jsClick(serv.BotonCancelarInforme());
				 		}
	
					driver.switchTo().parentFrame();}
		}
	
    }
	
	@AfterTest
	public void Quit() {
		
		driver.quit();
		System.out.println("I run after Tests Navigate");
	}
	
}
