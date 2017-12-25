/*
HashMap, HashSet. HttpUrlConnection, XML - DOM парсер
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final String LINK = "https://www.tut.by";
    public static void main(String[] arg){
            Set<Pacient> testSet = new HashSet<>();
        testSet.add(new Pacient("asdasd", 25));
        testSet.add(new Pacient("asdasd", 25));
        testSet.add(new Pacient("adsadf", 35));
        for (Pacient pacient: testSet){
            System.out.println("value = " + pacient.getAge()); //одинаковые записи удаляются
        }
//        List<String> list = new ArrayList<>();
//        list.add("aaa");
//        list.add("bbb");
//        list.add("aaa");
//
//        testSet.addAll(list); // добавляем list в HashSet для удаления дубликатов
//        list.clear();// очистили массив
//        list.addAll(testSet); // выдает в случайном порядке данные(не как было в листе)
        Map<String, String> testMap = new HashMap<>();
        testMap.put("RU", "RU VALUE");
        testMap.put("BY", "BY VALUE");
        testMap.put("EN", "EN VALUE");
        testMap.put("FR", "FR VALUE");  // если ключ(RU, BY, EN...) будет совпадать, он будет перезаписан. Value может повторяться
        System.out.println(" VALUE = " + testMap.get("RU"));
        // скачивание из интернета
        InputStream inputStream = null; // чтение информации
        FileOutputStream fileOutputStream = null;
        try {
            URL url = new URL(LINK);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
         int responseCode = httpURLConnection.getResponseCode();
         if (responseCode == HttpURLConnection.HTTP_OK){
             inputStream = httpURLConnection.getInputStream();
             File file = new File("ex.html");
             fileOutputStream = new FileOutputStream(file);
             int byteRead = -1;
             byte [] buffer = new byte[2048];
             while ((byteRead = inputStream.read(buffer)) != -1){
                 fileOutputStream.write(buffer, 0, byteRead); // указываем с какой позиции надо записывать полезные данные
             }

         }
         else System.out.println("Данные не найдены, response code = " + responseCode);
        }
        catch (Exception e){
            System.out.println("Невозможно скачать файл");
        }
        finally {
            if(inputStream != null){
                try {
                    inputStream.close();}
                    catch (IOException e){ System.out.println("Невозможно закрыть inputStream, error = " + e.toString());
                }

            }

            if (fileOutputStream != null){
                try{fileOutputStream.close();}
                catch (IOException e){ System.out.println("Невозможно закрыть outputStream, error = " + e.toString());}

            }
        }
    }
}
