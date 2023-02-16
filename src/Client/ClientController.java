package Client;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.ClientInfoStatus;
import java.util.Scanner;

public class ClientController {
    Socket socket;
    ClientModel model;
    ClientGUI view;
    PrintWriter out;
    BufferedReader in;

public ClientController(ClientModel m, ClientGUI v){
    this.model = m;
    this.view = v;
}

    public static void main(String[] args) throws InterruptedException {
            JFrame frame = new JFrame("ClientGUI");
            frame.setContentPane(new ClientGUI().getPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        // Client me = new Client.Client("10.80.47.10", 5858); //alexandro
        ClientModel me = new ClientModel("10.80.46.47", 1234); //ME
        me.getStreams();
        ListenerThread l = new ListenerThread(me.in, System.out);
        Thread listener = new Thread(l);
        listener.start();
        me.runProtocol();
        listener.join();
        me.shutDown();
    }


}