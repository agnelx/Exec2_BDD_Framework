package manager;

import org.openqa.selenium.WebDriver;
import pageobject.categorypage;
import pageobject.homepage;
import pageobject.orderPage;

public class PageObjectManager {
	
	private WebDriver driver;
	private homepage home;
	private categorypage category;
	private orderPage order;
	
	 public PageObjectManager(WebDriver driver) {
		 
		 this.driver = driver;
		 
		 }
	 
	 public homepage getHomePage(){
		 
		 return (home == null) ? home = new homepage(driver) : home;
		 
		 }
	 
	 public categorypage getcategoryPage(){
		 
		 return (category == null) ? category = new categorypage(driver) : category;
		 
		 }
	 
	 public orderPage getOrderPage(){
		 
		 return (order == null) ? order = new orderPage(driver) : order;
		 
		 }
}
