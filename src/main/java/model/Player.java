package model;

import game_element.Tile;

public class Player {
    String myName;
    Tile[] myHand;
    boolean myTurn;
    int score;

    public Player(String myName, Tile[] myHand, boolean myTurn) {
        this.myName = myName;
        this.myHand = myHand;
        this.myTurn = myTurn;
        this.score = 0;
    }

    public String getName() {
        return myName;
    }

    public int getScore() {
        return score;
    }

    public Tile[] getMyHand() {
        return myHand;
    }
}
