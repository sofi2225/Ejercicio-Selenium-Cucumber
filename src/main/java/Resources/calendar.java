package Resources;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import ObejectRepository.AccountPage;


public class calendar extends base {

	WebDriver driver;
	
	public void Calendario(String day, String month, String year, WebDriver driver) throws InterruptedException{
		
				
		AccountPage ap= new AccountPage(driver);
		JavascriptExecutor executor = (JavascriptExecutor)driver;

        executor.executeScript("arguments[0].scrollIntoView();", ap.InputFecha());
        jsClick(ap.InputFecha());
       // Thread.sleep(6000);
		
       WebElement mesValue= driver.findElement(By.xpath("//div[@class=\"slds-datepicker__filter slds-grid\"]/div/h2"));
		
        //WebElement mesValue= driver.findElement(By.cssSelector("[id*='month-title']"));

        
        //System.out.println(mesValue);
		
		//String value = mesValue.getText();
		//System.out.println(value);
        //Month
				
		while (!mesValue.getText().contains(month)) 
				{
				
					driver.findElement(By.xpath("//button[@title='Mes siguiente']")).click();
				}
				
				
				List<WebElement> dates = driver.findElements(By.xpath("//span[@class='slds-day']"));

				//System.out.println(dates);
					for (int i=0;i<dates.size(); i++)
					{
						String text= driver.findElements(By.xpath("//span[@class='slds-day']")).get(i).getText();
					
						//System.out.println(text);
						
						if (text.equalsIgnoreCase(day))
						{
							driver.findElements(By.xpath("//span[@class='slds-day']")).get(i).click();
							break;
					}
						
					}
		
	}



	
	
}
