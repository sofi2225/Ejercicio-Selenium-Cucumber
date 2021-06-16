package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

import Excel.ExcelData;
import ObejectRepository.AccountPage;
import ObejectRepository.Servicios;

public class base {

	public static JavascriptExecutor executor;
	public static WebDriver driver;
	public Properties prop;

	
	
	public WebDriver initializeDriver() throws IOException {
	
		prop = new Properties();
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Resources//data.properties");
		prop.load(fis);
		//mvn test -browser	
		//String browserName =  System.getProperty("browser");
		
		String browserName =prop.getProperty("browser");
		
		if (browserName.contains("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","/Users/sofi/Documents/Drivers/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			
			driver = new ChromeDriver(options);
	
		}else if (browserName.equals("firefox")) {
			//Firefox code
		}else if (browserName.equals("IE")) {
			//IE code
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	
	
	
	public static void CreateAccountFromExcel(int cuentasACrear) throws InterruptedException, IOException {
		
		
		for (int i=0; i<cuentasACrear; i++) {	
	   
		String nombre = getExcelData()[i][0].toString();
		String valoracion = getExcelData()[i][1].toString();
		String tipo = getExcelData()[i][2].toString();
		String empleados = getExcelData()[i][3].toString();
		String fecha = getExcelData()[i][4].toString();
		String oportunidad = getExcelData()[i][5].toString();
    	
		CreateAccount(nombre,fecha,valoracion,tipo,empleados, oportunidad);
		
		}
	}
	
	public static void jsClick(WebElement webElement)  {
		
		executor.executeScript("arguments[0].click();", webElement);
	}
	
	
	 public static void jsClickNew(WebElement webElement) throws InterruptedException  {
		 
		 	
			executor.executeScript("arguments[0].click();", webElement);
			driver.findElement(By.cssSelector("a[title='Nuevo']")).click();
			driver.findElement(By.xpath("//button[@title='Cancelar']|//button[text()='Cancelar']")).click();
		
				
		}
	 
	 
	 public static void JsClickInforme( WebElement webElement) throws InterruptedException {

			executor.executeScript("arguments[0].click();", webElement);
			driver.findElement(By.cssSelector("span[data-aura-class='folderActionBar'] ul li a")).click();
			Thread.sleep(3000);
			
			driver.switchTo().frame(0);
			Thread.sleep(2000);
			
			WebElement cancel = driver.findElement(By.cssSelector("[class='slds-button slds-button_neutral report-type-cancel']"));
			executor.executeScript("arguments[0].click();", cancel);
			
			driver.switchTo().parentFrame();
	 }
	 
	 
	 
	 
	 public static void selectDropdownText(WebElement webElement,String text) throws InterruptedException {
		 
		 	executor.executeScript("arguments[0].scrollIntoView();", webElement);
		 	Thread.sleep(2000);
			webElement.click();
			driver.findElement(By.xpath("//*[text()='"+text+"']")).click();
		 
	 }
	 

	 public static void GetInView(WebElement webElement) throws InterruptedException {
		 
		 	executor.executeScript("arguments[0].scrollIntoView();", webElement);
		 	
		 
	 }
	 
	 public static void CreateAccount(String nombre,String fecha,String valoracion,String tipo,String empleados,String oportunidad) throws InterruptedException {
		 
		 	NewAccount();
		 	AccountPage ap = new AccountPage(driver);
		
			jsClick(ap.InputName());
			ap.InputName().sendKeys(nombre);
		
			String[] fechaValue = fecha.split("-");
			
			
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
			System.out.println("Url found :"+url);
	       // SoftAssert sa = new SoftAssert(); 
	       // sa.assertTrue(url.contains("view"));
	       // sa.assertAll();
	 }
	 
	
	 public static void NewAccount() throws InterruptedException{
		 
			Servicios serv = new Servicios(driver);
		 	AccountPage ap = new AccountPage(driver);
			
		 	jsClick(serv.TabCuentas());
			Thread.sleep(3000);
			jsClick(ap.ButtonNew()); 
			
	 }
	 
	 public void ModifyAccount() throws InterruptedException {
		 	Servicios serv = new Servicios(driver);
		 	AccountPage ap = new AccountPage(driver);
		 
			jsClick(serv.TabCuentas());
			Thread.sleep(4000);

			ap.ButtonMenuModificar().click();
			ap.ButtonModificar().click();
	 }
	 

	public static Object[][] getExcelData() throws IOException {
		 
		ExcelData d = new ExcelData();
		Object[][] dataExcel = d.getData() ;
		
		return dataExcel;
	 }
	 
	 
}


