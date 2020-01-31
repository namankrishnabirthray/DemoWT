package Ocom.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Footer {

	static {
		System.setProperty("webdriver.chrome.driver", ".//Driver/chromedriver.exe");
	}

	public static void getFooter(WebElement main, WebDriver driver) 
	{

		String[] tags = { "strong", "p", "h1", "h2", "h3", "h4", "h5", "h6", "li", "b" };
		Actions action = new Actions(driver);
		List<WebElement> links = main.findElements(By.tagName("a"));
		List<WebElement> headings = main.findElements(By.tagName("h5"));
		
		for (WebElement heading : headings) 
		{
			String Text = heading.getAttribute("innerText");
			System.out.println(Text);
			String color = heading.getCssValue("color");
			System.out.println(color);
		}
		for (WebElement link : links) {

			
			String linktext = link.getAttribute("innerText");
			if (!linktext.equals("") && linktext != null) {
				System.out.println(linktext);
				String color = link.getCssValue("color");
				action.moveToElement(link).build().perform();
				String hoverColor = link.getCssValue("color");
				if (color.equals(hoverColor)) {
					System.out.println(color);
				} else {
					System.out.println("Hover" + "->" + color + hoverColor);
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://webstandards.us.oracle.com:9494/ocom/template-sample/pillar-overview.html");
		WebElement main = driver.findElement(By.xpath(".//div[contains(@data-ocomid,'u10')]"));
		System.out.println(main.getCssValue("background-color"));
		int X = main.getLocation().getX();
		int Y = main.getLocation().getY();
		JavascriptExecutor linkJ = (JavascriptExecutor) driver;
		linkJ.executeScript("window.scrollBy(" + X + "," + Y + ")");
		
		
		

		driver.close();

	}
}
