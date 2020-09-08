import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str;

        while (!(str = scan.nextLine()).equals("stop")) {
            String nStr = str.replaceAll("[\\D]", "");
            if (nStr.indexOf('8') == 0) {
                nStr = nStr.replaceFirst("8", "7");
            }
            System.out.println(nStr);
            //  str =scan.nextLine();
        }
    }
}
