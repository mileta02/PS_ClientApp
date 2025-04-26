/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dialogController;

import communication.Communication;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.Termin;
import model.TipTermina;
import uidialog.TerminDialog;

/**
 *
 * @author milan
 */
public class TerminDialogController {
    private TerminDialog td;

    public TerminDialogController(TerminDialog td) {
        this.td = td;
        addActionListener();
    }
    
    public void openForm(){
        fillComboBox();
        td.setLocationRelativeTo(null);
        td.setVisible(true);
    }

    private void addActionListener() {
        td.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(!validation())
                        return;
                    Date utilDate = td.getjDateChooser().getDate();
                    LocalDate date = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                    Date vremeOdDate = (Date) td.getjSpinnerVremeOd().getValue();
                    LocalTime vremeOd = vremeOdDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

                    Date vremeDoDate = (Date) td.getjSpinnerVremeDo().getValue();
                    LocalTime vremeDo = vremeDoDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

                    int brojSati = (int) Duration.between(vremeOd, vremeDo).toHours();
                    int maxBrojSkijasa = (int) td.getjSpinnerBrojSkijasa().getValue();

                    TipTermina tip = (TipTermina) td.getjComboBoxTipTermina().getSelectedItem();

                    Termin t = new Termin();
                    t.setBrojSati(brojSati);
                    t.setDatum(date);
                    t.setVremeOd(vremeOd);
                    t.setVremeDo(vremeDo);
                    t.setMaxBrojSkijasa(maxBrojSkijasa);
                    t.setTipTermina(tip);
                    t.setInstruktor(td.getUlogovan());

                    boolean b = Communication.getInstance().kreirajTermin(t);
                    if(b){
                        JOptionPane.showMessageDialog(td, "Sistem je kreirao termin","Kreiranje termina",JOptionPane.INFORMATION_MESSAGE);
                        td.dispose();
                        td.getController().fillTable(null);
                    }


                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(td, ex.getMessage(),"Kreiranje termina",JOptionPane.ERROR_MESSAGE);
                }
            }

            private boolean validation() {
                td.getjLabelDate().setText("");                
                td.getjLabelTip().setText("");
                td.getjLabelVremeDo().setText("");
                td.getjLabelVremeOd().setText("");
                td.getjLabelBroj().setText("");

                Date utilDate = td.getjDateChooser().getDate();
                LocalDate date = (utilDate == null) ? null : utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                boolean valid = true;
                if (date == null) {
                    valid = false;
                    td.getjLabelDate().setText("Unesite datum");
                }else if (date.isBefore(LocalDate.now())) {
                    valid = false;
                    td.getjLabelDate().setText("Datum se mora odnositi na budućnost");
                }
                
                Date vremeOdDate = (Date) td.getjSpinnerVremeOd().getValue();
                LocalTime vremeOd = vremeOdDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

                Date vremeDoDate = (Date) td.getjSpinnerVremeDo().getValue();
                LocalTime vremeDo = vremeDoDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
                
                if (vremeDo.isBefore(vremeOd)) {
                    valid = false;
                    td.getjLabelVremeDo().setText("Vreme do mora biti nakon vremena od");
                }

                int brojSati = (int) Duration.between(vremeOd, vremeDo).toHours();
                int maxBrojSkijasa = (int) td.getjSpinnerBrojSkijasa().getValue();

                if (maxBrojSkijasa<=0) {
                    td.getjLabelBroj().setText("Broj skijaša mora biti veći od 0");
                    valid = false;
                }

                TipTermina tip = (TipTermina) td.getjComboBoxTipTermina().getSelectedItem();
                if(tip==null){
                    valid = false;
                    td.getjLabelTip().setText("Unesite tip termina");
                }
                return valid;
            }
        });
        td.backActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                td.dispose();
            }
        });
    }
    
    private void fillComboBox() {
        List<TipTermina> listTip;
        try {
            listTip = Communication.getInstance().vratiListuSviTipTermina();
            for(TipTermina t : listTip){
                td.getjComboBoxTipTermina().addItem(t);
            }
            td.getjComboBoxTipTermina().setSelectedItem(null);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(td, "Greska prilikom punjenja CB."+ex.getMessage(),"Punjenje CB",JOptionPane.ERROR_MESSAGE);
        }
            
    }
    
    
}
