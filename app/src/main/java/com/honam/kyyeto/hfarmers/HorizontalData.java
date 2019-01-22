package com.honam.kyyeto.hfarmers;

public class HorizontalData {
    private int img;
    private String text;

    public HorizontalData(String text, int img){
        this.img = img;
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public int getImg() {
        return this.img;
    }
}
