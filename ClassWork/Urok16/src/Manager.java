public class Manager {
    private String a;
    private static Manager instance = new Manager();  // потоко безопасно
    private Manager(){

    }

    public static Manager getInstance(){

        return instance;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
