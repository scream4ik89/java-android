package Homework8;

public class MyException extends Exception {
    private String RussianMessage;

    public MyException(String russianMessage) {
        this.RussianMessage = russianMessage;
    }

    public String getRussianMessage() {
        return RussianMessage;
    }
}
