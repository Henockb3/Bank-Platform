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
    public void createAccount( Account account) {
      //  User newUser = new User();

      //  account.setUserId(account.getUserId());

        accountDao.createAccount(account);

    }

    @Override
    public void createUser(User user) {
        dao.createUser(user);
    }


}
