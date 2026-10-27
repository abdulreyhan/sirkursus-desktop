/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

<<<<<<< HEAD
import dao.PesertaDAO;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import model.Peserta;

public class FormPendaftaranKursus extends javax.swing.JFrame {

    private ButtonGroup groupJenis;
=======
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

public class FormPendaftaranKursus extends javax.swing.JFrame {

    private ButtonGroup groupJenis
>>>>>>> 6a39aeddb1585dfd336a92b3a9314d61141b3724
            
    public FormPendaftaranKursus() {
        initComponents();
        
        // --- TAMBAHKAN KODE INI DI DALAM KONSTRUKTOR ---
        groupJenis = new ButtonGroup();
<<<<<<< HEAD
        groupJenis.add(rbLaki);
        groupJenis.add(rbPerempuan);

        txtRingkasan.setEditable(false);
        setLocationRelativeTo(null);

=======
        groupJenis.add(jRadioButton1); 
        groupJenis.add(jRadioButton2); 
        
        txtRingkasan.setEditable(false);
        setLocationRelativeTo(null);
        
>>>>>>> 6a39aeddb1585dfd336a92b3a9314d61141b3724
        cmbKursus.removeAllItems();
        cmbKursus.addItem("-- Pilih Kursus --");
        cmbKursus.addItem("Java Desktop");
        cmbKursus.addItem("Data Science");
        cmbKursus.addItem("Web Programming");
        cmbKursus.addItem("UI/UX Design");
<<<<<<< HEAD
    }

    // Method mengambil jenis peserta
    private String getJenisKelamin() {
        if (rbLaki.isSelected()) {
            return "L";
        } else if (rbPerempuan.isSelected()) {
            return "P";
=======
        // -----------------------------------------------
    }

    // Method mengambil jenis peserta
    private String getJenisPeserta() {
        if (jRadioButton1.isSelected()) { 
            return "Mahasiswa";
        }
        if (jRadioButton2.isSelected()) { 
            return "Umum";
>>>>>>> 6a39aeddb1585dfd336a92b3a9314d61141b3724
        }
        return "";
    }

    // Method menentukan biaya dasar
    private double hitungBiayaDasar(String kursus) {
        double biaya = 0;
        switch (kursus) {
            case "Java Desktop":
                biaya = 500000;
                break;
            case "Data Science":
                biaya = 650000;
                break;
            case "Web Programming":
                biaya = 450000;
                break;
            case "UI/UX Design":
                biaya = 400000;
                break;
        }
        return biaya;
    }

    // Method menghitung biaya fasilitas tambahan
    private double hitungBiayaFasilitas() {
        double total = 0;
        if (cbModul.isSelected()) { total += 50_000; }
        if (cbSertifikat.isSelected()) { total += 75_000; }
        if (cbRekaman.isSelected()) { total += 40_000; }
        return total;
    }

    // Method menyusun ringkasan fasilitas dengan Array dan Loop
    private String buatRingkasanFasilitas() {
        String[] fasilitasDipilih = new String[3];
        int jumlah = 0;
<<<<<<< HEAD

=======
        
>>>>>>> 6a39aeddb1585dfd336a92b3a9314d61141b3724
        if (cbModul.isSelected()) {
            fasilitasDipilih[jumlah] = "Modul Cetak";
            jumlah++;
        }
        if (cbSertifikat.isSelected()) {
            fasilitasDipilih[jumlah] = "Sertifikat";
            jumlah++;
        }
        if (cbRekaman.isSelected()) {
            fasilitasDipilih[jumlah] = "Akses Rekaman";
            jumlah++;
        }
<<<<<<< HEAD

        if (jumlah == 0) {
            return "Tidak ada fasilitas tambahan\n";
        }

=======
        
        if (jumlah == 0) {
            return "Tidak ada fasilitas tambahan\n";
        }
        
>>>>>>> 6a39aeddb1585dfd336a92b3a9314d61141b3724
        StringBuilder hasil = new StringBuilder();
        for (int i = 0; i < jumlah; i++) {
            hasil.append("- ").append(fasilitasDipilih[i]).append("\n");
        }
        return hasil.toString();
    }

    // Method memvalidasi input
    private boolean validasiInput() {
        String nama = txtNama.getText().trim();
        String kode = txtKodeAkses.getText().trim(); 
        
        if (nama.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama peserta wajib diisi.", "Validasi", JOptionPane.WARNING_MESSAGE);
            txtNama.requestFocus();
            return false;
        }
        
        // KODE AKSES DIUBAH MENJADI PBO2026
        if (!kode.equals("PBO2026")) {
            JOptionPane.showMessageDialog(this, "Kode akses demo salah.", "Validasi", JOptionPane.WARNING_MESSAGE);
            txtKodeAkses.requestFocus();
            return false;
        }
        
<<<<<<< HEAD
        if (!rbLaki.isSelected() && !rbPerempuan.isSelected()) {
=======
        if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()) {
>>>>>>> 6a39aeddb1585dfd336a92b3a9314d61141b3724
            JOptionPane.showMessageDialog(this, "Pilih jenis peserta.", "Validasi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (cmbKursus.getSelectedIndex() == 0) { 
            JOptionPane.showMessageDialog(this, "Pilih kursus terlebih dahulu.", "Validasi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    
    // Method reset form
    private void resetForm() {
<<<<<<< HEAD
        txtNim.setText("");
        txtNama.setText("");
        txtKodeAkses.setText("");
        groupJenis.clearSelection();
        txtProdi.setText("");
        txtHp.setText("");
        txtEmail.setText("");
=======
        txtNama.setText("");
        txtKodeAkses.setText("");
        groupJenis.clearSelection();
>>>>>>> 6a39aeddb1585dfd336a92b3a9314d61141b3724
        cmbKursus.setSelectedIndex(0);
        cbModul.setSelected(false);
        cbSertifikat.setSelected(false);
        cbRekaman.setSelected(false);
<<<<<<< HEAD
        txtNim.requestFocus();
=======
        txtRingkasan.setText(""); 
        txtNama.requestFocus();
>>>>>>> 6a39aeddb1585dfd336a92b3a9314d61141b3724
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        txtKodeAkses = new javax.swing.JTextField();
<<<<<<< HEAD
        rbLaki = new javax.swing.JRadioButton();
        rbPerempuan = new javax.swing.JRadioButton();
=======
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
>>>>>>> 6a39aeddb1585dfd336a92b3a9314d61141b3724
        cmbKursus = new javax.swing.JComboBox<>();
        cbModul = new javax.swing.JCheckBox();
        cbSertifikat = new javax.swing.JCheckBox();
        cbRekaman = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRingkasan = new javax.swing.JTextArea();
        btnReset = new javax.swing.JButton();
<<<<<<< HEAD
        btnSimpan = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtNim = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtProdi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtHp = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
=======
        btnProses = new javax.swing.JButton();
>>>>>>> 6a39aeddb1585dfd336a92b3a9314d61141b3724

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 51, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("From Pendaftaran Kursus");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
<<<<<<< HEAD
                .addContainerGap(207, Short.MAX_VALUE)
=======
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
>>>>>>> 6a39aeddb1585dfd336a92b3a9314d61141b3724
                .addComponent(jLabel1)
                .addGap(199, 199, 199))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nama Peserta");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Kode Akses");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
<<<<<<< HEAD
        jLabel4.setText("Jenis Kelamin");
=======
        jLabel4.setText("Jenis Peserta");
>>>>>>> 6a39aeddb1585dfd336a92b3a9314d61141b3724

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Kursus");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Fasilitas");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Ringkasan");

<<<<<<< HEAD
        rbLaki.setText("Laki-laki");
        rbLaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbLakiActionPerformed(evt);
            }
        });

        rbPerempuan.setText("Perempuan");

        cmbKursus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Java Desktop", "Data Science", "Web Programming", "UI/UX Design" }));
        cmbKursus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKursusActionPerformed(evt);
            }
        });
=======
        jRadioButton1.setText("Mahasiswa");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Umum");

        cmbKursus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Java Desktop", "Data Science", "Web Programming", "UI/UX Design" }));
>>>>>>> 6a39aeddb1585dfd336a92b3a9314d61141b3724

        cbModul.setText("Modul");

        cbSertifikat.setText("Sertifikat");
<<<<<<< HEAD
        cbSertifikat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSertifikatActionPerformed(evt);
            }
        });

        cbRekaman.setText("Rekaman");
        cbRekaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRekamanActionPerformed(evt);
            }
        });
=======

        cbRekaman.setText("Rekaman");
>>>>>>> 6a39aeddb1585dfd336a92b3a9314d61141b3724

        txtRingkasan.setColumns(20);
        txtRingkasan.setRows(5);
        jScrollPane1.setViewportView(txtRingkasan);

        btnReset.setBackground(new java.awt.Color(204, 0, 0));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

<<<<<<< HEAD
        btnSimpan.setBackground(new java.awt.Color(102, 102, 255));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("NIM");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Program Studi");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Nomor HP");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Email");

=======
        btnProses.setBackground(new java.awt.Color(102, 102, 255));
        btnProses.setText("Proses");
        btnProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesActionPerformed(evt);
            }
        });

>>>>>>> 6a39aeddb1585dfd336a92b3a9314d61141b3724
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
<<<<<<< HEAD
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel11))
                        .addGap(56, 56, 56)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtKodeAkses, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                    .addComponent(txtNama)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbLaki)
                        .addGap(51, 51, 51)
                        .addComponent(rbPerempuan))
                    .addComponent(cmbKursus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(txtNim)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbModul)
                        .addGap(53, 53, 53)
                        .addComponent(cbSertifikat)
                        .addGap(52, 52, 52)
                        .addComponent(cbRekaman))
                    .addComponent(txtProdi)
                    .addComponent(txtHp)
                    .addComponent(txtEmail))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
=======
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnProses, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbModul)
                        .addGap(51, 51, 51)
                        .addComponent(cbSertifikat)
                        .addGap(71, 71, 71)
                        .addComponent(cbRekaman))
                    .addComponent(txtKodeAkses, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                    .addComponent(txtNama)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addGap(51, 51, 51)
                        .addComponent(jRadioButton2))
                    .addComponent(cmbKursus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(26, Short.MAX_VALUE))
>>>>>>> 6a39aeddb1585dfd336a92b3a9314d61141b3724
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
<<<<<<< HEAD
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtKodeAkses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbLaki)
                    .addComponent(rbPerempuan)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtProdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbKursus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
=======
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtKodeAkses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton1)
                        .addComponent(jRadioButton2)))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbKursus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
>>>>>>> 6a39aeddb1585dfd336a92b3a9314d61141b3724
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbModul)
                    .addComponent(cbSertifikat)
                    .addComponent(cbRekaman))
<<<<<<< HEAD
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(43, 43, 43)
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
=======
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(38, 38, 38)
                        .addComponent(btnProses)
                        .addGap(58, 58, 58)
                        .addComponent(btnReset))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
>>>>>>> 6a39aeddb1585dfd336a92b3a9314d61141b3724
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

<<<<<<< HEAD
    private void rbLakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbLakiActionPerformed

    }//GEN-LAST:event_rbLakiActionPerformed
=======
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed

    }//GEN-LAST:event_jRadioButton1ActionPerformed
>>>>>>> 6a39aeddb1585dfd336a92b3a9314d61141b3724

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        int jawab = JOptionPane.showConfirmDialog(this, "Kosongkan seluruh input?", "Konfirmasi Reset", JOptionPane.YES_NO_OPTION);
        if (jawab == JOptionPane.YES_OPTION) {
            resetForm();
        }
    }//GEN-LAST:event_btnResetActionPerformed

<<<<<<< HEAD
    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
    String nim = txtNim.getText().trim();
        String nama = txtNama.getText().trim();
        String prodi = txtProdi.getText().trim();
        String noHp = txtHp.getText().trim();
        String email = txtEmail.getText().trim();
        String kode = txtKodeAkses.getText().trim();
        String jenisKelamin = getJenisKelamin();

        // 2. Validasi input wajib sesuai Panduan Pertemuan 9 (Langkah 11)
        if (nim.isEmpty() || nama.isEmpty() || prodi.isEmpty() || jenisKelamin.isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "NIM, nama, jenis kelamin, dan prodi wajib diisi.",
                "Validasi",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // Validasi tambahan (Latihan Penguatan - Nomor HP & Email)
        if (!noHp.isEmpty() && !noHp.matches("\\d+")) {
            JOptionPane.showMessageDialog(
                this,
                "Nomor HP hanya boleh berisi angka.",
                "Validasi",
                JOptionPane.WARNING_MESSAGE
            );
            txtHp.requestFocus();
            return;
        }

        if (!email.isEmpty() && !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(
                this,
                "Format email tidak valid.",
                "Validasi",
                JOptionPane.WARNING_MESSAGE
            );
            txtEmail.requestFocus();
            return;
        }

        // Validasi Kode Akses & Kursus (jika diisi pada form gabungan ini)
        if (!kode.isEmpty() && !kode.equals("PBO2026")) {
            JOptionPane.showMessageDialog(this, "Kode akses demo salah (Gunakan: PBO2026).", "Validasi", JOptionPane.WARNING_MESSAGE);
            txtKodeAkses.requestFocus();
            return;
        }

        // 3. Bentuk object Peserta & panggil PesertaDAO (Langkah 11)
        Peserta peserta = new Peserta(nim, nama, jenisKelamin, prodi, noHp, email);
        PesertaDAO dao = new PesertaDAO();

        try {
            boolean berhasil = dao.insert(peserta);
            if (berhasil) {
                // Tampilkan ringkasan ke TextArea jika kursus dipilih
                String kursus = cmbKursus.getSelectedIndex() > 0 ? cmbKursus.getSelectedItem().toString() : "-";
                double biayaDasar = hitungBiayaDasar(kursus);
                double diskon = !nim.isEmpty() ? biayaDasar * 0.10 : 0;
                double biayaFasilitas = hitungBiayaFasilitas();
                double total = biayaDasar - diskon + biayaFasilitas;
                String fasilitas = buatRingkasanFasilitas();

                String ringkasan = "DATA PESERTA & PENDAFTARAN\n"
                        + "====================\n"
                        + "NIM             : " + nim + "\n"
                        + "Nama            : " + nama + "\n"
                        + "Jenis Kelamin   : " + (jenisKelamin.equals("L") ? "Laki-laki (L)" : "Perempuan (P)") + "\n"
                        + "Program Studi   : " + prodi + "\n"
                        + "Nomor HP        : " + noHp + "\n"
                        + "Email           : " + email + "\n"
                        + "Kursus          : " + kursus + "\n"
                        + "Biaya Dasar     : Rp" + String.format("%,.0f", biayaDasar) + "\n"
                        + "Diskon          : Rp" + String.format("%,.0f", diskon) + "\n"
                        + "====================\n"
                        + "Fasilitas:\n" + fasilitas
                        + "Biaya Fasilitas : Rp" + String.format("%,.0f", biayaFasilitas) + "\n"
                        + "TOTAL           : Rp" + String.format("%,.0f", total);

                txtRingkasan.setText(ringkasan);

                JOptionPane.showMessageDialog(this, "Data peserta berhasil disimpan.");
                clearForm();
            } else {
                JOptionPane.showMessageDialog(
                    this,
                    "Data tidak tersimpan.",
                    "Informasi",
                    JOptionPane.WARNING_MESSAGE
                );
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                this,
                "Gagal menyimpan data:\n" + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
            );
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void cbSertifikatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSertifikatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSertifikatActionPerformed

    private void cbRekamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRekamanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbRekamanActionPerformed

    private void cmbKursusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKursusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKursusActionPerformed
=======
    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
    if (!validasiInput()) {
            return;
        }
        
        String nama = txtNama.getText().trim();
        String jenis = getJenisPeserta();
        String kursus = cmbKursus.getSelectedItem().toString(); 
        
        double biayaDasar = hitungBiayaDasar(kursus);
        double diskon = jenis.equals("Mahasiswa") ? biayaDasar * 0.10 : 0;
        double biayaFasilitas = hitungBiayaFasilitas();
        double total = biayaDasar - diskon + biayaFasilitas;
        
        String fasilitas = buatRingkasanFasilitas();
        
        String ringkasan = "PENDAFTARAN KURSUS\n" +
                           "====================\n" +
                           "Nama            : " + nama + "\n" +
                           "Jenis Peserta   : " + jenis + "\n" +
                           "Kursus          : " + kursus + "\n" +
                           "Biaya Dasar     : Rp" + String.format("%,.0f", biayaDasar) + "\n" +
                           "Diskon          : Rp" + String.format("%,.0f", diskon) + "\n" +
                           "====================\n" +
                           "Fasilitas:\n" + fasilitas +
                           "Biaya Fasilitas : Rp" + String.format("%,.0f", biayaFasilitas) + "\n" +
                           "TOTAL           : Rp" + String.format("%,.0f", total);
                           
        txtRingkasan.setText(ringkasan);
        JOptionPane.showMessageDialog(this, "Pendaftaran berhasil diproses.", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnProsesActionPerformed
>>>>>>> 6a39aeddb1585dfd336a92b3a9314d61141b3724

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
<<<<<<< HEAD
       try {
=======
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
>>>>>>> 6a39aeddb1585dfd336a92b3a9314d61141b3724
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
<<<<<<< HEAD
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPendaftaranKursus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

=======
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormPendaftaranKursus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPendaftaranKursus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPendaftaranKursus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPendaftaranKursus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
<<<<<<< HEAD
=======
        //</editor-fold>
>>>>>>> origin/master

        /* Create and display the form */
>>>>>>> 6a39aeddb1585dfd336a92b3a9314d61141b3724
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPendaftaranKursus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
<<<<<<< HEAD
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
=======
    private javax.swing.JButton btnProses;
    private javax.swing.JButton btnReset;
>>>>>>> 6a39aeddb1585dfd336a92b3a9314d61141b3724
    private javax.swing.JCheckBox cbModul;
    private javax.swing.JCheckBox cbRekaman;
    private javax.swing.JCheckBox cbSertifikat;
    private javax.swing.JComboBox<String> cmbKursus;
    private javax.swing.JLabel jLabel1;
<<<<<<< HEAD
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
=======
>>>>>>> 6a39aeddb1585dfd336a92b3a9314d61141b3724
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
<<<<<<< HEAD
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbLaki;
    private javax.swing.JRadioButton rbPerempuan;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHp;
    private javax.swing.JTextField txtKodeAkses;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNim;
    private javax.swing.JTextField txtProdi;
    private javax.swing.JTextArea txtRingkasan;
    // End of variables declaration//GEN-END:variables

    private void clearForm() {
        resetForm();
    }

=======
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtKodeAkses;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextArea txtRingkasan;
    // End of variables declaration//GEN-END:variables

>>>>>>> 6a39aeddb1585dfd336a92b3a9314d61141b3724
}
