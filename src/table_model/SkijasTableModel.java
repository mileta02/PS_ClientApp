/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table_model;

import Language.LanguageSupport;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Skijas;

/**
 *
 * @author milan
 */
public class SkijasTableModel extends AbstractTableModel {
    
    private List<Skijas> list;
    private String[] columns = {LanguageSupport.getText("name"),LanguageSupport.getText("surname"),LanguageSupport.getText("contact"),LanguageSupport.getText("ski_level")};

    public List<Skijas> getList() {
        return list;
    }
    
    
    
    public SkijasTableModel(List<Skijas> list){
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
        Skijas s = list.get(rowIndex);
        
        switch(columnIndex){
            case 0: return s.getIme();
            case 1: return s.getPrezime();
            case 2: return s.getBrojTelefona();
            case 3: return s.getNivoSkijanja().getNazivNivoa();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    
    
}
