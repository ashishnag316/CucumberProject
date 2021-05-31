package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalHomePage {
	
	public WebDriver driver;
	//constructor
	public PortalHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By searchBox =  By.name("query");
	
	
	
	
	public WebElement searchBox()
	{
		return driver.findElement(searchBox);
	}
	

}
