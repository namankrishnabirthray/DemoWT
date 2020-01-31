package Ocom.com;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ReadSourcecode 
{
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

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// "h1", "h2", "h3", "h4", "h5", "h6",
		String hTag[] = { "strong", "h1", "h2", "h3", "h4", "h5", "h6", "li", "b", "p", "a" };
		driver.get("http://webstandards.us.oracle.com:9494/builder/compsample,f11v6[][hc02v24,cb114v0x0]");
		WebElement main = driver.findElement(By.xpath(".//section[contains(@data-ocomid,'cb114')]"));
		List<WebElement> classNames = main.findElements(By.xpath(".//*[@class]"));
		JavascriptExecutor j = (JavascriptExecutor) driver;

		
		for (WebElement e2 : classNames) {
			String className = e2.getAttribute("class");
			if (className.contains("col-framework")) {
				List<WebElement> allCards = e2.findElements(By.xpath("./div/div"));

				for (WebElement card : allCards) {
					String Class = card.getAttribute("class");
					for (String tag : hTag) {
						try {
							WebElement V = card.findElement(By.tagName(tag));
							String Na = V.getAttribute("innerText");
							if (!Na.equals("")) {
								System.out.println(tag + "->" + Na);

								System.out.println(Comcolor(V.getCssValue("color")));
								System.out.println(Comcolor(V.getCssValue("background-color")));
								System.out.println(Comcolor(card.getCssValue("background")));

							}
						} catch (Exception e) {
						}
					}

					Thread.sleep(2000);

					System.out.println("***HOVER***");
					System.out.println(Class);
					int x = card.getLocation().getX();
					int y = card.getLocation().getY();
					j.executeScript("window.scrollBy(" + x + "," + y + ")");
					Actions a = new Actions(driver);
					a.moveToElement(card).build().perform();
					Thread.sleep(2000);

					for (String tag : hTag) {
						try {
							List<WebElement> V = card.findElements(By.tagName(tag));

							for (WebElement v : V) {
								String Na = v.getAttribute("innerText");
								if (!Na.equals("")) {
									System.out.println(tag + "->" + Na);
									System.out.println(Comcolor(v.getCssValue("color")));
									System.out.println(Comcolor(v.getCssValue("background-color")));
									System.out.println(Comcolor(card.getCssValue("background")));
								}
							}
						} catch (Exception e) {
						}
					}
				}
			}
		}
		
		
		
		
		

		/*
		 * if (className.contains("eyebrow")) { System.out.println(className);
		 * System.out.println(e2.getAttribute("innerText")); String color =
		 * e2.getCssValue("color"); System.out.println(color);
		 * System.out.println(Comcolor(color)); String color2 =
		 * e2.getCssValue("background-color"); System.out.println(color2);
		 * System.out.println(Comcolor(color2));
		 * 
		 * } if (className.contains("obttns")) {
		 * 
		 * WebElement buttn = e2.findElement(By.xpath("./div")); WebElement a11
		 * =buttn.findElement(By.tagName("a"));
		 * 
		 * System.out.println("********buttn color*****");
		 * 
		 * System.out.println(buttn.getText());
		 * System.out.println(buttn.getCssValue("background-color"));
		 * System.out.println(a11.getCssValue("color"));
		 * 
		 * int x = e2.getLocation().getX(); int y = e2.getLocation().getY();
		 * 
		 * j.executeScript("window.scrollBy(" + x + "," + y + ")");
		 * 
		 * Actions a = new Actions(driver); a.moveToElement(buttn).build().perform();
		 * Thread.sleep(5000);
		 * 
		 * System.out.println("******hover-over******");
		 * 
		 * WebElement buttn2 = e2.findElement(By.xpath("./div"));
		 * System.out.println(buttn2.getCssValue("background-color"));
		 * System.out.println(a11.getCssValue("color")); } }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * List<WebElement> ATag = main.findElements(By.tagName("a")); for(WebElement a
		 * : ATag) {
		 * 
		 * String text = a.getAttribute("innerText"); if (text != null &&
		 * !text.equals("")) { System.out.println(text); String color =
		 * a.getCssValue("color"); System.out.println(color);
		 * System.out.println(Comcolor(color)); String color2 =
		 * a.getCssValue("background-color"); System.out.println(color2);
		 * System.out.println(Comcolor(color2)); } }
		 */

		/*
		 * for(WebElement m:main) { if(m!=null) { String
		 * m1=m.getAttribute("data-ocomid"); if(m1!=null) { System.out.
		 * println("find heading text and color and back ground colors:---------------------------"
		 * ); for(String tag:hTag) { List<WebElement> headings=
		 * m.findElements(By.tagName(tag)); for(WebElement heading:headings) {
		 * System.out.println(tag + "=" +heading.getText()); } }
		 * 
		 * System.out.
		 * println("find link text and there color and back ground color:-------------------------"
		 * ); List<WebElement> links=m.findElements(By.tagName("a")); for(WebElement
		 * link:links) { System.out.println("link Text for<a> tag "+""+link.getText());
		 * 
		 * }
		 * 
		 * System.out.
		 * println("--------------class Name is hare _-------------------------");
		 * List<WebElement> classNames= m.findElements(By.xpath(".//*[@class]"));
		 * 
		 * 
		 * for(WebElement CLName:classNames) {
		 * System.out.println(CLName.getAttribute("class"));
		 * 
		 * } } } }
		 */

		/*
		 * System.out.println("----------------Next----------------------");
		 * System.out.println("when attribute Name  is  data-ocomid");
		 * 
		 * List<WebElement> p=driver.findElements(By.xpath(".//*[@data-ocomid]"));
		 * 
		 * for(WebElement p1:p) { String a=p1.getAttribute("data-ocomid"); if(a!=null)
		 * System.out.println(a); }
		 * 
		 * System.out.println("----------------Next----------------------");
		 * System.out.println("when attribute Name  is  data-trackas");
		 * 
		 * List<WebElement> q=driver.findElements(By.xpath(".//*[@data-ocomid]"));
		 * for(WebElement p1:q) { String a=p1.getAttribute("data-trackas"); if(a!=null)
		 * System.out.println(a); }
		 * 
		 */

		/* List<WebElement> main = driver.findElements(By.xpath(".//*")); */

		/*
		 * ArrayList<String> number = new ArrayList<String>(); for (int i = 0; i <= 10;
		 * i++) { number.add(Integer.toString(i)); } for (int i = 0; i <= main.size() -
		 * 1; i++) { String component = main.get(i).getAttribute("data-ocomid"); if
		 * (component != null) { if (component.equals("ocrsl")) { component =
		 * main.get(i).getAttribute("data-trackas"); } System.out.println(component);
		 * System.out.println(main.get(i).getTagName()); } }
		 */

		Thread.sleep(3000);
		driver.close();

	}
}
