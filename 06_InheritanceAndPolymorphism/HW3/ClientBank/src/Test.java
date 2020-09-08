import java.util.ArrayList;

public class Test {
    private static final double MONEY_1 = 500;
    private static final double MONEY_2 = 1000;
    private static final double MONEY_3 = 1500;
    private static ArrayList<Client> arrClients;

    public static void main(String[] args) {

        arrClients = new ArrayList<>();

        arrClients.add(new Individuals());
        arrClients.add(new LegalEntities());
        arrClients.add(new IndividualEntrepreneurs());

        checkClientsMoney();

        putAllClients(MONEY_1);
        putAllClients(MONEY_2);
        putAllClients(MONEY_3);

        takeAllClients(MONEY_1);
        takeAllClients(MONEY_2);
        takeAllClients(MONEY_3);


        System.out.println("\n\n\n Проверка перевода денег");
        arrClients.get(0).transfer(arrClients.get(1), 100);
        checkClientsMoney();

    }

    private static void checkClientsMoney() {
        for (Client c : arrClients) {
            c.whichClient();
            c.checkCheckingAccount();
        }
    }

    private static void putAllClients(double money) {
        System.out.println("\nКаждый клиент пополняет свой счет на " + money);
        for (Client c : arrClients) {
            c.whichClient();
            c.putCheckingAccount(money);
            c.checkCheckingAccount();
        }
    }

    private static void takeAllClients(double money) {
        System.out.println("\nКаждый клиент снимает со своего счет " + money);
        for (Client c : arrClients) {
            c.whichClient();
            c.takeCheckingAccount(money);
            c.checkCheckingAccount();
        }
    }
}
