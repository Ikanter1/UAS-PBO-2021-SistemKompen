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
public class TestMahasiswa {
    public static void main(String[] args) {
//        Mahasiswa mhs1 = new Mahasiswa("Rony", "TI-2C");
//        Mahasiswa mhs2 = new Mahasiswa("Yanu", "TI-2F");
//        Mahasiswa mhs3 = new Mahasiswa("Ilham", "TI-2A");
//        Mahasiswa mhs4 = new Mahasiswa("Zadah", "TI-2B");
//        Mahasiswa mhs5 = new Mahasiswa("Putri", "TI-2C");
//        Mahasiswa mhs6 = new Mahasiswa("Dio", "TI-2D");
//        
//        mhs1.save();
//        mhs2.save();
//        mhs3.save();
//        mhs4.save();
//        mhs5.save();
//        mhs6.save();
//        
//        mhs5.setNamaMhs("Nurifa");
//        mhs5.save();
//        
//        mhs6.delete();
        
        System.out.println("-------------- DATA MAHASISWA --------------");
        for(Mahasiswa mhs : new Mahasiswa().getAll()) {
            System.out.println("NIM : " + mhs.getNim());
            System.out.println("NAMA MAHASISWA : " + mhs.getNamaMhs());
            System.out.println("KELAS          : " + mhs.getKelas());
            System.out.println("---------------------------------------------");
        }
        System.out.println();
        
        System.out.println("----------------- CARI DATA -----------------");
        for(Mahasiswa mhs : new Mahasiswa().search("RONY")) {
            System.out.println("NIM : " + mhs.getNim());
            System.out.println("NAMA MAHASISWA : " + mhs.getNamaMhs());
            System.out.println("KELAS          : " + mhs.getKelas());
            System.out.println("---------------------------------------------");
        }
    }
}
