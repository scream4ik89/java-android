package Test2;

public class Main {
    private static AbstractClass a = new AbstractClass() {
        @Override
        public void test() {

        }
    };
    static int b = 5;
    public static void main(String[] arg){

        makeSmith(a); // любо так можно сделать реализацию абстрактного класса
        makeSmith(new AbstractClass() { // либо так
            @Override
            public void test() {
                b = 10; // нужно указывать переменную static в самом начале или делать ее final в main

            }
        });
    }
    public static void makeSmith(AbstractClass obj){
        obj.test();
    }
}
