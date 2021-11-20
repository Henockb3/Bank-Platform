package bankplatform.service;

import bankplatform.dto.Account;
import bankplatform.dto.Transaction;
import bankplatform.dto.User;

import java.util.List;

public interface BankPlatformServiceLayer {
    void createAccount(Account account);
    void createUser(User user);
    void generateTransaction(Transaction transaction);
    List<User> getAllUsers();
    List<Account> getAllAccounts();


}
