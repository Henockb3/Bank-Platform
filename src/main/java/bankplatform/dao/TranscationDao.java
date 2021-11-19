package bankplatform.dao;

import bankplatform.dto.Transaction;

import java.util.List;

public interface TranscationDao {
  void add(Transaction transaction);
  List<Transaction> getAll();
  List<Transaction> getByTimeRange(String beginning, String ending);
  Transaction getByAccountNumber(int accountNumber);
}
