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

public class Konfirmasi implements IKompen{
    private int idkonfirmasi;
    private Mahasiswa mahasiswa = new Mahasiswa();
    private Penugasan penugasan = new Penugasan();
    private String konfirm;

    public int getIdkonfirmasi() {
        return idkonfirmasi;
    }

    public void setIdkonfirmasi(int idkonfirmasi) {
        this.idkonfirmasi = idkonfirmasi;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public Penugasan getPenugasan() {
        return penugasan;
    }

    public void setPenugasan(Penugasan penugasan) {
        this.penugasan = penugasan;
    }

    public String getKonfirm() {
        return konfirm;
    }

    public void setKonfirm(String konfirm) {
        this.konfirm = konfirm;
    }

    public Konfirmasi() {

    }

    public Konfirmasi(Mahasiswa mahasiswa, Penugasan penugasan, String konfirm) {
        this.mahasiswa = mahasiswa;
        this.penugasan = penugasan;
        this.konfirm = konfirm;
    }

    public Konfirmasi getById(int id) {
        Konfirmasi kon = new Konfirmasi();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                + " k.idkonfirmasi AS idkonfirmasi, "
                + " k.konfirm AS konfirm, "
                + " m.nim AS nim, "
                + " m.namaMhs AS namaMhs, "
                + " m.kelas AS kelas, "
                + " p.idPenugasan AS idPenugasan, "
                + " p.tugas AS tugas, "
                + " p.jmlhJam AS jmlhJam "
                + " FROM konfirmasi k "
                + " LEFT JOIN mahasiswa m ON m.nim = k.nim "
                + " LEFT JOIN penugasan p ON p.idPenugasan = k.idPenugasan "
                + " WHERE k.idkonfirmasi = '" + id + "'");
        try {
            while (rs.next()) {
                kon = new Konfirmasi();
                kon.setIdkonfirmasi(rs.getInt("idkonfirmasi"));
                kon.getMahasiswa().setNim(rs.getInt("nim"));
                kon.getMahasiswa().setNamaMhs(rs.getString("namaMhs"));
                kon.getMahasiswa().setKelas(rs.getString("kelas"));
                kon.getPenugasan().setIdPenugasan(rs.getInt("idPenugasan"));
                kon.getPenugasan().setTugas(rs.getString("tugas"));
                kon.getPenugasan().setJmlhJam(rs.getInt("jmlhJam"));
                kon.setKonfirm(rs.getString("konfirm"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kon;
    }

    public ArrayList<Konfirmasi> getAll() {
        ArrayList<Konfirmasi> ListKonfirmasi = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                + " k.idkonfirmasi AS idkonfirmasi, "
                + " k.konfirm AS konfirm, "
                + " m.nim AS nim, "
                + " m.namaMhs AS namaMhs, "
                + " m.kelas AS kelas, "
                + " p.idPenugasan AS idPenugasan, "
                + " p.tugas AS tugas, "
                + " p.jmlhJam AS jmlhJam "
                + " FROM konfirmasi k "
                + " LEFT JOIN mahasiswa m ON m.nim = k.nim "
                + " LEFT JOIN penugasan p ON p.idPenugasan = k.idPenugasan ");
        try {
            while (rs.next()) {
                Konfirmasi kon = new Konfirmasi();
                kon.setIdkonfirmasi(rs.getInt("idkonfirmasi"));
                kon.getMahasiswa().setNim(rs.getInt("nim"));
                kon.getMahasiswa().setNamaMhs(rs.getString("namaMhs"));
                kon.getMahasiswa().setKelas(rs.getString("kelas"));
                kon.getPenugasan().setIdPenugasan(rs.getInt("idPenugasan"));
                kon.getPenugasan().setTugas(rs.getString("tugas"));
                kon.getPenugasan().setJmlhJam(rs.getInt("jmlhJam"));
                kon.setKonfirm(rs.getString("konfirm"));

                ListKonfirmasi.add(kon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListKonfirmasi;
    }

    public ArrayList<Konfirmasi> search(String keyword) {
        ArrayList<Konfirmasi> ListKonfirmasi = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                + " k.idkonfirmasi AS idkonfirmasi, "
                + " k.konfirm AS konfirm, "
                + " m.nim AS nim, "
                + " m.namaMhs AS namaMhs, "
                + " m.kelas AS kelas, "
                + " p.idPenugasan AS idPenugasan, "
                + " p.tugas AS tugas, "
                + " p.jmlhJam AS jmlhJam "
                + " FROM konfirmasi k "
                + " LEFT JOIN mahasiswa m ON m.nim = k.nim "
                + " LEFT JOIN penugasan p ON p.idPenugasan = k.idPenugasan "
                + " WHERE k.konfirm LIKE '%" + keyword + "%' "
                + " OR m.namaMhs LIKE '%" + keyword + "%' "
                + " OR p.tugas LIKE '%" + keyword + "%' ");
        try {
            while (rs.next()) {
                Konfirmasi kon = new Konfirmasi();
                kon.setIdkonfirmasi(rs.getInt("idkonfirmasi"));
                kon.getMahasiswa().setNim(rs.getInt("nim"));
                kon.getMahasiswa().setNamaMhs(rs.getString("namaMhs"));
                kon.getMahasiswa().setKelas(rs.getString("kelas"));
                kon.getPenugasan().setIdPenugasan(rs.getInt("idPenugasan"));
                kon.getPenugasan().setTugas(rs.getString("tugas"));
                kon.getPenugasan().setJmlhJam(rs.getInt("jmlhJam"));
                kon.setKonfirm(rs.getString("konfirm"));

                ListKonfirmasi.add(kon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListKonfirmasi;
    }

    @Override
    public void save() {
        if (getById(idkonfirmasi).getIdkonfirmasi() == 0) {
            String SQL = "INSERT INTO konfirmasi (nim, idPenugasan, konfirm) VALUES("
                    + " '" + this.getMahasiswa().getNim() + "', "
                    + " '" + this.getPenugasan().getIdPenugasan() + "', "
                    + " '" + this.konfirm + "' "
                    + " )";
            this.idkonfirmasi = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE konfirmasi SET "
                    + " nim = '" + this.getMahasiswa().getNim() + "', "
                    + " idPenugasan = '" + this.getPenugasan().getIdPenugasan() + "', "
                    + " konfirm = '" + this.konfirm + "' "
                    + " WHERE idkonfirmasi = '" + this.idkonfirmasi + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    @Override
    public void delete() {
        String SQL = "DELETE FROM konfirmasi WHERE idkonfirmasi = '" + this.idkonfirmasi + "'";
        DBHelper.executeQuery(SQL);
    }
}
