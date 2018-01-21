package Task2;

public class Main2 {
    public static void main(String[] arg){

        ParsingThread parsingThread = new ParsingThread();
        DownloaderThread downloaderThread = new DownloaderThread();

        parsingThread.setDownloaderThread((downloaderThread));
        downloaderThread.setParsingThread(parsingThread);

        parsingThread.start();
        downloaderThread.start();


    }
}
