/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formController;

import Language.LanguageSupport;
import cordinator.Cordinator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import uiform.GlavnaForm;

/**
 *
 * @author milan
 */
public class GlavnaFormController {
    private GlavnaForm gf;

    public GlavnaFormController(GlavnaForm gf) {
        this.gf = gf;
        addActionListener();
    }

    private void addActionListener() {
        gf.instruktorActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cordinator.getInstance().openInstruktorForm(gf);
            }
        });
        
        gf.terminActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cordinator.getInstance().openTerminForm();
            }
        });
        
        gf.skijasActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cordinator.getInstance().openSkijasForm();
            }
        });
        
        gf.accountActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cordinator.getInstance().openInstruktorNalogForm(gf, Cordinator.getInstance().getLogged());   
            }
        });
        
        gf.logOutActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gf.dispose();
                Cordinator.getInstance().openLoginForm();
            }
        });
        
        gf.licencaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cordinator.getInstance().openLicencaForm();
            }
        });
        
        gf.tipTerminaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cordinator.getInstance().openTipTerminaForm();
            }
        });
        
        gf.nivoSkijanjaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cordinator.getInstance().openNivoSkijanjaForm();
            }
        });
    }
    
    public void openForm(){
        gf.setVisible(true);
        setLanguage();
    }

    private void setLanguage() {
        gf.getjLabelSkiers().setText(LanguageSupport.getText("skiers"));
        gf.getjLabelAppointments().setText(LanguageSupport.getText("appointments"));
        gf.getjLabelInstructors().setText(LanguageSupport.getText("instructors"));
        gf.getjButtonInstruktor().setText(LanguageSupport.getText("show_instructors_btn"));
        gf.getjButtonSkijas().setText(LanguageSupport.getText("show_skiers_btn"));
        gf.getjButtonTermin().setText(LanguageSupport.getText("show_appointments_btn"));
        gf.getPodešavanja().setText(LanguageSupport.getText("settings"));
        gf.getjMenuAccount().setText(LanguageSupport.getText("account"));
        gf.getjMenuItemEditProfile().setText(LanguageSupport.getText("my_account"));
        gf.getjMenuItemLogOut().setText(LanguageSupport.getText("logout"));
        gf.getjMenuItemLicenca().setText(LanguageSupport.getText("licence"));
        gf.getjMenuItemNivo().setText(LanguageSupport.getText("ski_level"));;
        gf.getjMenuItemTip().setText(LanguageSupport.getText("type_of_appointment"));
        gf.setTitle(LanguageSupport.getText("main_form_title"));
    }
}
