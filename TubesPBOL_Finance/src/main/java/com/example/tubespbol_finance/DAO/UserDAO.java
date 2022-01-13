package com.example.tubespbol_finance.DAO;

import com.example.tubespbol_finance.Model.Tipeuser;
import com.example.tubespbol_finance.Model.User;
import com.example.tubespbol_finance.Utility.JDBCConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//18720003-Edward Michael
//1872005-Michael Sebastian Gunadi
public class UserDAO implements daoInterface<User> {
    @Override
    public int addData(User data) {
        int result = 0;

        try {
            String query = "insert into user(nama, alamat, telepon, tanggalLahir, email, username, password, tipeuser_id) values(?,?,?,?,?,?,?,?);";
            PreparedStatement ps;
            ps = JDBCConnection.getConnection().prepareStatement(query);
            ps.setString(1, data.getNama());
            ps.setString(2, data.getAlamat());
            ps.setString(3, data.getTelepon());
            ps.setDate(4, data.getTanggalLahir());
            ps.setString(5, data.getEmail());
            ps.setString(6, data.getUsername());
            ps.setString(7, data.getPassword());
            ps.setInt(8, data.getTipeuser().getId());
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public int delData(User data) {
        return 0;
    }

    @Override
    public int updateData(User data) {
        return 0;
    }

    @Override
    public ObservableList<User> showData() {
        ObservableList<User> uList = FXCollections.observableArrayList();

        try {
            String query = "select u.id as id, u.nama as nama, u.alamat as alamat, u.telepon as telepon, u.tanggalLahir as tanggalLahir, u.email as email, u.username as username, u.password as password, u.tipeuser_id as tipeuser, tu.id as idtipeuser, tu.namaTipe as namaTipe from user u join tipeuser tu on u.tipeuser_id = tu.id";
            PreparedStatement ps;
            ps = JDBCConnection.getConnection().prepareStatement(query);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                int idtipeuser = res.getInt("idtipeuser");
                String namatipe = res.getString("namaTipe");
                Tipeuser tipeuser = new Tipeuser(idtipeuser, namatipe);

                int iduser = res.getInt("id");
                String nama = res.getString("nama");
                String alamat = res.getString("alamat");
                String telepon = res.getString("telepon");
                Date tanggallahir = res.getDate("tanggalLahir");
                String email = res.getString("email");
                String username = res.getString("username");
                String password = res.getString("password");
                User user = new User(iduser, nama, alamat, telepon, tanggallahir, email, username, password, tipeuser);

                uList.add(user);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return uList;
    }

    public User fetchUser(User user) throws SQLException {
        User result;
        try (Connection connection = JDBCConnection.getConnection()) {
            String query = "select * from user where username = ? and password = ?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                try (ResultSet res = ps.executeQuery()) {
                    result = new User();
                    while (res.next()) {
                        result.setId(res.getInt("id"));
                        result.setNama(res.getString("nama"));
                        result.setAlamat(res.getString("alamat"));
                        result.setTelepon(res.getString("telepon"));
                        result.setTanggalLahir(res.getDate("tanggalLahir"));
                        result.setEmail(res.getString("email"));
                        result.setUsername(res.getString("username"));
                        result.setPassword(res.getString("password"));
                    }
                    return result;
                }
            }
        }
    }
}
