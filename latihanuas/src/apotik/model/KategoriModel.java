package apotik.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import apotik.entity.Kategori;
import java.util.List;
import java.util.ArrayList;

public class KategoriModel {
    private Connection connection;
    
    public KategoriModel(Connection connection){
        this.connection = connection;
    }
    
    //QUERY UNTUK INSERT DATA PELANGGAN    
    public void insert(Kategori kategori) throws SQLException{
        String sql = "INSERT INTO "
                + "ms_kategori("
                    + "id_kategori, "
                    + "nama_kategori"
                + ") "
            + "VALUES ("
                + "?, "
                + "?"
            + ")";
        
        PreparedStatement statemen = connection.prepareStatement(sql);
        statemen.setString(1, kategori.getKode());
        statemen.setString(2, kategori.getNama());
        statemen.executeUpdate();
        statemen.close();
    }
    
    
    //QUERY UNTUK UPDATE DATA PELANGGAN    
    public void update(Kategori kategori) throws SQLException{
        String sql = " UPDATE "
                        + " ms_kategori "
                     + " SET "
                        + "nama_kategori = ?"
                     + " WHERE "
                         + "id_kategori = ?"
                     ;
        
        PreparedStatement statemen = connection.prepareStatement(sql);
        statemen.setString(1, kategori.getNama());
        statemen.executeUpdate();
        statemen.close();
    }
    
    //QUERY DELETE DATA PELANGGAN
    public void delete(Kategori kategori) throws SQLException{
        String sql = 
                "DELETE FROM "
                    + "ms_kategori "
                + "WHERE "
                    + "id_kategori = ?"
                ;
        
        PreparedStatement statemen = connection.prepareStatement(sql);
        statemen.setString(1, kategori.getKode());
        statemen.executeUpdate();
        statemen.close();
    }
    
    //QUERY UNTUK SEARCH PELANGGAN
    public List<Kategori> search(String keyword){
            String sql = 
                    "SELECT "
                        + "id_kategori, "
                        + "nama_kategori "
                    + "FROM "
                        + "ms_kategori "
                    + "WHERE "
                        + "id_kategori LIKE ? "
                    + "OR "
                        + "nama_kategori LIke ? "
                    ;
            List<Kategori> list = new ArrayList<Kategori>();
            PreparedStatement statement = null;
            try{
                statement = connection.prepareStatement(sql);
                statement.setString(1, "%"+keyword+"%");
                statement.setString(2, "%"+keyword+"%");
                ResultSet result = statement.executeQuery();
                while(result.next()){
                    Kategori entity = new Kategori();
                    entity.setKode(result.getString("id_kategori"));
                    entity.setNama(result.getString("nama_kategori"));
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
    public List<Kategori> getData(){
        String sql = 
                "SELECT "
                    + "id_kategori, "
                    + "nama_kategori "
                + "FROM "
                    + "ms_kategori"
                ;
        List<Kategori> list = new ArrayList<Kategori>();
        PreparedStatement statement = null;
        
        try{
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                Kategori entity = new Kategori();
                entity.setKode(result.getString("id_kategori"));
                entity.setNama(result.getString("nama_kategori"));
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
