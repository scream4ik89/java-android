

public class Main {
    private volatile String value;
  public static void main(String[] arg){
      Main main = new Main();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                    main.value = "sadasda";
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                main.value = "AAAAA";
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

