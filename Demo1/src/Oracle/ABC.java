package Oracle;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.logging.Level;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ABC 
{
 static{System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");}   
 public static WebDriver driver=null;
 public static String analyzeLog() 
 {
     LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
     String a=null;
     for (LogEntry entry : logEntries) 
     {
    	// System.out.println(/*new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " +*/ entry.getMessage());
    	 a=entry.getMessage();
     }
     return a;   
 }	
public static void main(String[] args) throws AWTException 
{
	 DesiredCapabilities caps = DesiredCapabilities.chrome();
     LoggingPreferences logPrefs = new LoggingPreferences();
     logPrefs.enable(LogType.BROWSER, Level.ALL);
     caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
     driver = new ChromeDriver(caps);
     driver.manage().window().maximize();
     driver.get("https://www.oracle.com/index.html");
     Robot rb = new Robot();
     rb.keyPress(KeyEvent.VK_CONTROL);
     rb.keyPress(KeyEvent.VK_SHIFT);
     rb.keyPress(KeyEvent.VK_J);
     Set<String> abc = driver.getWindowHandles();
     for(String a:abc) { System.out.println(a);}
     String a="clear();";
     String script="return console.log(OraclePerformance.measure().page.domComplete);";
     JavascriptExecutor js = (JavascriptExecutor)driver;
     rb.keyPress(KeyEvent.VK_ENTER);
     js.executeScript(script);
     String domcomplete=analyzeLog();
     String dom[]=domcomplete.split(" ");
     System.out.println("Domcomplete"+"-->"+dom[dom.length-1]);
     //OraclePerformance.measure().page.domContentLoaded
     String script2="console.log(a=OraclePerformance.measure().page.domContentLoaded);";
   //  String ab="return console.log(a);";
         js.executeScript(script2);
         String abcd=(String)js.executeScript("console.log(a);");
         System.out.println(abcd+"not null");
        // System.out.println("abcd"+a1);
         
     String domcontentLoaded=analyzeLog();
     String dom1[]=domcontentLoaded.split(" ");
     System.out.println("DomcontentLoaded"+"-->"+dom1[dom1.length-1]);
     
	 String script3="return console.log(OraclePerformance.measure().page.domInteractive);";
	 System.out.println("abc"+"---->"+js.executeScript(script3));
	 String domInteractive=analyzeLog();
	 String dom2[]=domInteractive.split(" ");
	 System.out.println("DomIntreactive"+"-->"+dom2[dom2.length-1]);
	 
}}