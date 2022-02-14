import sun.rmi.runtime.Log;

import java.io.*;
import java.util.ArrayList;

public class LogModel {
    private static void load() {
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
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        System.out.println(l);

    }
    private static void save() {
        LogEntry l = new LogEntry("testauthor","testmessage");
        ObjectOutputStream outs = null;
        try {
            outs = new ObjectOutputStream(new FileOutputStream(new File("testSave")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (outs != null) {
                outs.writeObject(l);
                outs.flush();
                outs.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
