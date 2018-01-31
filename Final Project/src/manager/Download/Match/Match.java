package manager.Download.Match;


/**
 * Абстрактный класс для дальнешей проверки правильности ссылки для скачивания наших файлов
 * */

public abstract class Match {

    protected Match match;

    public abstract void checkProcess(String Url);

    public void nextMatch(Match nextMatch){
        this.match = nextMatch;
    }
}