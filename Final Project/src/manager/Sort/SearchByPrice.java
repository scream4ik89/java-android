package manager.Sort;

import manager.Main;
import model.entity.Beer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchByPrice extends Search {
    @Override
    public void sort(List<Beer> list) throws IOException {

        do {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            try {
                String str = reader.readLine().toLowerCase();
                Pattern p = Pattern.compile("[0-9]+");
                Matcher m = p.matcher(str);
                if (!m.matches()) {

                    throw new Exception();

                } else {
                    int countPrice = 0;
                    for (Beer goods : list) {
                        if (goods.getPrice().equals(str)) {
                            Beer.printEmployee(goods);
                            countPrice++;
                        }
                    }
                    if (countPrice == 0) {
                        Main.printSearchFail();
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
