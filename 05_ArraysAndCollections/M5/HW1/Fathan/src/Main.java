import java.util.Arrays;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        String text = "Каждый охотник желает знать, где сидит фазан";
        String[] colors = text.split(",?\\s+");
        for (int i = 0; i < colors.length; i++) {
            System.out.println(colors[i]);
        }
      //  ArrayUtils.reverse(colors);  не понял что нужно подключить чтобы ArrayUtils принял компилятор


        //Способ №1
//        String [] colorsReverse = new String  [colors.length];
//        for(int i = 0; i<colors.length; i++)
//        {
//            colorsReverse[i]=colors[colors.length-i-1];
//            System.out.println(colorsReverse[i]);
//        }

        //Способ №2
        for(int i = 0; i<colors.length/2; i++)
        {
            //String[] str =new String[2];
//            str[0] = colors[colors.length-1-i];
//            str[1]=colors[i];
//            colors[i]=str[0];
//            colors[colors.length-i-1]=str[1];1
            //Способ №3 (переделанный 2ой)
            String str = null;
            str=colors[colors.length-1-i];
            colors[colors.length-1-i]=colors[i];
            colors[i]=str;

        }
        for (String i:colors) {
            System.out.println(i);
        }

    }
}
