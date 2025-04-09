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
            
                    Date utilDate = td.getjDateChooser().getDate();
                    LocalDate date = (utilDate == null) ? null : utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                    if (date == null) {
                        JOptionPane.showMessageDialog(td, "Molimo izaberite datum!", "Greška", JOptionPane.ERROR_MESSAGE);
                        return;
                    }   
                    if (date.isBefore(LocalDate.now())) {
                        JOptionPane.showMessageDialog(td, "Ne možete zakazati termin u prošlosti!", "Greška", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Date vremeOdDate = (Date) td.getjSpinnerVremeOd().getValue();
                    LocalTime vremeOd = vremeOdDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

                    Date vremeDoDate = (Date) td.getjSpinnerVremeDo().getValue();
                    LocalTime vremeDo = vremeDoDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

                    if (vremeDo.isBefore(vremeOd)) {
                        JOptionPane.showMessageDialog(td, "Vreme završetka ne može biti pre početka!", "Greška", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    System.out.println("Vreme od: " + vremeOd);
                    System.out.println("Vreme do: " + vremeDo);

                    int brojSati = (int) Duration.between(vremeOd, vremeDo).toHours();
                    System.out.println("Broj sati: " + brojSati);

                    int maxBrojSkijasa = (int) td.getjSpinnerBrojSkijasa().getValue();

                    if (maxBrojSkijasa<=0) {
                        JOptionPane.showMessageDialog(td, "Broj skijaša mora biti veći od 0!", "Greška", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    TipTermina tip = (TipTermina) td.getjComboBoxTipTermina().getSelectedItem();
                    if(tip==null){
                        JOptionPane.showMessageDialog(td, "Izaberite tip termina!", "Greška", JOptionPane.ERROR_MESSAGE);
                        return;
                    }


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
                        JOptionPane.showMessageDialog(td, "Termin uspešno kreiran!","Kreiranje termina",JOptionPane.INFORMATION_MESSAGE);
                        td.dispose();
                        td.getController().fillTable(null);
                    }


                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(td, "Termin nije kreiran!"+ex.getMessage(),"Kreiranje termina",JOptionPane.ERROR_MESSAGE);
                }
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
