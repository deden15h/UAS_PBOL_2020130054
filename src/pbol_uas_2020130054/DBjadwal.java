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
public class DBjadwal {
        private JadwalModel dt = new JadwalModel();

    public JadwalModel getJadwalModel() {
        return (dt);
    }

    public void setJadwalModel(JadwalModel s) {
        dt = s;
    }

    public ObservableList<JadwalModel> Load() {
        try {
            ObservableList<JadwalModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select j.nidn, nama as namadosen, m.kodemk, namamk as matakuliah, r.koderuangan, lokasi as lokasi, jam, hari, hadir from ((jadwal j inner join dosen d on j.nidn=d.nidn) inner join matakuliah m on j.kodemk=m.kodemk) inner join ruangan r on j.koderuangan=r.koderuangan");
            int i = 1;
            while (rs.next()) {
                JadwalModel d = new JadwalModel();
                d.setNidn(rs.getString("nidn"));
                d.setNamadosen(rs.getString("namadosen"));
                d.setKodemk(rs.getString("kodemk")); 
                d.setMatakuliah(rs.getString("matakuliah"));
                d.setKoderuangan(rs.getString("koderuangan"));
                d.setLokasi(rs.getString("lokasi"));
                d.setJam(rs.getString("jam"));
                d.setHari(rs.getString("hari"));
                tableData.add(d);
                i++;
            }
            con.tutupKoneksi();
            return tableData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int validasi(String nomor, String kode) {
        int val = 0;
        try {
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from jadwaL where nidn = '" + nomor
                    + "' and kodemk='" + kode + "'");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement(
                    "insert into jadwal (nidn,kodemk,koderuangan, jam, hari) values (?,?,?,?,?)");
            con.preparedStatement.setString(1, getJadwalModel().getNidn());
            con.preparedStatement.setString(2, getJadwalModel().getKodemk());
            con.preparedStatement.setString(3, getJadwalModel().getKoderuangan());
            con.preparedStatement.setString(4, getJadwalModel().getJam());
            con.preparedStatement.setString(5, getJadwalModel().getHari());
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

    public boolean delete(String nomor, String kode) {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();;
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from jadwal where nidn  = ? and kodemk = ?");
            con.preparedStatement.setString(1, nomor);
            con.preparedStatement.setString(2, kode);
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }

    public boolean update() {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement(
                    "update nilai set hari = ?, jam = ?, koderuangan = ?  where  nidn = ? and kodemk = ? ");
            con.preparedStatement.setString(1, getJadwalModel().getHari());
            con.preparedStatement.setString(2, getJadwalModel().getJam());
            con.preparedStatement.setString(3, getJadwalModel().getKoderuangan());
            con.preparedStatement.setString(4, getJadwalModel().getNidn());
            con.preparedStatement.setString(5, getJadwalModel().getKodemk());
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
