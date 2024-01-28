package apotik.entity;
import java.util.Date;
public class Penjualan {
    private String nomor;
    private Date tanggal;
    private Integer total;
    private Pembeli pelanggan;

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Pembeli getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pembeli pelanggan) {
        this.pelanggan = pelanggan;
    }
    
    
}
