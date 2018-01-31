package manager.Search;

import model.entity.Beer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchByName{

    public static void search(List<Beer> list) throws IOException {
        do {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            try {
                String str = reader.readLine().toLowerCase();
                Pattern p = Pattern.compile("[a-zA-Z, ]+");
                Matcher m = p.matcher(str);
                if (!m.matches()) {

                    throw new Exception();

                } else {
                    int countName = 0;
                    for (Beer goods : list) {
                        if (goods.getName().toLowerCase().contains(str)) {
                            Beer.printBeer(goods);
                            countName++;
                        }
                    }
                    if (countName == 0) {
                        System.out.println("Поиск не дал результатов. Совпадений не найдено");
                        break;
                    }
                    break;
                }
            }catch (Exception e){
                System.out.println("Неверный ввод данных используйте буквы латинского алфавита");
            }
        } while (true);
    }
    }


