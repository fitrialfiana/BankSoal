package com.example.banksoal.database;
import java.io.Serializable;

public class dbTampilSoal implements Serializable{
    String id;
    String data;
    String jawab;

    public dbTampilSoal() {

    }

    public dbTampilSoal(String id, String data, String jawab) {
        this.id = id;
        this.data = data;
        this.jawab = jawab;
    }

    public String getIdd() {
        return id;
    }

    public void setIdd(String id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getJawab() {
        return jawab;
    }

    public void setJawab(String jawab) {
        this.jawab = jawab;
    }

}
