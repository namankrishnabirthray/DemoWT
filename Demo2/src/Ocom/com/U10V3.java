package Ocom.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class U10V3 {

	static {
		System.setProperty("webdriver.chrome.driver", ".//Driver/chromedriver.exe");
	}

	public static void getFooterU10V3(WebElement main, WebDriver driver) 
	{
		Actions action = new Actions(driver);
		String mainBackgroundColor = main.getCssValue("background-color");
		System.out.println(mainBackgroundColor);

		System.out.println("c");
		WebElement mainTitle = main.findElement(By.xpath(".//div[contains(@class,'u10title')]"));

		String Title = mainTitle.getText();
		System.out.println(Title);
		String Titlecolor = mainTitle.getCssValue("color");
		System.out.println(Titlecolor + "-" + mainBackgroundColor);

		List<WebElement> links = main.findElements(By.tagName("a"));
		for (WebElement link : links) {
			String linkText = link.getAttribute("innerText");
			String color = link.getCssValue("color");
			System.out.println(linkText + "->" + color);
			action.moveToElement(link).build().perform();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://webstandards.us.oracle.com:9494/ocom/template-sample/pillar-overview.html");
		WebElement main = driver.findElement(By.xpath(".//section[contains(@class,'u10v3')]"));
		int X = main.getLocation().getX();
		int Y = main.getLocation().getY();
		JavascriptExecutor linkJ = (JavascriptExecutor) driver;
		linkJ.executeScript("window.scrollBy(" + X + "," + Y + ")");
		getFooterU10V3( main, driver); 
		

	}

}
