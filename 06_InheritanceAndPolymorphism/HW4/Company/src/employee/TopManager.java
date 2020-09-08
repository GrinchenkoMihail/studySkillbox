package employee;

import company.Company;

public class TopManager implements Employee {
    private final double SALARY = 65000;
    private final double MIN_LIMIT = 10000000;
    private Company company;
    private double percent = 1.5;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public double getMonthSalary() {
        if (company.getIncome() > MIN_LIMIT) {
            return SALARY + SALARY * percent;
        } else {
            return SALARY;
        }
    }

    @Override
    public String getPosition() {
        return "employee.TopManager";
    }

    @Override
    public double rollMonth() {
        percent = percent * 3 / 2;
        return percent;

    }
}


