package stepDefinitions;

import java.util.Iterator;
import java.util.Set;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.asserts.SoftAssert;
import ObejectRepository.AccountPage;
import ObejectRepository.HomePage;
import ObejectRepository.LoginPage;
import ObejectRepository.Servicios;
import Resources.base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class stepDefinition extends base {
	
	@Given("^Initalize driver in Chrome and login with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void initalize_driver_in_chrome_and_login_with_username_something_and_password_something(String strArg1, String strArg2) throws Throwable {
        
			driver = initializeDriver();	
			driver.get("https://tdccom-dev-ed.my.salesforce.com");
			LoginPage log = new LoginPage(driver);
			//Login
			log.LogUsername().sendKeys(strArg1);
			log.LogPassword().sendKeys(strArg2);
			log.LogButton().click();
			
		}
		
	
		@When("User is on Service Page")
		public void user_click_a_tab_to_open()  {

			HomePage home = new HomePage(driver);
			//Menu
			home.ButtonWaffle().click();
			home.ButtonService().click();
			
		}
		

	    @Then("Click on all tabs if button new present click and the cancel")
	    public void if_new_account_button_is_present_clicks_on_new_and_then_cancel() throws InterruptedException  {
	    	
	    	Servicios serv = new Servicios(driver);
			executor = (JavascriptExecutor)driver;
			
			jsClick(serv.TabChatter());
			jsClickNew(serv.TabCuentas() );
			jsClickNew(serv.TabContactos());
			jsClickNew( serv.TabCasos());
			JsClickInforme( serv.TabInformes());
		
	    }

	    
	    @When("User is on Account Page")
	    public void user_is_on_account_page() {
	        // Write code here that turns the phrase above into concrete actions
	    	
	    	executor = (JavascriptExecutor)driver;
	    	Servicios serv = new Servicios(driver);
	    	HomePage home = new HomePage(driver);
			
	    	//Menu
			home.ButtonWaffle().click();
			home.ButtonService().click();
	    	jsClick(serv.TabCuentas() );
	    }
	    

	    @Then("^Create \"([^\"]*)\" complete accounts and \"([^\"]*)\" account with empty name field$")
	    public void create_something_complete_accounts_and_something_account_with_empty_name_field(String strArg1, String strArg2) throws Throwable {
	    	int num1 =Integer.parseInt(strArg1);
	    	int num2 =Integer.parseInt(strArg2);
	    	
	    	CreateAccountFromExcel(num1+num2);
	    	
	    }
	    
	    @And("Create account with previous account name")
	    public void Create_account_with_previous_account_name() throws Throwable {

	    	AccountPage ap = new AccountPage(driver);
	    	NewAccount();
	    	String nombre = ap.GetNameDetail().getText();
	    	jsClick(ap.InputName());
			ap.InputName().sendKeys(nombre);
			ap.ButtonSave().click();
			
	    }
	    
	    
	    @Then("^Modify (.+), (.+) and (.+) on crated last account$")
	    public void modify_and_on_crated_last_account(String rating, String upsellopportunity, String type) throws Throwable {

	    	AccountPage ap = new AccountPage(driver);
		
			ModifyAccount();
		
			//selectDropdownText(ap.InputOportunidad(),upsellopportunity);
			selectDropdownText(ap.InputValoracion(), rating);
			selectDropdownText(ap.InputTipo(),type);
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
		    sa.assertEquals(rating, ap.DetailsValoracion().getText());
		    sa.assertEquals(type, ap.DetailsTipo().getText());
		    //sa.assertEquals(upsellopportunity, ap.DetailsOpportunity().getText());
		    sa.assertAll();
		        
		    driver.switchTo().window(parentId);
		    Thread.sleep(2000);
		    
	    }
	    
	    
	    @When("^User populate employee number with \"([^\"]*)\"$")
	    public void user_populate_employee_number_with_something(String strArg1) throws Throwable {
	        
			AccountPage ap = new AccountPage(driver);
	    	ModifyAccount();
			GetInView(ap.InputEmpleados());
			ap.InputEmpleados().click();
			ap.InputEmpleados().clear();
			ap.InputEmpleados().sendKeys(strArg1);
			ap.BlankClick().click();
		    jsClick(ap.ButtonSave());
	    }

	    
	    @Then("^Verify error message \"([^\"]*)\"$")
	    public void verify_error_message_something(String strArg1) throws Throwable {
	     
	    AccountPage ap = new AccountPage(driver);
	    ap.TextoError().getText();
	     
		
	
		 SoftAssert sa = new SoftAssert(); 
	     sa.assertEquals(strArg1, ap.TextoError().getText());
	     sa.assertAll();
	     
	    }
	    
	    
	    
	    
	    
	    
	    

}
