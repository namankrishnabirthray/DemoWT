package Ocom.com;

public class Funtions
{

	public static void  getValidation() 
	{
		
		String check1="Pass";
        String check2="Pass";		
		
		
		String color1="Natural1";
		String OScolor1="";
		if(OScolor1==null) 
		{
			check1="fail";
		}
		String backgroundColor1="Natural2";
		String OSbackgroundColor1="Natural2";
		
		if(OSbackgroundColor1==null) 
		{
			check1="Fail";
		}
		
		String fontFamily="Oracle-sans";
		String color2="";
		String OScolor2="";
		if(OScolor2==null) 
		{
			check2="Fail";
		}
		String backgroundColor2="";
		String OSbackgroundColor2="";
		if(OSbackgroundColor2==null) 
		{
			check2="Fail";
		}
		
		
		
		
		
		
		 
	  if(color1.equals(color2)&&backgroundColor1.equals(backgroundColor2))
		{
			//no hover
		}else {
			//hover
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
