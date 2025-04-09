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
                Date utilDate = tdd.getjDateChooser().getDate();
                LocalDate date = (utilDate == null) ? null : utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                if (date == null) {
                    JOptionPane.showMessageDialog(tdd, "Molimo izaberite datum!", "Greška", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (date.isBefore(LocalDate.now())) {
                    JOptionPane.showMessageDialog(tdd, "Ne možete zakazati termin u prošlosti!", "Greška", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Date vremeOdDate = (Date) tdd.getjSpinnerVremeOd().getValue();
                LocalTime vremeOd = vremeOdDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

                Date vremeDoDate = (Date) tdd.getjSpinnerVremeDo().getValue();
                LocalTime vremeDo = vremeDoDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

                if (vremeDo.isBefore(vremeOd)) {
                    JOptionPane.showMessageDialog(tdd, "Vreme završetka ne može biti pre početka!", "Greška", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                int brojSati = (int) Duration.between(vremeOd, vremeDo).toHours();

                int maxBrojSkijasa = (int) tdd.getjSpinnerBrojSkijasa().getValue();

                if (maxBrojSkijasa<=0) {
                    JOptionPane.showMessageDialog(tdd, "Broj skijaša mora biti veći od 0!", "Greška", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                TipTermina tip = (TipTermina) tdd.getjComboBoxTipTermina().getSelectedItem();
                if(tip==null){
                    JOptionPane.showMessageDialog(tdd, "Izaberite tip termina!", "Greška", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                TerminSkijasTableModel stm = (TerminSkijasTableModel) tdd.getjTableSkijasi().getModel();
                int brojSkijasa = stm.getList().size();
                double ukupanIznos = brojSkijasa*brojSati*tip.getCenaSata();

                tdd.getT().setBrojSati(brojSati);
                tdd.getT().setMaxBrojSkijasa(maxBrojSkijasa);
                tdd.getT().setDatum(date);
                tdd.getT().setVremeOd(vremeOd);
                tdd.getT().setVremeDo(vremeDo);
                tdd.getT().setTipTermina(tip);
                tdd.getT().setUkupanIznos(ukupanIznos);

            try {
                boolean b = Communication.getInstance().promeniTermin(tdd.getT());
                JOptionPane.showMessageDialog(tdd, "Termin uspešno izmenjen!","Ažuriranje termina",JOptionPane.INFORMATION_MESSAGE);
                tdd.getController().fillTable(null);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(tdd, "Termin nije izmenjen!"+ex.getMessage(),"Ažuriranje termina",JOptionPane.ERROR_MESSAGE);
            }
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
                            JOptionPane.showMessageDialog(tdd, "Uspešno obrisan termin.","Brisanje termina",JOptionPane.INFORMATION_MESSAGE);
                            tdd.getController().fillTable(null);
                            tdd.dispose();
                            }
                    } catch (Exception ex) {
                    JOptionPane.showMessageDialog(tdd, "Greška prilikom brisanja termina.\n"+ex.getMessage(),"Brisanje termina",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        
        tdd.addSkijasActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TerminSkijas ts = new TerminSkijas((Skijas) tdd.getjComboBoxSkijas().getSelectedItem(), tdd.getT(), LocalDate.now());
        
                TerminSkijasTableModel tstm = (TerminSkijasTableModel) tdd.getjTableSkijasi().getModel();
                List<TerminSkijas> list = tstm.getList();
                int num = list.size();
                if(num==tdd.getT().getMaxBrojSkijasa()){
                    JOptionPane.showMessageDialog(tdd, "Dostigli se maksimalan kapacitet skijaša za izabrani termin.","Dodavanje skijaša",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                try {
                    boolean b = Communication.getInstance().kreirajTerminSkijas(ts);
                    if(b){
                        JOptionPane.showMessageDialog(tdd, "Uspešno dodat skijaš.","Dodavanje skijaša",JOptionPane.INFORMATION_MESSAGE);
                        fillTable();
                        double cena = tdd.getT().getBrojSati() * tdd.getT().getTipTermina().getCenaSata();
                        tdd.getT().setUkupanIznos(tdd.getT().getUkupanIznos()+cena);
                        Communication.getInstance().promeniTermin(tdd.getT());
                        tdd.getController().fillTable(null);
                    }
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(tdd, "Greška prilikom dodavanja skijaša."+ex.getMessage(),"Dodavanje skijaša",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        tdd.deleteSkijasActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tdd.getjTableSkijasi().getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(tdd, "Morate izabrati skijaša!", "Greška", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                TerminSkijasTableModel tstm = (TerminSkijasTableModel) tdd.getjTableSkijasi().getModel();
                List<TerminSkijas> list = tstm.getList();
                TerminSkijas ts = list.get(row);


                try {
                    boolean b = Communication.getInstance().obrisiTerminSkijas(ts);
                    if(b){
                        JOptionPane.showMessageDialog(tdd, "Uspešno obrisan skijaš.","Brisanje skijaša",JOptionPane.INFORMATION_MESSAGE);
                        fillTable();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(tdd, "Greška prilikom brisanja skijaša."+ex.getMessage(),"Brisanje skijaša",JOptionPane.ERROR_MESSAGE);
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
        tdd.getjButtonDelete().setVisible(visible);
        tdd.getjButtonAddSkijas().setVisible(visible);
        tdd.getjButtonChange().setVisible(visible);
        tdd.getjButtonDeleteSkijas().setVisible(visible);
        tdd.getjComboBoxSkijas().setVisible(visible);
    }
}
