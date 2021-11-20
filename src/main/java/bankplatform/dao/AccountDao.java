package bankplatform.dao;

import bankplatform.dto.Account;
import bankplatform.dto.Transaction;
import bankplatform.dto.User;

import java.util.List;

public interface AccountDao {
    Account createAccount(Account account);
    List<Account> getAccountList();
    Account getAccountByNumber(int accountNumber);
    void updateAccount(Account account);
    List<Transaction> listAllTransactions(int accountNumber);
    List<Transaction> getTransactionByDate(Transaction transactionDate);
}
