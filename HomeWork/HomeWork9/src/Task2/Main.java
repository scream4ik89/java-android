package Task2;

import Task2.Exception.IlluminanceTooMuchException;
import Task2.Exception.SpaceUsageTooMuchException;
import Task2.Furnitures.Bed;
import Task2.Furnitures.CofeTable;
import Task2.Furnitures.Table;

public class Main {
    public static Building addFurniture(Building building, int i, String type, String name, double area) throws Exception {
        try {
            if (type.equals("Table"))
            building.getRoomList().get(i).addFurniture(new Table(name, area));
            else
            if (type.equals("Bed"))
                building.getRoomList().get(i).addFurniture(new Bed(name, area));
            else
            if (type.equals("CofeTable"))
                building.getRoomList().get(i).addFurniture(new CofeTable(name, area));
            else System.out.println("Неверные данные");
        } catch (SpaceUsageTooMuchException e) {
            e.getMessage();
        }
        return building;
    }
    public static Building addLamp(Building building, int i, int light)throws Exception{
        try {
            building.getRoomList().get(i).addLamp(new Lamp(light));
        } catch (IlluminanceTooMuchException e){
            e.getMessage();
        }
        return building;
    }
    public static void main(String[] arg) throws Exception {
        Building building = new Building();
        building.addRoom(new Room("kitchen", 10, 1));
        building.addRoom(new Room("bedroom", 20, 2));
        addFurniture(building,0, "Table", "ikea", 2);
        addFurniture(building,1, "Bed", "ikea", 6);
        addLamp(building, 0, 300);
        addLamp(building, 1, 700);

    }
}

