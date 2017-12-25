import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import Model.People;
import Model.Root;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;



public class Main {
    private static final String LINK = "http://kiparo.ru/t/test.json";
    public static void main(String[] arg){
        // скачивание из интернета
        InputStream inputStream = null; // чтение информации
        FileOutputStream fileOutputStream = null;
        try {
            URL url = new URL(LINK);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK){
                inputStream = httpURLConnection.getInputStream();
                File file = new File("test.json");
                fileOutputStream = new FileOutputStream(file);
                int byteRead = -1;
                byte [] buffer = new byte[2048];
                while ((byteRead = inputStream.read(buffer)) != -1){
                    fileOutputStream.write(buffer, 0, byteRead); // указываем с какой позиции надо записывать полезные данные
                }
parseGson();
                //parseJson();

            }
            else System.out.println("Данные не найдены, response code = " + responseCode);
        }
        catch (Exception e){
            System.out.println("Невозможно скачать файл" + e.toString());
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
//    public static void parseJson(){  //parse - перевод из одного формата в другой. переводим из json в нужные объекты
//
//        JSONParser parser = new JSONParser();
//        FileReader fileReader = null;
//        Root rootModel = new Root();
//        try {
//            fileReader = new FileReader("test.json");
//            JSONObject root = (JSONObject) parser.parse(fileReader);
//            String name = (String) root.get("name");
//            System.out.println("name = " + name);
//            rootModel.setFirstName(name);
//            JSONArray peoples = (JSONArray) root.get("people");
//            List<People> peopleList = new ArrayList<>();
//            for (Object element: peoples){
//                People peopleModel = new People();
//                JSONObject people = (JSONObject) element;
//                long id = (Long) people.get("id");
//                System.out.println("id = " + id);
//                peopleModel.setId((int) id);
//                String nameElement = (String) people.get("name");
//                System.out.println("name = " + nameElement);
//                peopleModel.setFirstName(nameElement);
//                String surname = (String) people.get("surname");
//                System.out.println("surname = " + surname);
//                peopleModel.setSorname(surname);
//                long age = (Long) people.get("age");
//                System.out.println("age = " + age);
//                peopleModel.setAge((int) age);
//                boolean isDegree = (Boolean) people.get("isDegree");
//                System.out.println("isDegree = " + isDegree);
//                peopleModel.setisDegree(isDegree);
//                peopleList.add(peopleModel);
//            }
//            rootModel.setPeople(peopleList);
//            System.out.println("==================");
//            System.out.println("root = " + rootModel.toString());
//
//        }
//        catch (Exception e){
//            System.out.println("Невозможно открыть. json error = " + e.toString());
//            return;
//        } finally {
//            if(fileReader != null){
//                try {
//                    fileReader.close();
//                }
//                catch (IOException e){
//                    System.out.println("Невозможно закрыть filereader. error = " + e.toString());
//                }
//        }
//        }
//    }
    private static void parseGson(){
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("test.json"));
                GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(Date.class, new DataGsonConverter());
                Gson gson = gsonBuilder.create(); // для парсинга даты

                Root root = gson.fromJson(bufferedReader, Root.class);
                System.out.println("==================");
                System.out.println("root = " + root.toString());
            }
            catch (Exception e){
                System.out.println("Невозможно открыть. json error = " + e.toString());
                return;
            }
    }
}
