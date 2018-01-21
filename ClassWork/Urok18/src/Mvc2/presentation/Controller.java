package Mvc2.presentation;


public class Controller { //он же менеджер, который должен выполнять все действия в итоговом проекте

    private View view;

    public Controller(View view){
        this.view = view;
    }

    public void getMoney(){
        // тут стучимся в UserCase, а затем показываем данные на экране

        view.showGetMoneyResult();
    }
}
