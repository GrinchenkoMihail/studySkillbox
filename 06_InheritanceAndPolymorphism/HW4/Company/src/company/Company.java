package company;

import employee.Employee;

import java.util.*;


public class Company {


    private List<Employee> allEmployees = new ArrayList<>();
    private final int COMPANY_INCOME_COEFFICIENT = 15000000;

    public List<employee.Employee> getAllEmployees() {
        return allEmployees;
    }

    private double income = (Math.random() * COMPANY_INCOME_COEFFICIENT);

    public void hire(Employee employee) {
        allEmployees.add(employee);
    }

    public void hireAll(List<Employee> employee) {
        allEmployees.addAll(employee);
    }

    public void fire(int count) {
        if (allEmployees.size() < count) {
            System.out.println("Превышен размер списка");
        } else {

            allEmployees.remove(count);
        }

    }

    public double getIncome() {
        return income;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        Comparator<Employee> salaryComparator = Comparator.comparing(Employee::getMonthSalary);
        allEmployees.sort(salaryComparator.reversed());
        return getSortedEmployees(count);
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        Comparator<Employee> salaryComparator = Comparator.comparing(Employee::getMonthSalary);
        allEmployees.sort(salaryComparator);
        return getSortedEmployees(count);
    }

    public void recountOfSalaries() {
        for (Employee e : allEmployees) {
            e.rollMonth();
        }
    }

    private List<Employee> getSortedEmployees(int count) {
        List<Employee> sortArr = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            sortArr.add(allEmployees.get(i));
        }
        return sortArr;
    }


}

