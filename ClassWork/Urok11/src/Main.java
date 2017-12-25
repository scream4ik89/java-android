import Model.People;
import Model.Root;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class Main {
    private static final String LINK = "http://kiparo.ru/t/test.xml";
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
                File file = new File("test.xml");
                fileOutputStream = new FileOutputStream(file);
                int byteRead = -1;
                byte [] buffer = new byte[2048];
                while ((byteRead = inputStream.read(buffer)) != -1){
                    fileOutputStream.write(buffer, 0, byteRead); // указываем с какой позиции надо записывать полезные данные
                }
                parseXml();

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
    public static void parseXml(){  //parse - перевод из одного формата в другой. переводим из xml в нужные объекты
        Document dom;
        try{

            //открываем xml файл

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            dom = builder.parse("test.xml");
        }
        catch (Exception e){
            System.out.println("Невозможно открыть xml. error = " + e.toString());
            return;
        }

        //наш объект, который мы будем заполнять данными из xml

        Root root = new Root();

        // ======= парсинг xml(вытягиваем данные из xml) ========

        //получаем главный(самый первый) элемент из файла
        Element rootElement = dom.getDocumentElement(); //вернет самый первый тег из xml - root
        System.out.println("root tag name = " + rootElement.getTagName());

        //получаем элемент по названию, в данном случае вытягиваем тэг name
        NodeList nameNodeList = rootElement.getElementsByTagName("name"); // содержимое главного тега root

        //так как в теге может быть много других тегов, мы изначально получаем массив
        //так как мы знаем что у нас нет содержимого в name, а только текст после тега, берем первый элемент
        Node nameNode = nameNodeList.item(0);
        System.out.println("name tag name = " + nameNode.getNodeName());
        nameNode.getTextContent();

        // получаем содержимое тега name
        String nameFile = nameNode.getTextContent();
        System.out.println("content tag name = " + nameFile);

        //заполняем наш объект Root
        root.setName(nameFile);

        //===== парсинг people ======
        NodeList peopleNodeList = rootElement.getElementsByTagName("people");
        Node peopleNode = peopleNodeList.item(0);
        System.out.println("name tag people = " + peopleNode.getNodeName());

        //получаем из тега people все содержимое, т.е. массив элементов element
        //один элемент из elementsNodeList это один тег element
        NodeList elementsNodeList = peopleNode.getChildNodes();
        List<People> peoples = new ArrayList<>();

        //заполняем массив данными из element
        for (int i = 0; i < elementsNodeList.getLength(); i++){
            Node node = elementsNodeList.item(i);

            if(node.getNodeType() != Node.ELEMENT_NODE){
                continue;
            }
            System.out.println("============");

            Element element = (Element) node;

            //вытягиваем name
            String name = element.getElementsByTagName("name").item(0).getTextContent();
            System.out.println("name  = " + name);

            //вытягиваем sorname
            String surname = element.getElementsByTagName("surname").item(0).getTextContent();
            System.out.println("surname = " + surname);

            //вытягиваем age
            String ageString = element.getElementsByTagName("age").item(0).getTextContent();
            int age = Integer.valueOf(ageString);
            System.out.println("age = " + age);

            //вытягиваем id
            String idString = element.getElementsByTagName("id").item(0).getTextContent();
            int id = Integer.valueOf(idString);
            System.out.println("id = " + id);

            //вытягиваем id
            String isDegreeString = element.getElementsByTagName("isDegree").item(0).getTextContent();
            boolean isDegree = Boolean.valueOf(isDegreeString);
            System.out.println("isDegree = " + isDegree);

            People people = new People();
            people.setName(name);
            people.setSorname(surname);
            people.setAge(age);
            people.setId(id);
            people.setisDegree(isDegree);
            peoples.add(people);
        }


        root.setPeople(peoples);
        System.out.println("==================");
        System.out.println("root = " + root.toString());


    }
}