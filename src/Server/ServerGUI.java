package Server;

import javax.swing.*;

public class ServerGUI {



    public JTextArea textArea1;

    public JTextField textField1;

    public JButton skickaButton;

    public JPanel panel;

    public ServerGUI (){

    }

    public JPanel getPanel() {
        return panel;
    }

    public void setTextArea1(String Cmsg) {
        this.textArea1.append(Cmsg);
    }

    public String getTextField1() {
        return textField1.getText();
    }

    public JButton getSkickaButton() {
        return skickaButton;
    }

}
