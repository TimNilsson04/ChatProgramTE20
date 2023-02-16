package Client;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientModel {
        String Cmsg = "";
        String msg = "";
        Socket socket;
        PrintWriter out;
        BufferedReader in;

    public String getCmsg() {
        return Cmsg = "Client: " + msg;
    }

    public void setMsg(String getTextField1) {
        this.msg = getTextField1;
    }


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

        public void runProtocol() {
            Scanner tgb = new Scanner(System.in);
            System.out.println("chatting...");

    }

        public void shutDown() {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


}

