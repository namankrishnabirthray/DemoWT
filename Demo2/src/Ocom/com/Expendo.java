package Ocom.com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Expendo {
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

	public static void getExpendoButton(WebElement main, WebDriver driver) {
		try {

			
			
			WebElement expendoButton = main.findElement(By.xpath("//div[contains(@class,'expando-btn block')]"));
			WebElement expendoText = expendoButton.findElement(By.xpath("./div/span"));
			System.out.println(expendoText.getAttribute("innerText"));
			System.out.println(expendoText.getCssValue("color"));
			System.out.println(expendoText.getCssValue("background-color"));
			expendoText.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

			System.out.println(expendoText.getAttribute("innerText"));
			System.out.println(expendoText.getCssValue("color"));
			System.out.println(expendoText.getCssValue("background-color"));

			System.out.println("Successfully captured Expoendo Button");

		} catch (Exception E) {
			System.out.println("No Expendo Button found using GetExpendoButton funtion");
		}

	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://webstandards.us.oracle.com:9494/ocom/template-sample/pillar-overview.html");
		WebElement main = driver.findElement(By.xpath(".//section[contains(@data-ocomid,'cw67')]"));
		int X = main.getLocation().getX();
		int Y = main.getLocation().getY();
		JavascriptExecutor linkJ = (JavascriptExecutor) driver;
		linkJ.executeScript("window.scrollBy(" + X + "," + Y + ")");
		getExpendoButton(main, driver);
		driver.close();

	}
}
