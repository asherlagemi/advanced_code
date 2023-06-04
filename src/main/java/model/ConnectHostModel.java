package model;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class ConnectHostModel {
    HostServer hostServer;
    Socket hostSocket;
    int adminPort;

    public ConnectHostModel(HostServer hostServer, Socket hostSocket, int adminPort) {
        this.hostServer = hostServer;

        Random r=new Random();
        this.adminPort = 6000+r.nextInt(1000);
        System.out.println("port: " + adminPort);
        this.hostServer = new HostServer(adminPort, new PlayerHandler(),3);
        hostServer.start(); // runs in the background
    }
    public void waitForClients(){

    }

    public void talkToServer(){

        try {
            hostSocket=new Socket("localhost", adminPort);
            PrintWriter outToServer=new PrintWriter(hostServer.getOutputStream());
            Scanner in=new Scanner(hostServer.getInputStream());
            String response=in.next();
            outToServer.println(w);
            outToServer.flush();
            in.close();
            outToServer.close();
            hostServer.close();
        }catch(Exception e) {
            System.out.println("error in checking dictionaryLegal in Board");
        }finally{
            hostSocket.close();
        }
    }
}
