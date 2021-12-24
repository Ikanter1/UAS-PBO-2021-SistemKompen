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
public class TestKonfirmasi {
    public static void main(String[] args) {
        Mahasiswa mhs1 = new Mahasiswa().getById(2041720036);
        Mahasiswa mhs2 = new Mahasiswa().getById(2041720037);
        Mahasiswa mhs3 = new Mahasiswa().getById(2041720038);
        Mahasiswa mhs4 = new Mahasiswa().getById(2041720039);
        
        Penugasan pen1 = new Penugasan().getById(1501);
        Penugasan pen2 = new Penugasan().getById(1502);
        Penugasan pen3 = new Penugasan().getById(1503);
        Penugasan pen4 = new Penugasan().getById(1504);
        
        Konfirmasi kon1 = new Konfirmasi(mhs1, pen1, "SELESAI");
        Konfirmasi kon2 = new Konfirmasi(mhs2, pen2, "BELUM");
        Konfirmasi kon3 = new Konfirmasi(mhs3, pen3, "BELUM");
        Konfirmasi kon4 = new Konfirmasi(mhs4, pen4, "SELESAI");
        
        kon1.save();
        kon2.save();
        kon3.save();
        kon4.save();
        
        kon2.setKonfirm("SELESAI");
        kon2.save();
        
        kon4.delete();
        
        System.out.println("----------------- DATA KOMPEN ------------------");
        for(Konfirmasi k : new Konfirmasi().getAll()) {
            System.out.println("NAMA MAHASISWA : " + k.getMahasiswa().getNamaMhs());
            System.out.println("TUGAS          : " + k.getPenugasan().getTugas());
            System.out.println("KONFRIMASI     : " + k.getKonfirm());
            System.out.println("---------------------------------------------");
        }
        System.out.println();
        
        System.out.println("---------------- CARI DATA ------------------");
        for(Konfirmasi k : new Konfirmasi().search("SELESAI")) {
            System.out.println("NAMA MAHASISWA : " + k.getMahasiswa().getNamaMhs());
            System.out.println("TUGAS          : " + k.getPenugasan().getTugas());
            System.out.println("KONFRIMASI     : " + k.getKonfirm());
            System.out.println("---------------------------------------------");
        }
    }
}
