package bankplatform.service;

import bankplatform.dao.AccountDao;
import bankplatform.dao.UserDaoImpl;
import bankplatform.dto.Account;
import bankplatform.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceLayer implements BankPlatformServiceLayer {

    @Autowired
    UserDaoImpl dao;
    @Autowired
    AccountDao accountDao;

    @Override
    public void createAccount(User user, Account account) {
      //  User newUser = new User();

        account.setUserId(user.getUserId());
        dao.createUser(user);
        accountDao.createAccount(account);

    }


}
