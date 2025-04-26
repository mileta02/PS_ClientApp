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
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import model.Instruktor;
import model.Termin;
import model.TipTermina;
import table_model.TerminTableModel;
import uidialog.TerminDetaljiDialog;
import uidialog.TerminDialog;
import uiform.TerminForm;

/**
 *
 * @author milan
 */
public class TerminFormController {
    private TerminForm tf;

    public TerminFormController(TerminForm tf) {
        this.tf = tf;
        addActionListener();
    }
    
    public void openForm(){
        fillComboBoxes();
        fillTable(null);
        tf.setVisible(true);
    }

    private void addActionListener() {
        tf.searchActionsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    defaultBorders();
                    Termin ter = new Termin();
                    if(!validation(ter))
                        return;

                    List<Termin> list = Communication.getInstance().vratiListuTermin(ter);
                    if(list.isEmpty()){
                        JOptionPane.showMessageDialog(tf, "Sistem ne može da nadje termine po zadatim kriterijumima.","Filtriranje podataka",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    JOptionPane.showMessageDialog(tf, "Sistem je našao termine po zadatim kriterijumima.","Filtriranje podataka",JOptionPane.INFORMATION_MESSAGE);
                    fillTable(list);


                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(tf, "Greska prilikom filtriranja termina.\n"+ex.getMessage(),"Filtriranje podataka",JOptionPane.ERROR_MESSAGE);
                }
            }

            private boolean validation(Termin ter) {
                boolean valid = true;
                String numText = tf.getjTextFieldNum().getText().trim();
                Instruktor i = (Instruktor) tf.getjComboInstruktor().getSelectedItem();
                TipTermina t = (TipTermina) tf.getjComboTipTermina().getSelectedItem();
                
                if(i==null && t==null && numText.isBlank() && !tf.getjCheckBoxFuture().isSelected()){
                    JOptionPane.showMessageDialog(tf, "Unesite  kriterijum pretrage","Pretraga",JOptionPane.INFORMATION_MESSAGE);
                    return false;
                }
                LocalDate date = (tf.getjCheckBoxFuture().isSelected()) ? LocalDate.now() : null;;
                int num = 0;
                if(!numText.isBlank()){
                         try {
                            num = Integer.parseInt(numText);
                            if(num<=0)
                                throw new Exception("Broj manji od 0");
                        } catch (Exception ex) {
                            tf.getjTextFieldNum().setBorder(new LineBorder(Color.RED,2));
                            valid = false;
                        }
                    }

                if(!valid){
                    JOptionPane.showMessageDialog(tf, "Pogrešan unos","Pretraga",JOptionPane.WARNING_MESSAGE);
                    return false;
                }
                ter.setDatum(date);
                ter.setInstruktor(i);
                ter.setMaxBrojSkijasa(num);
                ter.setTipTermina(t);
                return valid;
            }
        });
        
        tf.clearFilterActionsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.getjComboInstruktor().setSelectedItem(null);
                tf.getjComboTipTermina().setSelectedItem(null);
                tf.getjTextFieldNum().setText("");
                tf.getjCheckBoxFuture().setSelected(false);
                defaultBorders();
                fillTable(null);
            }
        });
        
        tf.addActionsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cordinator.getInstance().openTerminDialog(tf);
            }
        });
        
        tf.detailsActionsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tf.getjTableTermin().getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(tf, "Morate izabrati termin!", "Greška", JOptionPane.WARNING_MESSAGE);
                    return;
                }   

                TerminTableModel ttm = (TerminTableModel) tf.getjTableTermin().getModel();
                List<Termin> list = ttm.getList();
                Termin t = list.get(row);
                Cordinator.getInstance().openTerminDetaljiDialog(tf, t);
            }
        });
        
        tf.backActionsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.dispose();
            }
        });
    }
    
    public void fillTable(List<Termin> list) {
        try {
            if(list==null)
                list = Communication.getInstance().vratiListuSviTermin();
            TerminTableModel ttm = new TerminTableModel(list);
            tf.getjTableTermin().setModel(ttm);
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(tf, "Greska prilikom punjenja tabele."+ex.getMessage(),"Punjenje tabele",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void fillComboBoxes() {
        try {
            List<Instruktor> listIns = Communication.getInstance().vratiListuSviInstruktor();
            for(Instruktor i : listIns){
                tf.getjComboInstruktor().addItem(i);
            }
            tf.getjComboInstruktor().setSelectedItem(null);
            
            List<TipTermina> listTip = Communication.getInstance().vratiListuSviTipTermina();
            for(TipTermina t : listTip){
                tf.getjComboTipTermina().addItem(t);
            }
            tf.getjComboTipTermina().setSelectedItem(null);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(tf, "Greska prilikom punjenja CB."+ex.getMessage(),"Punjenje CB",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void defaultBorders() {
        tf.getjTextFieldNum().setBorder(new LineBorder(Color.black,1));
    }
    
}
