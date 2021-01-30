package com.example.drawing_board;

public class Room {

    private int Room_id;
    private String Room_name;
    private String Players;
    private boolean Key;
    private int Password;

    public Room(){
        this.Room_id = 00000;
        this.Room_name = "돌려돌려 그림판";
        this.Players = "0 / 0";
        this.Key = false;
        this.Password = 0;
    }

    public Room(int room_id, String room_name, String players, boolean key, int password) {
        this.Room_id = room_id;
        this.Room_name = room_name;
        this.Players = players;
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

    public String getPlayers() {
        return Players;
    }

    public void setPlayers(String players) {
        Players = players;
    }

    public boolean isKey() { return Key; }

    public void setKey(boolean key) { this.Key = key; }

    public int getPassword() {
        return Password;
    }

    public void setPassword(int password) {
        Password = password;
    }
}
