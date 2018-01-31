package manager.Download;

/**
 * Реализация интерефейса FactoryDownloadInterface фабрики FactoryDownload
 * для создания обьекта Downloads.
 * */

public interface FactoryDownloadInterface {
    FactoryDownload createUrlDownloader();


    class XmlDownloadCreator implements FactoryDownloadInterface{

        @Override
        public FactoryDownload createUrlDownloader() {
            return new DownloadXML();
        }
    }
    class JsonDownloadCreator implements FactoryDownloadInterface{

        @Override
        public FactoryDownload createUrlDownloader() {
            return new DownloadJSON();
        }
    }
}
