package Task2;

public class Thread1 extends Thread {

    private boolean isFinish = false;

    public void setFinish(boolean finish) {  // для корректного выхода из потока. проверка закончилась ли наша итерация
        isFinish = finish;
    }

    @Override
    public void run(){
        for (int i = 1; i <= 10; i++){
            if(isInterrupted()){  // встроенный аналог нашего isFinish
                System.out.println("stop by if");
                return;
            }
//            if (isFinish == true) {
//                System.out.println("Начало выхода");
//            return;}
            System.out.println("thread1 i = " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("stop by exception"); //корректно прервет выполнение итераций не дожидаюсь всего времени
                return;


            }
        }
    }


}
