/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.*;

/**
 *
 * @author LENOVO
 */
public class TestDosen {
    public static void main(String[] args) {
        Penugasan pen1 = new Penugasan().getById(1501);
        Penugasan pen2 = new Penugasan().getById(1502);
        Penugasan pen3 = new Penugasan().getById(1503);
        Penugasan pen4 = new Penugasan().getById(1504);
        
        Dosen dosen1 = new Dosen(1, "Abdulah Syahrony Kurniawan, S. S.T., M. Tr. T", pen1);
        Dosen dosen2 = new Dosen(2, "Yanto basnan,S.T.,M.Kom.", pen2);
        Dosen dosen3 = new Dosen(3, "Hamami zadah, S.Kom., M.T.", pen3);
        Dosen dosen4 = new Dosen(4, "Putrinurifa S.ST., M.Sc", pen4);
        
        dosen1.save();
        dosen2.save();
        dosen3.save();
        dosen4.save();
        
        dosen2.setNamaDsn("Rafi ahmad, S.ST., MT.");
        dosen2.save();
        
        dosen4.delete();
        
        System.out.println("---------------- DATA DOSEN ----------------");
        for(Dosen d : new Dosen().getAll()) {
            System.out.println("NIP : " + d.getNip());
            System.out.println("NAMA DOSEN : " + d.getNamaDsn());
            System.out.println("TUGAS      : " + d.getPenugasan().getTugas());
            System.out.println("---------------------------------------------");
        }
        System.out.println();
        
        System.out.println("---------------- CARI DATA ------------------");
        for(Dosen d : new Dosen().search("Yushintia Pramitarini, S.ST., MT.")) {
            System.out.println("NIP : " + d.getNip());
            System.out.println("NAMA DOSEN : " + d.getNamaDsn());
            System.out.println("TUGAS      : " + d.getPenugasan().getTugas());
            System.out.println("---------------------------------------------");
        }
    }
}
