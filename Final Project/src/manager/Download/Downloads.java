package manager.Download;


import manager.Download.Match.Match;
import manager.Download.Match.MatchJSON;
import manager.Download.Match.MatchXML;
import manager.Parse.Parsers;

/**
 * Реализация скачивания в многопоточности совместно с Parsers
 * */

public class Downloads extends Thread {
    private Parsers parsers;

    public void setParsers(Parsers parsers) {
        this.parsers = parsers;
    }
    @Override
    public  void run() {
        synchronized (Object.class) {
            Match matchXML = new MatchXML();
            matchXML.checkProcess("http://kiparo.ru/t/pub.xml");
            Object.class.notify();

            try {
                Object.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Match matchJson = new MatchJSON();
            matchJson.checkProcess("http://kiparo.ru/t/pub.json");
            Object.class.notify();
        }
    }
}
//public class Downloads extends Thread {
//
//    public void setObject(Object object) {
//        this.object = object;
//    }
//
//    private Object object;
//
//    @Override
//    public void run() {
//        Downloader.download("http://kiparo.ru/t/pub.xml");
//        synchronized (object){
//            object.notify();}
//        try {
//            synchronized (object) {
//                object.wait();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Downloader.download("http://kiparo.ru/t/pub.json");
//        synchronized (object){
//            object.notify();}
//    }
//}
