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
public class TestAbsen {
    public static void main(String[] args) {
        Mahasiswa mhs1 = new Mahasiswa().getById(2041720036);
        Mahasiswa mhs2 = new Mahasiswa().getById(2041720037);
        Mahasiswa mhs3 = new Mahasiswa().getById(2041720038);
        Mahasiswa mhs4 = new Mahasiswa().getById(2041720039);
        Mahasiswa mhs5 = new Mahasiswa().getById(2041720040);
        
        Absen absen1 = new Absen(1, mhs1, 20);
        Absen absen2 = new Absen(2, mhs2, 100);
        Absen absen3 = new Absen(3, mhs3, 60);
        Absen absen4 = new Absen(4, mhs4, 80);
        Absen absen5 = new Absen(5, mhs5, 90);
        
        absen1.save();
        absen2.save();
        absen3.save();
        absen4.save();
        absen5.save();
        
        absen2.setJmlhJam(40);
        absen2.save();
        
        absen5.delete();
        
            System.out.println("--------------- DATA ABSENSI ----------------");
        for(Absen a : new Absen().getAll()) {
            System.out.println("NO.ABSEN : " + a.getNoAbsen());
            System.out.println("MAHASISWA : " + a.getMahasiswa().getNamaMhs());
            System.out.println("JUMLAH JAM : " + a.getJmlhJam() + " JAM");
            System.out.println("---------------------------------------------");
        }
        System.out.println();
        
        System.out.println("---------------- CARI DATA ------------------");
        for(Absen a : new Absen().search("20")) {
            System.out.println("NO.ABSEN : " + a.getNoAbsen());
            System.out.println("MAHASISWA : " + a.getMahasiswa().getNamaMhs());
            System.out.println("JUMLAH JAM : " + a.getJmlhJam() + " JAM");
            System.out.println("---------------------------------------------");
        }
    }
}
