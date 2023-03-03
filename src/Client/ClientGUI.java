package Client;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ClientGUI {
        private JPanel panel1;
        private JTextPane textPane1;
        private JTextField writeYourTextHereTextField;
        private JButton sendButton;
        private JTextPane list1;

    public ClientGUI() {
    }


    public JPanel getPanel() {
        return panel1;
    }

    public String getMsg() {
        return writeYourTextHereTextField.getText();
    }

    public void setMsg(String c) {
        writeYourTextHereTextField.setText(c);
    }

    public void listaddMessage(String c) {
        list1.setText(c);
    }

    public void settextPane1(String c) {
        textPane1.setText(c);
    }


    public void sendListener(ActionListener sendListener) {
        writeYourTextHereTextField.addActionListener(sendListener);
    }

    public AbstractButton getsendButton() {
        return sendButton;
    }

    public JTextField getEnter() {
        return writeYourTextHereTextField;
    }
}
