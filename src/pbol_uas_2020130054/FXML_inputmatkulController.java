/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pbol_uas_2020130054;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author deden hidayat
 */
public class FXML_inputmatkulController implements Initializable {

    @FXML
    private Button btnkeluar;
    @FXML
    private Button btnbatal;
    @FXML
    private Button btnsimpan;
    @FXML
    private TextField txtsks;
    @FXML
    private TextField txtnamamk;
    @FXML
    private TextField txtkodemk;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void keluarklik(ActionEvent event) {
    }

    @FXML
    private void batalklik(ActionEvent event) {
    }

    @FXML
    private void simpanklik(ActionEvent event) {
        MKModel mm = new MKModel();
        mm.setKodemk(txtkodemk.getText());
        mm.setNamamk(txtnamamk.getText());
        mm.setSks(txtsks.getText());
        FXMLDocumentController.dtmk.setMm(mm);
        if (FXMLDocumentController.dtmk.validasi(mm.getKodemk()) <= 0) {
            if (FXMLDocumentController.dtmk.insert()) {
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
            txtkodemk.requestFocus();
        }
    }

}
