package singleton;

public class Main {
    public static void main(String[] arg){

        Manager manager = Manager.getInstance();  //pattern singleton
        manager.setA("asdasd");
        Manager manager2 = Manager.getInstance();
        System.out.println(manager2.getA());


    }
}
