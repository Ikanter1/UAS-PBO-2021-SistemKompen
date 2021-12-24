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

public class Mahasiswa implements IKompen{   
    private int nomorinduk;
    private int nim;
    private String namaMhs;

    public int getNomorinduk() {
        return nomorinduk;
    }

    public void setNomorinduk(int nomorinduk) {
        this.nomorinduk = nomorinduk;
    }
    private String kelas;

    public int getNim() {
        return nim;
    }

    public void setNim(int nim) {
        this.nim = nim;
    }

    public String getNamaMhs() {
        return namaMhs;
    }

    public void setNamaMhs(String namaMhs) {
        this.namaMhs = namaMhs;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String toString() {
        return namaMhs;
    }

    public Mahasiswa() {

    }

    public Mahasiswa(int nim, String namaMhs, String kelas) {
        this.nim = nim;
        this.namaMhs = namaMhs;
        this.kelas = kelas;
    }

    public Mahasiswa getById(int id) {
        Mahasiswa mhs = new Mahasiswa();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM mahasiswa "
                + " WHERE nim = '" + id + "'");

        try {
            while (rs.next()) {
                mhs = new Mahasiswa();
                mhs.setNim(rs.getInt("nim"));
                mhs.setNamaMhs(rs.getString("namaMhs"));
                mhs.setKelas(rs.getString("kelas"));
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return mhs;
    }

    public ArrayList<Mahasiswa> getAll() {
        ArrayList<Mahasiswa> ListMhs = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT * FROM mahasiswa ");

        try {
            while (rs.next()) {
                Mahasiswa mhs = new Mahasiswa();
                mhs.setNim(rs.getInt("nim"));
                mhs.setNamaMhs(rs.getString("namaMhs"));
                mhs.setKelas(rs.getString("kelas"));

                ListMhs.add(mhs);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return ListMhs;
    }

    public ArrayList<Mahasiswa> search(String keyword) {
        ArrayList<Mahasiswa> ListMhs = new ArrayList();

        String sql = "SELECT * FROM mahasiswa WHERE "
                + "     namaMhs LIKE '%" + keyword + "%' "
                + "     OR kelas LIKE '%" + keyword + "%' ";

        ResultSet rs = DBHelper.selectQuery(sql);

        try {
            while (rs.next()) {
                Mahasiswa mhs = new Mahasiswa();
                mhs.setNim(rs.getInt("nim"));
                mhs.setNamaMhs(rs.getString("namaMhs"));
                mhs.setKelas(rs.getString("kelas"));

                ListMhs.add(mhs);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return ListMhs;
    }

    @Override
    public void save() {
        if (getById(nim).getNim() == 0) {
            String SQL = "INSERT INTO mahasiswa (nim, namaMhs, kelas) VALUES("
                    + "     '" + this.nim + "', "
                    + "     '" + this.namaMhs + "', "
                    + "     '" + this.kelas + "' "
                    + "     )";
            this.nim = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE mahasiswa SET "
                    + "     namaMhs = '" + this.namaMhs + "', "
                    + "     kelas = '" + this.kelas + "' "
                    + "     WHERE nim = '" + this.nim + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    @Override
    public void delete() {
        String SQL = "DELETE FROM mahasiswa WHERE nim = '" + this.nim + "'";
        DBHelper.executeQuery(SQL);
    }
}
