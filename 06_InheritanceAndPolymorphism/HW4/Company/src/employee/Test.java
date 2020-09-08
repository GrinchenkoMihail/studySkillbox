package employee;

import company.Company;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private final static String OPERATOR = "employee.Operator";
    private final static String MANAGER = "employee.Manager";
    private final static String TOP_MANAGER = "employee.TopManager";
    private final static int OPERATOR_AMOUNT = 30;
    private final static int MANAGER_AMOUNT = 20;
    private final static int TOP_MANAGER_AMOUNT = 5;
    private final static boolean ON = true;
    private final static boolean OFF = false;

    public static Company company = new Company();


    public static void main(String[] args) {
        company.hireAll(createListEmployee(OPERATOR, OPERATOR_AMOUNT));
        company.hireAll(createListEmployee(TOP_MANAGER, TOP_MANAGER_AMOUNT));
        company.hireAll(createListEmployee(MANAGER, MANAGER_AMOUNT));


        //TODO список из самых высоких зп
        showList(company.getTopSalaryStaff(10));
        //TODO список из самых низких зп
        showList(company.getLowestSalaryStaff(10));
        //TODO увольяем 1/2
        delete(company);
        //TODO список из самых высоких зп
        showList(company.getTopSalaryStaff(10));
        //TODO список из самых низких зп
        showList(company.getLowestSalaryStaff(10));
        // TODO перерасчет зп на другой месяц
        System.out.println("\nПерерасчет на новый месяц\n");
        company.recountOfSalaries();
        //TODO список из самых высоких зп
        showList(company.getTopSalaryStaff(10));
        //TODO список из самых низких зп
        showList(company.getLowestSalaryStaff(10));


    }

    public static List<Employee> createListEmployee(String str, int size) {
        List<Employee> arrEmp = new ArrayList<>();
        Employee emp;
        for (int i = 0; i < size; i++) {
            if (str.equals(OPERATOR)) {
                emp = new Operator();
            } else if (str.equals(MANAGER)) {
                emp = new Manager();
            } else {
                emp = new TopManager(company);
            }
            arrEmp.add(emp);
        }
        return arrEmp;
    }

    public static void delete(Company company) {
        int operator = 0;
        for (; operator < OPERATOR_AMOUNT / 2; operator++) {
            company.fire(operator);
        }
        int manager;
        for (manager = operator; manager < operator + MANAGER_AMOUNT / 2; manager++) {
            company.fire(manager);
        }
        for (int managerTop = manager; managerTop < manager + TOP_MANAGER_AMOUNT / 2; managerTop++) {
            company.fire(managerTop);
        }
    }

    public static void showList(List<Employee> employees) {
        for (int i = 0; i < employees.size(); i++) {
            System.out.println((i + 1) + " " + employees.get(i).getPosition() + " " + employees.get(i).getMonthSalary());
        }
    }


}

