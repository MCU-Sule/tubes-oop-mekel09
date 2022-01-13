package com.example.tubespbol_finance.Model;
//18720003-Edward Michael
//1872005-Michael Sebastian Gunadi
public class Tipeuser {
    private int id;
    private String namaTipe;

    public Tipeuser(int id, String namaTipe) {
        this.id = id;
        this.namaTipe = namaTipe;
    }

    public Tipeuser() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaTipe() {
        return namaTipe;
    }

    public void setNamaTipe(String namaTipe) {
        this.namaTipe = namaTipe;
    }

    @Override
    public String toString() {
        return namaTipe;
    }
}
