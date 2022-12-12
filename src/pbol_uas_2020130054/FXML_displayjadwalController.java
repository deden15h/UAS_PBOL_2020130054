/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pbol_uas_2020130054;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author deden hidayat
 */
public class FXML_displayjadwalController implements Initializable {

    @FXML
    private Button btnkeluar;
    @FXML
    private Button btnakhir;
    @FXML
    private Button btnubah;
    @FXML
    private Button btnsesudah;
    @FXML
    private Button btnhapus;
    @FXML
    private Button btnsebelum;
    @FXML
    private Button btntambah;
    @FXML
    private Button btnawal;
    @FXML
    private TableView<String> tbvjadwal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showdata();
    }

    @FXML
    private void keluarklik(ActionEvent event) {
    }

    @FXML
    private void akhirklik(ActionEvent event) {
    }

    @FXML
    private void ubahklik(ActionEvent event) {
    }

    @FXML
    private void sesudahklik(ActionEvent event) {
    }

    @FXML
    private void hapusklik(ActionEvent event) {
    }

    @FXML
    private void sebelumklik(ActionEvent event) {
    }

    @FXML
    private void tambahklik(ActionEvent event) {
    }

    @FXML
    private void awalklik(ActionEvent event) {
    }

    public void showdata() {
        ObservableList<JadwalModel> data = FXMLDocumentController.dtJadwal.Load();
        if (data != null) {
            tbvjadwal.getColumns().clear();
            tbvjadwal.getItems().clear();
            TableColumn col = new TableColumn("Nidn");
            col.setCellValueFactory(new PropertyValueFactory<JadwalModel, String>("nidn"));
            tbvjadwal.getColumns().addAll(col);

            col = new TableColumn("NamaDosen");
            col.setCellValueFactory(new PropertyValueFactory<JadwalModel, String>("namadosen"));
            tbvjadwal.getColumns().addAll(col);

            col = new TableColumn("Kodemk");
            col.setCellValueFactory(new PropertyValueFactory<JadwalModel, String>("kodemk"));
            tbvjadwal.getColumns().addAll(col);

            col = new TableColumn("Matakuliah");
            col.setCellValueFactory(new PropertyValueFactory<JadwalModel, String>("matakuliah"));
            tbvjadwal.getColumns().addAll(col);
            
            col = new TableColumn("Koderuangan");
            col.setCellValueFactory(new PropertyValueFactory<JadwalModel, String>("koderuangan"));
            tbvjadwal.getColumns().addAll(col);
            
            col = new TableColumn("Lokasi");
            col.setCellValueFactory(new PropertyValueFactory<JadwalModel, String>("lokasi"));
            tbvjadwal.getColumns().addAll(col);
            
            col = new TableColumn("Jam");
            col.setCellValueFactory(new PropertyValueFactory<JadwalModel, String>("jam"));
            tbvjadwal.getColumns().addAll(col);
            
            col = new TableColumn("Hari");
            col.setCellValueFactory(new PropertyValueFactory<JadwalModel, String>("hari"));
            tbvjadwal.getColumns().addAll(col);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvjadwal.getScene().getWindow().hide();;
        }
    }

}
