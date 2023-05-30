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

    public static void main(String[] args){
        testDist();
    }
}
