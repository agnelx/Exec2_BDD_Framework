package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.common;

public class homepage {

	private WebDriver driver;

	public homepage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSignInBtn() {
		// return driver.findElement(By.xpath("//a[contains(text(), \"Sign in\")]"));
		return common.waitToBeClickable(driver, By.cssSelector("a.login"), 30);
	}

	public WebElement getTshirt() {
		return driver.findElement(By.xpath("(//a[contains(text(),'T-shirts')])[2]"));
		// return common.waitToBeClickable(driver,
		// By.xpath("(//a[contains(text(),'T-shirts')])[2]"),30);
	}

}
