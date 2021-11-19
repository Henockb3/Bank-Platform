package bankplatform.dao;

public interface TranscationDao {
  void add(Transaction transaction);
  List<Transaction> getAll();
  List<Transaction> getByTimeRange(String beginning, String ending);
  Transaction getByAccountNumber(int accountNumber);
}
