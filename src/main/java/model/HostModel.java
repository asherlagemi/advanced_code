package model;

public class HostModel extends Model {
    HostServer gameServer;
    public HostModel(String propertiesFileName) {
        super(propertiesFileName);
        gameServer = new HostServer();
    }
}
