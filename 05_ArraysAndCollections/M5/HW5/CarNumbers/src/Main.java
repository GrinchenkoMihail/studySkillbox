import java.util.*;

public class Main {
    public static ArrayList<String> number;
    public static HashSet<String> numberHash;
    public static TreeSet<String> numberTree;


    public static void main(String[] args) {
        final String COMMAND_STOP = "STOP";
        System.out.println("Генерация номеров ...");
        generatorCarNumbers();
        System.out.println("Номера сгенерированы");
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Введите номер или команду STOP");
            String str = scan.nextLine();
            if (str.equals(COMMAND_STOP)) {
                break;
            }

            derectSearch(str.toUpperCase());
            binSearch(str.toUpperCase());
            hashSearch(str.toUpperCase());
            mapSearch(str.toUpperCase());
        }


    }

    public static void generatorCarNumbers() {
        number = new ArrayList<>();
        numberHash = new HashSet<>();
        numberTree = new TreeSet<>();
        String[] strNum = new String[4];
        char[] latters = {'А', 'О', 'М', 'Р', 'В', 'Е', 'К', 'Х', 'С', 'Т', 'Н', 'У'};
        for (int l1 = 0; l1 < latters.length; l1++) {
            for (int n1 = 0; n1 <= 9; n1++) {
                for (int n2 = 0; n2 <= 9; n2++) {

                    for (int l2 = 0; l2 < latters.length; l2++) {
                        for (int l3 = 0; l3 < latters.length; l3++) {
                            for (int region = 1; region <= 199; region++) {
                                strNum[0] = latters[l1] + Integer.toString(n1) + Integer.toString(n2) + Integer.toString(n1) + latters[l2] + latters[l3] + Integer.toString(n1);
                                strNum[1] = latters[l1] + Integer.toString(n1) + Integer.toString(n1) + Integer.toString(n2) + latters[l2] + latters[l3] + Integer.toString(n1);
                                strNum[2] = latters[l1] + Integer.toString(n2) + Integer.toString(n1) + Integer.toString(n1) + latters[l2] + latters[l3] + Integer.toString(n1);
                                strNum[3] = latters[l1] + Integer.toString(n1) + Integer.toString(n1) + Integer.toString(n1) + latters[l2] + latters[l3] + Integer.toString(n1);
                                for (String s : strNum) {
                                    number.add(s);
                                    numberHash.add(s);
                                    numberTree.add(s);
                                }
                                if (number.size() == 3000000) {
                                    l3 = latters.length;
                                    l2 = l3;
                                    l1 = l2;
                                    n2 = 10;
                                    n1 = n2;
                                    break;
                                }
                            }
                        }

                    }


                }

            }

        }
        System.out.println(number.size());
    }

    public static void derectSearch(String str) {
        boolean answer = false;
        long start = System.nanoTime();
        for (int i = 0; i < number.size(); i++) {
            if (number.get(i).equals(str)) {

                System.out.println("Поиск перебором: номер " + str + " найден, поиск занял " + (System.nanoTime() - start) + " нс");
                answer = true;
                break;
            }
        }
        if (!answer) {
            System.out.println("Поиск перебором: номер " + str + " не найден, поиск занял " + (System.nanoTime() - start) + " нс");
        }
    }

    public static void binSearch(String str) {
        Collections.sort(number);
        long start = System.nanoTime();

        int num = Collections.binarySearch(number, str);
        long finish = System.nanoTime() - start;
        if (num < 0) {
            System.out.println("Бинарный поиск: номер " + str + " не найден, поиск занял " + finish + " нс");
        } else {
            System.out.println("Бинарный поиск: " + str + " найден, поиск занял " + finish + " нс");
        }
    }

    public static void hashSearch(String str) {
        long start = System.nanoTime();
        if (numberHash.contains(str)) {
            System.out.println("Поиск в HashSet: номер " + str + " найден, поиск занял " + (System.nanoTime() - start) + " нс");
        } else {
            System.out.println("Поиск в HashSet: номер " + str + " не найден, поиск занял " + (System.nanoTime() - start) + " нс");
        }
    }

    public static void mapSearch(String str) {
        long start = System.nanoTime();
        if (numberTree.contains(str)) {
            System.out.println("Поиск в TreeSet: номер " + str + " найден, поиск занял " + (System.nanoTime() - start) + " нс");
        } else {
            System.out.println("Поиск в TreeSet: номер " + str + " не найден, поиск занял " + (System.nanoTime() - start) + " нс");
        }

    }
}
