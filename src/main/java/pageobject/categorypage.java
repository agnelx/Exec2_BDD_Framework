package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.common;

public class categorypage {

	private WebDriver driver;

	public categorypage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getitem() {
		return driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='--'])[1]/preceding::i[1]"));
	}

	public WebElement addtocart() {
		common.waitForElementPresence(driver, By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Add to Compare'])[1]/preceding::span[2]"), 30);
		return driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Add to Compare'])[1]/preceding::span[2]"));

	}

	public WebElement proceedtocheckout() {
		return driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span"));
	}

}
