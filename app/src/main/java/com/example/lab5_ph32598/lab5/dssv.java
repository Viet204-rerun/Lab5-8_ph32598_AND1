package com.example.lab5_ph32598.lab5;

public class dssv {
    private String thanhpho;
    private String hoten;
    private String diachi;

    public dssv(String thanhpho, String hoten, String diachi) {
        this.thanhpho = thanhpho;
        this.hoten = hoten;
        this.diachi = diachi;
    }

    public dssv() {
    }

    public String getThanhpho() {
        return thanhpho;
    }

    public void setThanhpho(String thanhpho) {
        this.thanhpho = thanhpho;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
