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

    public JTextField getTextField1() {
        return textField1;
    }

    public JButton getSkickaButton() {
        return skickaButton;
    }

    public void setTextArea1(JTextArea textArea1) {
        this.textArea1 = textArea1;
    }

}
