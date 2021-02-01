package com.example.drawing_board;

public class Room {

    private int Room_id;
    private String Room_name;
    private int curPlayers;
    private int maxPlayers;
    private boolean Key;
    private String Password;

    public Room(){
        this.Room_id = 00000;
        this.Room_name = "돌려돌려 그림판";
        this.curPlayers = 0;
        this.maxPlayers = 0;
        this.Key = false;
        this.Password = "0";
    }

    public Room(int room_id, String room_name, int curplayers, int maxplayers, boolean key, String password) {
        this.Room_id = room_id;
        this.Room_name = room_name;
        this.curPlayers = curplayers;
        this.maxPlayers = maxplayers;
        this.Key = key;
        this.Password = password;
    }

    public int getRoom_id() {
        return Room_id;
    }

    public void setRoom_id(int room_id) {
        Room_id = room_id;
    }

    public String getRoom_name() {
        return Room_name;
    }

    public void setRoom_name(String room_name) {
        Room_name = room_name;
    }

    public int getcurPlayers() {
        return curPlayers;
    }

    public void setcurPlayers(int curplayers) {
        curPlayers = curplayers;
    }

    public int getmaxPlayers() {
        return maxPlayers;
    }

    public void setmaxPlayers(int maxplayers) {
        maxPlayers = maxplayers;
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
