package by.itacademy.task1;

import java.util.Scanner; //должно быть для работы сканера

public class Main {
    //    public static void main(String[] arg){
//        int a = 0;
//        int b = 0;
//        Scanner scanner = new Scanner(System.in); // ввод данных через консоль
//        System.out.println("Введите а");
//        a = scanner.nextInt();
//        System.out.println("Введите b");
//        b = scanner.nextInt();
//     System.out.println(a + b);
//        public static void main(String[] arg) {   //очередность работы методов
//            int a = 5; //для передачи переменной в метод test
//            System.out.println("DO TESTA");
//            test(a);  //обращение к классу test
//            System.out.println("Posle vuzova");
//        }
//        public static void test(int value){
//           System.out.println("TEST  " + value);
//        }
    public static void main(String[] arg) {
        String[] array = new String[10];
        array[0] = "task1";
        array[1] = "task2";
        printArray(array);
        printArray(array);

    }

    public static void printArray(String[] array) {
        System.out.println(array);
    }
}