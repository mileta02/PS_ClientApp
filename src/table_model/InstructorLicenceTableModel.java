/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table_model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.InstruktorLicenca;
import model.Licenca;

/**
 *
 * @author milan
 */
public class InstructorLicenceTableModel extends AbstractTableModel {
    
    private String[] columns={"Naziv licence","Zvanje instruktora","Godina sticanja"};
    private List<InstruktorLicenca> list;

    public List<InstruktorLicenca> getList() {
        return list;
    }
    
    
    
    public InstructorLicenceTableModel(List<InstruktorLicenca> list){
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
        InstruktorLicenca l = list.get(rowIndex);
        switch(columnIndex){
            case 0: 
                return l.getLicenca().getNazivLicence();
            case 1:
                return l.getLicenca().getZvanjeInstruktora();
            case 2:
                return l.getGodinaSticanja();
            default: 
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    
    
}
