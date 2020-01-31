package Ocom.com;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SerenityHomePageDemo 
{

	public static  WebElement chatEnable=null;
	static {
		System.setProperty("webdriver.chrome.driver", ".//Driver/chromedriver.exe");
	}

	/*public static boolean m1(WebElement chatEnable,WebDriver driver) 
	{
		
	try {	
     chatEnable=driver.findElement(By.xpath(" .//div[contains(@data-trackas,'ochat_slideout')]//ul[contains(@class,'ochat_slidew2 active')]"));
	}catch(Exception e) {
		
	}
		return chatEnable.isEnabled();
	}*/
	
	
	
	public static WebElement fun(WebDriver driver) 
	{	
		
	WebElement	per=driver.findElement(By.xpath(".//div[contains(@data-trackas,'panel3:about')]//div[contains(@class,'rh02current')]//div[contains(@class,'rh02-pcontent')]/h2"));
	return per;
	
	}
	public static void main(String[] args) 
	{
		
			
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("view-source:https://www.oracle.com/index.html");
		
		
		
	  System.out.println( driver.findElement(By.tagName("html")).getAttribute("textContent"));
		
		
		
		/*Actions action=new Actions(driver);
		WebElement chat=driver.findElement(By.xpath(".//div[contains(@data-trackas,'ochat_slideout')]//a[contains(@class,'ochat')]"));
		List<WebElement>lists=driver.findElements(By.xpath(".//ul[contains(@class,'rh02nav')]//li/a"));
	    WebElement close=driver.findElement(By.xpath(".//div[contains(@data-trackas,'ochat_slideout')]//a[contains(@data-lbl,'proactive:flyout-close')]"));
	    
	    WebElement chatEnable=driver.findElement(By.xpath(" .//div[contains(@data-trackas,'ochat_slideout')]//ul[contains(@class,'ochat_slidew2 active')]"));
	   for(int i=0;i<=1;i--) 
	   {
		   if( close.isDisplayed()) 
			{
			   try {
			   Thread.sleep(5000);}catch(Exception e)
			   {	   
			   }
				action.moveToElement(close).click().build().perform();
				break;
			}  
	   } 
	    int j=1;
		for(int i=0;i<=lists.size()-1;i++)
		{
			action.moveToElement(lists.get(i)).click().build().perform();
			
			System.out.println(fun(driver).getAttribute("textContent"));
			try 
			{	
			  Thread.sleep(4000);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			
			
			
		}
		
		
		
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * WebElement per=driver.findElement(By.xpath(".//div[contains(@data-trackas,'panel2:apps')]//button[contains(@class,'rh02-pcontent')]"));
		System.out.println(per.getText());
		WebElement button=driver.findElement(By.xpath(".//div[contains(@data-trackas,'panel2:apps')]//div[contains(@class,'rh02-cta')]"));
		List<WebElement>allLink=button.findElements(By.tagName("a"));
		System.out.println(allLink.size());
		Actions action=new Actions(driver);
		action.moveToElement(per).build().perform();
		for(WebElement a:allLink) 
		{
			int X=a.getLocation().getX();
			int Y=a.getLocation().getY();
			action.moveToElement(a).build().perform();	   
			System.out.println(a.getAttribute("textContent"));
			
	    try {
				Thread.sleep(1000);
			} catch (InterruptedException e) 
			   {
				e.printStackTrace();
			   }   
		   }
		List<WebElement> allLinks=driver.findElements(By.xpath(".//div[contains(@data-trackas,'panel2:apps')]//div[contains(@class,'rh02w3')]//div[contains(@class,'rh02link')]//a"));	
		for(WebElement link:allLinks) 
		{
			action.moveToElement(link).build().perform();
			System.out.println(link.getAttribute("textContent"));
			  try {
					Thread.sleep(1000);
				  }
			  catch (InterruptedException e) 
				   {
					e.printStackTrace();
				   }  	
		}
		  WebElement e=driver.findElement(By.xpath(".//section[contains(@data-trackas,'header')]//a[contains(@class,'u28home rw-logo')]"));
	      int x1=e.getLocation().getX();
	      int y1=e.getLocation().getY();
	      action.moveToElement(e,x1,y1).build().perform();
	
		  driver.close();
		
		
		
		
		
		
		
		
		
		
		
		*/
		
		
		
		
		
		/*WebElement per=driver.findElement(By.xpath(".//div[contains(@data-trackas,'panel1:infra')]//button[contains(@class,'rh02-pcontent')]//div[contains(@class,'rh02-sub')]"));
		WebElement button=driver.findElement(By.xpath(".//div[contains(@data-trackas,'panel1:infra')]//div[contains(@class,'rh02-cta')]"));
		System.out.println(per.getText());
		
		List<WebElement>allLink=button.findElements(By.tagName("a"));
		System.out.println(allLink.size());
		
		int x=per.getLocation().getX();
		int y=per.getLocation().getY();
		
		Actions action=new Actions(driver);
		action.moveToElement(per).build().perform();
		
		for(WebElement a:allLink) 
		{
			int X=a.getLocation().getX();
			int Y=a.getLocation().getY();
			action.moveToElement(a).build().perform();	   
			System.out.println(a.getAttribute("textContent"));
			
	    try {
				Thread.sleep(1000);
			} catch (InterruptedException e) 
			   {
				e.printStackTrace();
			   }   
		   }
		
    List<WebElement> allLinks=driver.findElements(By.xpath(".//div[contains(@data-trackas,'panel1:infra')]//div[contains(@class,'rh02w3')]//div[contains(@class,'rh02link')]//a"));	
	for(WebElement link:allLinks) 
	{
		action.moveToElement(link).build().perform();
		System.out.println(link.getAttribute("textContent"));
		  try {
				Thread.sleep(1000);
			  }
		  catch (InterruptedException e) 
			   {
				e.printStackTrace();
			   }  
		
		
		
		
		
	}
	
	WebElement e=driver.findElement(By.xpath(".//section[contains(@data-trackas,'header')]//a[contains(@class,'u28home rw-logo')]"));
	      int x1=e.getLocation().getX();
	      int y1=e.getLocation().getY();
	action.moveToElement(e,x1,y1).build().perform();
	
		driver.close();
		
		
		
		
		
		*/
		
		
		
		
		

	}
}
