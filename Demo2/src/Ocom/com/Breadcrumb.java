package Ocom.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Breadcrumb {
	static {
		System.setProperty("webdriver.chrome.driver", ".//Driver/chromedriver.exe");
	}

	public static void getButton(WebElement main, WebDriver driver) 
	{
		List<WebElement> Classes = main.findElements(By.xpath(".//div[contains(@class,'obttns')]"));
		Actions action = new Actions(driver);

		for (WebElement CLass : Classes) {
			List<WebElement> buttns = CLass.findElements(By.xpath(".//div"));
			for (WebElement buttn : buttns) {

				WebElement a = buttn.findElement(By.tagName("a"));
				String text = a.getAttribute("innerText");
				String color = a.getCssValue("color");
				String backgroundColor = a.getCssValue("background-color");
				System.out.println(text + "->" + color + "->" + backgroundColor);
				action.moveToElement(buttn).build().perform();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				color = a.getCssValue("color");
				backgroundColor = a.getCssValue("background-color");
				System.out.println(text + "->" + color + "->" + backgroundColor);

			}
		}
	}
	
	
	public static void getU03(WebElement main,WebDriver driver) {
		
		getButton(main, driver);
		String mainBColor = main.getCssValue("background-color");
		System.out.println(mainBColor);
		ancorLinks.getLinks(main, driver);
		ConventionalTags.getConventionalTags( main,driver);
		
	}
	

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://webstandards.us.oracle.com:9494/ocom/template-sample/pillar-overview.html");
		WebElement main = driver.findElement(By.xpath(".//nav[contains(@data-ocomid,'u03')]"));
		int X = main.getLocation().getX();
		int Y = main.getLocation().getY();
		JavascriptExecutor linkJ = (JavascriptExecutor) driver;
		linkJ.executeScript("window.scrollBy(" + X + "," + Y + ")");
		
		getButton(main, driver);
		String mainBColor = main.getCssValue("background-color");
		System.out.println(mainBColor);
		ancorLinks.getLinks(main, driver);
		ConventionalTags.getConventionalTags( main,driver);
		
		
		
		
		driver.close();

	}

}
