package apotik.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import apotik.entity.Obat;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class ObatModel {
    private Connection connection;
    
    public ObatModel(Connection connection){
        this.connection = connection;
    }
    
    public void insert(Obat barang) throws SQLException{
        String sql = "INSERT INTO "
                + "ms_barang("
                    + "kode, "
                    + "nama, "
                    + "kategori, "
                    + "harga_satuan"
                + ") "
            + "VALUES ("
                + "?, "
                + "?, "
                + "?, "
                + "?"
            + ")";
        
        PreparedStatement statemen = connection.prepareStatement(sql);
        statemen.setString(1, barang.getKode());
        statemen.setString(2, barang.getNama());
        statemen.setString(3, barang.getKategori());
        statemen.setInt(4, barang.getHarga_satuan());
        statemen.executeUpdate();
        statemen.close();
    }
    
    public void update(Obat barang) throws SQLException{
        String sql = " UPDATE "
                        + " ms_barang "
                     + " SET "
                        + "nama = ?, "
                        + "kategori = ?, "
                        + "harga_satuan = ?"
                     + " WHERE "
                         + "kode = ?"
                     ;
        
        PreparedStatement statemen = connection.prepareStatement(sql);
        statemen.setString(1, barang.getNama());
        statemen.setString(2, barang.getKategori());
        statemen.setInt(3, barang.getHarga_satuan());
        statemen.setString(4, barang.getKode());
        statemen.executeUpdate();
        statemen.close();
    }
    
    public void delete(Obat barang) throws SQLException{
        String sql = 
                "DELETE FROM "
                    + "ms_barang "
                + "WHERE "
                    + "kode = ?"
                ;
        
        PreparedStatement statemen = connection.prepareStatement(sql);
        statemen.setString(1, barang.getKode());
        statemen.executeUpdate();
        statemen.close();
    }
    
    public List<Obat> search(String keyword){
        String sql = 
                "SELECT "
                    + "kode, "
                    + "nama, "
                    + "kategori, "
                    + "harga_satuan "
                + "FROM "
                    + "ms_barang "
                + "WHERE "
                    + "kode LIKE ? "
                + "OR "
                    + "nama LIke ? "
                ;
        List<Obat> list = new ArrayList<Obat>();
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%"+keyword+"%");
            statement.setString(2, "%"+keyword+"%");
            ResultSet result = statement.executeQuery();
            while(result.next()){
                Obat entity = new Obat();
                entity.setKode(result.getString("kode"));
                entity.setNama(result.getString("nama"));
                entity.setKategori(result.getString("kategori"));
                entity.setHarga_satuan(result.getInt("harga_satuan"));
                list.add(entity);
            }
            result.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return list;
    }
    public List<Obat> getData(){
        String sql = 
                "SELECT "
                    + "kode, "
                    + "nama, "
                    + "kategori, "
                    + "harga_satuan "
                + "FROM "
                    + "ms_barang"
                ;
        List<Obat> list = new ArrayList<Obat>();
        PreparedStatement statement = null;
        
        try{
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                Obat entity = new Obat();
                entity.setKode(result.getString("kode"));
                entity.setNama(result.getString("nama"));
                entity.setKategori(result.getString("kategori"));
                
                entity.setHarga_satuan(result.getInt("harga_satuan"));
                list.add(entity);
            }
            result.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return list;
    }
}
