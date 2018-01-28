import Task2.Thread1;



public class Main {    // данный способ годится если надо что-то небольшое запустить в этом же потоке


    public static void main(String[] arg) {
//        System.out.println("start main");
//        Thread1 thread1 = new Thread1();
//        thread1.start();
//        try {    //для остановки потока после 3000 млс
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//
//        }
//        thread1.interrupt();  //метод для прерывания метода
//        //thread1.setFinish(true);
//
//        System.out.println("end main");
//
//    }
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("thread2 i = " + i);
                    try {
                        Thread.sleep(1000); //метод sleep приостанавливает работу на заданное кол-во милиСекунд
                    } catch (InterruptedException e) {
                    }
                }

            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("thread2 i = " + i);
                    try {
                        Thread.sleep(1000); //метод sleep приостанавливает работу на заданное кол-во милиСекунд
                    } catch (InterruptedException e) {
                    }
                }

            }
        });
        thread1.setName("thread1");  // задать имя потоку
        thread1.start();
        thread2.start();
        thread2.setPriority(Thread.MAX_PRIORITY); // приоритет выполнения приоритета
        thread2.isDaemon(); //поток демон который живет пока живут дополнительные потоки. по завершению всех потоков, main их прервет
    }

    public  static void openFile(){
        Thread.currentThread().getName(); // получить имя потока который использует данный метод
    }
}

