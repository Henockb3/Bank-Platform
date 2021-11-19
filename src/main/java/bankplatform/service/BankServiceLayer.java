package bankplatform.service;

import bankplatform.dao.AccountDao;
import bankplatform.dao.UserDaoImpl;
import bankplatform.dto.Account;
import bankplatform.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceLayer implements BankPlatformServiceLayer {

    @Autowired
    UserDaoImpl userDao;
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
        userDao.createUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getUserList();
    }
}
