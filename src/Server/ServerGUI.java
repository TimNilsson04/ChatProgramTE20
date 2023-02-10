package Server;

import javax.swing.*;

public class ServerGUI {



    private JTextArea textArea1;

    private JTextField textField1;

    private JButton skickaButton;

    private JPanel panel;

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
