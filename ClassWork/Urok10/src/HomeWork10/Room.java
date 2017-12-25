package HomeWork10;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private static int maxPercent = 70; //максимальное заполнение площади мебелью
    private double area, freeArea;  // плозадь и сколько свободно площади осталось
    private int windows;
    private List<Lamp> lampList = new ArrayList<>();
    private List<Furniture> furnitureList = new ArrayList<>();
    private void addLamp(Lamp lamp){
        lampList.add(lamp);
        //проверка на пределы допустимого освещения
    }
    private List addFurniture(Furniture furniture) throws Exception{

        //должно быть исключение, если места уже нет для мебели
        if (area > maxPercent){
            throw new Exception();

        }
        else furnitureList.add(furniture);
        return null;
    }

    public int getWindows() {
        return windows;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getFreeArea() {
        return freeArea;
    }

    public void setFreeArea(double freeArea) {
        this.freeArea = freeArea;
    }
}
