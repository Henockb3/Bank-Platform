package bankplatform.dao;

import bankplatform.dto.Account;
import bankplatform.dto.Transaction;
import bankplatform.dto.User;

import java.util.List;

public class AccountDaoImpl implements AccountDao{
    @Override
    public Account createAccount(User userId) {
        return null;
    }

    @Override
    public List<Transaction> listAllTransactions(Account accountNumber) {
        return null;
    }

    @Override
    public List<Transaction> getTransactionByDate(Transaction transactionDate) {
        return null;
    }
}
