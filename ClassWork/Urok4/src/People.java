public class People {
//    public String name; // меняем на private      // privat доступен только в пределах своего класса
//    public int age;
    public static int staticValue;

    private String name; // меняем на private
    private int age;

    public People() {   // конструктор для выполнения каких либо задач при создании объекта People

        name = "asd";
    }

    public People(String name, int age) {  // в Джаве есть конструктор, но нет диструктор(выполнение метода при удалении данных)
        this.name = name;
        this.age = age;
    }

    public String getName() {   // скрытие в приват это Инкапсуляция

        return name;
    }

    public void setName(String name) {   // модификатор доступа public, private и дефолтный тип, доступный только внутри пакета(пустой) String getName()

        this.name = name;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public int getAge() {

        return age;
    }
}
