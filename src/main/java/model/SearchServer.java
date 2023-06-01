package model;

import word_search.ClientHandler;

import java.util.Queue;

public class SearchServer extends MyServer {
    private MyServer s;
    Queue<PlayerStatistics> clientQueue;    //

    public SearchServer(int port, ClientHandler ch, int maxThreads) {
        super(port, ch, maxThreads);
    }
}
