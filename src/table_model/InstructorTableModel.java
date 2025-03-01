package table_model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Instruktor;

/**
 *
 * @author milan
 */
public class InstructorTableModel extends AbstractTableModel {
    private String[] columns = {"Ime","Prezime","Kontakt"};
    private List<Instruktor> list = new ArrayList<>();
    
    public InstructorTableModel(List<Instruktor> list){
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
        Instruktor i = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return i.getIme();
            case 1:
                return i.getPrezime();
            case 2:
                return i.getKontakt();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    
}
