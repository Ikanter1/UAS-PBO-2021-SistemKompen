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

public class Absen implements IKompen{
    private int noAbsen;
    private Mahasiswa mahasiswa = new Mahasiswa();
    private int jmlhJam;

    public int getNoAbsen() {
        return noAbsen;
    }

    public void setNoAbsen(int noAbsen) {
        this.noAbsen = noAbsen;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public int getJmlhJam() {
        return jmlhJam;
    }

    public void setJmlhJam(int jmlhJam) {
        this.jmlhJam = jmlhJam;
    }

    public Absen() {

    }

    public Absen(int noAbsen, Mahasiswa mahasiswa, int jmlhJam) {
        this.noAbsen = noAbsen;
        this.mahasiswa = mahasiswa;
        this.jmlhJam = jmlhJam;
    }

    public Absen getById(int id) {
        Absen absen = new Absen();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                + " a.noAbsen AS noAbsen, "
                + " a.jmlhJam AS jmlhJam, "
                + " m.nim AS nim, "
                + " m.namaMhs AS namaMhs, "
                + " m.kelas AS kelas "
                + " FROM absen a "
                + " LEFT JOIN mahasiswa m ON m.nim = a.nim "
                + " WHERE a.noAbsen = '" + id + "'");
        try {
            while (rs.next()) {
                absen = new Absen();
                absen.setNoAbsen(rs.getInt("noAbsen"));
                absen.getMahasiswa().setNim(rs.getInt("nim"));
                absen.getMahasiswa().setNamaMhs(rs.getString("namaMhs"));
                absen.getMahasiswa().setKelas(rs.getString("kelas"));
                absen.setJmlhJam(rs.getInt("jmlhJam"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return absen;
    }

    public ArrayList<Absen> getAll() {
        ArrayList<Absen> ListAbsen = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                + " a.noAbsen AS noAbsen, "
                + " a.jmlhJam AS jmlhJam, "
                + " m.nim AS nim, "
                + " m.namaMhs AS namaMhs, "
                + " m.kelas AS kelas "
                + " FROM absen a "
                + " LEFT JOIN mahasiswa m ON m.nim = a.nim ");
        try {
            while (rs.next()) {
                Absen absen = new Absen();
                absen.setNoAbsen(rs.getInt("noAbsen"));
                absen.getMahasiswa().setNim(rs.getInt("nim"));
                absen.getMahasiswa().setNamaMhs(rs.getString("namaMhs"));
                absen.getMahasiswa().setKelas(rs.getString("kelas"));
                absen.setJmlhJam(rs.getInt("jmlhJam"));

                ListAbsen.add(absen);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListAbsen;
    }

    public ArrayList<Absen> search(String keyword) {
        ArrayList<Absen> ListAbsen = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                + " a.noAbsen AS noAbsen, "
                + " a.jmlhJam AS jmlhJam, "
                + " m.nim AS nim, "
                + " m.namaMhs AS namaMhs, "
                + " m.kelas AS kelas "
                + " FROM absen a "
                + " LEFT JOIN mahasiswa m ON m.nim = a.nim "
                + " WHERE a.jmlhJam LIKE '%" + keyword + "%' "
                + " OR m.namaMhs LIKE '%" + keyword + "%' "
                + " OR m.kelas LIKE '%" + keyword + "%' ");
        try {
            while (rs.next()) {
                Absen absen = new Absen();
                absen.setNoAbsen(rs.getInt("noAbsen"));
                absen.getMahasiswa().setNim(rs.getInt("nim"));
                absen.getMahasiswa().setNamaMhs(rs.getString("namaMhs"));
                absen.getMahasiswa().setKelas(rs.getString("kelas"));
                absen.setJmlhJam(rs.getInt("jmlhJam"));

                ListAbsen.add(absen);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListAbsen;
    }

    @Override
    public void save() {
        if (getById(noAbsen).getNoAbsen() == 0) {
            String SQL = "INSERT INTO absen (noAbsen, nim, jmlhJam) VALUES("
                    + " '" + this.noAbsen + "', "
                    + " '" + this.getMahasiswa().getNim() + "', "
                    + " '" + this.jmlhJam + "' "
                    + " )";
            this.noAbsen = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE absen SET "
                    + " nim = '" + this.getMahasiswa().getNim() + "', "
                    + " jmlhJam = '" + this.jmlhJam + "' "
                    + " WHERE noAbsen = '" + this.noAbsen + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    @Override
    public void delete() {
        String SQL = "DELETE FROM absen WHERE noAbsen = '" + this.noAbsen + "'";
        DBHelper.executeQuery(SQL);
    }
}
