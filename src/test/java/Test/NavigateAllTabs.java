package Test;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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
	
	System.out.println("I run befote Tests Navigate");
		
		driver = initializeDriver();	
		driver.get("https://tdccom-dev-ed.my.salesforce.com");
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
		
		jsClick(serv.TabChatter());
		jsClickNew(serv.TabCuentas() );
		jsClickNew(serv.TabContactos());
		jsClickNew( serv.TabCasos());
		JsClickInforme( serv.TabInformes());
		
	}
	
	@AfterTest
	public void Quit() {
		
		driver.quit();
		System.out.println("I run after Tests Navigate");
	}
	
}
