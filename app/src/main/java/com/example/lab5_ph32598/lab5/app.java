package com.example.lab5_ph32598.lab5;

public class app {
    private int img;
    private String text;

    public app(int img, String text) {
        this.img = img;
        this.text = text;
    }

    public app() {
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
