package manager.Download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Скачиваем файл в формате *.xml
 * */

public class DownloadXML implements FactoryDownload {
    @Override
    public void urlDownload(String urlXML) {
        boolean checkResult = CheckURL.checkAdress(urlXML);
        if (checkResult) {
            try {
                URL url = new URL(urlXML);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    File file = null;
                    if (urlXML.contains(".xml")) {
                        file = new File("pub.xml");
                    }
                    try (InputStream streamIn = connection.getInputStream();
                         FileOutputStream streamOut = new FileOutputStream(file)) {

                        byte[] buffer = new byte[2048];
                        int read;
                        while ((read = streamIn.read(buffer)) != -1) {
                            streamOut.write(buffer, 0, read);
                        }
                    }
                } else {
                    return;
                }
            } catch (
                    IOException e) {
                e.getMessage();
                return;
            }
        } else System.out.println("Отсутствует соеденение с интернетом, попробуйте позже");

    }
}
