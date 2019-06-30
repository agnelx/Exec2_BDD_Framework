package stepDefinitions;


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
	private homepage home;
	private categorypage category;
	private orderPage order;

	PageObjectManager pageObjectManager;

	@Given("^You are in Home page of Mystore with URL \"([^\"]*)\"$")
	public void you_are_in_Home_page_of_Mystore(String pagelink) {
		
		System.setProperty("webdriver.chrome.driver", FileReaderManager.getInstance().getConfigReader().getDriverPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		pageObjectManager = new PageObjectManager(driver);
		driver.get(pagelink);
	}

	@When("^Navigates to \"([^\"]*)\" Section$")
	public void navigates_to_Section(String p1) {

		switch (p1) {
		case "Tshirt":
			home = new homepage(driver);
			home.getTshirt().click();

		}
	}

	@Then("^Click on to any item from list$")
	public void click_on_to_any_item_from_list() {

		//category = new categorypage(driver);
		category = pageObjectManager.getcategoryPage();
		category.getitem().click();

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
