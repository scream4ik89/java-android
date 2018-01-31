import manager.Manager;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] arg) throws IOException, ParseException {
        Manager manager = Manager.getInstance();
        manager.startManager();

    }

}
