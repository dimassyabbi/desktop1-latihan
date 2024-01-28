package apotik.model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import apotik.entity.Kategori;
public class KategoriTableModel extends AbstractTableModel {
    
    private List<Kategori> rows;
    public KategoriTableModel (List<Kategori> list){
        rows = list;
    }
    @Override
    public int getRowCount(){
        return rows.size();
    }
    @Override
    public int getColumnCount(){
        return 2;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        Kategori perkiraan = rows.get(rowIndex);
        switch(columnIndex){
            case 0:
                return perkiraan.getKode();
            case 1:
                return perkiraan.getNama();
            default :
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "Kode";
            case 1:
                return "Nama Kategori";
            default :
                return null;
        }
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch(columnIndex){
            case 0:
                return String.class;
            case 1:
                return String.class;
            default :
                return super.getColumnClass(columnIndex);
        }
    }
    
    public void setRows(List<Kategori> list){
        rows = list;
    }
    public List<Kategori> getRows(){
        return rows;
    }
}
