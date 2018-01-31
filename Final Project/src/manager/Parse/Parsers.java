package manager.Parse;

import manager.Download.Downloads;
import model.entity.Pub;

import java.text.ParseException;

/**
 * Реализация парсинга в многопоточности совместно с Downloads
 * */
public class Parsers extends Thread {
    private Downloads downloads;

    public void setDownloads(Downloads downloads) {
        this.downloads = downloads;
    }

    @Override
    public void run() {
        try {
            synchronized (Object.class) {
                Object.class.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Pub pub = Xml.parseXML();
            System.out.println(pub.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        synchronized (Object.class){
            Object.class.notify();}
        try {
            synchronized (Object.class) {
                Object.class.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Pub pub1 =  Json.parseJson();
        System.out.println(pub1.toString());
    }
}
//public class Parsers extends Thread {
//
//    public  void setObject(Object object) {
//        this.object = object;
//    }
//    private Object object;
//
//    @Override
//    public void run() {
//        try {
//            synchronized (object) {
//                object.wait();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            Pub company = Xml.parseXML();
//            System.out.println(company.toString());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        synchronized (object){
//            object.notify();}
//        try {
//            synchronized (object) {
//                object.wait();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Pub company1 =  Json.parseJson();
//        System.out.println(company1.toString());
//    }
//}