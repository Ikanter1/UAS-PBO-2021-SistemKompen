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
public class TestPenugasan {
    public static void main(String[] args) {
        Penugasan pen1 = new Penugasan(2, "MEMBELI RAM DDR6 16GB", 0);
        Penugasan pen2 = new Penugasan(3, "MEMBELI MOUSE LOGITECH", 0);
        Penugasan pen3 = new Penugasan(1, "MEMBERSIHKAN PC", 30);
        Penugasan pen4 = new Penugasan(4, "MEMBENARKAN AC SETIAP KELAS", 100);
        
        pen1.save();
        pen2.save();
        pen3.save();
        pen4.save();
        
        pen2.setJmlhJam(80);
        pen2.save();
        
        System.out.println("-------------- DATA PENUGASAN ---------------");
        for(Penugasan pen : new Penugasan().getAll()){
            System.out.println("PENUGASAN      : " + pen.getIdPenugasan());
            System.out.println("TUGAS      : " + pen.getTugas());
            System.out.println("JUMLAH JAM : " + pen.getJmlhJam()+ " JAM");  
            System.out.println("---------------------------------------------");
        }
        System.out.println();
        
        System.out.println("----------------- CARI DATA------------------");
        for(Penugasan pen : new Penugasan().search("MEMBERSIHKAN")){
            System.out.println("TUGAS      : " + pen.getTugas());
            System.out.println("JUMLAH JAM : " + pen.getJmlhJam()+ " JAM");   
            System.out.println("---------------------------------------------");
        }
    }
}
