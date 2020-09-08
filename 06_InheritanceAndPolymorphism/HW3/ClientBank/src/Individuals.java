public class Individuals extends Client {
   private final String NAME_CLIENT = "Физическое лицо";
   private  final String INFO = "Пополнение и снятие происходит без комиссии";

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
