import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class LogController {
    private LogView view;
    public static void main(String[] args) {
        LogController controller = new LogController();
    }

    public LogController() {
        view = new LogView();
        JFrame frame = new JFrame("Notepad");
        frame.setContentPane(view.getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        ArrayList<LogEntry> logEntries = LogModel.load();
        view.getAddNewButton().addActionListener(new AddNewAL());
        for (LogEntry entry:
             logEntries) {
            view.getComboBox1().addItem(entry);
        }
    }

    private class AddNewAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            ArrayList<LogEntry> newEntries = LogModel.load();
            LogEntry newEntry = new LogEntry(view.getTextField1().getText(),view.getTextField2().getText());
            newEntries.add(newEntry);
            LogModel.save(newEntries);
            System.out.println(LogModel.load());
            view.getComboBox1().addItem(newEntry);
        }
    }
}
