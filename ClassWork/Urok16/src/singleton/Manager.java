package singleton;

public class Manager {
    private String a;
    private static Manager instance;
    private Manager(){

    }

    public static Manager getInstance(){
        if(instance == null){
            instance = new Manager();
        }

        return instance;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
