abstract class Client {

    private final int RATE = 10000;

    private double checkingAccount = Math.random() * RATE;
    private static String nameClient = "";

    public static String getNameClient() {
        return nameClient;
    }

    public static void setNameClient(String nameClient) {
        Client.nameClient = nameClient;
    }

    public double getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(double checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public void takeCheckingAccount(double money) {
        if (money > getCheckingAccount()) {
            System.out.println("Введенная сумма превышает размер счета");
        } else {
            setCheckingAccount(getCheckingAccount() - money);
        }
    }

    public void putCheckingAccount(double money) {
        setCheckingAccount(getCheckingAccount() + money);
    }

    public void checkCheckingAccount() {
        System.out.println(checkingAccount);
    }

    public void whichClient() {
        System.out.println(getNameClient());
    }
    public void transfer(Client client, double sum){
        if(sum<=getCheckingAccount()){
        takeCheckingAccount(sum);
        client.putCheckingAccount(sum);
        }else{
            System.out.println("Введенная сумма превышает размер счета");
        }
    }

    public abstract void printInfo();
}
