/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dialogController;

import Language.LanguageSupport;
import communication.Communication;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
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
        setLanguage();
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
                        JOptionPane.showMessageDialog(td, LanguageSupport.getText("create_appointment_success"),LanguageSupport.getText("create_appointment_title"),JOptionPane.INFORMATION_MESSAGE);
                        td.dispose();
                        td.getController().fillTable(null);
                    }


                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(td, ex.getMessage(),LanguageSupport.getText("create_appointment_title"),JOptionPane.ERROR_MESSAGE);
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
                    td.getjLabelDate().setText(LanguageSupport.getText("choose_date"));
                }else if (date.isBefore(LocalDate.now())) {
                    valid = false;
                    td.getjLabelDate().setText(LanguageSupport.getText("choose_date_future_invalid"));
                }
                
                Date vremeOdDate = (Date) td.getjSpinnerVremeOd().getValue();
                LocalTime vremeOd = vremeOdDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

                Date vremeDoDate = (Date) td.getjSpinnerVremeDo().getValue();
                LocalTime vremeDo = vremeDoDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
                
                if (!vremeDo.isAfter(vremeOd)) {
                    valid = false;
                    td.getjLabelVremeDo().setText(LanguageSupport.getText("appointment_time_from_validation"));
                }

                int brojSati = (int) Duration.between(vremeOd, vremeDo).toHours();

                int maxBrojSkijasa = 0;
                try {
                    td.getjSpinnerBrojSkijasa().commitEdit();
                    maxBrojSkijasa = (int) td.getjSpinnerBrojSkijasa().getValue();

                    if (maxBrojSkijasa <= 0) {
                        td.getjLabelBroj().setText(LanguageSupport.getText("appointment_skiers_number_validation_invalid"));
                        valid = false;
                    }
                } catch (ParseException | ClassCastException e) {
                    td.getjLabelBroj().setText(LanguageSupport.getText("appointment_skiers_number_validation_invalid"));
                    valid = false;
                }
                TipTermina tip = (TipTermina) td.getjComboBoxTipTermina().getSelectedItem();
                if(tip==null){
                    valid = false;
                    td.getjLabelTip().setText(LanguageSupport.getText("appointment_type_validation_empty"));
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
            JOptionPane.showMessageDialog(td, LanguageSupport.getText("loading_appointment")+"\n"+ex.getMessage(),LanguageSupport.getText("error_loading_appointment"),JOptionPane.ERROR_MESSAGE);
        }
            
    }

    private void setLanguage() {
        td.getjLabel1().setText(LanguageSupport.getText("create_appointment_dialog_title"));
        td.getjLabel2().setText(LanguageSupport.getText("date"));
        td.getjLabel3().setText(LanguageSupport.getText("time_from"));
        td.getjLabel4().setText(LanguageSupport.getText("time_to"));
        td.getjLabel5().setText(LanguageSupport.getText("skiers_num"));
        td.getjLabel7().setText(LanguageSupport.getText("type_of_appointment"));
        td.getjButtonAdd().setText(LanguageSupport.getText("add_btn"));
        td.getjButtonBack().setText(LanguageSupport.getText("back_btn"));
        td.setTitle(LanguageSupport.getText("create_appointment_title"));
    }
    
    
}
