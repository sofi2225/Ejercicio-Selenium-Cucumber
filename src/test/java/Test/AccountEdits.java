package Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ObejectRepository.AccountPage;
import ObejectRepository.HomePage;
import ObejectRepository.LoginPage;

import Resources.base;

public class AccountEdits extends base {
	
	public  WebDriver driver;
	
@BeforeTest
	public void initialize() throws IOException {
	
	System.out.println("I run befote Tests Account Edits");
		
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
	public void EditAccount() throws InterruptedException {
		
		AccountPage ap = new AccountPage(driver);
		
		//String OpportunityNewValue = "Yes";
		String ValoracionNewValue = "Warm";
		String TipoNewValue = "Prospect";
		
		ModifyAccount();
	
		//selectDropdownText(ap.InputOportunidad(),OpportunityNewValue);
		selectDropdownText(ap.InputValoracion(), ValoracionNewValue);
		selectDropdownText(ap.InputTipo(),TipoNewValue);
		jsClick(ap.ButtonSave());
	
        String clickLink =  Keys.chord(Keys.COMMAND,Keys.ENTER);
		ap.FirstListItem().sendKeys(clickLink);
		
		//Assertion
		Set<String> win = driver.getWindowHandles();
		Iterator<String> it = win.iterator();
		String parentId = it.next();
		String childId =it.next();
		driver.switchTo().window(childId);
		Thread.sleep(3000);
		 
		ap.DetailsAccount().click();
		Thread.sleep(5000);

		SoftAssert sa = new SoftAssert(); 
	    sa.assertEquals(ValoracionNewValue, ap.DetailsValoracion().getText());
	    sa.assertEquals(TipoNewValue, ap.DetailsTipo().getText());
	    //sa.assertEquals(OpportunityNewValue, ap.DetailsOpportunity().getText());
	    sa.assertAll();
	        
	    driver.switchTo().window(parentId);
	    Thread.sleep(2000);
	    
	    
	    
	}
	@Test 
	
	public void EmployeeNumberCheck() throws InterruptedException {
		
		AccountPage ap = new AccountPage(driver);
		
		String employeeNumber = "1431655766";
		
		ModifyAccount();
		GetInView(ap.InputEmpleados());
		jsClick(ap.InputEmpleados());
		ap.InputEmpleados().sendKeys(employeeNumber);
		ap.BlankClick().click();
	    jsClick(ap.ButtonSave());
	    
	    Thread.sleep(3000);
	    //Assertion
		 String texto = driver.findElement(By.xpath("//label[text()='Empleados']//parent::lightning-input/div[2]")).getText();
	     
		 System.out.println("Failure EmployeeNumber:"+texto);
	
		 SoftAssert sa = new SoftAssert(); 
	     sa.assertEquals("Empleados: valor fuera del rango válido en campo numérico: 1431655766", texto);
	     sa.assertAll();
		
		 
		
	}
	
	@AfterTest
	public void Quit() {
		
		//driver.quit();
		
		System.out.println("I run after Tests Account Edits");
	}


	    
		
	
}
