package backendInfrastructure.Models;

public class Transactions {

    enum typeOfTransaction {
        DEPOSIT, WITHDRAWAL, TRANSFER, LOAN, STOCK
    }

    class transactionModel
    {
        String senderAccountAddress;
        String receiverAccountAddress;
        String amount;
        typeOfTransaction transactionType;
    }
}
