package com.example.tubespbol_finance.DAO;

import com.example.tubespbol_finance.Model.*;
import com.example.tubespbol_finance.Utility.JDBCConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
//18720003-Edward Michael
//1872005-Michael Sebastian Gunadi
public class PembukuanDAO implements daoInterface<Pembukuan> {
    @Override
    public int addData(Pembukuan data) {
        int result = 0;

        try {
            String query ="insert into pembukuan(nama, jumlah, keterangan, category_id, user_id) values (?,?,?,?,?)";
            PreparedStatement ps;
            ps = JDBCConnection.getConnection().prepareStatement(query);
            ps.setString(1, data.getNama());
            ps.setString(2, data.getJumlah());
            ps.setString(3, data.getKeterangan());
            ps.setInt(4, data.getCategory().getId());
            ps.setInt(5, data.getUser().getId());
            result = ps.executeUpdate();

        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public int delData(Pembukuan data) {
        return 0;
    }

    @Override
    public int updateData(Pembukuan data) {
        return 0;
    }

    @Override
    public ObservableList<Pembukuan> showData() {
        ObservableList<Pembukuan> pList = FXCollections.observableArrayList();

        try {
            String query = "select p.id as idpembukuan, p.nama as namapembukuan, p.jumlah as jumlahpembukuan, p.keterangan as keteranganpembukuan, p.category_id, p.user_id, c.id as idcategory, c.namacategory as namacategory, u.id as iduser, u.nama as namauser, u.alamat as alamatuser, u.telepon as teleponuser, u.tanggallahir as tanggallahiruser, u.email as emailuser, u.username as usernameuser, u.password as passworduser, u.tipeuser_id, s.id as idsaldo, s.norek as noreksaldo, s.jumlah as jumlahsaldo, s.user_id, tu.id as idtipeuser, tu.namatipe as namatipetipeuser from pembukuan p join category c on p.category_id = c.id join user u on u.id = p.user_id join saldo s on u.id = s.user_id join tipeuser tu on u.tipeuser_id = tu.id";
            PreparedStatement ps;
            ps = JDBCConnection.getConnection().prepareStatement(query);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                int idtipeuser = res.getInt("idtipeuser");
                String namatipe = res.getString("namatipetipeuser");
                Tipeuser tipeuser = new Tipeuser(idtipeuser, namatipe);

                int iduser = res.getInt("iduser");
                String nama = res.getString("namauser");
                String alamat = res.getString("alamatuser");
                String telepon = res.getString("teleponuser");
                Date tanggallahir = res.getDate("tanggallahiruser");
                String email = res.getString("emailuser");
                String username = res.getString("usernameuser");
                String password = res.getString("passworduser");
                User user = new User(iduser, nama, alamat, telepon, tanggallahir, email, username, password, tipeuser);

                int idsaldo = res.getInt("idsaldo");
                String norek = res.getString("noreksaldo");
                String jumlah = res.getString("jumlahsaldo");
                Saldo saldo = new Saldo(idsaldo, norek, jumlah, user);

                int idcategory = res.getInt("idcategory");
                String namacategory = res.getString("namacategory");
                Category category = new Category(idcategory, namacategory);

                int idpembukuan = res.getInt("idpembukuan");
                String namapembukuan = res.getString("namapembukuan");
                String jumlahpembukuan = res.getString("jumlahpembukuan");
                String keterangan = res.getString("keteranganpembukuan");
                Pembukuan pembukuan = new Pembukuan(idpembukuan, namapembukuan, jumlahpembukuan, keterangan, category, user);

                pList.add(pembukuan);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return pList;
    }

    public ObservableList<Pembukuan> showPemasukkan(User user) {
        ObservableList<Pembukuan> pList = FXCollections.observableArrayList();

        try {
            String query2 = "select p.id as idpembukuan, p.nama as namapembukuan, p.jumlah as jumlahpembukuan, p.keterangan as keteranganpembukuan, p.category_id, p.user_id, c.id as idcategory, c.namacategory as namacategory, u.id as iduser, u.nama as namauser, u.alamat as alamatuser, u.telepon as teleponuser, u.tanggallahir as tanggallahiruser, u.email as emailuser, u.username as usernameuser, u.password as passworduser, u.tipeuser_id, s.id as idsaldo, s.norek as noreksaldo, s.jumlah as jumlahsaldo, s.user_id, tu.id as idtipeuser, tu.namatipe as namatipetipeuser from pembukuan p join category c on p.category_id = c.id join user u on u.id = p.user_id join saldo s on u.id = s.user_id join tipeuser tu on u.tipeuser_id = tu.id where c.id = 1 and u.username = ?";
            PreparedStatement ps;
            ps = JDBCConnection.getConnection().prepareStatement(query2);
            ps.setString(1, user.getUsername());
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                int idtipeuser = res.getInt("idtipeuser");
                String namatipe = res.getString("namatipetipeuser");
                Tipeuser tipeuser = new Tipeuser(idtipeuser, namatipe);

                int iduser = res.getInt("iduser");
                String nama = res.getString("namauser");
                String alamat = res.getString("alamatuser");
                String telepon = res.getString("teleponuser");
                Date tanggallahir = res.getDate("tanggallahiruser");
                String email = res.getString("emailuser");
                String username = res.getString("usernameuser");
                String password = res.getString("passworduser");
                User user2 = new User(iduser, nama, alamat, telepon, tanggallahir, email, username, password, tipeuser);

                int idsaldo = res.getInt("idsaldo");
                String norek = res.getString("noreksaldo");
                String jumlah = res.getString("jumlahsaldo");
                Saldo saldo = new Saldo(idsaldo, norek, jumlah, user2);

                int idcategory = res.getInt("idcategory");
                String namacategory = res.getString("namacategory");
                Category category = new Category(idcategory, namacategory);

                int idpembukuan = res.getInt("idpembukuan");
                String namapembukuan = res.getString("namapembukuan");
                String jumlahpembukuan = res.getString("jumlahpembukuan");
                String keterangan = res.getString("keteranganpembukuan");
                Pembukuan pembukuan = new Pembukuan(idpembukuan, namapembukuan, jumlahpembukuan, keterangan, category, user);

                pList.add(pembukuan);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return pList;
    }

    public ObservableList<Pembukuan> showPengeluaran(User user) {
        ObservableList<Pembukuan> pList = FXCollections.observableArrayList();

        try {
            String query2 = "select p.id as idpembukuan, p.nama as namapembukuan, p.jumlah as jumlahpembukuan, p.keterangan as keteranganpembukuan, p.category_id, p.user_id, c.id as idcategory, c.namacategory as namacategory, u.id as iduser, u.nama as namauser, u.alamat as alamatuser, u.telepon as teleponuser, u.tanggallahir as tanggallahiruser, u.email as emailuser, u.username as usernameuser, u.password as passworduser, u.tipeuser_id, s.id as idsaldo, s.norek as noreksaldo, s.jumlah as jumlahsaldo, s.user_id, tu.id as idtipeuser, tu.namatipe as namatipetipeuser from pembukuan p join category c on p.category_id = c.id join user u on u.id = p.user_id join saldo s on u.id = s.user_id join tipeuser tu on u.tipeuser_id = tu.id where c.id = 2 and u.username = ?";
            PreparedStatement ps;
            ps = JDBCConnection.getConnection().prepareStatement(query2);
            ps.setString(1, user.getUsername());
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                int idtipeuser = res.getInt("idtipeuser");
                String namatipe = res.getString("namatipetipeuser");
                Tipeuser tipeuser = new Tipeuser(idtipeuser, namatipe);

                int iduser = res.getInt("iduser");
                String nama = res.getString("namauser");
                String alamat = res.getString("alamatuser");
                String telepon = res.getString("teleponuser");
                Date tanggallahir = res.getDate("tanggallahiruser");
                String email = res.getString("emailuser");
                String username = res.getString("usernameuser");
                String password = res.getString("passworduser");
                User user2 = new User(iduser, nama, alamat, telepon, tanggallahir, email, username, password, tipeuser);

                int idsaldo = res.getInt("idsaldo");
                String norek = res.getString("noreksaldo");
                String jumlah = res.getString("jumlahsaldo");
                Saldo saldo = new Saldo(idsaldo, norek, jumlah, user2);

                int idcategory = res.getInt("idcategory");
                String namacategory = res.getString("namacategory");
                Category category = new Category(idcategory, namacategory);

                int idpembukuan = res.getInt("idpembukuan");
                String namapembukuan = res.getString("namapembukuan");
                String jumlahpembukuan = res.getString("jumlahpembukuan");
                String keterangan = res.getString("keteranganpembukuan");
                Pembukuan pembukuan = new Pembukuan(idpembukuan, namapembukuan, jumlahpembukuan, keterangan, category, user);

                pList.add(pembukuan);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return pList;
    }
}
