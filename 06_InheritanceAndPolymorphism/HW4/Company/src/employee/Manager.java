package employee;


public class Manager implements Employee {
    private final double SALARY = 40000;
    private final double PERCENT = 0.05;
    private final int MIN_EARNED_MONEY = 115000;
    private final int MAX_EARNED_MONEY = 140000;
    private final int DIFFERENCE = MIN_EARNED_MONEY - MAX_EARNED_MONEY;
    private double randomCoefficientSalaryForManager = Math.random();


    @Override
    public double getMonthSalary() {

        return (SALARY + ((randomCoefficientSalaryForManager * (DIFFERENCE + 1)) + MAX_EARNED_MONEY) * PERCENT);
    }

    @Override
    public String getPosition() {
        return "employee.Manager";
    }

    @Override
    public double rollMonth() {
        randomCoefficientSalaryForManager = Math.random();
        return getMonthSalary();
    }


}
