package Warning;

public class Main {

    public static void main(String[] arg) {
        int[] array = {1, 1, 2, 2, 3, 3, 5};
        System.out.println(getNumber(array));
    }
        public static int getNumber(int [] array){
            int result = 0;
            for (int i = 0; i < array.length; i++){
                result = result ^ array[i];
            }
            return result;
    }
}
