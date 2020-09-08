public class LegalEntities extends Client {
    private final String NAME_CLIENT = "Юридическое лицо";
    private  final String INFO = "Снятие с комиссией 1%";
    private final double PERCENT = 0.01;

    @Override
    public void takeCheckingAccount(double money) {
        double commission = money * PERCENT;
        super.takeCheckingAccount(money + commission);
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
