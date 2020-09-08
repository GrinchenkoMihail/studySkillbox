public class CardAccount extends CheckingAccount {
    private final double PERCENT = 0.01;

    @Override
    public void takeMoney(double money) {
        double commission = money * PERCENT;
        super.takeMoney(money + commission);
    }
}
