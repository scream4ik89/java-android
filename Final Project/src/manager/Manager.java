package manager;

import manager.Download.Downloads;
import manager.Download.Match.Match;
import manager.Download.Match.MatchJSON;
import manager.Download.Match.MatchXML;
import manager.Parse.Json;
import manager.Parse.Parsers;
import manager.Parse.Xml;
import manager.Search.SearchByCountry;
import manager.Search.SearchByDate;
import manager.Search.SearchByName;
import manager.Search.SearchByPrice;
import manager.Sort.SortByCountry;
import manager.Sort.SortByName;
import manager.Sort.SortByPrice;
import manager.Sort.SortByYear;
import model.Exception.NoFile;
import model.Exception.NoObject;
import model.Input;
import model.entity.Beer;
import model.entity.Pub;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import java.util.Collections;

public class Manager  {

    private static Manager instance;
    public final String LINKXML = "http://kiparo.ru/t/pub.xml";
    public final String LINKJSON = "http://kiparo.ru/t/pub.json";
    private static final String beerlXML = "pub.xml";
    private static final String beerJSON = "pub.json";
    private static Pub pub;
    private static Beer beer;


    //реализация паттерна Singleton
    public void startManager() throws IOException, ParseException {
        PrepareForWork();
        begginingOfWork();
    }
    private Manager(){


    }
    private void PrepareForWork() throws ParseException {
        System.out.println("Добро пожаловать. Выберете нужный пункт: " + "\n" +
                "1)Загрузить Xml файл" + "\n" +
                "2)Загрузить Json файл" + "\n" +
                "3)Распарсить Xml" + "\n" +
                "4)Распарсить Json" + "\n" +
                "5)Скачать и распарсить в автоматическом режиме");

        int input = 0;
        input = Input.inputNumber();
        try {
            FunctionalManualPrepareForWork(input);
        } catch (NoFile noFile) {
            System.err.println(noFile.getMessage());
            this.PrepareForWork();
        } catch (NoObject noObject) {
            System.err.println(noObject.getMessage());
            this.PrepareForWork();
        }


    }

    private void FunctionalManualPrepareForWork(int input) throws NoFile, NoObject, ParseException {
        switch (input) {
            case 1:
                Match xmlMatch = new MatchXML();
                xmlMatch.checkProcess(LINKXML);
                this.PrepareForWork();
                break;

            case 2:
                Match jsonMatch = new MatchJSON();
                jsonMatch.checkProcess(LINKJSON);
                this.PrepareForWork();
                break;

            case 3:
                if (new File(beerlXML).exists()) {
                    pub = new Xml().parseXML();
                } else {
                    throw new NoFile("Файл " + beerlXML + " не найден. Попробуйте загрузить файл заново.");
                }
                this.PrepareForWork();
                break;

            case 4:
                if (new File(beerJSON).exists()) {
                    pub = new Json().parseJson();
                } else {
                    throw new NoFile("Файл " + beerJSON + " не найден. Попробуйте загрузить файл заново.");
                }
                this.PrepareForWork();
                break;

            case 5:
                if (pub != null) {
                    throw new NoObject("Обьект отсутствует, загрузите и десиреализуйте бар xml или json");
                } else {
                    System.out.println("Данные готовы, запуск программы");
                    Parsers parsers = new Parsers();
                    Downloads downloads = new Downloads();

                    downloads.setParsers(parsers);
                    parsers.setDownloads(downloads);

                    downloads.start();
                    parsers.start();
                    return;
                }

            default:
                System.err.println("Некорректный ввод, попробуйте снова:");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.FunctionalManualPrepareForWork(Input.inputNumber());
                break;
        }

    }


    private void begginingOfWork() throws IOException {
        System.out.println("Выберете желаемую операцию : " + "\n" +
                "1)Поиск" + "\n" +
                "2)Сортировка" + "\n" +
                "3)Выход из программыы");
        int input = 0;
        input = Input.inputNumber();
        operationMessage(input);

    }


    private void operationMessage(int input) throws IOException {
        if (input == 1) {
            System.out.println("Добро пожаловать в поисковик: " + "\n" +
                    "1)Поиск по стране" + "\n" +
                    "2)Поиск по году разлива" + "\n" +
                    "3)Поиск по названию пива" + "\n" +
                    "4)Поиск по цене пива" + "\n");
            input = Input.inputNumber();
            searchBeer(input);

        } else if (input == 2) {
            System.out.println("Добро пожаловать в сортировку: " + "\n" +
                    "1)Сортировка по стране" + "\n" +
                    "2)Сортировка по названию" + "\n" +
                    "3)Сортировка по цене" + "\n" +
                    "4)Сортировка по году разлива");
            input = Input.inputNumber();
            sortBeer(input);

        } else if (input == 3) {
            System.out.println("Программа завершает работу...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.exit(100);
        } else {
            System.err.println("Некорректный ввод, попробуйте снова:");
            operationMessage(Input.inputNumber());
            return;
        }
        begginingOfWork();
    }

    private void sortBeer(int input) {

        switch (input) {
            case 1:
                Collections.sort(pub.getGoods(), new SortByCountry());
                System.out.println("Результат сортировки:");
                System.out.println(pub.getGoods().toString());
                break;
            case 2:
                Collections.sort(pub.getGoods(), new SortByName());
                System.out.println("Результат сортировки:");
                System.out.println(pub.getGoods().toString());
                break;
            case 3:
                Collections.sort(pub.getGoods(), new SortByPrice());
                System.out.println("Результат сортировки:");
                System.out.println(pub.getGoods().toString());
                break;
            case 4:
                Collections.sort(pub.getGoods(), new SortByYear());
                System.out.println("Результат сортировки:");
                System.out.println(pub.getGoods().toString());
                break;
            default:
                System.err.println("Некорректный ввод, попробуйте снова:");
                sortBeer(Input.inputNumber());
                break;
        }

    }

    private void searchBeer(int input) throws IOException {
        switch (input) {
            case 1:
                SearchByCountry.search(pub.getGoods());
            case 2:
                SearchByDate.search(pub.getGoods());
                break;
            case 3:
                SearchByName.search(pub.getGoods());
                break;
            case 4:
                SearchByPrice.search(pub.getGoods());
                break;
            default:
                System.err.println("Некорректный ввод, попробуйте снова:");
                searchBeer(Input.inputNumber());
                break;

        }
    }
    public static Manager getInstance(){
        if(instance == null){
            instance = new Manager();
        }
        return instance;
    }
}
