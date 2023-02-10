package Client;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientModel {

        Socket socket;
        PrintWriter out;
        BufferedReader in;

        public ClientModel(String ip, int port) {
            try {
                socket = new Socket(ip,port);
            } catch (IOException e) {
                System.err.println("Failed to connect to server");
                e.printStackTrace();
            }
            System.out.println("Connection ready...");
        }

        public void getStreams() {
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Streams ready...");
        }

        public void runProtocol(String msg) {
            Scanner tgb = new Scanner(System.in);
            System.out.println("chatting...");
            while (!msg.equals("QUIT")) {
                out.println("CLIENT: " + msg);
                if (msg.endsWith("WreckingBall")){
                    try {
                        Process p = Runtime.getRuntime().exec("/Program Files (x86)/Google/Chrome/Application/chrome.exe https://www.youtube.com/watch?v=-8PibZVCWuI");
                        p.waitFor();
                        System.out.println("Google Chrome launched!");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void shutDown() {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


}

