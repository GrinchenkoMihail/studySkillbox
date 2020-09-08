import java.lang.reflect.Array;

public class Loader {
    public static void main(String[] args) {
        String text = "Вася заработал 10 рублей, Петя - 100 рубля, а Маша - 100000001 рублей";
//       String[] str=text.split(" ");
//       int res = Integer.parseInt(str[2])+Integer.parseInt(str[11]);
//        System.out.println(res);
        // int res = Integer.parseInt(text.substring(text.indexOf('л')+2),text.indexOf(" рублей"))+Integer.parseInt(text.substring(text.lastIndexOf(" - ")+3,text.lastIndexOf(" рублей")));
        int res = Integer.parseInt(text.substring(text.indexOf('л') + 2, text.indexOf(" рублей"))) + Integer.parseInt(text.substring(text.lastIndexOf(" - ") + 3, text.lastIndexOf(" рублей")));
        System.out.println(res);
    }
}