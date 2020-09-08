import java.util.Date;

public class BankStatement {
    private String accountType;
    private String accountNumber;
    private String currency;
    private Date dateOfOperation;
    private String wirinReference;
    private String operationDescription;
    private double arrival;
    private double consumption;
    private String nameCompany;

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setDateOfOperation(Date dateOfOperation) {
        this.dateOfOperation = dateOfOperation;
    }

    public void setWirinReference(String wirinReference) {
        this.wirinReference = wirinReference;
    }

    public void setOperationDescription(String operationDescription) {
        this.operationDescription = operationDescription;
    }

    public void setArrival(double arrival) {
        this.arrival = arrival;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }


    public String getAccountType() {
        return accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public Date getDateOfOperation() {
        return dateOfOperation;
    }

    public String getWirinReference() {
        return wirinReference;
    }

    public String getOperationDescription() {
        return operationDescription;
    }

    public double getArrival() {
        return arrival;
    }

    public double getConsumption() {
        return consumption;
    }

    public String getNameCompany() {
        return nameCompany;
    }

// Consumption


}
