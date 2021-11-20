package bankplatform.service;

import bankplatform.dto.Account;
import bankplatform.dto.User;

import java.util.List;

public interface BankPlatformServiceLayer {
    void createAccount(Account account);
    void createUser(User user);
    List<User> getAllUsers();
    List<Account> getAllAccounts();


}
