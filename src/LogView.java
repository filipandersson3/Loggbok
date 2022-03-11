import javax.swing.*;
import java.util.ArrayList;

public class LogView {
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton updateButton;
    private JButton addNewButton;
    private JPanel panel1;

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getAddNewButton() {
        return addNewButton;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void updateLogList(ArrayList<LogEntry> logEntries) {
        comboBox1.removeAllItems();
        for (LogEntry entry:
                logEntries) {
            comboBox1.addItem(entry);
        }
    }

    public void addLogListItem(LogEntry entry) {
        //kollar om en entry med samma createdAt redan finns och byter då ut den, annars lägg till en ny
        boolean exists = false;
        for (int i = 0; i < comboBox1.getItemCount(); i++) {
            if (((LogEntry)comboBox1.getItemAt(i)).getCreatedAt().getTime() == entry.getCreatedAt().getTime()) {
                ((LogEntry) comboBox1.getItemAt(i)).update(entry.getAuthor(),entry.getMessage());
                exists = true;
            }
        }
        if (!exists) {
            comboBox1.addItem(entry);
        }
    }

    public String getFilename() {
        //gör en dialogruta som frågar användaren vilken fil
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(null);
        if (result!=JFileChooser.APPROVE_OPTION){
            JOptionPane.showConfirmDialog(null,
                    "No file was chosen", "Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        return fc.getSelectedFile().getAbsolutePath();
    }

    public void showLogEntry(LogEntry log) {
        textField1.setText(log.getAuthor());
        textField2.setText(log.getMessage());
    }
}
