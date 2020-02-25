package homework2.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger logger;
    private static FileWriter fw;

    public static Logger getInstance() {
        return logger == null ? logger = new Logger() : logger;
    }

    private Logger() {
        try {
            File file = new File("log.txt");

            if (file.createNewFile()) {
                System.out.println("File has been created.");
            }
            fw = new FileWriter(file, true);

        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void log(String string) {
        try {
            fw.append(string).append(" \n");
            fw.flush();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
