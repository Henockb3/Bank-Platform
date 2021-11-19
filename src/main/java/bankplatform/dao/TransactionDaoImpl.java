package bankplatform.dao;

@Repository
@Profile("transaction")
public class TransactionDaoImpl implements TransactionDao{
  
  @Autowired
  private JdbcTemplate jdbcTemplate;
  
  @Override
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
  public Transaction getByAccountNumber(int accountNumber){
    final String sql = "SELECT * FROM transaction WHERE accountNumber=" + accountNumber + ";";
    return jdbcTemplate.query(sql, new TransactionMapper());
  }
  private static final class TransactionMapper implements RowMapper<Transaction> {
        @Override
        public Transaction mapRow(ResultSet rs, int index) throws SQLException {
            Transaction transaction = new Transaction(rs.getInt("transactionId"),rs.getInt("accountNumber"),rs.getString("timeStamp"),rs.getBigDecimal("transactionAmount"));
            return transaction;
        }
    }
}
