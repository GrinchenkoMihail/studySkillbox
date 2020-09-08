package employee;


public class Operator implements Employee {
    private final double SALARY = 30000;
    private final double PREMIUM_OR_FINE = 5000;
    private double salary = SALARY;


    @Override
    public double getMonthSalary() {
        return salary;
    }

    @Override
    public String getPosition() {
        return "employee.Operator";
    }

    @Override
    public double rollMonth() {
        double rnd = Math.random();
        if (rnd > 0.5) {
            return salary = SALARY + PREMIUM_OR_FINE;
        } else {
            return salary = SALARY - PREMIUM_OR_FINE;
        }
    }
}
