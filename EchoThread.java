
import java.io.*;
import java.net.*;
import java.util.*;
public  class EchoThread implements Runnable{
	private Socket client=null;

	public EchoThread(Socket client){
		this.client=client;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		PrintStream out=null;
		BufferedReader buf=null;
		
		
			try {
				buf=new BufferedReader(new InputStreamReader(client.getInputStream()));
				out=new PrintStream(client.getOutputStream());
				
				boolean f=true;
				while(f){
					
					
				String str=buf.readLine();
					
				out.println(new StringBuilder(str).reverse().toString());
						
				
				
				}
				out.close();
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
		
			
	}
	

}

