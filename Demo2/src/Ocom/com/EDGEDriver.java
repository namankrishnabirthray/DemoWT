package Ocom.com;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EDGEDriver {
	static 
	{
		System.setProperty("webdriver.edge.driver", "C://Windows/SysWOW64/MicrosoftWebDriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.oracle.com/index.html");
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		String TitleName = js.executeScript("return OraclePerformance.measure().page.domInteractive;").toString();			
	    System.out.println("DomInteractive = "+TitleName);
	    
	    Thread.sleep(2000);
	    String TitleName1 = js.executeScript("return OraclePerformance.measure().page.domComplete;").toString();			
	    System.out.println("DomComplete = "+TitleName1);	
	    Thread.sleep(2000);
	    
	    String TitleName2 = js.executeScript("return OraclePerformance.measure().page.domContentLoaded;").toString();			
	    System.out.println("DomContentLoaded = "+TitleName2);				
	    Thread.sleep(2000);
	    String TitleName3 = js.executeScript("return OraclePerformance.measure().page;").toString();			
	    System.out.println("DomContentLoaded = "+TitleName3);				
	    
	      String TitleName4 = js.executeScript("return OraclePerformance.measure().component;").toString();			
	      TitleName4=TitleName4.replace("{init=", "").replace("{","").replace("}", "");
	      String abc[]=TitleName4.split(",");
	      for(int i=0;i<=abc.length-1;i+=2) 
	      {
	    	  
	       System.out.println(abc[i]+","+abc[i+1]);
	    	  
	      }
	    
	    
	    driver.close();



	}

}
