package Model;

import com.google.gson.annotations.SerializedName;

public class People {
    private int age;
    private int id;
    private boolean isDegree;
    @SerializedName("name")  // заменяет реальное название name в json файле на firstName
    private String firstName;
    private String surname;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDegree() {
        return isDegree;
    }

    public void setisDegree(boolean isDegree) {
        isDegree = isDegree;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSorname() {
        return surname;
    }

    public void setSorname(String sorname) {
        this.surname = sorname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof People)) return false;

        People people = (People) o;

        if (age != people.age) return false;
        if (id != people.id) return false;
        if (isDegree != people.isDegree) return false;
        if (firstName != null ? !firstName.equals(people.firstName) : people.firstName != null) return false;
        return surname != null ? surname.equals(people.surname) : people.surname == null;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + id;
        result = 31 * result + (isDegree ? 1 : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Model.People{" +
                " id=" + id +
                ", firstName='" + firstName + '\'' +
                ", sorname='" + surname + '\'' +
                ", age=" + age +
                ", isDegree=" + isDegree +
                '}';
    }
}
