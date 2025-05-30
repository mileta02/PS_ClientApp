/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formController;
import communication.Communication;
import cordinator.Cordinator;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import model.TipTermina;
import table_model.TipTerminaTableModel;
import uidialog.TipTerminaDialog;
import uiform.TipTerminaForm;
/**
 *
 * @author milan
 */
public class TipTerminaFormController {
    private TipTerminaForm ttf;

    public TipTerminaFormController(TipTerminaForm ttf) {
        this.ttf = ttf;
        addActionListener();
    }

    private void addActionListener() {
        ttf.searchActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    defaultBorders();
                    TipTermina tt = new TipTermina();
                    if(!validation(tt))
                        return;
                    
                    List<TipTermina> list = Communication.getInstance().vratiListuTipTermina(tt);
                    if(list.isEmpty()){
                        JOptionPane.showMessageDialog(ttf, "Sistem ne može da nadje tipove termina po zadatim kriterijumima.","Filtriranje podataka",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    JOptionPane.showMessageDialog(ttf, "Sistem je našao tipove termina po zadatim kriterijumima.","Filtriranje podataka",JOptionPane.INFORMATION_MESSAGE);
                    fillTable(list);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ttf, "Greska prilikom pretrage","Pretraga",JOptionPane.ERROR_MESSAGE);
                }
            }

            private boolean validation(TipTermina tt) {
                String name = ttf.getjTextFieldName().getText().trim();
                String priceFromString = ttf.getjTextFieldPriceFrom().getText().trim();
                String priceToString = ttf.getjTextFieldPriceTo().getText().trim();
                double priceFrom=-1;
                double priceTo=-1;
                boolean valid = true;

                if(name.isBlank()&& priceFromString.isBlank() && priceToString.isBlank()){
                    JOptionPane.showMessageDialog(ttf, "Unesite  kriterijum pretrage","Pretraga",JOptionPane.INFORMATION_MESSAGE);
                    return false;
                }

                if(!name.isBlank() && !name.matches("^[a-zA-Z ]+$")){
                    ttf.getjTextFieldName().setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                    valid = false;
                }

                if(!priceFromString.isBlank()){
                    try{
                        priceFrom=Double.parseDouble(priceFromString);
                    }catch(NumberFormatException ex){
                        ttf.getjTextFieldPriceFrom().setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                        valid=false;
                    }
                }
                if(!priceToString.isBlank()){
                    try{
                        priceTo=Double.parseDouble(priceToString);
                    }catch(NumberFormatException ex){
                        ttf.getjTextFieldPriceTo().setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                        valid=false;
                    }
                }
                if(!valid){
                    JOptionPane.showMessageDialog(ttf, "Pogrešan unos","Pretraga",JOptionPane.WARNING_MESSAGE);
                    return false;
                }
                tt.setNazivTipa(name);
                tt.filter(priceFrom, priceTo);
                return valid;
            }
        });
        
        ttf.clearFilterActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ttf.getjTextFieldName().setText("");
                ttf.getjTextFieldPriceFrom().setText("");
                ttf.getjTextFieldPriceTo().setText("");
                defaultBorders();
                fillTable(null);
            }
        });
        
        ttf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cordinator.getInstance().openTipTerminaDialog(ttf, null);
            }
        });
        
        ttf.detailsActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = ttf.getjTableTipTermina().getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(ttf, "Izaberite tip termina iz tabele","Pogrešan izbor",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                
                TipTerminaTableModel tttm = (TipTerminaTableModel) ttf.getjTableTipTermina().getModel();
                TipTermina tt = tttm.getList().get(row);
                Cordinator.getInstance().openTipTerminaDialog(ttf, tt);
            }
        });
        
        ttf.backActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ttf.dispose();
            }
        });
    }
    public void openForm(){
        fillTable(null);
        ttf.setVisible(true);
    }
    
     public void fillTable(List<TipTermina> list) {
        try {
            if(list==null)
                list = Communication.getInstance().vratiListuSviTipTermina();
            TipTerminaTableModel tttm = new TipTerminaTableModel(list);
            ttf.getjTableTipTermina().setModel(tttm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(ttf, "Greška prilikom učitavanja tipova termina.","Učitavanje tipova termina",JOptionPane.ERROR_MESSAGE);
            
        }
    }

    private void defaultBorders() {
        ttf.getjTextFieldName().setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        ttf.getjTextFieldPriceFrom().setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        ttf.getjTextFieldPriceTo().setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }

    private boolean validation() {
        String name = ttf.getjTextFieldName().getText();
        String priceFromString = ttf.getjTextFieldPriceFrom().getText();
        String priceToString = ttf.getjTextFieldPriceTo().getText();
        boolean valid = true;
            
        if(name.isEmpty() && priceFromString.isEmpty() && priceToString.isEmpty()){
            JOptionPane.showMessageDialog(ttf, "Unesite  kriterijum pretrage","Pretraga",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
            
        if(!name.isEmpty() && !name.matches("^[a-zA-Z ]+$")){
            ttf.getjTextFieldName().setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            valid = false;
        }
        
        if(!valid){
            JOptionPane.showMessageDialog(ttf, "Pogrešan unos","Pretraga",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
}
