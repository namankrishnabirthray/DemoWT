package Ocom.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ct16 {

	static {
		System.setProperty("webdriver.chrome.driver", ".//Driver/chromedriver.exe");
	}
	
	public static void getct16(WebElement main,WebDriver driver)
	{
		Actions action=new Actions(driver);	  
	    WebElement background=main.findElement(By.xpath(".//nav[contains (@class,'ct16w2')]"));  
		for(int i=0;i<=6;i++) 
		{
		try
		{
		WebElement  links   =main.findElement(By.xpath(".//nav[contains (@class,'ct16w2')]/ul[1]//li[contains(@data-position,'"+i+"')]/a"));
		action.moveToElement(links).build().perform();
		/*String text=links.getText();
		String color=links.getCssValue("color");
		String Fontfamily=links.getCssValue("font-family");*/
		Thread.sleep(1000);
		}catch(Exception e) 
		{
			break;
		}
		 
		}
		
		WebElement backgroundsublinks=main.findElement(By.xpath(".//ul[contains(@class,'ct16t2')]"));
		List<WebElement> allSublinks=main.findElements(By.xpath(".//ul[contains(@aria-role,'menubar')]//a"));
		for(WebElement sublink:allSublinks)
		{
			
			String backgroundColor=backgroundsublinks.getCssValue("background-color");
			System.out.println("a");
			System.out.println(backgroundColor);
			
			if(backgroundColor.equals("rgba(0, 0, 0, 0)"))
			{
				backgroundColor=sublink.getCssValue("background-color");
				System.out.println("b");
				System.out.println(backgroundColor);
			}
			
			
			
			String color=sublink.getCssValue("color");
			String fontfamily=sublink.getCssValue("font-family");
			String text=sublink.getText();
			System.out.println(backgroundColor+color+fontfamily+text);
			
			try{
			action.moveToElement(sublink).build().perform();
			}catch(Exception e)
			{
				
			}
			System.out.println(sublink.getText());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
				
		
		
		
		
	}
	

	public static void main(String[] args)
	{

		
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.oracle.com/corporate/citizenship/?betamode=20.0.0");
		WebElement main = driver.findElement(By.xpath(".//section[contains(@class,'ct16-wrapper ct16loaded')]"));
		int X = main.getLocation().getX();
		int Y = main.getLocation().getY();
		JavascriptExecutor linkJ = (JavascriptExecutor) driver;
		linkJ.executeScript("window.scrollBy(" + X + "," + Y + ")");
		
		
		getct16(main,driver);
		driver.close();
		
		
		
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 

	}

}
