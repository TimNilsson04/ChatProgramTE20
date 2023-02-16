package Client;

import javax.swing.*;

public class ClientGUI {

    public JTextArea textArea1;

    public JTextField textField1;

    public JButton skickaButton;

    public JPanel panel;

    public ClientGUI (){

    }

    public JPanel getPanel() {
        return panel;
    }

    public void setTextArea1(JTextArea textArea1, String Cmsg) {
        this.textArea1 = textArea1;

    }

    public String getTextField1() {
        return textField1.getText();

    }

    public JButton getSkickaButton() {
        return skickaButton;
    }
}
