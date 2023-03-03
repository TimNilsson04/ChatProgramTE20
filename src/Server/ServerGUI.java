package Server;
import javax.swing.*;
import java.awt.event.ActionListener;

public class ServerGUI {
    private JPanel panel1;
    private JTextPane textPane1;
    private JTextField writeYourTextHereTextField;
    private JButton sendButton;
    private JTextPane list1;

    public ServerGUI() {
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

    public void settextPane1(String c) {
        textPane1.setText(c);
    }

    public void exportListener(ActionListener exportListener) {
        sendButton.addActionListener(exportListener);
    }

    public void sendListener(ActionListener sendListener) {
        sendButton.addActionListener(sendListener);
    }

    public AbstractButton getsendButton() {
        return sendButton;
    }

    public void listaddMessage(String c) {
        list1.setText(c);
    }

    public JTextField getEnter() {
        return writeYourTextHereTextField;
    }
}
