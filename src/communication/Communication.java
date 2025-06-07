/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import communication.Operation;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Instruktor;
import model.InstruktorLicenca;
import model.Licenca;
import model.NivoSkijanja;
import model.Skijas;
import model.Termin;
import model.TerminSkijas;
import model.TipTermina;

/**
 *
 * @author milan
 */
public class Communication {
    private static Communication instance;
    private Sender sender;
    private Receiver receiver;
    private Socket socket;
    
    private Communication() throws IOException{
        socket = new Socket("localhost",9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    public static Communication getInstance() throws IOException {
        if(instance==null)
            instance = new Communication();
        return instance;
    }

    //INSTRUKTOR SO
    
    public Instruktor login(Instruktor i) throws Exception {
            Request request = new Request(Operation.LOGIN, i);

            sender.send(request);
            Response response = (Response) receiver.receive();
            if(response.getException()==null){
                return (Instruktor) response.getResult();
            }
            throw response.getException();
    }

    public boolean kreirajInstruktor(Instruktor i) throws Exception {
        Request request = new Request(Operation.KREIRAJ_INSTRUKTOR, i);
        sender.send(request);
        
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return (boolean) response.getResult();
        }
        throw response.getException();
        
    }

    public boolean promeniInstruktor(Instruktor i) throws Exception {
        Request request = new Request(Operation.PROMENI_INSTRUKTOR,i);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return (boolean) response.getResult();
        }
        throw response.getException();
    }

    public boolean obrisiInstruktor(Instruktor i) throws Exception {
        Request request = new Request(Operation.OBRISI_INSTRUKTOR,i);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return (boolean) response.getResult();
        }
        throw response.getException();
    }

    public List<Instruktor> vratiListuSviInstruktor() throws Exception {
        Request request = new Request(Operation.UCITAJ_INSTRUKTOR, new Instruktor());
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return (List<Instruktor>) response.getResult();
        }
        throw response.getException();
    }

    public List<Instruktor> vratiListuInstruktor(Instruktor i) throws Exception {
        Request request = new Request(Operation.UCITAJ_INSTRUKTOR_FILTER, i);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return (List<Instruktor>) response.getResult();
        }
        throw response.getException();
    }

    
    //LICENCA SO
    public List<Licenca> vratiListuSviLicenca() throws Exception {
        Request request = new Request(Operation.UCITAJ_LICENCA, new Licenca());
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return (List<Licenca>) response.getResult();
        }
        throw response.getException();
    }
    
    public List<Licenca> vratiListuLicenca(Licenca l) throws Exception {
        Request request = new Request(Operation.UCITAJ_LICENCA_FILTER, l);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return (List<Licenca>) response.getResult();
        }
        throw response.getException();
    }
    
    public boolean obrisiLicenca(Licenca l) throws Exception {
        Request request = new Request(Operation.OBRISI_LICENCA, l);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return true;
        }
        throw response.getException();
    }
    
    
    public boolean promeniLicenca(Licenca l) throws Exception {
        Request request = new Request(Operation.PROMENI_LICENCA, l);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return (boolean) response.getResult();
        }
        throw response.getException();
    }
    
    
    public boolean kreirajLicenca(Licenca l) throws Exception {
        Request request = new Request(Operation.KREIRAJ_LICENCA, l);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return true;
        }
        throw response.getException();
    }

    //ISTRUKTORLICENCA SO
    
    public List<InstruktorLicenca> vratiListuInstruktorLicenca(Instruktor i) throws Exception {
        Request request = new Request(Operation.UCITAJ_INSTRUKTOR_LICENCA, i);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return (List<InstruktorLicenca>) response.getResult();
        }
        throw response.getException();
    }
    
    public List<InstruktorLicenca> vratiListuInstruktorLicencaFilter(InstruktorLicenca i) throws Exception {
        Request request = new Request(Operation.UCITAJ_INSTRUKTOR_LICENCA_FILTER, i);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return (List<InstruktorLicenca>) response.getResult();
        }
        throw response.getException();
    }
    
    public boolean obrisiInstruktorLicenca(InstruktorLicenca il) throws Exception {
        Request request = new Request(Operation.OBRISI_INSTRUKTOR_LICENCA, il);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return (boolean) response.getResult();
        }
        throw response.getException();
    }

    public boolean kreirajInstruktorLicenca(InstruktorLicenca il) throws Exception {
        Request request = new Request(Operation.KREIRAJ_INSTRUKTOR_LICENCA, il);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return  true;
        }
        throw response.getException();
    }

    //NIVO_SKIJANJA SO
    public List<NivoSkijanja> vratiListuSviNivoSkijanja() throws Exception {
        Request request = new Request(Operation.UCITAJ_NIVO_SKIJANJA, new NivoSkijanja());
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return (List<NivoSkijanja>) response.getResult();
        }
        throw response.getException();
    }

    public boolean obrisiNivoSkijanja(NivoSkijanja ns) throws Exception {
        Request request = new Request(Operation.OBRISI_NIVO_SKIJANJA, ns);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return  (boolean) response.getResult();
        }
        throw response.getException();
    }
    
    public boolean kreirajNivoSkijanja(NivoSkijanja ns) throws Exception{
        Request request = new Request(Operation.KREIRAJ_NIVO_SKIJANJA, ns);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return  (boolean) response.getResult();
        }
        throw response.getException();
    }

    public boolean promeniNivoSkijanja(NivoSkijanja ns) throws Exception {
        Request request = new Request(Operation.PROMENI_NIVO_SKIJANJA, ns);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return  (boolean) response.getResult();
        }
        throw response.getException();
    }

    public List<NivoSkijanja> vratiListuNivoSkijanja(NivoSkijanja ns) throws Exception {
        Request request = new Request(Operation.UCITAJ_NIVO_SKIJANJA_FILTER, ns);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return   (List<NivoSkijanja>) response.getResult();
        }
        throw response.getException();
    }
    
    
    //TIP_TERMINA
    public List<TipTermina> vratiListuSviTipTermina() throws Exception{
        Request request = new Request(Operation.UCITAJ_TIP_TERMINA, new TipTermina());
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return   (List<TipTermina>) response.getResult();
        }
        throw response.getException();
    }
    
    public List<TipTermina> vratiListuTipTermina(TipTermina tt) throws Exception{
        Request request = new Request(Operation.UCITAJ_TIP_TERMINA_FILTER, tt);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return   (List<TipTermina>) response.getResult();
        }
        throw response.getException();
    }

    public boolean kreirajTipTermina(TipTermina tt) throws Exception{
        Request request = new Request(Operation.KREIRAJ_TIP_TERMINA, tt);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return   (boolean) response.getResult();
        }
        throw response.getException();
    }

    public boolean promeniTipTermina(TipTermina tt) throws Exception {
        Request request = new Request(Operation.PROMENI_TIP_TERMINA, tt);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return   (boolean) response.getResult();
        }
        throw response.getException();
    }

    public boolean obrisiTipTermina(TipTermina tt) throws Exception {
        Request request = new Request(Operation.OBRISI_TIP_TERMINA, tt);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return   (boolean) response.getResult();
        }
        throw response.getException();
    }

    //SKIJAS
    public List<Skijas> vratiListuSviSkijas() throws Exception{
        Request request = new Request(Operation.UCITAJ_SKIJAS, new Skijas());
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return   (List<Skijas>) response.getResult();
        }
        throw response.getException();
    }
    
    public List<Skijas> vratiListuSkijas(Skijas s) throws Exception{
        Request request = new Request(Operation.UCITAJ_SKIJAS_FILTER, s);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return   (List<Skijas>) response.getResult();
        }
        throw response.getException();
    }

    public boolean kreirajSkijas(Skijas s) throws Exception{
        Request request = new Request(Operation.KREIRAJ_SKIJAS, s);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return   (boolean) response.getResult();
        }
        throw response.getException();
    }

    public boolean promeniSkijas(Skijas s) throws Exception {
        Request request = new Request(Operation.PROMENI_SKIJAS, s);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return   (boolean) response.getResult();
        }
        throw response.getException();
    }

    public boolean obrisiSkijas(Skijas s) throws Exception {
        Request request = new Request(Operation.OBRISI_SKIJAS, s);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return   (boolean) response.getResult();
        }
        throw response.getException();
    }
    //TERMIN
    
    public List<Termin> vratiListuSviTermin() throws Exception{
        Request request = new Request(Operation.UCITAJ_TERMIN, new Termin());
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return   (List<Termin>) response.getResult();
        }
        throw response.getException();
    }
    
    public List<Termin> vratiListuTermin(Termin t) throws Exception{
        Request request = new Request(Operation.UCITAJ_TERMIN_FILTER, t);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return   (List<Termin>) response.getResult();
        }
        throw response.getException();
    }

    public boolean kreirajTermin(Termin t) throws Exception{
        Request request = new Request(Operation.KREIRAJ_TERMIN, t);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return   (boolean) response.getResult();
        }
        throw response.getException();
    }

    public boolean promeniTermin(Termin t) throws Exception {
        Request request = new Request(Operation.PROMENI_TERMIN, t);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return   (boolean) response.getResult();
        }
        throw response.getException();
    }

    public boolean obrisiTermin(Termin t) throws Exception {
        Request request = new Request(Operation.OBRISI_TERMIN, t);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return   (boolean) response.getResult();
        }
        throw response.getException();
    }
    
    
    //TERMIN_SKIJAS
    public List<TerminSkijas> vratiListuTerminSkijas(Termin t) throws Exception {
        Request request = new Request(Operation.UCITAJ_TERMIN_SKIJAS, t);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return (List<TerminSkijas>) response.getResult();
        }
        throw response.getException();
    }
    
//    public boolean kreirajTerminSkijas(TerminSkijas ts) throws Exception {
//        Request request = new Request(Operation.KREIRAJ_TERMIN_SKIJAS, ts);
//        sender.send(request);
//        Response response = (Response) receiver.receive();
//        if(response.getException()==null){
//            return (boolean) response.getResult();
//        }
//        throw response.getException();
//    }
    public boolean kreirajTerminSkijas(List<TerminSkijas> ts) throws Exception {
        Request request = new Request(Operation.KREIRAJ_TERMIN_SKIJAS, ts);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return (boolean) response.getResult();
        }
        throw response.getException();
    }
    public boolean obrisiTerminSkijas(TerminSkijas ts) throws Exception {
        Request request = new Request(Operation.OBRISI_TERMIN_SKIJAS, ts);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return (boolean) response.getResult();
        }
        throw response.getException();
    }
    
    
    
    
}
