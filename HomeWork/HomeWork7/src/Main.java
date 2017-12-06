import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Pacient input() {
        String name;
        String sorname;
        String yearBirthday;
        String monthBirthday;
        Scanner inputs = new Scanner(System.in);
        System.out.println("Введите данные пациента");
        System.out.println("Введите имя пациента:");
        name = inputs.next();
        System.out.println("Введите фамилию пациента:");
        sorname = inputs.next();
        System.out.println("Введите год рождения пациента");
        yearBirthday = inputs.next();
        System.out.println("Введите месяц рождения пациента");
        monthBirthday = inputs.next();
        return new Pacient(name, sorname, yearBirthday, monthBirthday);
    }

    public static void main(String[] arg) {
        int key;
        ArrayList<Pacient> pacients = new ArrayList<>();
        for (int i = 0; i <= 1; i++)
            pacients.add(input());
        for (int i = 0; i < pacients.size(); i++)
            System.out.println("Пациент №" + (i + 1) + " " + pacients.get(i));
        Scanner output = new Scanner(System.in);
    }
}
