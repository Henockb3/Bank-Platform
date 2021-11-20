package bankplatform.dao;

import bankplatform.dto.Account;
import bankplatform.dto.Transaction;
import bankplatform.dto.User;

import java.util.List;

public interface AccountDao {
    Account createAccount(Account account);
    List<Account> getAccountList();
    List<Transaction> listAllTransactions(Account account);
    List<Transaction> getTransactionByDate(Transaction transactionDate);
    Account transferMoney(Account amount);
}
