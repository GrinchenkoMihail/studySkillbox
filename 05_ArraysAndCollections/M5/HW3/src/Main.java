import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static HashSet<String> mailHash;

    //имя_пользователя@имя_домена

    public static void main(String[] args) {
        mailHash = new HashSet<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите команду из списка:\nADD or LIST");
        String str = "";
        String[] command = str.split("\\s+");
        while (!command[0].equals("STOP")) {
            str = scan.nextLine();
            command = str.split("\\s+");
            switch (command[0]) {
                case "ADD": {
                    if (isEmail(command[1])) {
                        mailHash.add(command[1]);
                    } else {
                        System.out.println("Неверно введен адрес электронной почты");
                    }
                    break;
                }
                case "LIST": {
                    list();
                    break;
                }
                default: {
                    System.out.println("Неверная команда");
                }
            }
            System.out.println("\nВведите команду из списка:\nADD or LIST\nИли завершите работу, введя команду STOP");
        }
    }

    public static void list() {
        if (mailHash.size() == 0) {
            System.out.println("Список пуст");
        } else {
            for (String i : mailHash) {
                System.out.println(i);
            }
        }
    }

    public static boolean isEmail(String email) {
        return email.matches("[\\D \\d]+" + "@" + "[\\D \\d]+" + "\\." + "[\\D]{2,12}");
    }
}
