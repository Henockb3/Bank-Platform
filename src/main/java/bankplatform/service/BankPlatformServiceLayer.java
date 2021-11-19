package bankplatform.service;

import bankplatform.dto.Account;
import bankplatform.dto.User;

public interface BankPlatformServiceLayer {
    void createAccount(Account account);
    void createUser(User user);



}
