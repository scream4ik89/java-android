package Mvc;

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
    }
    public void showMessage(String message){
        System.out.println("Ошибка: " + message);
    }
}
