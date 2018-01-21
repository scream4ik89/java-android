package Task2;

public class Main {
    public static void main(String[] arg) {
        System.out.println("start main");
        Thread1 thread1 = new Thread1(); // переопределнный метод thead
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++){
                    System.out.println("thread2 i = " + i);
                    try {
                        Thread.sleep(1000); //метод sleep приостанавливает работу на заданное кол-во милиСекунд
                    } catch (InterruptedException e) {
                    }
                }

            }
        });

        // thread.run(); // выполнится в потоке main
        thread1.start();  // запускает метод run в другом потоке
        thread2.start();
        //thread2.stop(); не рекомендуется использовать этот метод т.к. обрубает поток мгновенно


        try {
            thread1.join();  // ждем пока завершат работу наши другие потоки
            thread2.join();
        } catch (InterruptedException e) {

        }


        System.out.println("end main");




    }
}