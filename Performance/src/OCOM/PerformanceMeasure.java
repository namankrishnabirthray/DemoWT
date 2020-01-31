package OCOM;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PerformanceMeasure {

	public static void page(ArrayList<String> pageLoad, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String pageResponce = js.executeScript("return OraclePerformance.measure().page;").toString();
		pageResponce = pageResponce.replace("{", "").replace("}", "");
		String page[] = pageResponce.split(",");
		for (String pageR : page) {
			pageLoad.add(pageR);
		}
	}
	public static void components(ArrayList<String> componentLoad, WebDriver driver) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String component = js.executeScript("return OraclePerformance.measure().component;").toString();			
	    component=component.replace("{init=", "").replace("{","").replace("}", "");
	    String abc[]=component.split(",");
	      for(int i=0;i<=abc.length-1;i+=2) 
	      {  
	       componentLoad.add(abc[i]+","+abc[i+1]);  
	      }	
	}

}