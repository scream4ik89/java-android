package manager;

import manager.Threads.Downloads;
import manager.Threads.Parsers;

public class Manager {
    private static final Object object = new Object();
    private static Manager instance;

    //реализация паттерна Singleton

    private Manager(){
        Parsers parsers = new Parsers();
        Downloads downloads = new Downloads();

        downloads.setObject(object);
        parsers.setObject(object);

        downloads.start();
        parsers.start();

    }

    public static Manager getInstance(){
        if(instance == null){
            instance = new Manager();
        }

        return instance;
    }
}
