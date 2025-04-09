/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dialogController;

import communication.Communication;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.TipTermina;
import uidialog.TipTerminaDialog;

/**
 *
 * @author milan
 */
public class TipTerminaDialogController {
    private TipTerminaDialog ttd;

    public TipTerminaDialogController(TipTerminaDialog ttd) {
        this.ttd = ttd;
        addActionListener();
    }
    
    public void openForm(){
        ttd.setLocationRelativeTo(null);
        fillFields();
        ttd.setVisible(true);
    }

    private void addActionListener() {
        ttd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!validation())
                    return;
                String name = ttd.getjTextFieldName().getText();
                String priceString = ttd.getjTextFieldPrice().getText();
                double price = Double.parseDouble(priceString);
                TipTermina tt = new TipTermina();
                tt.setCenaSata(price);
                tt.setNazivTipa(name);

                try {
                    boolean b = Communication.getInstance().kreirajTipTermina(tt);
                    if(b){
                        JOptionPane.showMessageDialog(ttd, "Uspešno kreiran tip termina.","Kreiranje tipa termina",JOptionPane.INFORMATION_MESSAGE);
                        ttd.dispose();
                        ttd.getController().fillTable(null);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ttd, "Greška prilikom kreiranja tipa termina.\n"+ex.getMessage(),"Kreiranje tipa termina",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        ttd.changeActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ttd.getjButtonChange().setVisible(false);
                ttd.getjButtonDelete().setVisible(false);
                ttd.getjButtonSaveChanges().setEnabled(true);
                ttd.getjTextFieldName().setEnabled(true);
                ttd.getjTextFieldPrice().setEnabled(true);
            }
        });
        
        ttd.saveActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!validation() || !isEdited())
                    return;

                try{
                    String name = ttd.getjTextFieldName().getText();
                    double price = Double.parseDouble(ttd.getjTextFieldPrice().getText());
                    ttd.getTt().setNazivTipa(name);
                    ttd.getTt().setCenaSata(price);
                    boolean b = Communication.getInstance().promeniTipTermina(ttd.getTt());
                    if(b){
                        JOptionPane.showMessageDialog(ttd, "Uspešno ažuriran tip termina.","Ažuriranje tipa termina",JOptionPane.INFORMATION_MESSAGE);
                        ttd.getController().fillTable(null);
                        ttd.dispose();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ttd, "Greška prilikom ažuriranja tipa termina. \n"+ex.getMessage(),"Ažuriranje tipa termina",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        ttd.deleteActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i =JOptionPane.showConfirmDialog(ttd, "Da li ste sigurni da želite da obrišete tip termina?","Brisanje tipa termina",JOptionPane.YES_NO_OPTION);
        
                if(i == JOptionPane.YES_OPTION){
                try {
                    boolean b = Communication.getInstance().obrisiTipTermina(ttd.getTt());
                    if(b){
                        JOptionPane.showMessageDialog(ttd, "Uspešno obrisan tip termina.","Brisanje tipa termina",JOptionPane.INFORMATION_MESSAGE);
                        ttd.getController().fillTable(null);
                        ttd.dispose();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ttd, "Greška prilikom brisanja tipa termina. \n"+ex.getMessage(),"Brisanje tipa termina",JOptionPane.ERROR_MESSAGE);
                }
                }
            }
        });
        
        ttd.backActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ttd.dispose();
            }
        });
    }
    
    private void fillFields() {
        if(ttd.getTt()==null){
            ttd.getjButtonDelete().setVisible(false);
            ttd.getjButtonChange().setVisible(false);
            ttd.getjButtonSaveChanges().setVisible(false);
        }else{
            ttd.getjButtonAdd().setVisible(false);
            ttd.getjButtonSaveChanges().setEnabled(false);
            ttd.getjTextFieldName().setText(ttd.getTt().getNazivTipa());
            ttd.getjTextFieldPrice().setText(Double.toString(ttd.getTt().getCenaSata()));
            ttd.getjTextFieldName().setEnabled(false);
            ttd.getjTextFieldPrice().setEnabled(false);
        }
    }
    
    private boolean validation(){
        String name = ttd.getjTextFieldName().getText();
        String priceString = ttd.getjTextFieldPrice().getText();
        double price = 0;
        
        boolean valid = true;
        if(name.isEmpty()){
            valid=false;
            ttd.getjLabelNameValidation().setText("Unesite naziv");
        }else if(!name.matches("^[a-zA-Z ]+$")){
            ttd.getjLabelNameValidation().setText("Naziv mora sadržati slova");
            valid=false;
        }
        if(priceString.isEmpty()){
            valid=false;
            ttd.getjLabelPriceValidation().setText("Popunite polje.");
        }else {
            try {
                price = Double.parseDouble(priceString);
                if (price < 0) {
                    valid = false;
                    ttd.getjLabelPriceValidation().setText("Cena mora biti pozitivan broj");
                } else {
                    ttd.getjLabelPriceValidation().setText("");
                }
            } catch (NumberFormatException e) {
                valid = false;
                ttd.getjLabelPriceValidation().setText("Unesite validan broj");
            }
        }
        return true;
    }

    private boolean isEdited() {
        if(ttd.getTt().getNazivTipa().equals(ttd.getjTextFieldName().getText()) && ttd.getTt().getCenaSata()==Double.parseDouble(ttd.getjTextFieldPrice().getText())){
            ttd.getjLabelNameValidation().setText("Niste izvršili izmenu");
            ttd.getjLabelPriceValidation().setText("Niste izvršili izmenu");
            return false;
        }
        return true;
    }
}
