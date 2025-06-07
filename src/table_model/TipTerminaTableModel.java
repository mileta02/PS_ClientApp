/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table_model;

import Language.LanguageSupport;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.TipTermina;

/**
 *
 * @author milan
 */
public class TipTerminaTableModel extends AbstractTableModel {
    
    private List<TipTermina> list;
    private String[] columns = {LanguageSupport.getText("type_name"),LanguageSupport.getText("type_price")};
    
    public TipTerminaTableModel(List<TipTermina> list){
        this.list=list;
    }

    public List<TipTermina> getList() {
        return list;
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
        TipTermina tt = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return tt.getNazivTipa();
            case 1:
                return tt.getCenaSata();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    
    
}
