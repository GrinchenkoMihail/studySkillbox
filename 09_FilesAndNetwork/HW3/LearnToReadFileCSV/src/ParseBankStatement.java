import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ParseBankStatement {
    private final int INDEX_ACCOUNT_TYPE = 0;
    private final int INDEX_ACCOUNT_NUMBER = 1;
    private final int INDEX_CURRENCY = 2;
    private final int INDEX_DATE_OF_OPERATION = 3;
    private final int INDEX_WIRIN_REFERENCE = 4;
    private final int INDEX_OPERATION_DESCRIPTION = 5;
    private final int INDEX_ARRIVAL = 6;
    private final int INDEX_CONSUMPTION = 7;
    private DateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    public BankStatement parseBankStatement(String[] fragments) throws ParseException {

            BankStatement bankStatement = new BankStatement();

            bankStatement.setAccountType(fragments[INDEX_ACCOUNT_TYPE]);
            bankStatement.setAccountNumber(fragments[INDEX_ACCOUNT_NUMBER]);
            bankStatement.setCurrency(fragments[INDEX_CURRENCY]);
            bankStatement.setDateOfOperation(format.parse(fragments[INDEX_DATE_OF_OPERATION]));
            bankStatement.setWirinReference(fragments[INDEX_WIRIN_REFERENCE]);
            bankStatement.setOperationDescription(fragments[INDEX_OPERATION_DESCRIPTION]);
            bankStatement.setArrival(Double.parseDouble(fragments[INDEX_ARRIVAL].replaceAll("[\\D]", "")));
            bankStatement.setConsumption(Double.parseDouble(fragments[INDEX_CONSUMPTION].replaceAll("[\\D]", "")));

            if (fragments[INDEX_OPERATION_DESCRIPTION].contains("\\")) {
                int first = fragments[INDEX_OPERATION_DESCRIPTION].indexOf("\\");
                int second = fragments[INDEX_OPERATION_DESCRIPTION].indexOf("   ", first);
                String str = fragments[INDEX_OPERATION_DESCRIPTION].substring(first, second);
                bankStatement.setNameCompany(str.replaceAll("\\W", ""));
            } else {
                String str = "RU/CARD2CARD ALFA_MOBILE>MOSCOW";
                bankStatement.setNameCompany(str.replaceAll("\\W", ""));
            }

        return bankStatement;
    }
}
