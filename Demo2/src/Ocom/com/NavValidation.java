package Ocom.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NavValidation {

	static {
		System.setProperty("webdriver.chrome.driver", ".//Driver/chromedriver.exe");
	}
	
public static void getct12(WebElement main,WebDriver driver) 
   {
		
	Actions action = new Actions(driver);
	String backgroundColor1 = main.getCssValue("background-color");
	System.out.println(backgroundColor1);
	List<WebElement> Lists = main.findElements(By.tagName("li"));
	List<WebElement> links = main.findElements(By.xpath(".//a[contains(@class,'aria-a')]"));
	List<WebElement> menuS = main
			.findElements(By.xpath(".//ul[contains(@role,'menubar')]//li[contains(@class,'ct12')]"));
	for (WebElement link : links) 
	{
		try{action.moveToElement(link).build().perform();}catch(Exception e)
		{	
		}
		String Text = link.getAttribute("innerText");
		String color = link.getCssValue("color");
		System.out.println(Text + "-" + color + "-" + backgroundColor1);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		color = link.getCssValue("color");
		/*System.out.println(Text + "-" + color + "-" + backgroundColor1);*/
	}
	for (int i = 2; i <= menuS.size() - 2; i++) {
		WebElement menu = menuS.get(i);
		  System.out.println(menu.getText());
		try {
			action.moveToElement(menu).build().perform();
		} catch (org.openqa.selenium.JavascriptException e) {
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> submenu = menu.findElements(By.tagName("a"));
		for (WebElement sub : submenu) {
			
			
			try {
				action.moveToElement(sub).build().perform();
			} catch (org.openqa.selenium.JavascriptException e) {
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
		
		
		
		
		
		
		
		
		
		
		
		
	}
public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://webstandards.us.oracle.com:9494/ocom/template-sample/pillar-overview.html");
		WebElement main = driver.findElement(By.xpath(".//nav[contains(@data-ocomid,'ct12')]"));
		int X = main.getLocation().getX();
		int Y = main.getLocation().getY();
		JavascriptExecutor linkJ = (JavascriptExecutor) driver;
		linkJ.executeScript("window.scrollBy(" + X + "," + Y + ")");
		getct12(main,driver);
		driver.close();

	}

}
