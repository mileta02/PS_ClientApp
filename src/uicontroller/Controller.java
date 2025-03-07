/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uicontroller;

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

/**
 *
 * @author milan
 */
public class Controller {
    private static Controller instance;
    private Sender sender;
    private Receiver receiver;
    private Socket socket;
    
    private Controller() throws IOException{
        socket = new Socket("localhost",9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    public static Controller getInstance() throws IOException {
        if(instance==null)
            instance = new Controller();
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

    public Instruktor kreirajInstruktor(Instruktor i) throws Exception {
        Request request = new Request(Operation.KREIRAJ_INSTRUKTOR, i);
        sender.send(request);
        
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return (Instruktor) response.getResult();
        }
        throw response.getException();
        
    }

    public Instruktor promeniInstruktor(Instruktor i) throws Exception {
        Request request = new Request(Operation.PROMENI_INSTRUKTOR,i);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return (Instruktor) response.getResult();
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
            return true;
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
    
    
    
    
    
}
