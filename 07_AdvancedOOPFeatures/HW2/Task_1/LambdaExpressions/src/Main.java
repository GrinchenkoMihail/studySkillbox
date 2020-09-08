import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

import static java.util.Calendar.YEAR;

public class Main {
    private static String staffFile = "data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";
    private static Calendar minDiapason = new GregorianCalendar(2017, 0, 1); //ввести только дату
    private static Calendar maxDiapason = minDiapason;
    private static Date dateYearMin = minDiapason.getTime();
    private static Date dateYearMax;



    public static void main(String[] args) {
        maxDiapason.add(YEAR, 1);
        dateYearMax = maxDiapason.getTime();
        ArrayList<Employee> staff = loadStaffFromFile();
        staff.stream()
                .filter(employee -> employee.getWorkStart().after(dateYearMin))
                .filter(employee -> employee.getWorkStart().before(dateYearMax))
                .max(Comparator.comparing(Employee::getSalary))
                .ifPresent(System.out::println);
    }

    private static ArrayList<Employee> loadStaffFromFile() {
        ArrayList<Employee> staff = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for (String line : lines) {
                String[] fragments = line.split("\t");
                if (fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new Employee(
                        fragments[0],
                        Integer.parseInt(fragments[1]),
                        (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }
}