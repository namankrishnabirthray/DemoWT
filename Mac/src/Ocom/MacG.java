package Ocom;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MacG 
{
	 
	    static
	    {
	 System.setProperty("webdriver.chrome.driver",".//Drivers/chromedriver.exe");
	    }
	     public static void main(String [] args) throws MalformedURLException 
	     {
	    	 String baseURL = "https://www.oracle.com/index.html";
	         
	         DesiredCapabilities capability = DesiredCapabilities.chrome();
	         capability.setBrowserName("chrome");
	         capability.setPlatform(Platform.MAC);
	    
	         ChromeOptions option=new ChromeOptions();
	         option.merge(capability);
	         String hub="http://10.178.30.48:4444/wb/hub";
	            
	         WebDriver driver=new RemoteWebDriver(new URL(hub),option);
	    	 
	         
	     }
}
