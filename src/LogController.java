import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class LogController {
    private LogView view;
    private LogModel model;
    public static void main(String[] args) {
        LogController controller = new LogController();
    }

    public LogController() {
        view = new LogView();
        String filename = view.getFilename();
        model = new LogModel();
        model.setFilename(filename);
        JFrame frame = new JFrame("Notepad");
        frame.setContentPane(view.getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        view.getAddNewButton().addActionListener(new AddNewAL());
        view.updateLogList(model.getLogEntries());
        view.getComboBox1().addActionListener(new ComboBoxAL());
        view.getUpdateButton().addActionListener(new UpdateAL());
    }

    private class AddNewAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            ArrayList<LogEntry> newEntries = model.getLogEntries();
            LogEntry newEntry = new LogEntry(view.getTextField1().getText(),view.getTextField2().getText());
            newEntries.add(newEntry);
            //model.setLogEntries(newEntries);
            model.save();
            view.addLogListItem(newEntry);
        }
    }

    private class ComboBoxAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JComboBox comboBox1 = (JComboBox) actionEvent.getSource();
            LogEntry log = (LogEntry) comboBox1.getSelectedItem();
            view.showLogEntry(log);
        }
    }

    private class UpdateAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            ArrayList<LogEntry> newEntries = model.getLogEntries();
            LogEntry newEntry = new LogEntry(view.getTextField1().getText(),view.getTextField2().getText());
            JComboBox comboBox1 = view.getComboBox1();
            //System.out.println((LogEntry) comboBox1.getSelectedItem());
            //System.out.println(newEntries.get(0).equals((LogEntry) comboBox1.getSelectedItem()));
            //System.out.println(newEntries.contains((LogEntry) comboBox1.getSelectedItem()));
            newEntries.set(newEntries.indexOf((LogEntry) comboBox1.getSelectedItem()),newEntry);
            model.setLogEntries(newEntries);
            model.save();
            view.addLogListItem(newEntry);
        }
    }
}
