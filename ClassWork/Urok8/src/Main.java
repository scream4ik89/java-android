import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] arg){
//сузествует 2 типа ошщибок, проверяемое и не проверяемое
        //не проверяемые это когда джава не ругается(не заставляет исправить ошибку)
        // и есть ошибки которые не зависят от программиста(цунами)))
        try {
            //блок кода в котором потенциально может быть проблема
            int a = 5/0;
            SimpleDateFormat sdf = new SimpleDateFormat("");
            Date date = sdf.parse("dsfsdf");
        } catch (ArithmeticException e){  //ловит только указанный тип ошибки
        //блок кода который выполниться, если в блоке try произошла ошибка
        System.out.println("ошибка деления на 0  " + e.toString());

        }
        catch (ParseException e) {  // можно использовать базовый класс ошибок Exception чтобы не писать каждую ощибку
            //ошибка парсинга даты
            e.printStackTrace();
            System.out.println("ошибка даты");
        }        finally {  System.out.println("ошибка 2"); // выполнится независимо есть ошибка или нет. подчищает все хвосты
        }
       try {           double result = test(5, 0);
       } catch (Exception_2 e){           System.out.println("ошибка, вводить 5 запрещено");
       }
    }

   public static double test(int a, int b) throws Exception_2{ // throws помечаем потенциально содержащий ошибку метод и перекидывает обработку ошибки выше
        if (b==5){
            throw new Exception_2();  //создание своего исключения
        }
       return a/b;

    }
}
