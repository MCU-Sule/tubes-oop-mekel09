package com.example.tubespbol_finance.DAO;

import com.example.tubespbol_finance.Model.Saldo;
import com.example.tubespbol_finance.Model.Tipeuser;
import com.example.tubespbol_finance.Model.User;
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
public class SaldoDAO implements daoInterface<Saldo> {
    @Override
    public int addData(Saldo data) {
        return 0;
    }

    @Override
    public int delData(Saldo data) {
        return 0;
    }

    @Override
    public int updateData(Saldo data) {
        return 0;
    }

    @Override
    public ObservableList<Saldo> showData() {
        ObservableList<Saldo> sList = FXCollections.observableArrayList();

        try {
            String query = "select u.id as iduser, u.nama as namauser, u.alamat as alamatuser, u.telepon as teleponuser, u.tanggallahir as tanggallahiruser, u.email as emailuser, u.username as usernameuser, u.password as passworduser, u.tipeuser_id, s.id as idsaldo, s.norek as noreksaldo, s.jumlah as jumlahsaldo, s.user_id, tu.id as idtipeuser, tu.namatipe as namatipetipeuser from saldo s join user u on u.id = s.user_id join tipeuser tu on u.tipeuser_id = tu.id";
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

                sList.add(saldo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return sList;
    }

    public ObservableList<Saldo> showSaldo(User user2) {
        ObservableList<Saldo> sList = FXCollections.observableArrayList();

        try {
            String query = "select u.id as iduser, u.nama as namauser, u.alamat as alamatuser, u.telepon as teleponuser, u.tanggallahir as tanggallahiruser, u.email as emailuser, u.username as usernameuser, u.password as passworduser, u.tipeuser_id, s.id as idsaldo, s.norek as noreksaldo, s.jumlah as jumlahsaldo, s.user_id, tu.id as idtipeuser, tu.namatipe as namatipetipeuser from saldo s join user u on u.id = s.user_id join tipeuser tu on u.tipeuser_id = tu.id where u.username = ?";
            PreparedStatement ps;
            ps = JDBCConnection.getConnection().prepareStatement(query);
            ps.setString(1, user2.getUsername());
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

                sList.add(saldo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return sList;
    }
}
