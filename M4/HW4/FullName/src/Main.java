import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine().trim();
        /*String[] arStr = str.split(" ");
        if (arStr.length == 3) {
            String strCheak = str.replaceAll("[^а-яА-яa-zA-z]", " ");//[0-9 - .!@#$%^&*(){}|?/><_+=]
            if (str.equals(strCheak)) {
                System.out.format("Фамилия: %s \nИмя: %s\nОтчество: %s", arStr[0], arStr[1], arStr[2]);
            } else {
                System.out.println("Некоректно введены данные");
            }
        } else {
            System.out.println("Некоректно введены данные");
        }*/
        char ch =' ';
        int index1 = str.indexOf(ch);
        int index2 = str.lastIndexOf(ch);
        if(index1!=index2&&(index2-index1>1)) {
            if(str.replaceAll("[^а-яА-Я ]","").equals(str)) {
                String secondName = str.substring(0, index1);
                String firthName = str.substring(index1 + 1, index2);
                String thirdName = str.substring(index2 + 1);
                System.out.printf("Фамилия:%s\nИмя:%s\nОтчество:%s", secondName, firthName, thirdName);
            }
            else{
                System.out.println("Некоректно введены данные");
            }
        }
        else{
            System.out.println("Некоректно введены данные");
        }
    }

}
