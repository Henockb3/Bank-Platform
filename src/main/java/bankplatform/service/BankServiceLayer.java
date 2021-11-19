package bankplatform.service;

import bankplatform.dao.AccountDao;
import bankplatform.dao.UserDaoImpl;
import bankplatform.dto.Account;
import bankplatform.dto.User;
import org.springframework.beans.factory.annotation.Autowired;

public class BankServiceLayer implements BankPlatformServiceLayer {
    @Autowired
    UserDaoImpl dao;
    @Autowired
    AccountDao accountDao;
    @Override
    public void createAccount(User user, Account account) {
      //  User newUser = new User();

        User newAccount = dao.createUser(user);
        accountDao.createAccount(newAccount.getUserId());

    }
}
