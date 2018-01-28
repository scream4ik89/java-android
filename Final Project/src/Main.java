package manager;

public class Main {
    public static void main(String[] arg){
        Manager manager = Manager.getInstance();
    }
    public static void printSearchFail() {
        System.out.println("Поиск не дал результатов. Совпадений не найдено");
    }
}
