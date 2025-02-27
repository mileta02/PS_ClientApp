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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Instruktor;

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

    public Instruktor login(Instruktor i) throws Exception {
            Request request = new Request(Operation.LOGIN, i);

            sender.send(request);
            Response response = (Response) receiver.receive();
            if(response.getException()==null){
                return (Instruktor) response.getResult();
            }
            throw response.getException();
    }

    public Instruktor register(Instruktor i) throws Exception {
        Request request = new Request(Operation.REGISTER, i);
        sender.send(request);
        
        Response response = (Response) receiver.receive();
        if(response.getException()==null){
            return (Instruktor) response.getResult();
        }
        throw response.getException();
        
    }
    
    
}
