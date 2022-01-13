package com.example.tubespbol_finance.Controller;

import com.example.tubespbol_finance.DAO.UserDAO;
import com.example.tubespbol_finance.Model.User;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
//18720003-Edward Michael
//1872005-Michael Sebastian Gunadi
public class UserController implements Initializable {

    public TableView<User> tvUser;
    public TableColumn<User, Integer> colID;
    public TableColumn<User, String> colUsername;
    public TableColumn<User, String> colNama;
    public TableColumn<User, String> colAlamat;
    public TableColumn<User, String> colTelepon;
    public TableColumn<User, Date> colTanggalLahir;
    public TableColumn<User, String> colEmail;
    public TableColumn<User, String> colKeterangan;

    ObservableList<User> uList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        uList = FXCollections.observableArrayList();
        UserDAO userDAO = new UserDAO();
        ObservableList<User> uList = userDAO.showData();
        tvUser.setItems(uList);
        colID.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()).asObject());
        colNama.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNama()));
        colAlamat.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAlamat()));
        colUsername.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getUsername()));
        colEmail.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEmail()));
        colTanggalLahir.setCellValueFactory(data -> new SimpleObjectProperty(data.getValue().getTanggalLahir()));
        colTelepon.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTelepon()));
    }
}
