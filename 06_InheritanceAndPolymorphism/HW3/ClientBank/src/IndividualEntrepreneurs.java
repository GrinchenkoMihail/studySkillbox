public class IndividualEntrepreneurs extends Client {
    private final int LIMIT = 1000;
    private final double PERSENT_05 = 0.005;
    private final double PERSENT_1 = 0.01;
    private  final String NAME_CLIENT = "Индивидуальный предприниматель";
    private  final String INFO = "Пополнение с комиссией 1%, если сумма меньше 1000 рублей, и 0,5%, если сумма больше либо равна 1000 рублей";

    @Override
    public void putCheckingAccount(double money) {
        if (money >= LIMIT) {
            super.putCheckingAccount(money - (money * PERSENT_05));
        } else {
            super.putCheckingAccount(money - (money * PERSENT_1));
        }
    }
    @Override
    public void whichClient() {
        setNameClient(NAME_CLIENT);
        super.whichClient();
        printInfo();
    }

    @Override
    public void printInfo() {
        System.out.println(INFO);
    }
}



