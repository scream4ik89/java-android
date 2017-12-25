package Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class People {
    private int age;
    private int id;
    @JsonProperty(value = "isDegree")
    private boolean isDegree;
    private String name;
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

    public String getName() {  return name;  }

    public void setName(String name) {  this.name = name;  }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof People)) return false;

        People people = (People) o;

        if (age != people.age) return false;
        if (id != people.id) return false;
        if (isDegree != people.isDegree) return false;
        if (name != null ? !name.equals(people.name) : people.name != null) return false;
        return surname != null ? surname.equals(people.surname) : people.surname == null;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + id;
        result = 31 * result + (isDegree ? 1 : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", id=" + id +
                ", isDegree=" + isDegree +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}

