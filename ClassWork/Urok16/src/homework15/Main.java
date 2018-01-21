package homework15;

public class Main {
    public static void main(String[] arg){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++){
                    Main main = new Main();
                    main.print10();
                }

            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++){
                    Main main = new Main();
                    main.print10();
                }

            }
        });
        thread.start();
        thread2.start();
    }
    public void print10() {
        synchronized (Main.class) {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + " i = " + i);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }
    }
}
