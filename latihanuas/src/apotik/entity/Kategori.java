package apotik.entity;
public class Kategori {
    private String id_kategori;
    private String nama_kategori;
    private String alamat;
    private String telepon;

    public String getKode() {
        return id_kategori;
    }

    public void setKode(String id_kategori) {
        this.id_kategori = id_kategori;
    }

    public String getNama() {
        return nama_kategori;
    }

    public void setNama(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }
        
}
