package Server;

import Client.ClientController;
import Client.ClientGUI;
import Client.ClientModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerController {
    ServerModel  model;
    ServerGUI  view;
    ServerSocket server;
    Socket client;
    PrintWriter out;
    BufferedReader in;

    public ServerController(ServerModel m, ServerGUI v){
    this.model = m;
    this.view = v;

    JFrame frame = new JFrame("ServerGUI");
        frame.setContentPane(v.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);




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
        ServerModel model = new ServerModel(1234);
        ServerGUI gui = new ServerGUI();
        ServerController controller = new ServerController(model, gui);
        model.acceptClient();
        model.getStreams();
        ListenerThread l = new ListenerThread(model.in, controller);
        Thread listener = new Thread(l);
        listener.start();
        model.runProtocol();

        /*
        s.acceptClient();
        s.getStreams();
        ListenerThread l = new ListenerThread(s.in, System.out);
        Thread listener = new Thread(l);
        listener.start();
        s.runProtocol();
        listener.join();
        s.shutdown();
*/
    }
    public void newMessage(String msg){
        model.setMsg(msg);
        view.setTextArea1(model.Cmsg);
    }

}