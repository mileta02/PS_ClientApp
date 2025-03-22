/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table_model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Skijas;
import model.TerminSkijas;

/**
 *
 * @author milan
 */
public class TerminSkijasTableModel extends AbstractTableModel {
    private List<TerminSkijas> list;
    private String[] columns = {"Ime","Prezime","Broj telefona","Nivo skijanja","Datum prijave"};

    public List<TerminSkijas> getList() {
        return list;
    }
    
    
    
    public TerminSkijasTableModel(List<TerminSkijas> list){
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
        TerminSkijas ts = list.get(rowIndex);
        
        switch(columnIndex){
            case 0: return ts.getSkijas().getIme();
            case 1: return ts.getSkijas().getPrezime();
            case 2: return ts.getSkijas().getBrojTelefona();
            case 3: return ts.getSkijas().getNivoSkijanja().getNazivNivoa();
            case 4: return ts.getDatumPrijave();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}
