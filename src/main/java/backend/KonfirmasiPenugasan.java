/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author LENOVO
 */
import java.util.ArrayList;
import java.sql.*;

public class KonfirmasiPenugasan {
    private int nim;
    private String namaMhs;
    private int idPenugasan;
    private String tugas;
    private String konfirm;
    
    public KonfirmasiPenugasan(){
        
    }
    
    public KonfirmasiPenugasan(int nim, String namaMhs, int idPenugasan, String tugas, String konfirm){
        this.nim = nim;
        this.namaMhs = namaMhs;
        this.idPenugasan = idPenugasan;
        this.tugas = tugas;
        this.konfirm = konfirm;
    }
    
    public void setNim(int nim){
        this.nim = nim;
    }
    
    public void setNamaMhs(String namaMhs){
        this.namaMhs = namaMhs;
    }
    
    public void setIdPenugasan(int idPenugasan){
        this.idPenugasan = idPenugasan;
    }
    
    public void setTugas(String tugas){
        this.tugas = tugas;
    }
    
    public void setKonfirm(String konfirm){
        this.konfirm = konfirm;
    }
    
    public int getNim(){
        return nim;
    }
    
    public String getNamaMhs(){
        return namaMhs;
    }
    
    public int getIdPenugasan(){
        return idPenugasan;
    }
    
    public String getTugas(){
        return tugas;
    }
    
    public String getKonfirm(){
        return konfirm;
    }
    
    public KonfirmasiPenugasan getByNim(int nim) {
        KonfirmasiPenugasan k = new KonfirmasiPenugasan();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM konfirmasi "
                + " WHERE nim = '" + nim + "'");

        try {
            while (rs.next()) {
                k = new KonfirmasiPenugasan();
                k.setNim(rs.getInt("nim"));
                k.setNamaMhs(rs.getString("namaMhs"));
                k.setIdPenugasan(rs.getInt("idPenugasan"));
                k.setTugas(rs.getString("tugas"));
                k.setKonfirm(rs.getString("konfirm"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return k;
    }

    public ArrayList<KonfirmasiPenugasan> getAll() {
        ArrayList<KonfirmasiPenugasan> ListKonfirmasi = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT * FROM konfirmasi");

        try {
            while (rs.next()) {
                KonfirmasiPenugasan k = new KonfirmasiPenugasan();
                k.setNim(rs.getInt("nim"));
                k.setNamaMhs(rs.getString("namaMhs"));
                k.setIdPenugasan(rs.getInt("idPenugasan"));
                k.setTugas(rs.getString("tugas"));
                k.setKonfirm(rs.getString("konfirm"));

                ListKonfirmasi.add(k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListKonfirmasi;
    }

    public ArrayList<KonfirmasiPenugasan> search(String keyword) {
        ArrayList<KonfirmasiPenugasan> ListKonfirmasi = new ArrayList();

        String sql = "SELECT * FROM konfirmasi WHERE "
                + "     nim LIKE '%" + keyword + "%' "
                + "     OR namaMhs LIKE '%" + keyword + "%' "
                + "     OR idPenugasan LIKE '%" + keyword + "%' "
                + "     OR tugas LIKE '%" + keyword + "%' "
                + "     OR konfirm LIKE '%" + keyword + "%' ";

        ResultSet rs = DBHelper.selectQuery(sql);

        try {
            while (rs.next()) {
                KonfirmasiPenugasan k = new KonfirmasiPenugasan();
                k.setNim(rs.getInt("nim"));
                k.setNamaMhs(rs.getString("namaMhs"));
                k.setIdPenugasan(rs.getInt("idPenugasan"));
                k.setTugas(rs.getString("tugas"));
                k.setKonfirm(rs.getString("konfirm"));

                ListKonfirmasi.add(k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListKonfirmasi;
    }

    public void save() {
        if (getByNim(nim).getNim() == 0) {
            String SQL = "INSERT INTO konfirmasi (nim, namaMhs, idPenugasan, tugas, konfirm) VALUES("
                    + "     '" + this.nim + "', "
                    + "     '" + this.namaMhs + "', "
                    + "     '" + this.idPenugasan + "', "
                    + "     '" + this.tugas + "', "
                    + "     '" + this.konfirm + "' "
                    + "     )";
            this.nim = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE konfirmasi SET "
                    + "     namaMhs = '" + this.namaMhs + "', "
                    + "     idPenugasan = '" + this.idPenugasan + "', "
                    + "     tugas = '" + this.tugas + "', "
                    + "     konfirm = '" + this.konfirm + "' "
                    + "     WHERE nim = '" + this.nim + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM konfirmasi WHERE nim = '" + this.nim + "'";
        DBHelper.executeQuery(SQL);
    }
}
