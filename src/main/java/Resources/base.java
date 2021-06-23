package Resources;

import java.io.*;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
			
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
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
			
			//selectDropdownText(ap.InputTipo(),tipo);
			
			jsClick(ap.InputEmpleados());
			ap.InputEmpleados().sendKeys(empleados);
			selectDropdownText(ap.InputOportunidad(),oportunidad);
			calendar c= new calendar();
			
			
			c.Calendario(fechaValue[1], fechaValue[0], fechaValue[2], driver);
			jsClick(ap.ButtonSave());

			Thread.sleep(3000);
			
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
	 
	public  WebElement BotonFrames(String m) {
		
		WebElement botonFrames = driver.findElement(By.xpath("//div[contains(text(),'Nuevo "+m.toLowerCase().charAt(0) +"')]"));
		return botonFrames;
		
	}
	
	public  List<WebElement> framesPresent(String m) {
		
		List<WebElement> framesPresent = driver.findElements(By.xpath("//div[contains(text(),'Nuevo "+m.toLowerCase().charAt(0) +"')]"));
		return framesPresent;
	}
 
	 public String getUrl() {
		 
		 String currentUrl = driver.getCurrentUrl().toString();
		 return currentUrl;
	 }
	
	 public void implicitWaitChange(long time) {
		 
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	 }
	 
}


