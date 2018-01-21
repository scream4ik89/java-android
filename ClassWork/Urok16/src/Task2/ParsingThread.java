package Task2;

public class ParsingThread extends Thread {
    private DownloaderThread downloaderThread;

    public void setDownloaderThread(DownloaderThread downloaderThread) {
        this.downloaderThread = downloaderThread;
    }

    @Override
    public void run(){
        System.out.println("wait parsing");
        try {
            wait();
        }catch (InterruptedException e){}
        // нас разбудили
        System.out.println("json parsing");

        //парсинг json

        //будим downloaderThread

        synchronized (DownloaderThread.class){
            System.out.println("ping download from parsing");
        downloaderThread.notify();}

        //а сами засыпаем пока нас не разбудит downloaderThread
        System.out.println("wait parsing");
        try {
            wait();
        }catch (InterruptedException e){}

        System.out.println("xml parsing");

        //парсинг xml

        System.out.println("end parsing");
    }


}
