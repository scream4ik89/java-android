package Task1;

public class Main3 {
    public static void main(String[] arg){
        int a = 5;
        int b = 0;
        try {
            System.out.println(a/b);
            return;
        }
        catch (Exception e){
            System.out.println(a/b);

        }
        finally {
            System.out.println("работает " + a);
        }
    }
}
