/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pemrograman_berbasis_dekstop.entity;

/**
 *
 * @author user
 */
public class Barang {
    private String kode; 
    private String nama; 
    private String satuan; 
    private Integer harga_satuan; 

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public Integer getHarga_satuan() {
        return harga_satuan;
    }

    public void setHarga_satuan(Integer harga_satuan) {
        this.harga_satuan = harga_satuan;
    }
    
    

}
