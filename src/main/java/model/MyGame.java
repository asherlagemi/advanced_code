package model;

import game_element.Board;

public class MyGame {
    int[] allPlayersScores;
    Board board;
    Player me;

    public MyGame(int[] allPlayersScores, Board board, Player me) {
        this.allPlayersScores = allPlayersScores;
        this.board = board;
        this.me = me;
    }

}
