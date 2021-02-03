package com.example.drawing_board;

public class Room {

    private String Room_id;
    private String Room_name;
    private long curPlayers;
    private long maxPlayers;
    private String Players;
    private boolean Key;
    private String Password;

    public Room(){
        this.Room_id = "000";
        this.Room_name = "돌려돌려 그림판";
        this.curPlayers = 0;
        this.maxPlayers = 0;
        this.Players = "0 / 0";
        this.Key = false;
        this.Password = "0";
    }

    public Room(String room_id, String room_name, long curplayers, long maxplayers,String players, boolean key, String password) {
        this.Room_id = room_id;
        this.Room_name = room_name;
        this.curPlayers = curplayers;
        this.maxPlayers = maxplayers;
        this.Players = players;
        this.Key = key;
        this.Password = password;
    }

    public String getRoom_id() {
        return Room_id;
    }

    public void setRoom_id(String room_id) {
        Room_id = room_id;
    }

    public String getRoom_name() {
        return Room_name;
    }

    public void setRoom_name(String room_name) {
        Room_name = room_name;
    }

    public long getcurPlayers() {
        return curPlayers;
    }

    public void setcurPlayers(long curplayers) {
        curPlayers = curplayers;
    }

    public long getmaxPlayers() {
        return maxPlayers;
    }

    public void setmaxPlayers(long maxplayers) {
        maxPlayers = maxplayers;
    }

    public void setPlayers(String players) {
        Players = players;
    }

    public boolean isKey() { return Key; }

    public void setKey(boolean key) { this.Key = key; }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
