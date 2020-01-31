package Ocom.com;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;


public class FireFox 
{
 public static WebDriver driver=null;
 public static String  getConsoleLogs(WebDriver driver) {
	    LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
	    String consoleLog = "";

	    for (LogEntry logEntry : logEntries.getAll()) {
	        consoleLog += logEntry.toString() + "\n";
	    }

	    return  consoleLog;
	}
	
  static
  {
	System.setProperty("webdriver.gecko.driver",".//Driver/geckodriver.exe");  
  }
	public static void main(String[] args) throws AWTException, IOException, InterruptedException
	{	
		/*FirefoxOptions options = new FirefoxOptions();
		options.setLogLevel(FirefoxDriverLogLevel.TRACE);*/
		WebDriver driver = new FirefoxDriver();
	   
	  
		driver.get("https:www.oracle.com/index.html");
		
		
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



	
		
         
}}