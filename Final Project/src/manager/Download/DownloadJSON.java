package manager.Download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Скачиваем файл в формате *.json
 * */

public class DownloadJSON implements FactoryDownload {
    @Override
    public void urlDownload(String urlJSON) {
        boolean checkResult = CheckURL.checkAdress(urlJSON);
        if (checkResult) {
            try {
                URL url = new URL(urlJSON);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    File file = null;
                    if (urlJSON.contains(".json")) {
                        file = new File("pub.json");
                    }
                    try (InputStream streamIn = connection.getInputStream();
                         FileOutputStream streamOut = new FileOutputStream(file)) {

                        byte[] buffer = new byte[2048];
                        int read;
                        while ((read = streamIn.read(buffer)) != -1) {
                            streamOut.write(buffer, 0, read);
                        }
                        streamOut.close();
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
