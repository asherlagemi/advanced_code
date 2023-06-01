package model;

import word_search.ClientHandler;

import java.io.*;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class RunSearchServer extends RunServer{

    public static void main(String[] args) {
        Random r = new Random();
        int port = 6000 + r.nextInt(1000);
        System.out.println("port: " + port);
        MyServer s = new SearchServer(port, new BookScrabbleHandler(), 3);
        s.start(); // runs in the background
        try {
            Socket server = new Socket("localhost", port);
            PrintWriter outToServer = new PrintWriter(server.getOutputStream());
            Scanner in = new Scanner(server.getInputStream());
            String response = in.next();
            outToServer.println(r);
            outToServer.flush();
            in.close();
            outToServer.close();
            server.close();
        } catch (Exception e) {
            System.out.println("error in checking dictionaryLegal in Board");
        } finally {
            s.close();
        }
    }
}
