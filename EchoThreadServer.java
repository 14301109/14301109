import java.net.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoThreadServer {
	
	public static ServerSocket server=null;
	public static Socket client=null;
	public static void main(String []args) throws Exception{
		ExecutorService threadPool = Executors.newFixedThreadPool(20);
		server=new ServerSocket(3333);
		boolean f=true;
		
		while(f){
			System.out.println("服务器运行");
			client =server.accept();
			threadPool.execute(new EchoThread(client));
			
		}
		server.close();
	}
	
	
}
