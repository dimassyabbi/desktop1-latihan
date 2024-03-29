package apotik.view;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import pemrograman_berbasis_desktop.DBConnection;
import apotik.entity.Obat;
import apotik.entity.Pembeli;
import apotik.entity.Penjualan;
import apotik.entity.PenjualanDetail;
import apotik.model.PenjualanDetailTableModel;
import apotik.model.PenjualanModel;
import apotik.model.PenjualanDetailModel;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Vector;
public class PenjualanForm extends javax.swing.JInternalFrame {

    private Connection connection;
    private PembeliData pelangganData;
    private ObatData barangData;
    private PenjualanDetailTableModel penjualanDetailTableModel;
    private PenjualanModel penjualanModel;
    private PenjualanDetailModel penjualanDetailModel;
    public PenjualanForm() {
        initComponents();
        
        connection = DBConnection.newgetInstant();
        pelangganData = new PembeliData(null, true);
        barangData = new ObatData(null, true);
        penjualanDetailTableModel = new PenjualanDetailTableModel(new ArrayList<PenjualanDetail>());
        tableRender();
        penjualanModel = new PenjualanModel(connection);
        penjualanDetailModel = new PenjualanDetailModel(connection);
    }
    
    private void tableRender(){
        tabelBarangRincian.setModel(penjualanDetailTableModel);
        tabelBarangRincian.getColumnModel().getColumn(0).setPreferredWidth(40);
        tabelBarangRincian.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabelBarangRincian.getColumnModel().getColumn(2).setPreferredWidth(40);
        tabelBarangRincian.getColumnModel().getColumn(3).setPreferredWidth(40);
        tabelBarangRincian.getColumnModel().getColumn(4).setPreferredWidth(80);
        tabelBarangRincian.getColumnModel().getColumn(5).setPreferredWidth(80);
    }
    
    private Integer hitungJumlah(){
        Integer qty = Integer.valueOf(String.valueOf(textBarangKuantiti.getValue()));
        Integer hargaSatuan = Integer.valueOf(String.valueOf(textBarangHargaSatuan.getValue()));
        Integer jumlah = qty * hargaSatuan;
        return jumlah;
    }
    
    public Integer hitungTotal(){
        Integer total = 0;
        for(PenjualanDetail detail : penjualanDetailTableModel.getRows()){
            total = total + (detail.getHarga_satuan() * detail.getKuantiti());
        }
        return total;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textPenjualanNomor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textPenjualanTanggal = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        textBarangKode = new javax.swing.JTextField();
        textBarangNama = new javax.swing.JTextField();
        buttonBarangFind = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        textKategori = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textBarangKuantiti = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        buttonBarangSisipkan = new javax.swing.JButton();
        textBarangHargaSatuan = new javax.swing.JFormattedTextField();
        textBarangJumlah = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelBarangRincian = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        buttonPenjualanBaru = new javax.swing.JButton();
        buttonPenjualanSimpan = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        textPelangganKode = new javax.swing.JTextField();
        textPelangganNama = new javax.swing.JTextField();
        buttonPelangganFind = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        textPenjualanTotal = new javax.swing.JFormattedTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("FORMULIR PENJUALAN OBAT");

        jPanel1.setBackground(new java.awt.Color(0, 153, 102));

        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("No. Transaksi");

        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setText("Tanggal");

        textPenjualanTanggal.setModel(new javax.swing.SpinnerDateModel());
        textPenjualanTanggal.setEditor(new javax.swing.JSpinner.DateEditor(textPenjualanTanggal, "dd/MM/yyyy"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textPenjualanNomor, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textPenjualanTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textPenjualanNomor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(textPenjualanTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Barang yg Dijual"));

        jLabel3.setText("Barang");

        buttonBarangFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBarangFindActionPerformed(evt);
            }
        });

        jLabel4.setText("Kategori");

        textKategori.setEditable(false);
        textKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textKategoriActionPerformed(evt);
            }
        });

        jLabel5.setText("Kuantiti");

        textBarangKuantiti.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        textBarangKuantiti.setEditor(new javax.swing.JSpinner.NumberEditor(textBarangKuantiti, "#,##0"));
        textBarangKuantiti.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                textBarangKuantitiStateChanged(evt);
            }
        });

        jLabel6.setText("Harga Satuan");

        jLabel7.setText("Jumlah");

        buttonBarangSisipkan.setText("TAMBAH");
        buttonBarangSisipkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBarangSisipkanActionPerformed(evt);
            }
        });

        textBarangHargaSatuan.setEditable(false);
        textBarangHargaSatuan.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        textBarangHargaSatuan.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textBarangHargaSatuan.setValue(0);

        textBarangJumlah.setEditable(false);
        textBarangJumlah.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        textBarangJumlah.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textBarangJumlah.setValue(0);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(textBarangKode, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textBarangNama, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonBarangFind, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(textBarangKuantiti, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(textBarangHargaSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(textBarangJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonBarangSisipkan, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonBarangFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(textBarangNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textBarangKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textBarangKuantiti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonBarangSisipkan)
                                .addComponent(textBarangHargaSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textBarangJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jLabel8.setText("Rincian Barang yg Dijual");

        tabelBarangRincian.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabelBarangRincian);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        buttonPenjualanBaru.setText("BARU");
        buttonPenjualanBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPenjualanBaruActionPerformed(evt);
            }
        });

        buttonPenjualanSimpan.setText("SIMPAN");
        buttonPenjualanSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPenjualanSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonPenjualanBaru)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPenjualanSimpan)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPenjualanBaru)
                    .addComponent(buttonPenjualanSimpan))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Dijual Kepada"));

        jLabel10.setText("Pelanggan");

        textPelangganKode.setEditable(false);

        textPelangganNama.setEditable(false);

        buttonPelangganFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPelangganFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textPelangganKode, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textPelangganNama, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPelangganFind, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(textPelangganKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textPelangganNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonPelangganFind, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("TOTAL BAYAR");

        textPenjualanTotal.setEditable(false);
        textPenjualanTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        textPenjualanTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textPenjualanTotal.setValue(0);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textPenjualanTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textPenjualanTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBarangFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBarangFindActionPerformed
        barangData.show();
        Obat barang = barangData.getSelectionRow();
        if(barang != null){
            textBarangKode.setText(barang.getKode());
            textBarangNama.setText(barang.getNama());
            textKategori.setText(barang.getKategori());
            textBarangKuantiti.setValue(1);
            
            textBarangHargaSatuan.setValue(barang.getHarga_satuan());
            textBarangJumlah.setValue(hitungJumlah());
        }
    }//GEN-LAST:event_buttonBarangFindActionPerformed

    private void textKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textKategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textKategoriActionPerformed

    private void buttonPelangganFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPelangganFindActionPerformed
        pelangganData.show();
        Pembeli pelanggan = pelangganData.getSelectionRow();
        if(pelanggan != null){
            textPelangganKode.setText(pelanggan.getKode());
            textPelangganNama.setText(pelanggan.getNama());
        }
    }//GEN-LAST:event_buttonPelangganFindActionPerformed

    private void textBarangKuantitiStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_textBarangKuantitiStateChanged
        textBarangJumlah.setValue(hitungJumlah());
    }//GEN-LAST:event_textBarangKuantitiStateChanged

    private void buttonBarangSisipkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBarangSisipkanActionPerformed
        Obat barang = new Obat();
        barang.setKode(textBarangKode.getText());
        barang.setNama(textBarangNama.getText());
        barang.setKategori(textKategori.getText());
        
        barang.setHarga_satuan(Integer.valueOf(String.valueOf(textBarangHargaSatuan.getValue())));
            PenjualanDetail penjualanDetail = new PenjualanDetail();
            penjualanDetail.setBarang(barang);
        penjualanDetail.setKuantiti(Integer.valueOf(String.valueOf(textBarangKuantiti.getValue())));
        penjualanDetail.setHarga_satuan(Integer.valueOf(String.valueOf(textBarangHargaSatuan.getValue())));
        boolean add = true;
        for(PenjualanDetail penjualanDetailOld : penjualanDetailTableModel.getRows()){
            if(penjualanDetailOld.getBarang().getKode().equals(penjualanDetail.getBarang().getKode())){
                add = false;
                Integer kuantiti = penjualanDetailOld.getKuantiti() + penjualanDetail.getKuantiti();
                penjualanDetailOld.setKuantiti(kuantiti);
                penjualanDetailOld.setHarga_satuan(penjualanDetail.getHarga_satuan());
                break;
            }
        }
        if(add)
            penjualanDetailTableModel.getRows().add(penjualanDetail);
            penjualanDetailTableModel.fireTableDataChanged();
            textPenjualanTotal.setValue(hitungTotal());
            
            textBarangKode.setText(null);
            textBarangNama.setText(null);
            textKategori.setText(null);
            textBarangKuantiti.setValue(1);
            textBarangHargaSatuan.setValue(0);
            textBarangJumlah.setValue(hitungJumlah());
        
    }//GEN-LAST:event_buttonBarangSisipkanActionPerformed

    private void buttonPenjualanBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPenjualanBaruActionPerformed
        textPenjualanNomor.setText(null);
        textPenjualanTanggal.setValue(new Date());
        textPelangganKode.setText(null);
        textPelangganNama.setText(null);
        textBarangKode.setText(null);
        textBarangNama.setText(null);
        textKategori.setText(null);
        textBarangKuantiti.setValue(1);
        textBarangHargaSatuan.setValue(0);
        textBarangJumlah.setValue(hitungJumlah());
        
        penjualanDetailTableModel.setRows(new ArrayList<PenjualanDetail>());
        penjualanDetailTableModel.fireTableDataChanged();
    }//GEN-LAST:event_buttonPenjualanBaruActionPerformed

    private void buttonPenjualanSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPenjualanSimpanActionPerformed
        try{
            connection.setAutoCommit(false);
            //insert penjualan
            Penjualan penjualan = new Penjualan();
            penjualan.setNomor(textPenjualanNomor.getText());
            penjualan.setTanggal((Date)textPenjualanTanggal.getValue());
            penjualan.setTotal(Integer.valueOf(String.valueOf(textPenjualanTotal.getValue())));
            
            Pembeli pelanggan = new Pembeli();
            pelanggan.setKode(textPelangganKode.getText());
            pelanggan.setNama(textPelangganNama.getText());
            
            penjualan.setPelanggan(pelanggan);
            penjualanModel.insert(penjualan);
            
            //insert penjualan detail
            for(PenjualanDetail detail : penjualanDetailTableModel.getRows()){
                detail.setPenjualan(penjualan);
                penjualanDetailModel.insert(detail);
            }
            connection.commit();
            JOptionPane.showMessageDialog(this, "DATA TRANSAKSI BERHASIL DISIMPAN", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "DATA TRANSAKSI GAGAL DISIMPAN", "KESALAHAN", JOptionPane.INFORMATION_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_buttonPenjualanSimpanActionPerformed

public static void main(String arg[]){
    try{
        for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
            if("Nimbus".equals(info.getName())){
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    }catch(ClassNotFoundException ex){
        java.util.logging.Logger.getLogger(PenjualanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }catch(InstantiationException ex){
        java.util.logging.Logger.getLogger(PenjualanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }catch(IllegalAccessException ex){
        java.util.logging.Logger.getLogger(PenjualanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }catch(javax.swing.UnsupportedLookAndFeelException ex){
        java.util.logging.Logger.getLogger(PenjualanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    
    java.awt.EventQueue.invokeLater(new Runnable(){
       public void run(){
            JFrame frame = new JFrame();
            frame.addWindowListener(new java.awt.event.WindowAdapter(){
                @Override
                public void windowClosing(java.awt.event.WindowEvent e){
                    System.exit(0);
                }
            });
            PenjualanForm form = new PenjualanForm();
            frame.add(form);
            form.setVisible(true);

            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
        } 
    });
}
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBarangFind;
    private javax.swing.JButton buttonBarangSisipkan;
    private javax.swing.JButton buttonPelangganFind;
    private javax.swing.JButton buttonPenjualanBaru;
    private javax.swing.JButton buttonPenjualanSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabelBarangRincian;
    private javax.swing.JFormattedTextField textBarangHargaSatuan;
    private javax.swing.JFormattedTextField textBarangJumlah;
    private javax.swing.JTextField textBarangKode;
    private javax.swing.JSpinner textBarangKuantiti;
    private javax.swing.JTextField textBarangNama;
    private javax.swing.JTextField textKategori;
    private javax.swing.JTextField textPelangganKode;
    private javax.swing.JTextField textPelangganNama;
    private javax.swing.JTextField textPenjualanNomor;
    private javax.swing.JSpinner textPenjualanTanggal;
    private javax.swing.JFormattedTextField textPenjualanTotal;
    // End of variables declaration//GEN-END:variables
}


