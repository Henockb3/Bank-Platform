package bankplatform.service;

import bankplatform.dao.AccountDao;
import bankplatform.dao.TransactionDao;
import bankplatform.dao.UserDaoImpl;
import bankplatform.dto.Account;
import bankplatform.dto.Transaction;
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
    @Autowired
    TransactionDao transactionDao;

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
    public void generateTransaction(Transaction transaction){
        transactionDao.add(transaction);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getUserList();
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountDao.getAccountList();
    }
}
