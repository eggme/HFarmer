package com.honam.kyyeto.hfarmers.Home;

public class Month_Goods {

    private String title;
    private int drawableId;

    public Month_Goods(){}

    public Month_Goods(String title, int drawableId) {
        this.title = title;
        this.drawableId = drawableId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }
}
