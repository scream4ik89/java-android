package Task2;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private String nameBuilding;
    private List<Room> roomList = new ArrayList<>();
    public void addRoom(Room room){
        roomList.add(room);
    }
    public List<Room> getRoomList() {
        return roomList;
    }

    public String getNameBuilding() {
        return nameBuilding;
    }

    @Override
    public String toString() {
        return "Building{" +
                "nameBuilding='" + nameBuilding + '\'' +
                ", roomList=" + roomList +
                '}';
    }
}