import java.io.*;
import java.util.ArrayList;

public class LogModel {
    public static ArrayList<LogEntry> load() {
        ObjectInputStream ins = null;
        try {
            ins = new ObjectInputStream(new FileInputStream(new File("testSave")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<LogEntry> l = new ArrayList<>();
            try {
                if (ins != null) {
                    LogEntry logitem = (LogEntry) ins.readObject();
                    while (logitem != null) {
                        l.add(logitem);
                        logitem = (LogEntry) ins.readObject();
                    }
                    ins.close();
                }
            } catch (IOException | ClassNotFoundException ignored) {}
        return l;

    }
    public static void save(ArrayList<LogEntry> logEntries) {
        ObjectOutputStream outs = null;
        try {
            outs = new ObjectOutputStream(new FileOutputStream(new File("testSave")));
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
}
