package com.example.tubespbol_finance.Controller;

import com.example.tubespbol_finance.DAO.PembukuanDAO;
import com.example.tubespbol_finance.Model.Pembukuan;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;
//18720003-Edward Michael
//1872005-Michael Sebastian Gunadi
public class DetailPembukuanController implements Initializable {
    public TableView<Pembukuan> tvPembukuan;
    public TableColumn<Pembukuan, String> colNama;
    public TableColumn<Pembukuan, String> colJumlah;
    public TableColumn<Pembukuan, String> colKategori;

    ObservableList<Pembukuan> pList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pList = FXCollections.observableArrayList();
        PembukuanDAO pembukuanDAO = new PembukuanDAO();
        ObservableList<Pembukuan> pList = pembukuanDAO.showData();
        tvPembukuan.setItems(pList);
        colNama.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNama()));
        colJumlah.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getJumlah()));
        colKategori.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCategory().getNamaCategory()));
    }
}
