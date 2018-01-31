package manager.Download.Match;

import manager.Download.FactoryDownload;
import manager.Download.FactoryDownloadInterface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Реализация класса Match для проверки правильности ссылки файла *.xml
 * */

public class MatchXML extends Match {
    public void checkProcess(String checkdUrl) {
        Pattern patternXML = Pattern.compile("^http://((.)+)\\.(xml)$");
        Matcher matcher = patternXML.matcher(checkdUrl);

        if (matcher.matches()) {
            System.out.println("Корректный формат ссылки xml");
            FactoryDownloadInterface fdi = new FactoryDownloadInterface.XmlDownloadCreator();
            FactoryDownload DownloadXML = fdi.createUrlDownloader();
            DownloadXML.urlDownload("http://kiparo.ru/t/pub.xml");
        } else match.nextMatch(match);
    }
}
