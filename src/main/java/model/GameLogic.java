package model;

import game_element.Tile;

public class GameLogic {
    private final int handSize;

    public GameLogic() {
        handSize = 7;
    }

    public Tile[] distributeTiles(Tile[] currHand) {
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

    public void updateStatistic(Player player, boolean riskFlag, int score) {
        if (riskFlag) {
            if (score!=0)
                score += 10;    // prize if took successful risk
            else
                score -= 5;     // penalty if took unfruitful risk
        }

        player.setScore(player.getScore() + score);
    }

}