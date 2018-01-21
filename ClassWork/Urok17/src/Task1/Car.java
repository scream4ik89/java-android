package Task1;

public class Car {
    private int id;
    public String name;

    interface Listener{
        void onClick();
    }

        class Windows{   //если просто класс, то он считается внутренним,
            // если класс будет static, то он будет вложенным
    private int idWindows;
    public String model;
    public void test(){
        name = "asdasd";
        id = 5;
    }
}
    public int getId() {
        return id;
    }

    public void setId(int id) {


        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
