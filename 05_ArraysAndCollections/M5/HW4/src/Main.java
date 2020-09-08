
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static TreeMap<String, String> phoneBook;
    public static String str;
    public static Scanner scan = new Scanner(System.in);
    public static final String REGEX_TELEPHONE = "[\\d]+";
    public static final String REGEX_NAME = "[\\D \\s+]+";


    public static void main(String[] args) {
        final String COMMAND_STOP = "STOP";
        final String COMMAND_LIST = "LIST";


        phoneBook = new TreeMap<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("ТЕЛЕФОННАЯ КНИГА");
        while (true) {
            str = scan.nextLine();
            if (str.equals(COMMAND_STOP)) {
                break;
            }
            if (str.matches("[\\d]+")) {
                if (phoneBook.containsValue(str)) {
                    printContactByTelephone();
                } else {
                    System.out.println("Введите имя контакта");
                    String name =getUserInput(REGEX_NAME);
                    phoneBook.put(name, str);
                }

            } else if ((str.matches("[\\D \\s+]+")) && (!str.equals(COMMAND_LIST))) {
                if (phoneBook.containsKey(str)) {
                    printTelephoneByName(str);
                } else {
                    System.out.println("Введите номер контакта");
                    String number =getUserInput(REGEX_TELEPHONE);
                    phoneBook.put(str, number);
                }
            }
            if (str.equals(COMMAND_LIST)) {
                printMap();
            }
            System.out.println("\nОжидание пользовательского запроса ...");
        }
    }

    public static void printMap() {
        for (String key : phoneBook.keySet()) {
            System.out.println(key + ": " + phoneBook.get(key));
        }
    }

    public static void printTelephoneByName(String name) {
        System.out.println(name + ": " + phoneBook.get(name));
    }

    public static void printContactByTelephone() {
        for (String key : phoneBook.keySet()) {
            if (phoneBook.get(key).equals(str)) {
                System.out.println((key + ": " + phoneBook.get(key)));
                break;
            }
        }
    }

    public static String getUserInput(String regex) {
        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            input = scanner.nextLine();
            if (input.matches(regex)) {
                break;
            } else {
                System.out.println("неверный формат ввода, попробуйте еще раз");
            }
        }
        return input;
    }

}
