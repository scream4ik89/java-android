package Test;

import Test.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

    public static void main(String[] arg) throws IllegalAccessException {

        Test test = new Test();
        Class classTest = test.getClass();
        System.out.println(classTest.getName());

        int mod = classTest.getModifiers();  //проверяем какого доступа класс Test
        if (Modifier.isAbstract(mod)) {
            System.out.println("Abstract");
        } else {
            System.out.println("Non Abstract");
        }
        if (Modifier.isPublic(mod)) {
            System.out.println("Public");
        } else {
            System.out.println("Non Public");

        }
        Field[] fields = classTest.getDeclaredFields(); // показывает все переменные в Test. get.Fields только публичные
        for (Field field : fields){
           System.out.println("Field = " + field.getName());
           try {
               field.setAccessible(true);
               System.out.println("Field value = " + (int) field.get(test));
               field.set(test, 50); // меняет значение переменных
               System.out.println("Field value = " + (int) field.get(test));
           }
           catch (IllegalAccessException e){
               e.getMessage();
           }
        }
        Method[] methods = classTest.getDeclaredMethods();
        for (Method method : methods){
            System.out.println("method name = " + method.getName());
        }

    }
}
