public class Pacient implements Comparable<Pacient>{
    private String name;
    private int age;
    private boolean heals;
    private String gender;
    private String sorname;
    private String lastname;

    public Pacient(String name, int age, boolean heals, String gender, String sorname, String lastname) {
        this.name = name;
        this.age = age;
        this.heals = heals;
        this.gender = gender;
        this.sorname = sorname;
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public boolean getHeals() {
        return heals;
    }

    public String getSorname() {
        return sorname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.name = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeals(boolean heals) {
        this.heals = heals;
    }

    public void setSorname(String sorname) {
        this.name = sorname;
    }

    public void setLastname(String lastname) {
        this.name = lastname;
    }

    @Override
    public String toString() {
        if (heals == true)
            return "Пациент: " + name + " Фамилия: " + sorname + " Отчество: " + lastname + " Возраст: " + age + "Пол: " + gender + " Состояние - выписан";
        else
            return "Пациент: " + name + " Фамилия: " + sorname + " Отчество: " + lastname + " Возраст: " + age + " Пол: " + gender + " Состояние - не выписан";
    }

    @Override
    public boolean equals(Object obj) {  //необходимо переопределить метод сравнения equals для сравнений по содержимому в массивах или для сравнения объектов
        Pacient pacient = (Pacient) obj;
        return this.name.equals(pacient.getName());
    }

    @Override
    public int hashCode() {     // тоже показатель сравнения, но ограничен вместимостью инта
        int result = name.hashCode();
        result = 31 * result + lastname.hashCode();
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

