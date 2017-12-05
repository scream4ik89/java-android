public class Main {
    public static void main(String[] arg){
        People[] peopleArray = new People[2];
        People people1 = new People();  // это создание нового объекта
        people1.setName("aaaaa");
        people1.setAge(27);
        people1.staticValue = 100;  // static единая переменная для всего класса

        People people2 = new People(); //после конструктора  People people2 = new People(name "asdasd, age 26);
        people2.setName("bbbb");
        people2.setAge(26);
//        printPeople(people1);
//        printPeople(people2);
        people2.staticValue = 200;   // для обращения к статичным переменным нужна обращаться к классу с большой буквы People.staticValue

        peopleArray[0] = people1;
        peopleArray[1] = people2;
        for (People people: peopleArray){
            printPeople(people);

        }
    }
    public static void printPeople(People people){
        System.out.println("name  " + people.getName());
        System.out.println("age  " + people.getAge());
        System.out.println("staticValue  " + people.staticValue);

    }
}
