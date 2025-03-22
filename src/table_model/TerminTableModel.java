/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table_model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Termin;

/**
 *
 * @author milan
 */
public class TerminTableModel extends AbstractTableModel {

    private String[] columns = {"Instruktor","Datum","Vreme od","Vreme do","Broj sati","Broj skijasa","Tip termina"};
    private List<Termin> list;

    public List<Termin> getList() {
        return list;
    }
    
    
    
    public TerminTableModel(List<Termin> list){
        this.list=list;
    }
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Termin t = list.get(rowIndex);
        switch(columnIndex){
            case 0: return t.getInstruktor();
            case 1: return t.getDatum();
            case 2: return t.getVremeOd();
            case 3: return t.getVremeDo();
            case 4: return t.getBrojSati();
            case 5: return t.getMaxBrojSkijasa();
            case 6: return t.getTipTermina().getNazivTipa();
            default: return "";
        }
    }

    @Override
     public String getColumnName(int column) {
         return columns[column];
    }
    
    
    
}
