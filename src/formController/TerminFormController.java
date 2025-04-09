/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formController;

import communication.Communication;
import cordinator.Cordinator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
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
                    LocalDate date;
                    if(tf.getjCheckBoxFuture().isSelected())
                        date = LocalDate.now();
                    else
                        date=null;

                    int num = 0;
                    String numText = tf.getjTextFieldNum().getText().trim();
                    if(!numText.isEmpty()){
                         try {
                            num = Integer.parseInt(numText);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(tf, "Broj skijaša mora biti validan broj!", "Greška", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                    }
                    Instruktor i = (Instruktor) tf.getjComboInstruktor().getSelectedItem();
                    TipTermina t = (TipTermina) tf.getjComboTipTermina().getSelectedItem();

                    if(i==null && t==null && numText.isEmpty() && !tf.getjCheckBoxFuture().isSelected()){
                        JOptionPane.showMessageDialog(tf, "Unesite  kriterijum pretrage","Pretraga",JOptionPane.INFORMATION_MESSAGE);
                    }

                    Termin ter = new Termin();
                    ter.setDatum(date);
                    ter.setInstruktor(i);
                    ter.setMaxBrojSkijasa(num);
                    ter.setTipTermina(t);


                    List<Termin> list = Communication.getInstance().vratiListuTermin(ter);
                    fillTable(list);


                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(tf, "Greska prilikom filtriranja termina.\n"+ex.getMessage(),"Filtriranje podataka",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        tf.clearFilterActionsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.getjComboInstruktor().setSelectedItem(null);
                tf.getjComboTipTermina().setSelectedItem(null);
                tf.getjTextFieldNum().setText("");
                tf.getjCheckBoxFuture().setSelected(false);
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
    
}
