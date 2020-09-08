public class CheckingAccount {
    private double moneyInTheAccount = 0;

    public void checkMoney() { // TODO  посмотреть, сколько денег на счёте.
        System.out.println(moneyInTheAccount);
    }

    public void putMoney(double money) {        //TODO деньги  положить
        moneyInTheAccount = moneyInTheAccount + money;
    }

    public void takeMoney(double money) { // TODO деньги снять

        if (money > moneyInTheAccount) {
            System.out.println("Не корректная сумма");
        } else {
            moneyInTheAccount = moneyInTheAccount - money;
        }
    }
}
