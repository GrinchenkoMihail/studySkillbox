import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] arStr = str.split(" ");
        if (arStr.length == 3) {
           boolean b=arStr[1].matches("[а-яА-я]");
            String strCheak = str.replaceAll("[^а-яА-Я ]", "");
            if (str.contentEquals(strCheak)) {
                System.out.format("Фамилия:%s \nИмя:%s\nОтчество:%s", arStr[0], arStr[1], arStr[2]);
            } else {
                System.out.println("Некоректно введены данные");
            }
        } else {
            System.out.println("Некоректно введены данные");
        }
    }
}
