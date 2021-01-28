package com.example.drawing_board;

public class Room {

    private int Room_id;
    private char Room_name;
    private char Players;
    private int Password;

    public Room(int room_id, char room_name, char players, int password) {
        this.Room_id = room_id;
        this.Room_name = room_name;
        this.Players = players;
        this.Password = password;
    }

    public int getRoom_id() {
        return Room_id;
    }

    public void setRoom_id(int room_id) {
        Room_id = room_id;
    }

    public char getRoom_name() {
        return Room_name;
    }

    public void setRoom_name(char room_name) {
        Room_name = room_name;
    }

    public char getPlayers() {
        return Players;
    }

    public void setPlayers(char players) {
        Players = players;
    }

    public int getPassword() {
        return Password;
    }

    public void setPassword(int password) {
        Password = password;
    }
}
