package bankplatform.dao;


import bankplatform.dto.Transaction;
import bankplatform.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.List;

@Repository
public class TransactionDaoImpl implements TransactionDao{
  
  @Autowired
  private JdbcTemplate jdbcTemplate;

  public static final class TransactionMapper implements RowMapper<Transaction>{

    @Override
    public Transaction mapRow(ResultSet resultSet, int i) throws SQLException {
      Transaction transaction = new Transaction();
      transaction.setTransactionId(resultSet.getInt("transactionId"));
      transaction.setAccountNumber(resultSet.getInt("accountNumber"));
      transaction.setTimeStamp(resultSet.getString("timeStamp"));
      transaction.setTransactionAmount(resultSet.getBigDecimal("transactionAmount"));

      return transaction;
    }
  }

  @Override
  @Transactional
  public void add(Transaction transaction){
    final String sql = "INSERT INTO transaction(accountNumber,timeStamp,transactionAmount) VALUES(?,?,?);";
    GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update((Connection conn) -> {
      PreparedStatement statement = conn.prepareStatement(
              sql,
              Statement.RETURN_GENERATED_KEYS
      );
      statement.setInt(1,transaction.getAccountNumber());
      statement.setString(2,transaction.getTimeStamp());
      statement.setBigDecimal(3, transaction.getTransactionAmount());
      
      return statement;

    },keyHolder);
    
    transaction.setTransactionId(keyHolder.getKey().intValue());
  }
  @Override
  public List<Transaction> getAll() {
    final String sql = "SELECT * from transaction;";
    return jdbcTemplate.query(sql, new TransactionMapper());
  }
  @Override
  public List<Transaction> getByTimeRange(String beginning, String ending){
    final String sql = "SELECT * FROM transaction WHERE timeStamp BETWEEN " + beginning + " AND " + ending + ";";
    return jdbcTemplate.query(sql, new TransactionMapper());
  }

  @Override
  public List<Transaction> getByAccountNumber(int accountNumber){
    final String sql = "SELECT * FROM transaction WHERE accountNumber=" + accountNumber + ";";
    return jdbcTemplate.query(sql, new TransactionMapper());
  }

}
