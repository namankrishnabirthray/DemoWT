package Ocom.com;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

public class REdirectURLs {

	public static String RedirectURL = new String();
	
	public static boolean machURL(String URL, String ReDirectURL) 
	{
		
		boolean condision = URL.replace("https", "").replace("http", "")
				.equals(ReDirectURL.replace("https", "").replace("http", ""));
		return condision;
		
	}
	public static void getRedirect(String url) 
	{
		RedirectURL=new String();
		System.out.println("c");
		   
	}

	public static void main(String[] args)
	{
		
		getRedirect("https://www.oracle.com/applications/erp/");
		String url="https://go.oracle.com/subscriptions?l_code=en-us&src1=OW:O:SW";
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("www-proxy.us.oracle.com",80));
		HttpURLConnection huc = null;
		String result = "";
		int code = 200; 
		
		try 
		{
			 huc= (HttpURLConnection)(new URL(url).openConnection(proxy));
			
			 huc.setInstanceFollowRedirects(true);
			 huc.setInstanceFollowRedirects(false);
			// huc.connect();
			 String method=huc.getRequestMethod().toString();
			 huc.setRequestMethod(method);
			 huc.setConnectTimeout(3000);
			 huc.connect();
			 code= huc.getResponseCode();
			 System.out.println(url);
			 System.out.println(code);
			 InputStream is = huc.getInputStream();
			 System.out.println( "redirected url: " + huc.getURL() );
			 String location = huc.getHeaderField( "Location" );
			 System.out.println( location );
			 
			 if(code>=400) 
			 {
			  System.out.println("broken"); 
			 
			 }else
			     {
				
				 }
	     }
		catch (Exception e)
		{
		
		System.out.println("Please make sure network connected with Oracle VPN + a1");
		
		}

		

	}
}