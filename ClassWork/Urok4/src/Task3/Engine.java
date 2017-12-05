package Task3;

public class Engine {
//    public static final int GAS_98 = 1; //1 вариант добавить бензин
//    public static final int GAS_95 = 2;
//    public static final int GAS_92 = 3;
//
    public enum GAS_TYPE{    //2й способ внести бензин. enum, переменная в которой хранятся несколько данных
        GAS_98, GAS_95, GAS_92
}
    private double volume;  // объем
    private String model;
    private GAS_TYPE gas;

//    private int gas;

}


//if (engine.getGas() == Engine.GAS_98){
//    break;
//        }