/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formController;

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
                Cordinator.getInstance().openInstruktorNalogForm(gf);   
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
    }
}
