package by.itacademy.task2;
public class Main {
    //   public static String a = "hello";
//    public static int a = 10;
//    public static void main(String[] arg) {
//        String[] array = new String[10];
//        array[0] = "sdsd";
//        array[1] = "sdsd";
//        by.itacademy.task1.Main.printArray(array);
//    }
//public static void main(String[] arg) {
//    int result = 0;
//    result = plus(10, 15);
//    System.out.println(result);
//}
//public static int plus(int a, int b) {
//    int sum = a + b;
//    return sum;
//}
//public static void plus (){
//    if(true){
//
//
//    return; //прерывает все действий и выходит из метода, а break останавливает цикл и остается в методе
//    }
//public static void main(String[] arg) {
//    String result;
//    result = plus();
//    System.out.println(result);
//}
//    public static String plus() {
//        String a = null; // не существует значений в a
//if (a == null){  // проверка чтобы значение не было нулевым
//    return null;
//}
//        a.concat("adsa");
//        return a;
//    }
//    public static void main(String[] arg) {
//        System.out.println(a);
//        int a = 20; // присваевается новое значение
//        System.out.println(a); // вывод уже новой а
//        System.out.println(Main.a); // вывод самой верхней переменной
//
//    }
    public static void main(String[] arg) {
        double striangle = getTriangle(2, 5);
        System.out.println(striangle);
        double skavadrat = getKvadrat(5);
        System.out.println(skavadrat);
        double sPryamo = getPryamo(4, 7);
        System.out.println(sPryamo);
    }

    public static double getTriangle(double h, double a) {
        return 0.5 * h * a;

    }

    public static double getKvadrat(double a) {
        return a * a;
    }

    public static double getPryamo(double a, double b) {
        return 2 * (a + b);
    }
}