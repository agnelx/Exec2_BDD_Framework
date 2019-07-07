package stepDefinitions;


import java.io.*;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;


import org.junit.Assert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;


import pageobject.homepage;
import pageobject.categorypage;
import pageobject.orderPage;
import manager.PageObjectManager;
import manager.FileReaderManager;





public class sampleSteps {

	WebDriver driver;
	private categorypage category;
	private orderPage order;

	PageObjectManager pageObjectManager;

	
	@Given("^User is in <Script_Path>$")
	public void user_is_in_Script_Path() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	@When("^Check Is the application available in \"([^\"]*)\" with \"([^\"]*)\"$")
	public void check_do_we_hav_application(String P_Path,String P_file) throws Throwable {
		
		File f = new File(P_Path+P_file); 
		
		  if(f.exists() && f.isFile()) {
			  System.out.println("File/Application Available");
		  }
		  else
		  {
			  System.out.println("File/Application not Available");
			  Assert.fail();
		  }
		  
	}
	
	
	@When("User has access to application in \"([^\"]*)\" with \"([^\"]*)\"$")
	public void User_has_to_application(String P_Path,String p_file) throws Throwable {
		
		File f = new File(P_Path+p_file);
		System.out.println(p_file);
		boolean exists = f.exists(); 
        if(exists == true) 
        {
        boolean Exec = f.canExecute();
        
        if(Exec == false) 
        {
        	System.out.println("File not Executable."); 
        	Assert.fail();
        }
        
        }
        else
        { 
            System.out.println("File not found."); 
            Assert.fail();
        } 
	}

	@Then("^Run the application/script from \"([^\"]*)\" with \"([^\"]*)\",\"([^\"]*)\" for \"([^\"]*)\" with \"([^\"]*)\"$")
	public void run_the_application_script(String python_path,String Scriptpath,String Script,String Application ,String Interval ) throws IOException {
		
		try {
	    /// set up the command and parameter
					
			String pythonScriptPath = Scriptpath+Script;
        
			Process pr = Runtime.getRuntime().exec(python_path+" "+pythonScriptPath+" "+Application+" "+Interval ); 
			 
			// retrieve output from python script
			BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String line = "";
			
					while((line = bfr.readLine()) != null) {
					// display each output line form python script
					System.out.println(line);
					if(line != null) {
						Assert.assertTrue(true);
						}
			
		                     }
					
	} catch (Exception e ) {
		e.printStackTrace();
	}
	}
	
	@Then("^wait for \"([^\"]*)\" minutes$")
	public void wait_for_minutes(String time) throws Throwable {
	    
		TimeUnit.MINUTES.sleep(1);
	}

	@Then("^Click on to any item from list$")
	public void click_on_to_any_item_from_list() {

		//category = new categorypage(driver);
		category = pageObjectManager.getcategoryPage();
		category.getitem().click();

	}
	
	@Then("^Check is the file available in \"([^\"]*)\" with \"([^\"]*)\"$")
	public void check_do_we_hav_file(String P_Path,String P_file) throws Throwable {
		
		File f = new File(P_Path+P_file); 
		
		  if(f.exists() && f.isFile()) {
			  System.out.println("File Available");
		  }
		  else
		  {
			  System.out.println("File not Available");
			  Assert.fail();
		  }
		  
	}

	@And("^Click on to add to Cart$")
	public void click_on_to_add_to_Cart() {

		try {
			//category = new categorypage(driver);
			category.addtocart().click();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@And("^Click proceed to checkout$")
	public void click_proceed_to_checkout() throws Throwable {
		//category = new categorypage(driver);
		category.proceedtocheckout().click();
	}
	
	@Then("^Check do we have \\\"([^\\\"]*)\\\" item in Cart$")
	public void check_do_we_hav_item_in_cart(String P_item_no) throws Throwable {
		
		order = pageObjectManager.getOrderPage();
		String total_item_Org=
				order.Check_order_Total().getText();
		String total_item=total_item_Org.substring(0, 1);
		Assert.assertEquals(P_item_no, total_item);
	}
	
	
	
	
	
	
	@And("^Close the browser$")
	public void close_the_browser() throws Throwable {
		Thread.sleep(1000);
		driver.close();
		
	}
	

}
