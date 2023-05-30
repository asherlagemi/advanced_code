package model;

import game_element.Tile;

public class GameLogicTest {
    public static void testDist(){
        Tile[] tiles = {
                new Tile.Bag().getTile('A'),
                new Tile.Bag().getTile('C'),
                new Tile.Bag().getTile('U'),
                new Tile.Bag().getTile('T')
        };
        for (Tile t : tiles)
            System.out.println(t.letter);
        System.out.println("length: " + tiles.length);
        System.out.println();

        Tile[] newTiles = GameLogic.distributeTiles(tiles);
        for (Tile t : newTiles)
            System.out.println(t.letter);
        System.out.println("length: " + newTiles.length);
    }

    public static void testStats(){
        PlayerStatus p1 = new PlayerStatus("Asher");
        System.out.println(p1.getName());
        GameLogic.updateStatistic(p1,true,6); // should be 6+10=16
        System.out.printf("%d\t", p1.getScore());
        GameLogic.updateStatistic(p1,false,0); // should be 16
        System.out.printf("%d\t", p1.getScore());
        GameLogic.updateStatistic(p1,false,5); // should be 16+5=21
        System.out.printf("%d\t", p1.getScore());
        GameLogic.updateStatistic(p1,true,3); // should be 24+10=34
        System.out.printf("%d\t", p1.getScore());
        GameLogic.updateStatistic(p1,true,0); // should be 34-5=29
        System.out.printf("%d\t", p1.getScore());
    }

    public static void main(String[] args){
        testDist();
        testStats();
    }
}
