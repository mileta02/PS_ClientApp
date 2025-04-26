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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Instruktor;
import model.Skijas;
import model.Termin;
import model.TerminSkijas;
import model.TipTermina;
import table_model.TerminSkijasTableModel;
import uidialog.TerminDetaljiDialog;

/**
 *
 * @author milan
 */
public class TerminDetaljiDialogController {
    private TerminDetaljiDialog tdd;

    public TerminDetaljiDialogController(TerminDetaljiDialog tdd) {
        this.tdd = tdd;
        addActionListener();
    }
    
    public void openForm(){
        fillComboBoxes();
        fillFields();
        fillTable();
        configureFields(false);
        configureVisibility();
        tdd.setLocationRelativeTo(null);
        tdd.setVisible(true);
    }

    private void addActionListener() {
        tdd.changeActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tdd.getjButtonChange().setVisible(false);
                tdd.getjButtonSave().setVisible(true);
                configureFields(true);
            }
        });
        
        tdd.saveActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!validation(tdd.getT()))
                    return;

            try {
                boolean b = Communication.getInstance().promeniTermin(tdd.getT());
                JOptionPane.showMessageDialog(tdd, "Sistem je zapamtio termin.","Ažuriranje termina",JOptionPane.INFORMATION_MESSAGE);
                tdd.getController().fillTable(null);
                
                tdd.getjButtonChange().setVisible(true);
                tdd.getjButtonSave().setVisible(false);
                configureFields(false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(tdd, ex.getMessage(),"Ažuriranje termina",JOptionPane.ERROR_MESSAGE);
            }
                }

            private boolean validation(Termin t) {
                tdd.getjLabelDate().setText("");
                tdd.getjLabelVremeOd().setText("");
                tdd.getjLabelVremeDo().setText("");
                tdd.getjLabelNum().setText("");
                tdd.getjLabelTip().setText("");
                boolean valid = true;
                Date utilDate = tdd.getjDateChooser().getDate();
                LocalDate date = (utilDate == null) ? null : utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                if (date == null) {
                    valid = false;
                    tdd.getjLabelDate().setText("Unesite datum");
                }else if (date.isBefore(LocalDate.now())) {
                    valid = false;
                    tdd.getjLabelDate().setText("Datum se mora odnositi na budućnost");
                }

                Date vremeOdDate = (Date) tdd.getjSpinnerVremeOd().getValue();
                LocalTime vremeOd = vremeOdDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

                Date vremeDoDate = (Date) tdd.getjSpinnerVremeDo().getValue();
                LocalTime vremeDo = vremeDoDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

                if (vremeDo.isBefore(vremeOd)) {
                    valid = false;
                    tdd.getjLabelVremeDo().setText("Vreme do mora biti nakon vremena od");
                }


                int brojSati = (int) Duration.between(vremeOd, vremeDo).toHours();

                int maxBrojSkijasa = (int) tdd.getjSpinnerBrojSkijasa().getValue();
                
                if (maxBrojSkijasa<=0) {
                    valid = false;
                    tdd.getjLabelNum().setText("Broj skijaša mora biti veći od 0");
                } else if (maxBrojSkijasa<brojSkijasa()){
                    valid = false;
                    tdd.getjLabelNum().setText("Broj skijaša mora biti veći od ["+brojSkijasa()+"]");
                }

                TipTermina tip = (TipTermina) tdd.getjComboBoxTipTermina().getSelectedItem();
                if(tip==null){
                    valid = false;
                    tdd.getjLabelTip().setText("Izaberite tip termina");
                }

                TerminSkijasTableModel stm = (TerminSkijasTableModel) tdd.getjTableSkijasi().getModel();
                int brojSkijasa = stm.getList().size();
                double ukupanIznos = brojSkijasa*brojSati*tip.getCenaSata();
                
                if(!valid)
                    return valid;
                if(tdd.getT().getBrojSati() == brojSati && tdd.getT().getMaxBrojSkijasa() == maxBrojSkijasa && tdd.getT().getDatum().isEqual(date) &&
                        tdd.getT().getVremeDo().equals(vremeDo) && tdd.getT().getVremeOd().equals(vremeOd) && tdd.getT().getTipTermina().equals(tip)){
                    JOptionPane.showMessageDialog(tdd, "Niste izmenili podatke");
                    return false;
            }
                tdd.getT().setBrojSati(brojSati);
                tdd.getT().setMaxBrojSkijasa(maxBrojSkijasa);
                tdd.getT().setDatum(date);
                tdd.getT().setVremeOd(vremeOd);
                tdd.getT().setVremeDo(vremeDo);
                tdd.getT().setTipTermina(tip);
                tdd.getT().setUkupanIznos(ukupanIznos);
                
                return valid;
        }
        });
        
        tdd.deleteActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i =JOptionPane.showConfirmDialog(tdd, "Da li ste sigurni da želite da obrišete termin?","Brisanje termina",JOptionPane.YES_NO_OPTION);
        
                if(i == JOptionPane.YES_OPTION){
                    try {
                        boolean b = Communication.getInstance().obrisiTermin(tdd.getT());
                        if(b){
                            JOptionPane.showMessageDialog(tdd, "Sistem je obrisao termin..","Brisanje termina",JOptionPane.INFORMATION_MESSAGE);
                            tdd.getController().fillTable(null);
                            tdd.dispose();
                            }
                    } catch (Exception ex) {
                    JOptionPane.showMessageDialog(tdd, ex.getMessage(),"Brisanje termina",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        
        tdd.addSkijasActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = brojSkijasa();
                if(num==tdd.getT().getMaxBrojSkijasa()){
                    JOptionPane.showMessageDialog(tdd, "Dostigli se maksimalan broj skijaša za izabrani termin","Dodavanje skijaša",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                TerminSkijas ts = new TerminSkijas((Skijas) tdd.getjComboBoxSkijas().getSelectedItem(), tdd.getT(), LocalDate.now());
                try {
                    boolean b = Communication.getInstance().kreirajTerminSkijas(ts);
                    if(b){
                        updateTerminPrice(num + 1);
                        Communication.getInstance().promeniTermin(tdd.getT());
                        JOptionPane.showMessageDialog(tdd, "Sistem je zapamtio skijaša.","Dodavanje skijaša",JOptionPane.INFORMATION_MESSAGE);
                        fillTable();
                        tdd.getController().fillTable(null);
                    }
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(tdd, "Sistem ne može da zapamti skijaša."+ex.getMessage(),"Dodavanje skijaša",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        tdd.deleteSkijasActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = brojSkijasa();
                System.out.println(num);
                if(num==0){
                    JOptionPane.showMessageDialog(tdd, "Ne postoji skijaš za izabrani termin","Brisanje skijaša",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                int row = tdd.getjTableSkijasi().getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(tdd, "Morate izabrati skijaša", "Greška", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                TerminSkijasTableModel tstm = (TerminSkijasTableModel) tdd.getjTableSkijasi().getModel();
                List<TerminSkijas> list = tstm.getList();
                TerminSkijas ts = list.get(row);

                try {
                    boolean b = Communication.getInstance().obrisiTerminSkijas(ts);
                    if(b){
                        updateTerminPrice(num - 1);
                        Communication.getInstance().promeniTermin(tdd.getT());
                        JOptionPane.showMessageDialog(tdd, "Sistem je obrisao skijaša","Brisanje skijaša",JOptionPane.INFORMATION_MESSAGE);
                        fillTable();
                        tdd.getController().fillTable(null);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(tdd, ex.getMessage(),"Brisanje skijaša",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        tdd.backActionListener((ActionEvent e) -> {
            tdd.dispose();
        });
    }
    
    private void fillComboBoxes() {
        try {
            List<Instruktor> listIns = Communication.getInstance().vratiListuSviInstruktor();
            for(Instruktor i : listIns){
                tdd.getjComboBoxInstruktor().addItem(i);
            }
            
            List<TipTermina> listTip = Communication.getInstance().vratiListuSviTipTermina();
            for(TipTermina t : listTip){
                tdd.getjComboBoxTipTermina().addItem(t);
            }
            
            List<Skijas> listSki = Communication.getInstance().vratiListuSviSkijas();
            for(Skijas s : listSki){
                tdd.getjComboBoxSkijas().addItem(s);
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(tdd, "Greska prilikom punjenja CB."+ex.getMessage(),"Punjenje CB",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void fillFields() {
        tdd.getjDateChooser().setDate(Date.from(tdd.getT().getDatum().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        tdd.getjSpinnerVremeOd().setValue(java.sql.Time.valueOf(tdd.getT().getVremeOd()));
        tdd.getjSpinnerVremeDo().setValue(java.sql.Time.valueOf(tdd.getT().getVremeDo()));
        tdd.getjSpinnerBrojSkijasa().setValue(tdd.getT().getMaxBrojSkijasa());
        
        for(int i=0;i<tdd.getjComboBoxInstruktor().getItemCount();i++){
            if(tdd.getjComboBoxInstruktor().getItemAt(i).equals(tdd.getT().getInstruktor())){
                tdd.getjComboBoxInstruktor().setSelectedIndex(i);
                break;
            }
        }
        
        for(int i=0;i<tdd.getjComboBoxTipTermina().getItemCount();i++){
            if(tdd.getjComboBoxTipTermina().getItemAt(i).equals(tdd.getT().getTipTermina())){
                tdd.getjComboBoxTipTermina().setSelectedIndex(i);
                break;
            }
        }
    }

    private void configureFields(boolean b) {
        
        tdd.getjComboBoxInstruktor().setEnabled(false);
        tdd.getjComboBoxTipTermina().setEnabled(b);
        tdd.getjSpinnerVremeDo().setEnabled(b);
        tdd.getjSpinnerVremeOd().setEnabled(b);
        tdd.getjSpinnerBrojSkijasa().setEnabled(b);
        tdd.getjDateChooser().setEnabled(b);
    }

    private void fillTable() {
        try {
            List<TerminSkijas> list = Communication.getInstance().vratiListuTerminSkijas(tdd.getT());
            TerminSkijasTableModel tstm = new TerminSkijasTableModel(list);
            tdd.getjTableSkijasi().setModel(tstm);
        } catch (Exception ex) {
            Logger.getLogger(TerminDetaljiDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void configureVisibility() {
        tdd.getjButtonSave().setVisible(false);
        boolean my = tdd.getT().getInstruktor().equals(tdd.getParent().getUlogovan());
        boolean date = tdd.getT().getDatum().isBefore(LocalDate.now());
        boolean visible = true;
            if(!my || date)
                visible = false;
//        tdd.getjButtonDelete().setVisible(visible);
//        tdd.getjButtonAddSkijas().setVisible(visible);
//        tdd.getjButtonChange().setVisible(visible);
//        tdd.getjButtonDeleteSkijas().setVisible(visible);
//        tdd.getjComboBoxSkijas().setVisible(visible);
        tdd.getjButtonDelete().setEnabled(visible);
        tdd.getjButtonAddSkijas().setEnabled(visible);
        tdd.getjButtonChange().setEnabled(visible);
        tdd.getjButtonDeleteSkijas().setEnabled(visible);
        tdd.getjComboBoxSkijas().setEnabled(visible);
        tdd.getjTableSkijasi().setEnabled(visible);
    }
    
    private void updateTerminPrice(int num){
        double cena = tdd.getT().getBrojSati() * tdd.getT().getTipTermina().getCenaSata() * num;
        tdd.getT().setUkupanIznos(cena);
    }
    private int brojSkijasa() {
        TerminSkijasTableModel tstm = (TerminSkijasTableModel) tdd.getjTableSkijasi().getModel();
        List<TerminSkijas> list = tstm.getList();
        return list.size();
    }
}
