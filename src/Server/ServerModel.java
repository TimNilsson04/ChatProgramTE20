package Server;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerModel {

    String msg = "";
    String chat = "";
    String name = "";
    String names = "";
    ServerSocket server;
    Socket client;

    PrintWriter out;
    BufferedReader in;
    ServerController minChef;

    public ServerModel(int port) {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Failed to open serversocket.");
            e.printStackTrace();
        }
        System.out.println("ChatProgram.Server started...");
    }


    public String getmsg() {
        return msg;
    }
    public void setmsg(String msg) {
        this.msg = msg;
    }
    public void addmessagetochat(String msg) {
        chat += msg + "\n";
    }

    public String getchat() {return chat;}

    public String getname() {return this.name;}

    public String getnames() {return this.names;}

    public void setname(String name) {
        this.name = name;
        this.names += name;
    }
    public void addtonames(String name) {
        this.names += "\n" + name;
    }

    public void SendMsg(String msg) {
        out.println(name + ": " + msg);
    }
    public void acceptClient() {
        try {
            client = server.accept();
        } catch (IOException e) {
            System.err.println("Failed to connect to client");
            e.printStackTrace();
        }
        System.out.println("client connected...");
    }

    public void getStreams() {
        try {
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Streams ready...");
    }

    public void runProtocol() {
        Scanner tgb = new Scanner(System.in);
        System.out.println("chatting...");
        String msg = "";
        while (!msg.equals("QUIT")) {
            msg = tgb.next();
            out.println("SERVER: " + msg);
        }
    }


    public void shutdown() {
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

