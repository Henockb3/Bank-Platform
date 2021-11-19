package bankplatform.dao;

import bankplatform.dto.Account;
import bankplatform.dto.Transaction;
import bankplatform.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao{

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setAccountNumber(resultSet.getInt("accountNumber"));
        account.setUserId(resultSet.getInt("userId"));
        account.setAccountType(resultSet.getString("accountType"));
        account.setBalance(resultSet.getBigDecimal("balance"));
        return account;
    }

    @Override
    public Account createAccount(Account account) {
        final String INSERT_ACCOUNT = "INSERT INTO account(userId,accountType,balance)" + "VALUES(?,?,?);";
        jdbc.update(INSERT_ACCOUNT,account.getUserId(),account.getAccountType(),account.getBalance());
        int newId = jdbc.queryForObject("SELECT MAX(accountNumber) FROM account", Integer.class);
        account.setAccountNumber(newId);
        return account
    }

    @Override
    public List<Transaction> listAllTransactions(Account accountNumber) {
        return null;
    }

    @Override
    public List<Transaction> getTransactionByDate(Transaction transactionDate) {
        return null;
    }

    @Override
    public Account transferMoney(Account amount) {
        return null;
    }
}
