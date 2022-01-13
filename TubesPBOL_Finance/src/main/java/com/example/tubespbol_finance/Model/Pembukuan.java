package com.example.tubespbol_finance.Model;
//18720003-Edward Michael
//1872005-Michael Sebastian Gunadi
public class Pembukuan {
    private int id;
    private String nama;
    private String jumlah;
    private String keterangan;
    private Category category;
    private User user;

    public Pembukuan(int id, String nama, String jumlah, String keterangan, Category category, User user) {
        this.id = id;
        this.nama = nama;
        this.jumlah = jumlah;
        this.keterangan = keterangan;
        this.category = category;
        this.user = user;
    }

    public Pembukuan() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
