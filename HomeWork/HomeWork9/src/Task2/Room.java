package Task2;

import Task2.Exception.IlluminanceTooMuchException;
import Task2.Exception.SpaceUsageTooMuchException;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String nameRoom;
    public static final int maxPercent = 70; //максимальное заполнение площади мебелью
    private double area, freeArea;  // плозадь и сколько свободно площади осталось
    public static final int window = 700;
    private int countWindow;
    private List<Lamp> lampList = new ArrayList<>();
    private List<Furniture> furnitureList = new ArrayList<>();

    public Room(String nameRoom, double area, int countWindow) {
        this.nameRoom = nameRoom;
        this.area = area;
        this.countWindow = countWindow;
    }

    public int getLampIllum(){    //общая освещенность всех ламп
        int count = 0;
        for (int i = 0; i < lampList.size(); i++){
            count+=lampList.get(i).getLight();
        }
        return count;
    }
    public void addLamp(Lamp lamp) throws Exception{

        if ((getLampIllum() + countWindow * window) <= 4000 )
        lampList.add(lamp);
        else
        throw new IlluminanceTooMuchException();
        return;
        //проверка на пределы допустимого освещения
    }
    public double getAreaFurn(){
        double count = 0;
        for (int i = 0; i < furnitureList.size(); i++){
            count += furnitureList.get(i).getArea();
        }
        return count;
    }
    public void addFurniture(Furniture furniture) throws Exception{

        //должно быть исключение, если места уже нет для мебели
        if (getAreaFurn() / area * 100 < maxPercent){
            furnitureList.add(furniture);
        }
        else throw new SpaceUsageTooMuchException();
        return;
    }

    public int getCountWindow() {
        return countWindow;
    }

    public double getArea() {
        return area;
    }

    public double getFreeArea() {
        return freeArea;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public List<Furniture> getFurnitureList() {
        return furnitureList;
    }
}
