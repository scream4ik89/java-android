package Mvc;

import java.util.ArrayList;

public class Controller { //он же менеджер, который должен выполнять все действия в итоговом проекте

    private ArrayList<Model> data;
    private View view;

    public Controller(View view){
        this.view = view;
    }

    public String getHello(){
        return "Hello";
    }
    public int getNumber(){
        view.showMessage("какая-то ошибка");
        return 5;
    }
    public String getDataSortedByName(){
        return data.get(5).getName();
    }
}
