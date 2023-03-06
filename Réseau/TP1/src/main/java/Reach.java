import java.net.*;
public class Reach {	
	public static void main(String [ ] args) {
                //String host = "localhost"; 
                String host = "www.facebook.com"; //si vous êtes connectés à internet
                mystere (host);
	}
	private static void mystere (String host) {
		try {    InetAddress b = InetAddress.getByName(host);
		for(int i=0;i<5;i++)
		{
			boolean var = b.isReachable(180); 
			 if (var)  System.out.println("OK : " + host);
			 else System.out.println("Not OK : " + host);
		}
		     } catch (Exception e) {e.printStackTrace();}
	}	
}
