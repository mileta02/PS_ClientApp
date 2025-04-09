/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cordinator;

import dialogController.LicencaDialogController;
import dialogController.NivoSkijanjaDialogController;
import dialogController.SkijasDialogController;
import dialogController.TerminDetaljiDialogController;
import dialogController.TerminDialogController;
import dialogController.TipTerminaDialogController;
import formController.GlavnaFormController;
import formController.InstruktorFormController;
import formController.InstruktorNalogFormController;
import formController.LicencaFormController;
import formController.LoginController;
import formController.NivoSkijanjaFormController;
import formController.RegisterController;
import formController.SkijasFormController;
import formController.TerminFormController;
import formController.TipTerminaFormController;
import model.Instruktor;
import model.Licenca;
import model.NivoSkijanja;
import model.Skijas;
import model.Termin;
import model.TipTermina;
import uidialog.LicencaDialog;
import uidialog.NivoSkijanjaDialog;
import uidialog.SkijasDialog;
import uidialog.TerminDetaljiDialog;
import uidialog.TerminDialog;
import uidialog.TipTerminaDialog;
import uiform.GlavnaForm;
import uiform.InstruktorNalogForm;
import uiform.InstruktoriForm;
import uiform.LicencaForm;
import uiform.LoginForm;
import uiform.NivoSkijanjaForm;
import uiform.RegisterForm;
import uiform.SkijasForm;
import uiform.TerminForm;
import uiform.TipTerminaForm;

/**
 *
 * @author milan
 */
public class Cordinator {
    private LoginController loginController;
    private RegisterController registerController;
    private GlavnaFormController glavnaController;
    private SkijasFormController skijasController;
    private TerminFormController terminController;
    private InstruktorFormController instruktorController;
    private InstruktorNalogFormController instruktorNalogController;
    private TipTerminaFormController tipTerminaController;
    private LicencaFormController licencaController;
    private NivoSkijanjaFormController nivoSkijanjaController;
    
    private LicencaDialogController licencaDialogController;
    private TipTerminaDialogController tipTerminaDialogController;
    private NivoSkijanjaDialogController nivoSkijanjaDialogController;
    private SkijasDialogController skijasDialogController;
    private TerminDialogController terminDialogController;
    private TerminDetaljiDialogController terminDetaljiDialogController;
    
    private static Cordinator instance;
    private Instruktor logged;
    
    private Cordinator() {
    }

    public static Cordinator getInstance() {
        if(instance==null)
            instance = new Cordinator();
        return instance;
    }
    
    public Instruktor getLogged() {
        return logged;
    }

    public void setLogged(Instruktor logged) {
        this.logged = logged;
    }
    
    
    public void openLoginForm() {
        loginController = new LoginController(new LoginForm());
        loginController.openForm();
    }

    public void openRegisterForm() {
        registerController = new RegisterController(new RegisterForm());
        registerController.openForm();
    }

    public void openGlavnaForm() {
        glavnaController = new GlavnaFormController(new GlavnaForm(logged));
        glavnaController.openForm();
    }

    public void openTerminForm() {
        terminController = new TerminFormController(new TerminForm(logged));
        terminController.openForm();
    }

    public void openSkijasForm() {
        skijasController = new SkijasFormController(new SkijasForm());
        skijasController.openForm();
    }
    
    public void openInstruktorForm(GlavnaForm parent){
        instruktorController = new InstruktorFormController(new InstruktoriForm(parent,true));
        instruktorController.openForm();
    }
    
    public void openInstruktorNalogForm(GlavnaForm parent){
        instruktorNalogController = new InstruktorNalogFormController(new InstruktorNalogForm(parent, logged));
        instruktorNalogController.openForm();
    }
    
    public void openTipTerminaForm(){
        tipTerminaController = new TipTerminaFormController(new TipTerminaForm());
        tipTerminaController.openForm();
    }
    
    public void openNivoSkijanjaForm(){
        nivoSkijanjaController = new NivoSkijanjaFormController(new NivoSkijanjaForm());
        nivoSkijanjaController.openForm();
    }
    
    public void openLicencaForm(){
        licencaController = new LicencaFormController(new LicencaForm(logged));
        licencaController.openForm();
    }
    
    public void openLicencaDialog(LicencaForm parent, Licenca l){
        licencaDialogController = new LicencaDialogController(new LicencaDialog(parent, true, l, licencaController));
        licencaDialogController.openForm();
    }
    
    public void openNivoSkijanjaDialog(NivoSkijanjaForm parent, NivoSkijanja ns){
        nivoSkijanjaDialogController = new NivoSkijanjaDialogController(new NivoSkijanjaDialog(parent, true, ns, nivoSkijanjaController));
        nivoSkijanjaDialogController.openForm();
    }
    
    public void openTipTerminaDialog(TipTerminaForm parent, TipTermina tt){
        tipTerminaDialogController = new TipTerminaDialogController(new TipTerminaDialog(parent, true, tt, tipTerminaController));
        tipTerminaDialogController.openForm();
    }
    
    public void openSkijasDialog(SkijasForm parent, Skijas s){
        skijasDialogController = new SkijasDialogController(new SkijasDialog(parent, true, s, skijasController));
        skijasDialogController.openForm();
    }
    
    public void openTerminDialog(TerminForm parent){
        terminDialogController = new TerminDialogController(new TerminDialog(parent, true, logged, terminController));
        terminDialogController.openForm();
    }
    
    public void openTerminDetaljiDialog(TerminForm parent, Termin t){
        terminDetaljiDialogController = new TerminDetaljiDialogController(new TerminDetaljiDialog(parent, true, t, terminController));
        terminDetaljiDialogController.openForm();
    }
}
