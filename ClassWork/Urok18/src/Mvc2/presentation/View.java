package Mvc2.presentation;

public class View {
    public void main(String[] arg){
        View view = new View();
        view.startUI();

    }
    private Controller controller;

    public View(){
        controller = new Controller(this);
    }
    private void startUI(){
        System.out.println("Что ты хочешь?");
        //например пользователь хочет снять деньги
        controller.getMoney();
    }

    // этот метод будет вызывать контроллер,
    // что бы показать пользователю ответ на запрос о снятии денег

    public void showGetMoneyResult(boolean ok){
        if (ok == true) { System.out.println("Деньги сняты"); }
        else {  System.out.println("Ошибка снятия денег");}
    }
    public void showMessage(String message){
        System.out.println("Ошибка: " + message);
    }
}
