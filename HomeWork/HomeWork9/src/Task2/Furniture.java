package Task2;

abstract public class  Furniture {
    private String Name;
    private double Area;

    public Furniture(String name, double area) {
        Name = name;
        Area = area;
    }

    public String getName() {
        return Name;
    }

    public double getArea() {
        return Area;
    }

}
