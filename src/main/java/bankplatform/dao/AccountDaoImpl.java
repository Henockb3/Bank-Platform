package bankplatform.dao;

import bankplatform.dto.Account;
import bankplatform.dto.AccountType;
import bankplatform.dto.Transaction;
import bankplatform.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
    public static final class accountMapper implements RowMapper<Account> {
        @Override
        public Account mapRow(ResultSet resultSet, int i) throws SQLException {
            Account account = new Account();
            account.setAccountNumber(resultSet.getInt("accountNumber"));
            account.setUserId(resultSet.getInt("userId"));
            account.setAccountType(AccountType.valueOf(resultSet.getString("accountType").toUpperCase()));
            account.setBalance(resultSet.getBigDecimal("balance"));
            return account;
        }
    }

    @Override
    public Account createAccount(Account account) {
        final String INSERT_ACCOUNT = "INSERT INTO account(userId,accountType,balance)" + "VALUES(?,?,?);";
        jdbc.update(INSERT_ACCOUNT,account.getUserId(),account.getAccountType().toString(),account.getBalance());
        int newId = jdbc.queryForObject("SELECT MAX(accountNumber) FROM account", Integer.class);
        account.setAccountNumber(newId);
        return account;
    }

    @Override
    public List<Account> getAccountList(){
        final String SELECT_ACCOUNTS = "SELECT * FROM account";
        return jdbc.query(SELECT_ACCOUNTS, new accountMapper());
    }
    @Override
    public Account getAccountByNumber(int accountNumber){
        final String SELECT_ACCOUNT = "SELECT * FROM account WHERE accountNumber = ?;";
        return jdbc.queryForObject(SELECT_ACCOUNT, new accountMapper(), accountNumber);
    }
    @Override
    public void updateAccount(Account account){
        final String UPDATE_ACCOUNT = "UPDATE account SET balance = ? WHERE accountNumber = ?;";
        jdbc.update(UPDATE_ACCOUNT,account.getBalance(),account.getAccountNumber());
    }
    @Override
    public List<Account> getAccountsById(int userId){
        final String SELECT_ACCOUNTS = "SELECT * FROM account WHERE userId = ?;";
        return jdbc.query(SELECT_ACCOUNTS, new accountMapper(), userId);
    }

}
