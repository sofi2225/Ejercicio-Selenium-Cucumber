package Test;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Excel.ExcelData;
import ObejectRepository.AccountPage;
import ObejectRepository.HomePage;
import ObejectRepository.LoginPage;
import ObejectRepository.Servicios;
import Resources.base;
import Resources.calendar;

public class AccountTests extends base {
	
	public  WebDriver driver;
	
	
@BeforeTest
	public void initialize() throws IOException {
		
	System.out.println("I run befote Tests Account Tests");
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
	
	
	@DataProvider
	public Object[][] getDataExcel() throws IOException {
		
		ExcelData d = new ExcelData();
		Object[][] dataExcel = d.getData() ;
		
		return dataExcel;
		
	}
	
	@Test (dataProvider="getDataExcel")
	
	public void CreateAccounts(String nombre, String valoracion,String tipo,String empleados,String fecha,String oportunidad) throws InterruptedException {
		
		AccountPage ap = new AccountPage(driver);
		String[] fechaValue = fecha.split("-");
	
    	NewAccount();
   
    	jsClick(ap.InputName());
		ap.InputName().sendKeys(nombre);
	
		selectDropdownText(ap.InputValoracion(),valoracion);
		//Thread.sleep(2000);
		//selectDropdownText(ap.InputTipo(),tipo);
		
		jsClick(ap.InputEmpleados());
		ap.InputEmpleados().sendKeys(empleados);
		selectDropdownText(ap.InputOportunidad(),oportunidad);
		calendar c= new calendar();
		c.Calendario(fechaValue[1], fechaValue[0], fechaValue[2], driver);
		jsClick(ap.ButtonSave());

		Thread.sleep(7000);
		
		//Assertion
		String url = driver.getCurrentUrl();
        SoftAssert sa = new SoftAssert(); 
        sa.assertTrue(url.contains("view"));
        sa.assertAll();
        
	}
	
	@Test
	
	public void CreateAccountWithName() throws InterruptedException {
		Servicios serv = new Servicios(driver);
		AccountPage ap = new AccountPage(driver);
		
		jsClick(serv.TabCuentas());
		String nombre = ap.GetNameDetail().getText();
		String valoracion = "Warm";
	
    	NewAccount();
    	
    	jsClick(ap.InputName());
		ap.InputName().sendKeys(nombre);
		
		
		selectDropdownText(ap.InputValoracion(),valoracion);

		jsClick(ap.ButtonSave());
		
	}
	
	@AfterTest
	public void Quit() {
		
		driver.quit();
		System.out.println("I run after Tests Account Tests");
	}
	
}
