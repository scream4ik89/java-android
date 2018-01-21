package Task1;

public class Main {
    public static void main(String[] arg){

        Car.Windows windows = (new Car()). new Windows();
        //Car.Windows windows1 = new Car.Windows(); // такая запись будет, если класс Windows сделать static
        Car.Listener listener = new Car.Listener() {
            @Override
            public void onClick() {

            }
        };
    }
}
