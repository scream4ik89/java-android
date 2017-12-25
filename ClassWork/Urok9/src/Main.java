import java.util.*;

/*
Тема: Коллекции(топовый вопрос на собеседованиях)
переопределение equals и hashCode - вопрос на собеседованиях


 */
public class Main {
    public static void main(String[] arg){
        ArrayList<String > array = new ArrayList<>();
//        array.add("1111");
//        array.add("2222");
//        array.add("3333");
//        array.add("4444");
//        System.out.println("Размер листа " + array.size());
//        array.add("4444");
//        System.out.println("Размер листа " + array.size());
//        System.out.println("Значение элемента " + array.get(1)); //вызывает указанный элемент массива
//        array.remove(1); // удаляет элемент под указанным индексом в массиве
//        System.out.println("Размер листа " + array.size());
//        array.add(3, "новый элемент в индексе 3");// добавляет на указанное место новый элемент и сдвигает все остальные вправо
//        System.out.println(array.get(3));
//        array.set(2, "замененный элемент"); //заменяет указанный элемент на новый
//        System.out.println(array.get(2));
//        LinkedList<String> array = new LinkedList<>(); // двухсвязный список- имеется ссылки на предыдущий и следующий элемент.
                                                // Хорошо использовать для удаления элементов в середине или в конце в отличии от ArrayList

int[] a = new int[10]; // одномерный массив
        int[][] b = new int[10][10]; //многомерный массив(матрица)
        b [10][2] = 5;
        Collections.sort(array); // после переопределения Comparable можно сортировать объекты массива
        Comparator compare = new SortByAgeComparator();
        Collections.sort(array, compare);




    }
}
