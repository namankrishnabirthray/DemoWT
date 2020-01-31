package Ocom.com;

import java.awt.Color;

public class HexColorConversion {
	
	
	private static final String pad(String s)
	{
	    return (s.length() == 1) ? "0" + s : s;
	}
	
	public static int toHex(Color col) 
	{
		
	    String as = pad(Integer.toHexString(col.getAlpha()));
	    String rs = pad(Integer.toHexString(col.getRed()));
	    String gs = pad(Integer.toHexString(col.getGreen()));
	    String bs = pad(Integer.toHexString(col.getBlue()));
	    String hex = "0x" + as + rs + gs + bs;
	    System.out.println(hex);
	    System.out.println(Integer.parseInt(hex, 16));
	    return Integer.parseInt(hex, 16);
	    
	}	
	public static void main(String[] args) 
	{
		
	
	Color col=new Color(100f, 225f, 223f, 1.0f);
	int color = toHex(new Color(1f, 1f, 1f, 1f));
	

	}
	
}
	
	
	
	
	
	


