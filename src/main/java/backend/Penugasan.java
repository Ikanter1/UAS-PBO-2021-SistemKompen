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

public class Penugasan implements IKompen{
    private int idPenugasan;
    private String tugas;
    private int jmlhJam;

    public int getIdPenugasan() {
        return idPenugasan;
    }

    public void setIdPenugasan(int idPenugasan) {
        this.idPenugasan = idPenugasan;
    }

    public String getTugas() {
        return tugas;
    }

    public void setTugas(String tugas) {
        this.tugas = tugas;
    }

    public int getJmlhJam() {
        return jmlhJam;
    }

    public void setJmlhJam(int jmlhJam) {
        this.jmlhJam = jmlhJam;
    }

    public String toString() {
        return tugas;
    }

    public Penugasan() {

    }

    public Penugasan(int idPenugasan, String tugas, int jmlhJam) {
        this.idPenugasan = idPenugasan;
        this.tugas = tugas;
        this.jmlhJam = jmlhJam;
    }
public Penugasan getById(int id) {
        Penugasan pen = new Penugasan();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM penugasan "
                + " WHERE idPenugasan = '" + id + "'");

        try {
            while (rs.next()) {
                pen = new Penugasan();
                pen.setIdPenugasan(rs.getInt("idPenugasan"));
                pen.setTugas(rs.getString("tugas"));
                pen.setJmlhJam(rs.getInt("jmlhJam"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pen;
    }

    public ArrayList<Penugasan> getAll() {
        ArrayList<Penugasan> ListPen = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT * FROM penugasan ");

        try {
            while (rs.next()) {
                Penugasan pen = new Penugasan();
                pen.setIdPenugasan(rs.getInt("idPenugasan"));
                pen.setTugas(rs.getString("tugas"));
                pen.setJmlhJam(rs.getInt("jmlhJam"));
                ListPen.add(pen);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPen;
    }

    public ArrayList<Penugasan> search(String keyword) {
        ArrayList<Penugasan> ListPen = new ArrayList();

        String sql = "SELECT * FROM penugasan WHERE "
                + "     tugas LIKE '%" + keyword + "%' "
                + "     OR jmlhJam LIKE '%" + keyword + "%' ";

        ResultSet rs = DBHelper.selectQuery(sql);

        try {
            while (rs.next()) {
                Penugasan pen = new Penugasan();
                pen.setIdPenugasan(rs.getInt("idPenugasan"));
                pen.setTugas(rs.getString("tugas"));
                pen.setJmlhJam(rs.getInt("jmlhJam"));

                ListPen.add(pen);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPen;
    }

    @Override
    public void save() {
        if (getById(idPenugasan).getIdPenugasan() == 0) {
            String SQL = "INSERT INTO penugasan (idPenugasan, tugas, jmlhJam) VALUES("
                    + "     '" + this.idPenugasan + "', "
                    + "     '" + this.tugas + "', "
                    + "     '" + this.jmlhJam + "' "
                    + "     )";
            this.idPenugasan = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE penugasan SET "
                    + "     tugas = '" + this.tugas + "', "
                    + "     jmlhJam = '" + this.jmlhJam + "' "
                    + "     WHERE idPenugasan = '" + this.idPenugasan + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    @Override
    public void delete() {
        String SQL = "DELETE FROM penugasan WHERE idPenugasan = '" + this.idPenugasan + "'";
        DBHelper.executeQuery(SQL);
    }
}
