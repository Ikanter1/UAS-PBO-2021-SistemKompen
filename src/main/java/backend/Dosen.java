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

public class Dosen implements INoInduk, IKompen{
    private int nomorinduk;
    private int nip;
    private String namaDsn;
    private Penugasan penugasan = new Penugasan();

    public int getNomorinduk() {
        return nomorinduk;
    }

    public void setNomorinduk(int nomorinduk) {
        this.nomorinduk = nomorinduk;
    }
    
    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }

    public String getNamaDsn() {
        return namaDsn;
    }

    public void setNamaDsn(String namaDsn) {
        this.namaDsn = namaDsn;
    }

    public Penugasan getPenugasan() {
        return penugasan;
    }

    public void setPenugasan(Penugasan penugasan) {
        this.penugasan = penugasan;
    }
    
    public Dosen() {
        
    }
    
    public Dosen(int nip, String namaDsn, Penugasan penugasan) {
        this.nip = nip;
        this.namaDsn = namaDsn;
        this.penugasan = penugasan;
    }
    public Dosen getById(int id) {
        Dosen dosen = new Dosen();
        
        ResultSet rs = DBHelper.selectQuery("SELECT "
                                    + " d.nip AS nip, "
                                    + " d.namaDsn AS namaDsn, "
                                    + " p.idPenugasan AS idPenugasan, "
                                    + " p.tugas AS tugas, "
                                    + " p.jmlhJam AS jmlhJam "
                                    + " FROM dosen d "
                                    + " LEFT JOIN penugasan p ON p.idPenugasan = d.idPenugasan "
                                    + " WHERE d.nip = '" + id + "'");
        try {
            while(rs.next()){
            dosen = new Dosen();
            dosen.setNip(rs.getInt("nip"));
            dosen.setNamaDsn(rs.getString("namaDsn"));
            dosen.getPenugasan().setIdPenugasan(rs.getInt("idPenugasan"));
            dosen.getPenugasan().setTugas(rs.getString("tugas"));
            dosen.getPenugasan().setJmlhJam(rs.getInt("jmlhJam"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return dosen;
    }

    public ArrayList<Dosen> getAll() {
        ArrayList<Dosen> ListDosen = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                                    + " d.nip AS nip, "
                                    + " d.namaDsn AS namaDsn, "
                                    + " p.idPenugasan AS idPenugasan, "
                                    + " p.tugas AS tugas, "
                                    + " p.jmlhJam AS jmlhJam "
                                    + " FROM dosen d "
                                    + " LEFT JOIN penugasan p ON p.idPenugasan = d.idPenugasan ");
        try {
            while(rs.next()){
            Dosen dosen = new Dosen();
            dosen.setNip(rs.getInt("nip"));
            dosen.setNamaDsn(rs.getString("namaDsn"));
            dosen.getPenugasan().setIdPenugasan(rs.getInt("idPenugasan"));
            dosen.getPenugasan().setTugas(rs.getString("tugas"));
            dosen.getPenugasan().setJmlhJam(rs.getInt("jmlhJam"));
            ListDosen.add(dosen);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ListDosen;
    }

    public ArrayList<Dosen> search(String keyword) {
        ArrayList<Dosen> ListDosen = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                                    + " d.nip AS nip, "
                                    + " d.namaDsn AS namaDsn, "
                                    + " p.idPenugasan AS idPenugasan, "
                                    + " p.tugas AS tugas, "
                                    + " p.jmlhJam AS jmlhJam "
                                    + " FROM dosen d "
                                    + " LEFT JOIN penugasan p ON p.idPenugasan = d.idPenugasan "
                                    + " WHERE d.namaDsn LIKE '%" + keyword + "%' "
                                    + " OR p.tugas LIKE '%" + keyword + "%' "
                                    + " OR p.jmlhJam LIKE '%" + keyword + "%' ");
        try {
            while(rs.next()){
            Dosen dosen = new Dosen();
            dosen.setNip(rs.getInt("nip"));
            dosen.setNamaDsn(rs.getString("namaDsn"));
            dosen.getPenugasan().setIdPenugasan(rs.getInt("idPenugasan"));
            dosen.getPenugasan().setTugas(rs.getString("tugas"));
            dosen.getPenugasan().setJmlhJam(rs.getInt("jmlhJam"));
            ListDosen.add(dosen);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ListDosen;
    }

    @Override
    public void save() {
        if(getById(nip).getNip() == 0) {
            String SQL = "INSERT INTO dosen (nip, namaDsn, idPenugasan) VALUES("
                + " '" + this.nip + "', "
                + " '" + this.namaDsn + "', "
                + " '" + this.getPenugasan().getIdPenugasan() + "' "
                + " )";
            this.nip = DBHelper.insertQueryGetId(SQL);
        }
        else {
            String SQL = "UPDATE dosen SET "
                + " nip = '" + this.nip + "', "
                + " namaDsn = '" + this.namaDsn + "', "
                + " idPenugasan = '" + this.getPenugasan().getIdPenugasan() + "' "
                + " WHERE nip = '" + this.nip + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    @Override
    public void delete() {
        String SQL = "DELETE FROM dosen WHERE nip = '" + this.nip + "'";
        DBHelper.executeQuery(SQL);
    }

    @Override
    public void nomorinduk() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
