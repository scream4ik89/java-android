import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] arg){
//        String a = "@abs@gmail.com@";
//        a = a.replaceAll("^@|@$", "");
//        System.out.println(a);
//
//        String a2 = "2020 MP-7";
//
//        Pattern pattern = Pattern.compile("^[0-9]{4} [A-Za-z]{2}-[1-7]S*");
//        Matcher matcher = pattern.matcher(a2);
//        if (matcher.matches()){
//            System.out.println("Номер корректен");
//        }
//        else {
//            System.out.println("Номер не корректен");
//        }
//        String a3 = "+375 (25) 942-67-44";
//        a3 = a3.replaceAll("\\D", "");
//
//        Pattern pattern2 = Pattern.compile("^+375(17|25|29|33|44)[0-9]{7}S*");
//        Matcher matcher2 = pattern2.matcher(a3);
//        if (matcher2.matches()){
//            System.out.println("Номер корректен");
//        }
//        else {
//            System.out.println("Номер не корректен");
//        }

    }

    public static boolean checkCarNumber(String a2){
        Pattern pattern = Pattern.compile("^[0-9]{4} [A-Za-z]{2}-[1-7]S*");
        Matcher matcher = pattern.matcher(a2);
                return matcher.matches();
    }
    public static boolean checkPhoneNumber(String a3){
        a3 = a3.replaceAll("\\D", "");
        Pattern pattern2 = Pattern.compile("^+375(17|25|29|33|44)[0-9]{7}S*");
        Matcher matcher2 = pattern2.matcher(a3);
        return matcher2.matches();

    }
}
