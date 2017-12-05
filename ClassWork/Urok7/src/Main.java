import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.MonthDay;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {
    public static void main(String[] arg) throws ParseException {
           Date date = new Date();
//        System.out.println(date.toString());
//        System.out.println(date.getTime()); //время показывается в милисекундах
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy", Locale.CANADA);//разное количество букв кодировки дает разные результаты//Local меняет язык
//        String dataText = sdf.format(date);
//        System.out.println(dataText);

//        String inputData = "2017-11-30 17:50"; // перевод из строки в нужный формат даты
//        Date data2 = null;
//        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        data2 = sdf2.parse(inputData);
//        System.out.println(data2.toString());


        int day = date.getDate();// вывести дату в нужном формате с правильным окончанием числа
        String pattern = "MMMM dd'" + getPostfix(day) + "' hh:mm a"; // одна ковычка для экранирует, выводит содержимое как есть без замены на дату
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.ENGLISH);
        String dataText = sdf.format(date);
        System.out.println(dataText);


        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int dayM = calendar.get(GregorianCalendar.DAY_OF_MONTH);
        int month = calendar.get(GregorianCalendar.MONTH);
        calendar.add(GregorianCalendar.DATE, 30); // прибавляем 30 дней к текущей дате
        System.out.println(calendar.getTime().toString());
    }
    private static String getPostfix(int day){
        if (day >= 11 && day <= 13) return "-th";
        switch (day % 10){
            case 1: {
                return "-st";
            }
            case 2:{
                return "-th";
            }
            case 3:{
                return "-rd";
            }
            default:{
                return "-th";
            }
        }

    }
}
