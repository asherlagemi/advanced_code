package model;

import game_element.Tile;

public class GameLogic {

    public static Tile[] distributeTiles(Tile[] currHand) {
        int handSize = 7;
        Tile[] newHand = new Tile[handSize];
        for (int i = 0; i < handSize; i++) {
            if (i < currHand.length)
                newHand[i] = currHand[i];
            else {
                newHand[i] = new Tile.Bag().getRand();
            }
        }
        return newHand;
    }

    public static void updateStatistic(PlayerStatus player, boolean riskFlag, int score) {
        if (score != 0) {
            if (riskFlag)
                score += 10;    // prize if took successful risk
            else
                score -= 5;     // penalty if took unfruitful risk
        }
        player.setScore(player.getScore() + score);
    }

}