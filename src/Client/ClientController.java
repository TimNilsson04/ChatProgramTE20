package Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    JFrame frame = new JFrame("ClientGUI");
    frame.setContentPane(v.getPanel());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);

    m.getStreams();
    ListenerThread l = new ListenerThread(m.in, System.out);
    Thread listener = new Thread(l);
    listener.start();
    m.runProtocol();

    v.skickaButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            m.setMsg(v.getTextField1());
            m.getCmsg();
            v.setTextArea1(m.Cmsg);

        }
    });

}

    public static void main(String[] args) throws InterruptedException {
        ClientModel model = new ClientModel("localhost", 1234);
        ClientGUI gui = new ClientGUI();

        ClientController controller = new ClientController(model, gui);
    }
       /* // Client me = new Client.Client("10.80.47.10", 5858); //alexandro
        ClientModel me = new ClientModel("10.80.46.47", 1234); //ME
        me.getStreams();
        ListenerThread l = new ListenerThread(me.in, System.out);
        Thread listener = new Thread(l);
        listener.start();
        me.runProtocol();
        listener.join();
        me.shutDown();
    }*/


}