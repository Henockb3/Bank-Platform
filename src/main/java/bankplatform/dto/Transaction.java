package bankplatform.dto;

import java.math.BigDecimal;

public class Transaction {
    int transactionId;
    int accountNumber;
    String timeStamp;
    BigDecimal transactionAmount;

    public Transaction() {
    }

    public Transaction(int transactionId, int accountNumber, String timeStamp, BigDecimal transactionAmount) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.timeStamp = timeStamp;
        this.transactionAmount = transactionAmount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", accountNumber=" + accountNumber +
                ", timeStamp='" + timeStamp + '\'' +
                ", transactionAmount=" + transactionAmount +
                '}';
    }
}
