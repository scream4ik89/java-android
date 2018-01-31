package manager.Download.Match;

import manager.Download.FactoryDownload;
import manager.Download.FactoryDownloadInterface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Реализация класса Match для проверки правильности ссылки файла *.json
 * */

public class MatchJSON extends Match {
    public void checkProcess(String checkdUrl) {
        Pattern patternXML = Pattern.compile("^http://((.)+)\\.(json)$");
        Matcher matcher = patternXML.matcher(checkdUrl);

        if (matcher.matches()) {
            System.out.println("Корректный формат ссылки json");
            FactoryDownloadInterface fdi = new FactoryDownloadInterface.JsonDownloadCreator();
            FactoryDownload DownloadJSON = fdi.createUrlDownloader();
            DownloadJSON.urlDownload("http://kiparo.ru/t/pub.json");
        } else match.nextMatch(match);
    }
}

