package Ocom.com;

import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConventionalTags {

	static {
		System.setProperty("webdriver.chrome.driver", ".//Driver/chromedriver.exe");
	}

	public static String[] tags = {"strong","p", "h1", "h2", "h3", "h4", "h5", "h6", "li","b" };
	public static void getConventionalTags(WebElement main, WebDriver driver) 
	{
		
		  HashSet<String> findTag=new HashSet<String>();
		        List<WebElement> all=main.findElements(By.cssSelector("*"));
		        
		        for(WebElement al:all) 
		        {
		        	System.out.println(al.getTagName());
		        	findTag.add(al.getTagName());
		        }
		for (String tag : tags) 
		{
			
			if(findTag.contains(tag)) 
			{
			List<WebElement> conventionalTags = main.findElements(By.tagName(tag));
			for (WebElement conventionalTag : conventionalTags) 
			{	
				String conventionTagText = conventionalTag.getAttribute("innerText");
				String conventionTagTextcolor = conventionalTag.getCssValue("color");
				String conventionTagTextbackgroundcolor = conventionalTag.getCssValue("background-color");
                System.out.println(tag);
				System.out.println(conventionTagText);
				System.out.println(conventionTagTextcolor);
				System.out.println(conventionTagTextbackgroundcolor);
			}}
		}
	}
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.oracle.com/corporate/citizenship/?betamode=20.0.0");
		WebElement main = driver.findElement(By.xpath(".//section[contains(@data-ocomid,'cb83')]"));
		int X = main.getLocation().getX();
		int Y = main.getLocation().getY();
		JavascriptExecutor linkJ = (JavascriptExecutor) driver;
		linkJ.executeScript("window.scrollBy(" + X + "," + Y + ")");
		getConventionalTags( main,driver);
		driver.close();
		}}
