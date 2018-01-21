package Task2;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;


import static javax.script.ScriptEngine.FILENAME;


public class Main {

    public static void main(String[] args) throws TransformerException, ParserConfigurationException {

        String dir = "E:\\Text";

        String ext = ".txt";

        findFiles(dir, ext);
        File fileFile = new File("E:\\Text\\text1.xml");
        Path file = Paths.get(fileFile.getAbsolutePath());
        BasicFileAttributes attr = null;
        try {
            attr = Files.readAttributes(file, BasicFileAttributes.class);
            System.out.println("creation time: " + attr.creationTime());
        } catch (IOException e) {

        }
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();


            Document doc = builder.newDocument();

            Element rootElement =
                    doc.createElementNS("", "it-academy22");

            doc.appendChild(rootElement);


            rootElement.appendChild(getLanguage(doc, fileFile.getName(), fileFile.getPath(), (String.valueOf(fileFile.length())), String.valueOf(attr.creationTime())));



            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);


            StreamResult console = new StreamResult(System.out);
            StreamResult file2 = new StreamResult(new File("E:\\Text\\text1.xml"));


            transformer.transform(source, console);
            transformer.transform(source, file2);
            System.out.println("Создание XML файла закончено");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static Node getLanguage(Document doc, String name, String path, String size, String datetime) {
        Element language = doc.createElement("file");

        language.appendChild(getLanguageElements(doc, language, "name", name));


        language.appendChild(getLanguageElements(doc, language, "path", path));

        language.appendChild(getLanguageElements(doc, language, "size", size));

        language.appendChild(getLanguageElements(doc, language, "datetime", datetime));

        return language;
    }


    private static Node getLanguageElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }




    private static void findFiles(String dir, String ext) {
        File file = new File(dir);
        if(!file.exists()) System.out.println(dir + " папка не существует");
        File[] listFiles = file.listFiles(new MyFileNameFilter(ext));
        if(listFiles.length == 0){
            System.out.println(dir + " не содержит файлов с расширением " + ext);
        }else{
            for(File f : listFiles)
                System.out.println("Файл: " + dir + File.separator + f.getName());
        }
    }

    // Реализация интерфейса FileNameFilter
    public static class MyFileNameFilter implements FilenameFilter{

        private String ext;

        public MyFileNameFilter(String ext){
            this.ext = ext.toLowerCase();
        }
        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(ext);
        }
    }



}
