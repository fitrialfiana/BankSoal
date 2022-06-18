package com.example.banksoal.database;

import java.io.Serializable;

public class dbUpSoal implements Serializable {
    String id;
    String soal;
    String jawaban;

    public dbUpSoal() {
    }

    public dbUpSoal(String id, String soal, String jawaban) {
        this.id = id;
        this.soal = soal;
        this.jawaban = jawaban;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }
}


