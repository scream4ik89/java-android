package Task2;

import java.util.Scanner;

public class Main {
        public static void main(String[] arg){
        int key;
        Atm atm = new Atm(0, 0, 0, 0);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Для добавления денег нажмите - 1");
        System.out.println("Для снятия денег нажмите - 2");
        key = scanner.nextInt();
            switch (key) {
                case 1:
            System.out.println("Вставте деньги в купюроприемник");
            atm.addMoney(scanner.nextInt());
            break;
                case 2:
                System.out.println("Какую сумму желаете снять?");
                atm.getMoney(scanner.nextInt());
            }
        }

    }


