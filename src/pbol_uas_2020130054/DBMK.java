/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbol_uas_2020130054;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author deden hidayat
 */
public class DBMK {
        public MKModel getMm() {
        return mm;
    }

    public void setMm(MKModel mm) {
        this.mm = mm;
    }
    private MKModel mm = new MKModel();

    public ObservableList<MKModel> Load() {
        try {
            ObservableList<MKModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                    "Select kodemk, namamk, sks from matakuliah");
            int i = 1;
            while (rs.next()) {
                MKModel d = new MKModel();
                d.setKodemk(rs.getString("kodemk"));
                d.setNamamk(rs.getString("namamk"));
                d.setSks(rs.getString("sks"));
                TableData.add(d);
                i++;
            }
            con.tutupKoneksi();
            return TableData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<MKModel> LookUp(String fld, String dt) {
        try {
            ObservableList<MKModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select kodemk, namamk, sks from matakuliah where " + fld + " like '%" + dt +"%'" + "%'");
            int i = 1;
            while (rs.next()) {
                MKModel d = new MKModel();
                d.setKodemk(rs.getString("kodemk"));
                d.setNamamk(rs.getString("namamk"));
                d.setSks(rs.getString("sks"));
                tableData.add(d);
                i++;
            }
            con.tutupKoneksi();
            return tableData;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public int validasi(String nomor) {
        int val = 0;
        try {
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from matakuliah where kodemk = '" + nomor + "'");
            while (rs.next()) {
                val = rs.getInt("jml");
            }
            con.tutupKoneksi();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

    public boolean insert() {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into matakuliah (kodemk, namamk, sks) values (?,?,?)");
            con.preparedStatement.setString(1, getMm().getKodemk());
            con.preparedStatement.setString(2, getMm().getNamamk());
            con.preparedStatement.setString(3, getMm().getSks());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            berhasil = false;
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }
    
}
