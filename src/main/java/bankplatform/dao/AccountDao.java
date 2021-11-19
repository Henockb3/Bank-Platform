package bankplatform.dao;

import bankplatform.dto.Account;
import bankplatform.dto.Transaction;
import bankplatform.dto.User;

import java.util.List;

public interface AccountDao {
    Account createAccount(Account account);
    List<Transaction> listAllTransactions(Account accountNumber);
    List<Transaction> getTransactionByDate(Transaction transactionDate);
    Account transferMoney(Account amount);
}
