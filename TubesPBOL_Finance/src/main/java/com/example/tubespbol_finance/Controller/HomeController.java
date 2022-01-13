package com.example.tubespbol_finance.Controller;

import com.example.tubespbol_finance.DAO.CategoryDAO;
import com.example.tubespbol_finance.DAO.PembukuanDAO;
import com.example.tubespbol_finance.DAO.SaldoDAO;
import com.example.tubespbol_finance.HelloApplication;
import com.example.tubespbol_finance.Model.Category;
import com.example.tubespbol_finance.Model.Pembukuan;
import com.example.tubespbol_finance.Model.Saldo;
import com.example.tubespbol_finance.Model.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
//18720003-Edward Michael
//1872005-Michael Sebastian Gunadi
public class HomeController implements Initializable {
    public ComboBox cbBahasa;
    public TextField tfNamaPembukuan;
    public TextField tfJumlahPembukuan;
    public ComboBox<Category> cbKategori;
    public TextField tfKeterangan;
    public Button btnSimpan;
    public Label tfJumlahSaldo;
    public TableView<Pembukuan> tvPemasukan;
    public TableColumn<Pembukuan, String> colNamaPemasukan;
    public TableColumn<Pembukuan, String> colJumlahPemasukan;
    public TableColumn<Pembukuan, String> colKeteranganPemasukkan;
    public TableView<Pembukuan> tvPengeluaran;
    public TableColumn<Pembukuan, String> colNamaPengeluaran;
    public TableColumn<Pembukuan, String> colJumlahPengeluaran;
    public TableColumn<Pembukuan, String> colKeteranganPengeluaran;
    public Label labelPembukuan;
    public Label labelNamaPembukuan;
    public Label labelJumlahPembukuan;
    public Label labelKategoriPembukuan;
    public Label labelKeterangan;
    public Label labelSaldo;
    public Label labelPemasukkan;
    public Label labelPengeluaran;

    String value = "Indonesia";

    ObservableList<Category> cList;
    private LoginController loginController;
    private User thisUser;
    private User thisUser2;
    private Saldo thisSaldo;

    ObservableList<Pembukuan> pList;

    ObservableList<Saldo> sList;

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
        thisUser = loginController.getUser();

        sList = FXCollections.observableArrayList();
        SaldoDAO saldoDAO = new SaldoDAO();
        ObservableList<Saldo> sList = saldoDAO.showSaldo(thisUser);
        tfJumlahSaldo.setText(sList.toString());

        pList = FXCollections.observableArrayList();
        PembukuanDAO pembukuanDAO = new PembukuanDAO();
        ObservableList<Pembukuan> pList = pembukuanDAO.showPemasukkan(thisUser);
        tvPemasukan.setItems(pList);
        colNamaPemasukan.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNama()));
        colJumlahPemasukan.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getJumlah()));
        colKeteranganPemasukkan.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getKeterangan()));

        ObservableList<Pembukuan> pList2 = pembukuanDAO.showPengeluaran(thisUser);
        tvPengeluaran.setItems(pList2);
        colNamaPengeluaran.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNama()));
        colJumlahPengeluaran.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getJumlah()));
        colKeteranganPengeluaran.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getKeterangan()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbBahasa.getItems().addAll("Inggris","Indonesia");

        cList = FXCollections.observableArrayList();
        CategoryDAO categoryDAO = new CategoryDAO();
        ObservableList<Category> cList = categoryDAO.showData();
        cbKategori.getItems().addAll(cList);

        ResourceBundle bundle = ResourceBundle.getBundle("bundle_IN");
        labelPembukuan.setText(bundle.getString("inputp.text"));
        labelNamaPembukuan.setText(bundle.getString("namap.text"));
        labelJumlahPembukuan.setText(bundle.getString("jumlahp.text"));
        labelKategoriPembukuan.setText(bundle.getString("kategorip.text"));
        labelKeterangan.setText(bundle.getString("keteranganp.text"));
        btnSimpan.setText(bundle.getString("simpan.text"));
        labelPemasukkan.setText(bundle.getString("lpemasukkan.text"));
        labelPengeluaran.setText(bundle.getString("lpengeluaran.text"));
        colNamaPemasukan.setText(bundle.getString("namap.text"));
        colJumlahPemasukan.setText(bundle.getString("jumlahp.text"));
        colKeteranganPemasukkan.setText(bundle.getString("keteranganp.text"));
        colNamaPengeluaran.setText(bundle.getString("namap.text"));
        colJumlahPengeluaran.setText(bundle.getString("jumlahp.text"));
        colKeteranganPengeluaran.setText(bundle.getString("keteranganp.text"));

//        sList = FXCollections.observableArrayList();
//        SaldoDAO saldoDAO = new SaldoDAO();
//        ObservableList<Saldo> sList = saldoDAO.showSaldo(thisUser);
//        tfJumlahSaldo.setText(sList.toString());

//        tvPemasukan.setItems(pList);
//        colNamaPemasukan.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNama()));
//        colJumlahPemasukan.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getJumlah()));
//        colKeteranganPemasukkan.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getKeterangan()));

    }

    public void btnSimpanClicked(ActionEvent actionEvent) {
        String pembukuan = tfNamaPembukuan.getText();
        String jumlah = tfJumlahSaldo.getText();
        Object category = cbKategori.getValue();

        PembukuanDAO pembukuanDAO = new PembukuanDAO();

        Pembukuan pembukuan1 = new Pembukuan();
        pembukuan1.setNama(tfNamaPembukuan.getText());
        pembukuan1.setJumlah(tfJumlahPembukuan.getText());
        pembukuan1.setCategory(cbKategori.getValue());
        pembukuan1.setKeterangan(tfKeterangan.getText());
        pembukuan1.setUser(thisUser);
        pembukuanDAO.addData(pembukuan1);

        tfNamaPembukuan.setText(null);
        tfJumlahPembukuan.setText(null);
        tfKeterangan.setText(null);

        ObservableList<Pembukuan> pList = pembukuanDAO.showPemasukkan(thisUser);
        tvPemasukan.setItems(pList);
        ObservableList<Pembukuan> pList2 = pembukuanDAO.showPengeluaran(thisUser);
        tvPengeluaran.setItems(pList2);
    }

    public void btnPembukuanClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("pageDetailPembukuan.fxml"));
        Parent root = loader.load();
        DetailPembukuanController dpc = loader.getController();
        Stage detailpembukuanStage = new Stage();
        detailpembukuanStage.setTitle("Pembukuan");
        detailpembukuanStage.setScene(new Scene(root));
        detailpembukuanStage.initModality(Modality.APPLICATION_MODAL);
        detailpembukuanStage.showAndWait();
    }

    public void btnUserClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("pageUser.fxml"));
        Parent root = loader.load();
        UserController uc = loader.getController();
        Stage userStage = new Stage();
        userStage.setTitle("Pembukuan");
        userStage.setScene(new Scene(root));
        userStage.initModality(Modality.APPLICATION_MODAL);
        userStage.showAndWait();
    }

    public void btnExitClicked(ActionEvent actionEvent) {
    }

    public void cbBahasaClicked(ActionEvent actionEvent) {
        value = (String) cbBahasa.getValue();

        if (value == "Inggris") {
            ResourceBundle bundle = ResourceBundle.getBundle("bundle_EN");
            labelPembukuan.setText(bundle.getString("inputp.text"));
            labelNamaPembukuan.setText(bundle.getString("namap.text"));
            labelJumlahPembukuan.setText(bundle.getString("jumlahp.text"));
            labelKategoriPembukuan.setText(bundle.getString("kategorip.text"));
            labelKeterangan.setText(bundle.getString("keteranganp.text"));
            btnSimpan.setText(bundle.getString("simpan.text"));
            labelPemasukkan.setText(bundle.getString("lpemasukkan.text"));
            labelPengeluaran.setText(bundle.getString("lpengeluaran.text"));
            colNamaPemasukan.setText(bundle.getString("namap.text"));
            colJumlahPemasukan.setText(bundle.getString("jumlahp.text"));
            colKeteranganPemasukkan.setText(bundle.getString("keteranganp.text"));
            colNamaPengeluaran.setText(bundle.getString("namap.text"));
            colJumlahPengeluaran.setText(bundle.getString("jumlahp.text"));
            colKeteranganPengeluaran.setText(bundle.getString("keteranganp.text"));
        }
        else if (value == "Indonesia") {
            ResourceBundle bundle = ResourceBundle.getBundle("bundle_IN");
            labelPembukuan.setText(bundle.getString("inputp.text"));
            labelNamaPembukuan.setText(bundle.getString("namap.text"));
            labelJumlahPembukuan.setText(bundle.getString("jumlahp.text"));
            labelKategoriPembukuan.setText(bundle.getString("kategorip.text"));
            labelKeterangan.setText(bundle.getString("keteranganp.text"));
            btnSimpan.setText(bundle.getString("simpan.text"));
            labelPemasukkan.setText(bundle.getString("lpemasukkan.text"));
            labelPengeluaran.setText(bundle.getString("lpengeluaran.text"));
            colNamaPemasukan.setText(bundle.getString("namap.text"));
            colJumlahPemasukan.setText(bundle.getString("jumlahp.text"));
            colKeteranganPemasukkan.setText(bundle.getString("keteranganp.text"));
            colNamaPengeluaran.setText(bundle.getString("namap.text"));
            colJumlahPengeluaran.setText(bundle.getString("jumlahp.text"));
            colKeteranganPengeluaran.setText(bundle.getString("keteranganp.text"));
        }
    }
}
