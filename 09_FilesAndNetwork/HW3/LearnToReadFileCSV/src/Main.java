import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.ToDoubleFunction;

public class Main {
    static final String PATH = "data\\movementList.csv";

    public static void main(String[] args) {
        List<BankStatement> bankStatementList;
        try {
            bankStatementList = loadInformationCSV();
            System.out.println("Сумма расходов: " + String.format("%.2f", getSum(bankStatementList,BankStatement::getArrival)));
            System.out.println("Сумма доходов: " + String.format("%.2f", getSum(bankStatementList,BankStatement::getConsumption)));
            generalExpensesByOrganization(bankStatementList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static List<BankStatement> loadInformationCSV() throws Exception {
        File file = new File(PATH);
        ParseBankStatement parthBankStatement = new ParseBankStatement();
        List<BankStatement> bankStatementList = new ArrayList<>();
        if (!file.exists()) {
            throw new Exception("Файл не найден");
        } else {
            List<String> lines = Files.readAllLines(Paths.get(PATH));
            lines.remove(0);
            for (String line : lines) {
                String[] fragments = line.split(",");
                bankStatementList.add(parthBankStatement.parseBankStatement(fragments));
            }
            return bankStatementList;
        }
    }

    private static  double getSum(List<BankStatement> bankStatementList, ToDoubleFunction<BankStatement> function){
        return bankStatementList.stream().mapToDouble(function).sum();
    }


    private static void generalExpensesByOrganization(List<BankStatement> bankStatementList) {
        List<String> checkCompanyList = new ArrayList<>();
        System.out.println("\nСуммы расходов по организациям:");
        for (BankStatement statement : bankStatementList) {
            double sum = 0;
            if (!checkCompanyList.contains(statement.getNameCompany())) {
                String company = statement.getNameCompany();
                checkCompanyList.add(company);
                sum = bankStatementList.stream()
                        .filter(x -> x.getNameCompany().equals(company))
                        .mapToDouble(BankStatement::getConsumption)
                        .sum();
                System.out.println(company + " " + String.format("%.2f", sum));
            }
        }
    }
}
