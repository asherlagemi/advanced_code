package model;

import word_search.ClientHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class RunServer {

    public static class TestClientHandler implements ClientHandler {
        BufferedReader in;
        PrintWriter out;

        @Override
        public void handleClient(InputStream inFromClient, OutputStream outToClient) {
            in = new BufferedReader(new InputStreamReader(inFromClient));
            out = new PrintWriter(outToClient, true);
            String line;
            try {
                while(!(line=in.readLine()).equals("bye")) {
                    out.println("the length of \""+line+"\" is"+line.length());
                }
            } catch (IOException e) {e.printStackTrace();}
        }

        @Override
        public void close() {
            try {
                in.close();
                out.close();
            } catch (IOException e) {e.printStackTrace();}
        }
    }

    public static void main(String[] args) {
        System.out.println("SERVER SIDE");
        MyServer server = new MyServer(8080, new TestClientHandler(), 3);
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
