public class Main {
    public static void main(String[] arg){
        int money = getMoney();
        getMoney(new OnGetMoneyListener() {
            @Override
            public void onMoney(int money) {
                // вызовется как только нам отдадут деньги
                System.out.println(money);
            }
        });
        //показать прогресс бар
    }
    public static int getMoney(){
        return 50;
    }
    public static void getMoney(OnGetMoneyListener listener){
        //проходит много времени
        listener.onMoney(50);
    }
    interface OnGetMoneyListener{
        void onMoney(int money);
    }
}
