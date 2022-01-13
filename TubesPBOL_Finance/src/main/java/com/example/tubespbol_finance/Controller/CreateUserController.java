package com.example.tubespbol_finance.Controller;

import com.example.tubespbol_finance.DAO.TipeuserDAO;
import com.example.tubespbol_finance.DAO.UserDAO;
import com.example.tubespbol_finance.Model.Tipeuser;
import com.example.tubespbol_finance.Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
//18720003-Edward Michael
//1872005-Michael Sebastian Gunadi
public class CreateUserController implements Initializable {
    public TextField tfUsername;
    public TextField tfPassword;
    public TextField tfNama;
    public TextField tfAlamat;
    public TextField tfTelepon;
    public DatePicker dpTanggalLahir;
    public TextField tfEmail;
    public ComboBox<Tipeuser> cbUser;
    public Button btnBuatAkun;

    ObservableList<Tipeuser> tList;
    ObservableList<User> uList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tList = FXCollections.observableArrayList();
        TipeuserDAO tipeuserDAO = new TipeuserDAO();
        ObservableList<Tipeuser> tList = tipeuserDAO.showData();
        cbUser.getItems().addAll(tList);

    }

    public void btnBuatAkunClicked(ActionEvent actionEvent) {
        String username = tfUsername.getText();
        String password = tfPassword.getText();
        String nama = tfNama.getText();
        String alamat = tfAlamat.getText();
        String telepon = tfTelepon.getText();
        Date tanggalLahir = Date.valueOf(dpTanggalLahir.getValue());
        String email = tfEmail.getText();
        Object tipeuser = cbUser.getValue();

        UserDAO userDAO = new UserDAO();

        User user = new User();
        user.setUsername(tfUsername.getText());
        user.setPassword(tfPassword.getText());
        user.setNama(tfNama.getText());
        user.setAlamat(tfAlamat.getText());
        user.setTelepon(tfTelepon.getText());
        user.setTanggalLahir(Date.valueOf(dpTanggalLahir.getValue()));
        user.setEmail(tfEmail.getText());
        user.setTipeuser(cbUser.getValue());
        userDAO.addData(user);

        tfUsername.setText(null);
        tfPassword.setText(null);
        tfNama.setText(null);
        tfAlamat.setText(null);
        tfTelepon.setText(null);
        dpTanggalLahir.setId(null);
        tfEmail.setText(null);
        cbUser.setItems(null);


//        User user = new User()
//        int keterangan = (int) cbUser.getValue();
//        System.out.println(cbUser.getValue());
    }
}
