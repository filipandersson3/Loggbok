import java.io.*;
import java.util.ArrayList;

public class LogModel {
    private ArrayList<LogEntry> logEntries;
    private String filename = "";
    public LogModel() {
        logEntries = new ArrayList<LogEntry>();
    }
    public ArrayList<LogEntry> load() {
        ObjectInputStream ins = null;
        try {
            ins = new ObjectInputStream(new FileInputStream(new File(filename)));
            logEntries.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
            try {
                LogEntry logitem = null;
                if (ins != null) {
                    logitem = (LogEntry) ins.readObject();
                while (logitem != null) {
                    logEntries.add(logitem);
                    logitem = (LogEntry) ins.readObject();
                }
                ins.close();
                }
            } catch (IOException | ClassNotFoundException ignored) {}
        return logEntries;
    }
    public void save() {
        ObjectOutputStream outs = null;
        try {
            outs = new ObjectOutputStream(new FileOutputStream(new File(filename)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (outs != null) {
                for (LogEntry log: logEntries) {
                    outs.writeObject(log);
                }
                outs.flush();
                outs.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setLogEntries(ArrayList<LogEntry> logEntries) {
        this.logEntries = logEntries;
    }

    public ArrayList<LogEntry> getLogEntries() {
        logEntries = load();
        return logEntries;
    }

    public void setFilename(String filename) {
        this.filename = filename;
        logEntries = load();
    }
}
