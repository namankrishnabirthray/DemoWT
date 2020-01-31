package Ocom.com;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriver {

	static
	  {
		System.setProperty("webdriver.ie.driver",".//Driver/IEDriverServer.exe");  
	  }
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
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
	    System.out.println("DomContentLoaded = "+TitleName4);	
	    driver.close();



	}

}
