package model;

import word_search.ClientHandler;

import java.io.*;
import java.util.Scanner;

public class RunGameServer extends RunServer{


//    public static class TestClientHandler implements ClientHandler {
//        BufferedReader in;
//        PrintWriter out;
//
//        @Override
//        public void handleClient(InputStream inFromClient, OutputStream outToClient) {
//            in = new BufferedReader(new InputStreamReader(inFromClient));
//            out = new PrintWriter(outToClient, true);
//            String line;
//            try {
//                while(!(line=in.readLine()).equals("bye")) {
//                    out.println("the length of \""+line+"\" is"+line.length());
//                }
//            } catch (IOException e) {e.printStackTrace();}
//        }
//
//        @Override
//        public void close() {
//            try {
//                in.close();
//                out.close();
//            } catch (IOException e) {e.printStackTrace();}
//        }
//    }

    public static void main(String[] args) {
//        Random r=new Random();
//        int port=6000+r.nextInt(1000);
//        System.out.println("port: " + port);
//        MyServer s=new MyServer(port, new BookScrabbleHandler(),3);
//        s.start(); // runs in the background
//        try {
//            Socket server=new Socket("localhost", port);
//            PrintWriter outToServer=new PrintWriter(server.getOutputStream());
//            Scanner in=new Scanner(server.getInputStream());
//            String response=in.next();
//            outToServer.println(w);
//            outToServer.flush();
//            in.close();
//            outToServer.close();
//            server.close();
//        }catch(Exception e) {
//            System.out.println("error in checking dictionaryLegal in Board");
//        }finally{
//            s.close();
//        }

//
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
