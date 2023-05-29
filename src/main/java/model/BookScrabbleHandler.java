package model;


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
    public void handleClient(InputStream inFromclient, OutputStream outToClient) {
        out = new PrintWriter(outToClient);
        in = new Scanner(inFromclient);
        boolean res;
        String[] search = in.next().split(",");
        String type = search[0];
        String[] searchArgs = new String[search.length - 1];
        
        for(int i=1; i<search.length; i++)
            searchArgs[i-1] = search[i];

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

 
