package manager.Threads;


import manager.Downloader;

public class Downloads extends Thread {

    public void setObject(Object object) {
        this.object = object;
    }

    private Object object;

    @Override
    public void run() {
        Downloader.download("http://kiparo.ru/t/pub.xml");
        synchronized (object){
            object.notify();}
        try {
            synchronized (object) {
                object.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Downloader.download("http://kiparo.ru/t/pub.json");
        synchronized (object){
            object.notify();}
    }
}
