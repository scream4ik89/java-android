package manager.Search;

import model.entity.Beer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchByPrice {

    public static void search(List<Beer> beers) throws IOException {

        do {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            try {
                String str = reader.readLine().toLowerCase();
                Pattern p = Pattern.compile("\\d+");
                Matcher m = p.matcher(str);
                if (!m.matches()) {

                    throw new Exception();

                } else {
                    int countPrice = 0;
                    for (Beer goods : beers) {
                        if (goods.getPrice().equals(str)) {
                            Beer.printBeer(goods);
                            countPrice++;
                        }
                    }
                    if (countPrice == 0) {
                        System.out.println("Поиск не дал результатов. Совпадений не найдено");
                        break;
                    }
                    break;
                }
            }catch (Exception e){
                System.out.println("Неверный ввод данных используйте только цифры");
            }
        } while (true);
    }
}
