package com.example.tubespbol_finance.Model;
//18720003-Edward Michael
//1872005-Michael Sebastian Gunadi
public class Saldo {
    private int id;
    private String noRek;
    private String jumlah;
    private User user;

    public Saldo(int id, String noRek, String jumlah, User user) {
        this.id = id;
        this.noRek = noRek;
        this.jumlah = jumlah;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoRek() {
        return noRek;
    }

    public void setNoRek(String noRek) {
        this.noRek = noRek;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return jumlah;
    }
}
