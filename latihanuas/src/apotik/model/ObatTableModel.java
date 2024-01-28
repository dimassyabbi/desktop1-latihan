package apotik.model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import apotik.entity.Obat;
public class ObatTableModel extends AbstractTableModel{
    private List<Obat> rows;
    public ObatTableModel (List<Obat> list){
        rows = list;
    }
    @Override
    public int getRowCount(){
        return rows.size();
    }
    @Override
    public int getColumnCount(){
        return 4;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        Obat perkiraan = rows.get(rowIndex);
        switch(columnIndex){
            case 0:
                return perkiraan.getKode();
            case 1:
                return perkiraan.getNama();
            case 2:
                return perkiraan.getKategori();
            case 3:
                return perkiraan.getHarga_satuan();
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
                return "Nama";
            case 2:
                return "Kategori";
            case 3:
                return "Harga Satuan";
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
            case 2:
                return String.class;
            case 3:
                return String.class;
            default :
                return super.getColumnClass(columnIndex);
        }
    }
    
    public void setRows(List<Obat> list){
        rows = list;
    }
    public List<Obat> getRows(){
        return rows;
    }
    
}
