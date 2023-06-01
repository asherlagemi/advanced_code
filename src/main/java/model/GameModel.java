package model;

public abstract class GameModel {
    MyGame gameData;
    String hostIP;
    int port;

    public GameModel(MyGame gameData, String hostIP, int port) {
        this.gameData = gameData;
        this.hostIP = hostIP;
        this.port = port;
    }
}
