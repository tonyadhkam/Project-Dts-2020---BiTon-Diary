package com.example.csuser.biton_diary.entities;

public class Diary {
    private int id;
    private String tanggal;
    private String judul;
    private String pesan;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTanggal() {
        return tanggal;
    }
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    public String getJudul() {
        return judul;
    }
    public void setJudul(String judul) {
        this.judul = judul;
    }
    public String getPesan() {
        return pesan;
    }
    public void setPesan(String pesan) {
        this.pesan = pesan;
    }
    public Diary()
    {
        }
}
