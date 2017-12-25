public class Pacient implements Comparable<Pacient>{
    private String name;
    private int age;


    public Pacient(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public boolean equals(Object obj) {  //необходимо переопределить метод сравнения equals для сравнений по содержимому в массивах или для сравнения объектов
        Pacient pacient = (Pacient) obj;
        return this.name.equals(pacient.getName());
    }

    @Override
    public int hashCode() {     // тоже показатель сравнения, но ограничен вместимостью инта
        int result = name.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public int compareTo(Pacient o) { // для сравнивания и сортировки объекта. перед этим надо прописать implemets Comparable<Pacient>
        if (this.age == o.age && this.name.compareTo(o.getName()) == 0) return 0;
        if (this.age > o.age) return 1;
        return -1;
        // return  this.name.compareTo(o.getName());  для сортировки String
    }
}

