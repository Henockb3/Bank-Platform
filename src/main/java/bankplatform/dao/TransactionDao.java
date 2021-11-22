package bankplatform.dao;

import bankplatform.dto.Transaction;

import java.util.List;

public interface TransactionDao {
  void add(Transaction transaction);
  List<Transaction> getAll();
  List<Transaction> getByTimeRange(String beginning, String ending);
  List<Transaction> getByAccountNumber(int accountNumber);
  List<Transaction> getTransactionById(int userId);
}
