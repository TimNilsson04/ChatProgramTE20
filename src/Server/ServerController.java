package Server;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerController {
    ServerSocket server;
    Socket client;
    ServerGUI view;
    PrintWriter out;
    BufferedReader in;

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("ServerGUI");
        frame.setContentPane(new ServerGUI().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        ServerModel s = new ServerModel(1234);
        s.acceptClient();
        s.getStreams();
        ListenerThread l = new ListenerThread(s.in, System.out);
        Thread listener = new Thread(l);
        listener.start();
        s.runProtocol();
        listener.join();
        s.shutdown();

    }


}