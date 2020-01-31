package Ocom.com;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OcomHP {

	static {
		System.setProperty("webdriver.chrome.driver", ".//Driver/chromedriver.exe");
	}

	public static void main(String[] args) 
	{
		
		String url="https://www.oracle.com/applications/customer-experience/ecommerce/solutions/";
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("www-proxy.us.oracle.com",80));
		HttpURLConnection huc = null;
		String result = "";
		int code = 200; 
		
		try 
		{
			 huc= (HttpURLConnection)(new URL(url).openConnection(proxy));
			 String method=huc.getRequestMethod().toString();
			 huc.setRequestMethod(method);
			 huc.setConnectTimeout(3000);
			 huc.connect();
			 code= huc.getResponseCode();
			 System.out.println(url);
			 System.out.println(code);
			 InputStream is = huc.getInputStream();
			 System.out.println( "redirected url: " + huc.getURL() );
			 
	     }
		catch (Exception e)
		{
		
		System.out.println("Please make sure network connected with Oracle VPN + a1");
		
		}}

		
}
		                 
		                 
		  
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	


