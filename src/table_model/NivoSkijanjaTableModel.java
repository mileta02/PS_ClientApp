/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table_model;

import Language.LanguageSupport;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.NivoSkijanja;

/**
 *
 * @author milan
 */
public class NivoSkijanjaTableModel extends AbstractTableModel {
    
    private List<NivoSkijanja> list;
    private String[] columns={LanguageSupport.getText("ski_level_name")};
    
    public List<NivoSkijanja> getList() {
        return list;
    }
    
    public NivoSkijanjaTableModel(List<NivoSkijanja> list){
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
        NivoSkijanja ns = list.get(rowIndex);
        return ns.getNazivNivoa();
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    
    
}
