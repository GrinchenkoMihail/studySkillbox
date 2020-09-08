
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<String> toDoList;

    public static void add(String[] command, String str) {
        if (command.length == 1) { // проверяем что введена строка задачи
            System.out.println("Не введена строка задачи");
        } else {
            str = str.replaceAll("ADD", "");
            str = str.trim();
            String[] arrStr = str.split(" ");
            String checkLineNumber = arrStr[0].replaceAll("[\\D]", "");
            if (checkLineNumber.equals(arrStr[0])) {// проверяем что указан номер задачи
                if ((Integer.parseInt(arrStr[0]) - 1) > toDoList.size()) { // проверяем что не превышен размер списка
                    System.out.println("Номер задачи превышает имеющийся список");
                } else {
                    str = "";
                    for (int i = 1; i < arrStr.length; i++) {
                        str += arrStr[i] + " ";
                    }
                    str = str.trim();
                    toDoList.add((Integer.parseInt(arrStr[0]) - 1), str);
                    System.out.println("Команда выполнена");
                }
            } else {
                toDoList.add(str);
                System.out.println("Команда выполнена");
            }
        }
    }

    public static void edit(String[] command) {
        String strNewDoings = " ";
        String[] arrStr = command;
        if (arrStr.length == 1) { // проверяем что введен носер строки
            System.out.println("Отсутсвуут номер строки");
        } else {
            String checkLineNumber = arrStr[1].replaceAll("[\\D]", "");
            if (!checkLineNumber.equals(arrStr[1])) { // проверяем что введены цифры
                System.out.println("Отсутсвуут номер строки");
            } else {
                if (toDoList.size() < Integer.parseInt(arrStr[1]) - 1) {// проверяем не преышен ли размер списка
                    System.out.println("Номер задачи превышает имеющийся список");
                } else {
                    for (int i = 2; i < arrStr.length; i++) {
                        strNewDoings += arrStr[i] + " ";
                    }
                    strNewDoings = strNewDoings.trim();
                    toDoList.set(((Integer.parseInt(arrStr[1])) - 1), strNewDoings);
                    System.out.println("Команда выполнена");
                }
            }
        }

    }

    public static void list() {
        for (int i = 0; i < toDoList.size(); i++) {
            System.out.println((i + 1) + " " + toDoList.get(i));
        }
        System.out.println("Команда выполнена");
    }

    public static void delete(String[] command, String str) {
        String[] arrStr = command;
        if (arrStr.length == 1) { //проверяем указан ли номер строки
            System.out.println("Отсутсвует номер строки");
        } else {
            String checkLineNumber = str.replaceAll("[\\D]", "");
            if (!checkLineNumber.equals(arrStr[1])) {// проверяем что введены цифры
                System.out.println("Отсутсвуут номер строки");
            } else {

                int i = Integer.parseInt(arrStr[1]);
                if (i > toDoList.size()) { // роверяем не привышен ли список задач
                    System.out.println("Номер задачи превышает имеющийся список");
                } else {
                    toDoList.remove((i - 1));
                    System.out.println("Команда выполнена");
                }
            }
        }
    }


    public static void main(String[] args) {
        toDoList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите команду из списка:\nADD, DELETE, EDIT, LIST");
        String str = scan.nextLine();
        String[] command = str.split("\\s+");
        while (!command[0].equals("STOP")) {
            switch (command[0]) {
                case "ADD": {
                    add(command, str);
                    list();
                    break;
                }
                case "EDIT": {
                    edit(command);
                    list();
                    break;
                }
                case "LIST": {
                    list();
                    break;
                }
                case "DELETE": {
                    delete(command, str);
                    list();
                    break;
                }
                default: {
                    System.out.println("Неверная команда");
                }
            }
            System.out.println("\nВведите команду из списка:\nADD, DELETE, EDIT, LIST\nИли завершите работу, введя команду STOP");
            str = scan.nextLine();
            command = str.split(" ");
        }
    }
}
