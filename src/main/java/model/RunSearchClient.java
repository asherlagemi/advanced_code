package model;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RunSearchClient {



    public static void main(String[] args) throws Exception {
        System.out.println("CLIENT SIDE");
        Socket client = new Socket("localhost",8080);

        PrintWriter outToServer = new PrintWriter(client.getOutputStream(), true);
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

        outToServer.println("hello world!");
        System.out.println(inFromServer.readLine());

        outToServer.println("I love this course!");
        System.out.println(inFromServer.readLine());

        outToServer.println("bye");

        inFromServer.close();
        outToServer.close();
        client.close();
    }


}
