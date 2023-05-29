package model;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
//import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MyServer {

	int port;
	boolean stop;
	ClientHandler ch;
	int maxThreads;
	//ExecutorService executor;	//the thread pool
	ThreadPoolExecutor tp;
	
	public MyServer(int port, ClientHandler ch, int maxThreads) {	//constructor
		this.port = port;
		this.ch = ch;
		this.maxThreads = maxThreads;
		//executor = Executors.newFixedThreadPool(maxThreads);
		this.tp = (ThreadPoolExecutor) Executors.newFixedThreadPool(maxThreads);
	}
	
	public void start() {
		stop = false;
		//executor.submit(()->startServer());
		new Thread(this::startServer).start();
	}
	
	private void startServer() {	//general mechanism for creating a server
		try {
			ServerSocket server = new ServerSocket(port);
			server.setSoTimeout(1000);	//waiting 1 second for client connection
			while(!stop) {
				try {
					Socket client = server.accept();
					tp.execute(()->{
						try {
                            Class<? extends ClientHandler> chClass = this.ch.getClass();
                            ClientHandler ch1 = chClass.getDeclaredConstructor().newInstance();
                            ch1.handleClient(client.getInputStream(), client.getOutputStream());
                            client.close();
                            ch1.close();
                        } catch (IOException e) {e.printStackTrace();} 
						catch (InvocationTargetException | InstantiationException |IllegalAccessException | NoSuchMethodException e) {throw new RuntimeException(e);}
					});
					//ch.handleClient(client.getInputStream(), client.getOutputStream());
					//ch.close();
					//client.close();
				} catch(SocketTimeoutException e) {}
			}
			server.close();
			tp.shutdown();
		}catch(IOException e) {e.printStackTrace();}
		finally {
			tp.shutdown();
		}
	}
	
	public void close() {
		stop = true;
	}
}
