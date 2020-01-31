package Ocom.com;

import java.util.HashMap;

public class Demo
{
  
  
	
	public static void main(String[] args) 
	
	{
		String a="https://www.fcc.gov/cgb/dro/trsphonebk.html\">https://www.fcc.gov/cgb/dro/trsphonebk.html";
		if(a.contains("\">")) 
		{
		String ab[]=  a.split("\">");
		System.out.println(ab[0]);
		}
		
	}
	
	
}
