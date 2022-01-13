package com.example.tubespbol_finance.DAO;

import com.example.tubespbol_finance.Model.Category;
import com.example.tubespbol_finance.Utility.JDBCConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
//18720003-Edward Michael
//1872005-Michael Sebastian Gunadi
public class CategoryDAO implements daoInterface<Category> {
    @Override
    public int addData(Category data) {
        return 0;
    }

    @Override
    public int delData(Category data) {
        return 0;
    }

    @Override
    public int updateData(Category data) {
        return 0;
    }

    @Override
    public ObservableList<Category> showData() {
        ObservableList<Category> cList = FXCollections.observableArrayList();

        try {
            String query = "select * from category;";
            PreparedStatement ps;
            ps = JDBCConnection.getConnection().prepareStatement(query);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                int id = res.getInt("id");
                String namacategory = res.getString("namaCategory");
                Category category = new Category(id, namacategory);
                cList.add(category);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cList;
    }
}
