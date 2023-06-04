package model;

public class LoginModel {
    private int playMode;  // 1 for host, 2 for guest

    public int getPlayMode() {
        return playMode;
    }

    public void setPlayMode(int playMode) {
        this.playMode = playMode;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    private String nickName;

    public LoginModel(int playMode, String nickName) {
        this.playMode = playMode;
        this.nickName = nickName;
    }
}
