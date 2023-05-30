package model;


import word_search.ClientHandler;
import word_search.DictionaryManager;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class BookScrabbleHandler implements ClientHandler {
	
    PrintWriter out;
    Scanner in;
    DictionaryManager dm;

    public BookScrabbleHandler(){
        dm = DictionaryManager.get();
    }

    @Override
    public void handleClient(InputStream inFromClient, OutputStream outToClient) {
        out = new PrintWriter(outToClient);
        in = new Scanner(inFromClient);
        boolean res;
        String[] search = in.next().split(",");
        String type = search[0];
        String[] searchArgs = new String[search.length - 1];

        System.arraycopy(search, 1, searchArgs, 0, search.length - 1);

        if (type.equals("C"))
            res = dm.challenge(searchArgs);
        else if(type.equals("Q"))
            res = dm.query(searchArgs);
        else
        	res = false;
        
        out.println(res);
        out.flush();
    }

    @Override
    public void close() {
        dm.closeMap();
        in.close();
        out.close();
    }
}

 
