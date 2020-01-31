package Ocom.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Buttan {

	static {
		System.setProperty("webdriver.chrome.driver", ".//Driver/chromedriver.exe");
	}

	public static String Comcolor(String color) {
		String hex = "";
		String[] numbers = color.replace("rgba(", "").replace(")", "").split(",");
		int r = Integer.parseInt(numbers[0].trim());
		int g = Integer.parseInt(numbers[1].trim());
		int b = Integer.parseInt(numbers[2].trim());
		// System.out.println("r: " + r + "g: " + g + "b: " + b);
		hex = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
		// System.out.println(hex);

		return hex;
	}

	public static void getButton(WebElement main, WebDriver driver) 
	{
		List<WebElement> Classes = main.findElements(By.xpath(".//div[contains(@class,'obttns')]"));
		Actions action=new Actions(driver);
		    for (WebElement CLass : Classes) 
		    {
			List<WebElement> buttns = CLass.findElements(By.xpath(".//div"));
			for (WebElement buttn : buttns) 
			{
				WebElement a = buttn.findElement(By.tagName("a"));
				String text=a.getAttribute("innerText");
				String color=a.getCssValue("color");
				String backgroundColor=a.getCssValue("background-color");	
				System.out.println(text+"->"+color+"->"+backgroundColor);
				action.moveToElement(buttn).build().perform();
				
				String text1=a.getAttribute("innerText");
				String color1=a.getCssValue("color");
				String backgroundColor1=a.getCssValue("background-color");	
				System.out.println(text1+"->"+color1+"->"+backgroundColor1);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
			}}}


	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.oracle.com/corporate/citizenship/?betamode=20.0.0");
		WebElement main = driver.findElement(By.xpath(".//section[contains(@data-ocomid,'cb83')]"));
		int X = main.getLocation().getX();
		int Y = main.getLocation().getY();
		JavascriptExecutor linkJ = (JavascriptExecutor) driver;
		linkJ.executeScript("window.scrollBy(" + X + "," + Y + ")");
		
		getButton(main, driver);

		
		driver.close();

	}
}
