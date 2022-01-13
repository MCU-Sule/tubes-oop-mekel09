package com.example.tubespbol_finance.Model;
//18720003-Edward Michael
//1872005-Michael Sebastian Gunadi
import java.sql.Date;

public class User {
    private int id;
    private String nama;
    private String alamat;
    private String telepon;
    private Date tanggalLahir;
    private String email;
    private String username;
    private String password;
    private Tipeuser tipeuser;

    public User(int id, String nama, String alamat, String telepon, Date tanggalLahir, String email, String username, String password, Tipeuser tipeuser) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
        this.tanggalLahir = tanggalLahir;
        this.email = email;
        this.username = username;
        this.password = password;
        this.tipeuser = tipeuser;
    }

    public User() {

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

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Tipeuser getTipeuser() {
        return tipeuser;
    }

    public void setTipeuser(Tipeuser tipeuser) {
        this.tipeuser = tipeuser;
    }
}
