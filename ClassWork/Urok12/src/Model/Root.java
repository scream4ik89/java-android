package Model;

import java.util.Date;
import java.util.List;

// делаем объектную модель нашего xml файла
public class Root {
    private String name;
    private List<People> people;
    private Gender gender; // для примера если бы приходило значение пола в виде 0 и 1, можно подменить их на Man и Women
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<People> getPeople() {
        return people;
    }

    public void setPeople(List<People> people) {
        this.people = people;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Root)) return false;

        Root root = (Root) o;

        if (name != null ? !name.equals(root.name) : root.name != null) return false;
        return people != null ? people.equals(root.people) : root.people == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (people != null ? people.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Model.Root{" +
                "gender='" + gender + '\'' +
                "date='" + date + '\'' +
                "name='" + name + '\'' +
                ", people=" + people +
                '}';
    }
}


