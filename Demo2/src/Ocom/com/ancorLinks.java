package Ocom.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ancorLinks {

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

	public static void getLinks(WebElement main, WebDriver driver) {

	  List<WebElement> links = main.findElements(By.tagName("a"));
		for (WebElement link : links) 
		{
			int x = link.getLocation().getX();
			int y = link.getLocation().getY();
			String linkText = link.getText();
			String linkcolor = link.getCssValue("color");
			String linkBackgroundcolor = link.getCssValue("background-color");
			System.out.println(linkText + "-" + linkcolor + "-" + linkBackgroundcolor);
			Actions a = new Actions(driver);
			a.moveToElement(link).build().perform();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			String linkTextH = link.getAttribute("innerText");
			String linkcolorH = link.getCssValue("color");
			String linkBackgroundcolorH = link.getCssValue("background-color");
			System.out.println(linkTextH + "-" + linkcolorH + "-" + linkBackgroundcolorH);
		}
	}

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://webstandards.us.oracle.com:9494/ocom/template-sample/pillar-overview.html");
		WebElement main = driver.findElement(By.xpath(".//div[contains(@data-ocomid,'u10')]"));

		int X = main.getLocation().getX();
		int Y = main.getLocation().getY();

		JavascriptExecutor linkJ = (JavascriptExecutor) driver;
		linkJ.executeScript("window.scrollBy(" + X + "," + Y + ")");
		
		getLinks(main, driver);
		driver.close();

	}
}
