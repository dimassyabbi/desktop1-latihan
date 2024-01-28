/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pemrograman_berbasis_dekstop.model;
import java.util.*;
import javax.swing.table.AbstractTableModel;
import pemrograman_berbasis_dekstop.entity.Pelanggan;
/**
 *
 * @author user
 */
public class PelangganTableModel extends AbstractTableModel{
    private List<Pelanggan> rows;
    
    public PelangganTableModel(List<Pelanggan> list){
        rows = list;
    }
    public int getRowCount() {
        return rows.size();
    }
    public int getColumnCount() {
        return 4;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex){
        Pelanggan perkiraan1 = rows.get(rowIndex);
        switch(columnIndex){
            case 0 :
                return perkiraan1.getKode();
            case 1 :
                return perkiraan1.getNama();
            case 2 :
                return perkiraan1.getAlamat();
            case 3 :
                return perkiraan1.getTelepon();
            default :
                return null;
        }
    }
    public String getColumnName(int column){
        switch(column){
            case 0 : 
                return "Kode";
            case 1 :
                return "Nama";
            case 2 :
                return "Alamat";
            case 3 :
                return "Telepon";
            default :
                return null;
                
        }
    }
    public Class<?> getColumnClass (int columnIndex) { 
        switch(columnIndex) { 
            case 0: 
            return String.class; 
            case 1: 
            case 2: 
            return String.class; 
            case 3: 
            return String.class; 
            default : 
            return super.getColumnClass (columnIndex); 
    } 
    } 
    public void setRows (List<Pelanggan> list) { 
        rows = list; 
    }
    public List<Pelanggan> getRows() { 
        return rows; 
    } 

} 


    
    
    

