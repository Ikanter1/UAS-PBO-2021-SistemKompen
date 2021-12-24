/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class FrmMahasiswa extends javax.swing.JFrame {

    /**
     * Creates new form FrmMahasiswa
     */
    
    public FrmMahasiswa() {
        initComponents();
        tampilkanData();
        kosongkanForm();
    }
    
    public void kosongkanForm() {
        txtNim.setText("");
        txtNama.setText("");
        txtKelas.setText("");
    }
    
    public void tampilkanData() {
        String[] kolom = {"NIM", "NAMA", "KELAS"};
        ArrayList<Mahasiswa> list = new Mahasiswa().getAll();
        Object rowData[] = new Object[3];

        tblMahasiswa.setModel(new DefaultTableModel(new Object[][]{}, kolom));
        for (Mahasiswa ang : list) {
            rowData[0] = ang.getNim();
            rowData[1] = ang.getNamaMhs();
            rowData[2] = ang.getKelas();
            
            ((DefaultTableModel) tblMahasiswa.getModel()).addRow(rowData);
        }
    }
    
    public void cari(String keyword) {
        String[] kolom = {"NIM", "NAMA", "KELAS"};
        ArrayList<Mahasiswa> list = new Mahasiswa().search(keyword);
        Object rowData[] = new Object[3];

        tblMahasiswa.setModel(new DefaultTableModel(new Object[][]{}, kolom));
        for (Mahasiswa ang : list) {
            rowData[0] = ang.getNim();
            rowData[1] = ang.getNamaMhs();
            rowData[2] = ang.getKelas();

            ((DefaultTableModel) tblMahasiswa.getModel()).addRow(rowData);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnTambahData = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMahasiswa = new javax.swing.JTable();
        txtNama = new javax.swing.JTextField();
        txtKelas = new javax.swing.JTextField();
        btnDataMahasiswa = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnDataDosen = new javax.swing.JButton();
        btnDataAbsensi = new javax.swing.JButton();
        btnDataPenugasan = new javax.swing.JButton();
        btnDataKompen = new javax.swing.JButton();
        txtNim = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("DATA MAHASISWA");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("NIM");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("NAMA");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("KELAS");

        btnSimpan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnTambahData.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTambahData.setText("TAMBAH DATA");
        btnTambahData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahDataActionPerformed(evt);
            }
        });

        btnHapus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        txtCari.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnCari.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCari.setText("CARI");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        tblMahasiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblMahasiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMahasiswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMahasiswa);

        txtNama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtKelas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnDataMahasiswa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDataMahasiswa.setText("DATA MAHASISWA");
        btnDataMahasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataMahasiswaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("DASHBOARD");

        btnDataDosen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDataDosen.setText("DATA DOSEN");
        btnDataDosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataDosenActionPerformed(evt);
            }
        });

        btnDataAbsensi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDataAbsensi.setText("DATA ABSENSI");
        btnDataAbsensi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataAbsensiActionPerformed(evt);
            }
        });

        btnDataPenugasan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDataPenugasan.setText("DATA PENUGASAN");
        btnDataPenugasan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataPenugasanActionPerformed(evt);
            }
        });

        btnDataKompen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDataKompen.setText("DATA KOMPEN");
        btnDataKompen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataKompenActionPerformed(evt);
            }
        });

        txtNim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addComponent(btnDataMahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnDataDosen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnDataAbsensi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnDataPenugasan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnDataKompen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnSimpan)
                                .addComponent(btnTambahData)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtNim, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnHapus)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(188, 188, 188)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDataMahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDataDosen, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnDataAbsensi, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTambahData)
                            .addComponent(btnHapus)
                            .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCari)))
                    .addComponent(btnDataPenugasan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDataKompen, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahDataActionPerformed
        kosongkanForm();
    }//GEN-LAST:event_btnTambahDataActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        Mahasiswa mhs = new Mahasiswa();
        mhs.setNim(Integer.parseInt(txtNim.getText()));
        mhs.setNamaMhs(txtNama.getText());
        mhs.setKelas(txtKelas.getText());
        mhs.save();
        txtNim.setText(Integer.toString(mhs.getNim()));
        tampilkanData();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblMahasiswa.getModel();
        int row = tblMahasiswa.getSelectedRow();

        Mahasiswa mhs = new Mahasiswa().getById(Integer.parseInt(model.getValueAt(row, 0).toString()));
        mhs.delete();
        kosongkanForm();
        tampilkanData();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        cari(txtCari.getText());
    }//GEN-LAST:event_btnCariActionPerformed

    private void tblMahasiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMahasiswaMouseClicked
        DefaultTableModel model = (DefaultTableModel) tblMahasiswa.getModel();
        int row = tblMahasiswa.getSelectedRow();

        txtNim.setText(model.getValueAt(row, 0).toString());
        txtNama.setText(model.getValueAt(row, 1).toString());
        txtKelas.setText(model.getValueAt(row, 2).toString());
    }//GEN-LAST:event_tblMahasiswaMouseClicked

    private void btnDataMahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataMahasiswaActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmMahasiswa().setVisible(true);
                dispose();
            }
        });
    }//GEN-LAST:event_btnDataMahasiswaActionPerformed

    private void btnDataDosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataDosenActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmDosen().setVisible(true);
                dispose();
            }
        });
    }//GEN-LAST:event_btnDataDosenActionPerformed

    private void btnDataAbsensiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataAbsensiActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmAbsen().setVisible(true);
                dispose();
            }
        });
    }//GEN-LAST:event_btnDataAbsensiActionPerformed

    private void btnDataPenugasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataPenugasanActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmPenugasan().setVisible(true);
                dispose();
            }
        });
    }//GEN-LAST:event_btnDataPenugasanActionPerformed

    private void btnDataKompenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataKompenActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmKonfirm().setVisible(true);
                dispose();
            }
        });
    }//GEN-LAST:event_btnDataKompenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmMahasiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnDataAbsensi;
    private javax.swing.JButton btnDataDosen;
    private javax.swing.JButton btnDataKompen;
    private javax.swing.JButton btnDataMahasiswa;
    private javax.swing.JButton btnDataPenugasan;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambahData;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tblMahasiswa;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtKelas;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNim;
    // End of variables declaration//GEN-END:variables
}
