import java.time.LocalDate;

public class DepositoryAccount extends CheckingAccount {
    private LocalDate lastDateTakeMoney;

    @Override
    public void takeMoney(double money) {
        LocalDate today = LocalDate.now();
        if (today.isAfter(lastDateTakeMoney.plusMonths(1))) {
            super.takeMoney(money);
        } else {
            System.out.println("Снятие невозможно, месяц еще не истек.");
        }
    }

    @Override
    public void putMoney(double money) {
        lastDateTakeMoney = LocalDate.now();
        super.putMoney(money);
    }
}
