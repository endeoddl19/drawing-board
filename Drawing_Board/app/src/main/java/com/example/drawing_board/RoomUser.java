package com.example.drawing_board;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Bundle;
import android.util.AttributeSet;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import java.util.HashMap;
import java.util.List;

public class RoomUser {
    private int cnt,playernum;
    private List<HashMap<String,Bitmap>> list;

    public RoomUser(int cnt, int playernum, List<HashMap<String, Bitmap>> list) {
        this.cnt = cnt;
        this.playernum = playernum;
        this.list = list;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public int getPlayernum() {
        return playernum;
    }

    public void setPlayernum(int playernum) {
        this.playernum = playernum;
    }

    public List<HashMap<String, Bitmap>> getList() {
        return list;
    }

    public void setList(List<HashMap<String, Bitmap>> list) {
        this.list = list;
    }
}
