package com.example.lab5_ph32598.lab8;

import java.io.Serializable;

public class user implements Serializable {
    private String tk,mk;

    public user() {
    }

    public user(String tk, String mk) {
        this.tk = tk;
        this.mk = mk;
    }

    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }
}
