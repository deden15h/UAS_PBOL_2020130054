/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pbol_uas_2020130054;

import java.net.URL;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author deden hidayat
 */
public class FXML_inputjadwalController implements Initializable {
    boolean editdata = false;

    @FXML
    private Button btnpilihmk;
    @FXML
    private Button btnpilihsiswa;
    @FXML
    private Button btnkeluar;
    @FXML
    private Button btnbatal;
    @FXML
    private Button btnsimpan;
    @FXML
    private TextField txtkodemk;
    @FXML
    private TextField txtnidn;
    @FXML
    private TextField txtruangan;
    @FXML
    private Button btnpilihruang;
    @FXML
    private TextField txtjam;
    @FXML
    private TextField txthari;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    } 
    
     public void execute(JadwalModel d) {
        if (!d.getNidn().isEmpty() && !d.getKodemk().isEmpty()) {
            editdata = true;
            txtnidn.setText(d.getNidn());
            txtkodemk.setText(d.getKodemk());
            txtruangan.setText(d.getKoderuangan());
            txtjam.setText(d.getJam());
            txthari.setText(d.getHari());
            txtnidn.setEditable(false);
            txtkodemk.setEditable(false);
            txtruangan.requestFocus();
        }
    }

    @FXML
    private void pilihmkklik(ActionEvent event) {
    }

    @FXML
    private void pilihsiswaklik(ActionEvent event) {
    }

    @FXML
    private void keluarklik(ActionEvent event) {
    }

    @FXML
    private void batalklik(ActionEvent event) {
    }

    @FXML
    private void simpanklik(ActionEvent event) {
        JadwalModel n = new JadwalModel();
        n.setNidn(txtnidn.getText());
        n.setKodemk(txtkodemk.getText());
        n.setKoderuangan(txtruangan.getText());
        n.setJam(txtjam.getText());
        n.setHari(txthari.getText());
        FXMLDocumentController.dtJadwal.setJadwalModel(n);
        if (editdata) {
            if (FXMLDocumentController.dtJadwal.update()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data berhasil diubah", ButtonType.OK);
                a.showAndWait();
                txtnidn.setEditable(true);
                batalklik(event);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data gagal diubah", ButtonType.OK);
                a.showAndWait();
            }
        } else if (FXMLDocumentController.dtJadwal.validasi(n.getNidn(), n.getKodemk()) <= 0) {
            if (FXMLDocumentController.dtJadwal.insert()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data berhasil disimpan", ButtonType.OK);
                a.showAndWait();
                batalklik(event);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data gagal disimpan", ButtonType.OK);
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data sudah ada", ButtonType.OK);
            a.showAndWait();
            txtnidn.requestFocus();
        }
    }

    @FXML
    private void pilihruangklik(ActionEvent event) {
    }
    
}
