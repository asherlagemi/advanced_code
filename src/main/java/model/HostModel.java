package model;

public class HostModel extends GameModel {
    HostServer gameServer;
    GameLogic gl;

    public HostModel(MyGame gameData, String hostIP, int port, HostServer gameServer) {
        super(gameData, "127.0.0.1", port);
        this.gameServer = gameServer;
        this.gl = new GameLogic();
    }
}
