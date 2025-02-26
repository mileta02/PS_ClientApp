/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uicontroller;

import communication.Receiver;
import communication.Sender;
import java.io.IOException;
import java.net.Socket;

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
    
    
}
