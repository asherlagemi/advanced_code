package model;

import word_search.ClientHandler;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class HostServer {
    int admin_port;
    boolean stop;
    ClientHandler ch;
    int maxThreads;
    //ExecutorService executor;	//the thread pool
    ThreadPoolExecutor tp;

    public HostServer(int admin_port, ClientHandler ch, int maxThreads) {	//constructor
        this.admin_port = admin_port;
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
            ServerSocket server = new ServerSocket(admin_port);
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
                        catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {throw new RuntimeException(e);}
                    });
                    //ch.handleClient(client.getInputStream(), client.getOutputStream());
                    //ch.close();
                    //client.close();
                } catch(SocketTimeoutException ignored) {}
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


    public void run(String[] args) {
        Random r=new Random();
        int port=6000+r.nextInt(1000);
        System.out.println("port: " + port);
        MyServer s=new MyServer(port, new BookScrabbleHandler(),3);
        s.start(); // runs in the background
        try {
            Socket server=new Socket("localhost", port);
            PrintWriter outToServer=new PrintWriter(server.getOutputStream());
            Scanner in=new Scanner(server.getInputStream());
            String response=in.next();
            outToServer.println(w);
            outToServer.flush();
            in.close();
            outToServer.close();
            server.close();
        }catch(Exception e) {
            System.out.println("error in checking dictionaryLegal in Board");
        }finally{
            s.close();
        }


        System.out.println("SERVER SIDE");
        MyServer server = new MyServer(8080, new RunServer.TestClientHandler(), 3);
        //MyServer server = new MyServer(8080, new HTTPClientHandler());
        server.start();
        System.out.println("server started");
        Scanner s = new Scanner(System.in);
        String input;
        do {
            input = s.next();
        } while(!input.equals("stop"));
        s.close();
        server.close();
        System.out.println("server stopped");
    }


}
