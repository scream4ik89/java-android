import java.util.Comparator;

public class SortByAgeComparator implements Comparator<Pacient>{  //применяется для сортировки по разным параметрам объектов
    @Override
    public int compare(Pacient o1, Pacient o2) {
        if (o1.getAge() == o2.getAge()) return 0;
        if (o1.getAge() > o2.getAge()) return 1;

        return -1;
    }
}
