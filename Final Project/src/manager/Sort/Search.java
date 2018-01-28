package manager.Sort;

import model.entity.Beer;

import java.io.IOException;
import java.util.List;

//родительский класс для наследования сортировки

public abstract class Search {
    public abstract void sort(List<Beer> list) throws IOException;
}
