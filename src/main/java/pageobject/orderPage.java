package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class orderPage {

	private WebDriver driver;

	public orderPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement Check_order_Total() {
		return driver.findElement(By.xpath("//*[@id='summary_products_quantity']"));
		
		
	}

}
