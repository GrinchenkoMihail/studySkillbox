import java.util.Scanner;

public class Main {
    private static final String COMMAND_PUT = "PUT";
    private static final String COMMAND_TAKE = "TAKE";
    private static final String COMMAND_CHECK = "CHECK";
    private static final String COMMAND_STOP = "STOP";

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = "";
        CheckingAccount checkingAccount = new CheckingAccount();
        DepositoryAccount depositoryAccount = new DepositoryAccount();
        CardAccount cardAccount = new CardAccount();


        while (!str.equals(COMMAND_STOP)) {
            System.out.println("Введите команду:\nPUT,TAKE,CHECK or STOP");
            str = scan.nextLine();
            String[] arrStr = str.split("\\s+");
            switch (arrStr[0]) {
                case COMMAND_PUT: {
                    if (checkSum(arrStr[1])) {
                        cardAccount.putMoney(Integer.parseInt(arrStr[1]));
                    } else {
                        System.out.println("Некоррекная сумма\n");
                    }
                    break;
                }
                case COMMAND_TAKE: {
                    if (checkSum(arrStr[1])) {
                        cardAccount.takeMoney(Integer.parseInt(arrStr[1]));
                    } else {
                        System.out.println("Некоррекная сумма\n");
                    }
                    break;
                }
                case COMMAND_CHECK: {
                    cardAccount.checkMoney();
                    break;
                }
                default: {
                    System.out.println("Неверная команда\n");
                    break;
                }
            }

        }

    }

    public static boolean checkSum(String str) {
        if (str.matches("[\\d]+")) {
            return true;
        } else {
            return false;
        }
    }
}
