package com.example.tubespbol_finance.DAO;

import com.example.tubespbol_finance.Model.Tipeuser;
import com.example.tubespbol_finance.Utility.JDBCConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//18720003-Edward Michael
//1872005-Michael Sebastian Gunadi
public class TipeuserDAO implements daoInterface<Tipeuser> {
    @Override
    public int addData(Tipeuser data) {
        return 0;
    }

    @Override
    public int delData(Tipeuser data) {
        return 0;
    }

    @Override
    public int updateData(Tipeuser data) {
        return 0;
    }

    @Override
    public ObservableList<Tipeuser> showData() {
        ObservableList<Tipeuser> tList = FXCollections.observableArrayList();

        try {
            String query = "select * from tipeuser;";
            PreparedStatement ps;
            ps = JDBCConnection.getConnection().prepareStatement(query);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                int id = res.getInt("id");
                String namatipe = res.getString("namatipe");
                Tipeuser tipeuser = new Tipeuser(id, namatipe);
                tList.add(tipeuser);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tList;
    }
}
