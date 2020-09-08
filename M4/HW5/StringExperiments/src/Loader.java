import java.lang.reflect.Array;

public class Loader {
    public static void main(String[] args) {
        String text = "Вася заработал 10 рублей, Петя - 5 рубля, а Маша - 100 рублей";
        text = text.replaceAll("[^0-9]", " ");
        text= text.trim();
        String[] arrSum = text.split("\\s+");
        int res = 0;
        for (int i = 0; i < arrSum.length; i++) {
            res = Integer.parseInt(arrSum[i]) + res;
        }
        System.out.println(res);
    }
}