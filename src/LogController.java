import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

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
        JFrame frame = new JFrame("Logbook");
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
        //skapar ny entry från textfields och skickar det till model och view
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            ArrayList<LogEntry> newEntries = model.getLogEntries();
            LogEntry newEntry = new LogEntry(view.getTextField1().getText(),view.getTextField2().getText());
            newEntries.add(newEntry);
            model.save();
            view.addLogListItem(newEntry);
        }
    }

    private class ComboBoxAL implements ActionListener {
        //visar informationen i entry när man använder combobox
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JComboBox comboBox1 = (JComboBox) actionEvent.getSource();
            LogEntry log = (LogEntry) comboBox1.getSelectedItem();
            view.showLogEntry(log);
        }
    }

    private class UpdateAL implements ActionListener {
        //gör en ny entry med samma createdAt, byter ut entry i modellen och sparar,
        //skickar också entry till view, två entries med samma createdAt räknas som en entry
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            ArrayList<LogEntry> newEntries = model.getLogEntries();
            JComboBox comboBox1 = view.getComboBox1();
            LogEntry newEntry = new LogEntry(view.getTextField1().getText(),view.getTextField2().getText());
            newEntry.setCreatedAt(((LogEntry) Objects.requireNonNull(comboBox1.getSelectedItem())).getCreatedAt());
            newEntries.set(newEntries.indexOf((LogEntry) comboBox1.getSelectedItem()),newEntry);
            model.save();
            view.addLogListItem(newEntry);
        }
    }
}
