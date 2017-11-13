
public class Main {
    public static void main(String[] arg){
        int[] array = new int[5]; //Масивы
        array[0] = 4;
        array[1] = 5;
        array[2] = 10;
        array[3] = 2;
        array[4] = 20;
 //     int min;
//        int max;
//        double summ = 0;
////        System.out.println(array[1]);
//        for (int i = array.length - 1; i >= 0; i-- ){
////            System.out.println(i);
//            summ = summ + array[i];
//
//        }
//        double avg = summ / array.length;
//        System.out.println(avg);
//        int min = array[0];
//        for (int i = 1; i < array.length; i++){
//            if (min > array[i]){
//                min = array[i];
//
//            }
//        }
//        System.out.println(min);

//        for (int i = 0; i < array.length; i++){ // выводим масив пока i не станет равно array = 4
//            System.out.println("i = " + i);
//            System.out.println("array = " + array[i]);
//        }
//        System.out.println("finish");
//        for (int i = array.length-1; i >= array [0]; i--){ // выводим array с конца
//            System.out.println("i = " + i);
//            System.out.println("array = " + array[i]);
//        }
//        for (int value : array){ //сокращенная форма for. value имя переменной. выводит весь масив array
//            System.out.println(value);
//        }
//        int i = 0;
//        while (i < array.length){
//            System.out.println(array[i]);
//            i++;
//        }
//        do{     // выполнит как минимум 1 раз
//        } while (false);

        double a = 5.5;
 //       int i = a; не верно
        int i = (int)a; // превращение в инт
        // потренится с переводом
        System.out.println(arg[0]);
        System.out.println(arg[1]);


    }

}
