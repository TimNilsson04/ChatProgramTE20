package Client;

import javax.swing.*;

public class ClientGUI {

    private JTextArea textArea1;

    private JTextField textField1;

    private JButton skickaButton;

    private JPanel panel;

    public ClientGUI (){

    }

    public JPanel getPanel() {

        return panel;
    }

    public void setTextArea1(JTextArea textArea1) {
        this.textArea1 = textArea1;
    }

    public String getTextField1() {
        return textField1.getText();

    }

    public JButton getSkickaButton() {
        return skickaButton;
    }
}
