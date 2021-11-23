package bankplatform.controller;

import bankplatform.dto.Account;
import bankplatform.dto.Transaction;
import bankplatform.dto.User;
import bankplatform.service.BankServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

    @Autowired
    BankServiceLayer serviceLayer;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user){
        serviceLayer.createUser(user);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/account")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@RequestBody Account account){
        serviceLayer.createAccount(account);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/transaction")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTransaction(@RequestBody Transaction transaction){
        serviceLayer.generateTransaction(transaction);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/userlist")
    public List<User> getAllUsers() {
        return serviceLayer.getAllUsers();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/accountlist")
    public List<Account> getAllAccounts() {
        return serviceLayer.getAllAccounts();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/accounts")
    public List<Account> getCheckingAndSavings(int userId){
        return serviceLayer.getAccountListByUserId(userId);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getUser")
    public User getMyUser(String email, String password){
        return serviceLayer.getUserByEmailAndPassword(email,password);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/transfer")
    public void transfer(int fromAccountNumber, int toAccountNumber, BigDecimal amount){
        serviceLayer.transferMoney(fromAccountNumber,toAccountNumber,amount);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/usertransactions")
    public List<Transaction> getTransactionById(int userId){
        return serviceLayer.getAllTransactionsById(userId);
    }
}
