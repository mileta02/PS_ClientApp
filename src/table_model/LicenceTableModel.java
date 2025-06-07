/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table_model;

import Language.LanguageSupport;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Licenca;

/**
 *
 * @author milan
 */
public class LicenceTableModel extends AbstractTableModel {
    
    private String[] columns={LanguageSupport.getText("licence_name"),LanguageSupport.getText("licence_title")};
    private List<Licenca> list;

    public List<Licenca> getList() {
        return list;
    }
    
    
    
    public LicenceTableModel(List<Licenca> list){
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
        Licenca l = list.get(rowIndex);
        switch(columnIndex){
            case 0: 
                return l.getNazivLicence();
            case 1:
                return l.getZvanjeInstruktora();
            default: 
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    
    
}
