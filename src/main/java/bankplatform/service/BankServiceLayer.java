package bankplatform.service;

import bankplatform.dao.AccountDao;
import bankplatform.dao.TransactionDao;
import bankplatform.dao.UserDaoImpl;
import bankplatform.dto.Account;
import bankplatform.dto.Transaction;
import bankplatform.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @Override
    public List<Account> getAccountListByUserId(int userId) {
        return accountDao.getAccountsById(userId);
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password){
        return userDao.getUserByEmailAndPassword(email,password);
    }

    @Override
    public void transferMoney(int fromAccountNumber, int toAccountNumber, BigDecimal amount){
        Account account1 = accountDao.getAccountByNumber(fromAccountNumber);
        Account account2 = accountDao.getAccountByNumber(toAccountNumber);

        if(account1.getBalance().subtract(amount).doubleValue() > 0.0) {

            BigDecimal big1 = account1.getBalance().subtract(amount);
            account1.setBalance(big1.setScale(2, RoundingMode.HALF_UP));
            BigDecimal big2 = account2.getBalance().add(amount);
            account2.setBalance(big2.setScale(2, RoundingMode.HALF_UP));

            accountDao.updateAccount(account1);
            accountDao.updateAccount(account2);

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            Transaction transaction1 = new Transaction();
            transaction1.setAccountNumber(account1.getAccountNumber());
            transaction1.setTimeStamp(now.format(formatter));
            transaction1.setTransactionAmount(amount.negate());
            transactionDao.add(transaction1);

            now = LocalDateTime.now();
            Transaction transaction2 = new Transaction();
            transaction2.setAccountNumber(account2.getAccountNumber());
            transaction2.setTimeStamp(now.format(formatter));
            transaction2.setTransactionAmount(amount);
            transactionDao.add(transaction2);
        }
    }
}
