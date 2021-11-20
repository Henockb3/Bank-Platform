package bankplatform.controller;

import bankplatform.dto.Account;
import bankplatform.dto.Transaction;
import bankplatform.dto.User;
import bankplatform.service.BankServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    BankServiceLayer serviceLayer;

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user){
        serviceLayer.createUser(user);
    }
    @PostMapping("/account")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody Account account){
        serviceLayer.createAccount(account);
    }
    @PostMapping("/transaction")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTransaction(@RequestBody Transaction transaction){
        serviceLayer.generateTransaction(transaction);
    }

    @GetMapping("/userlist")
    public List<User> getAllUsers() {
        return serviceLayer.getAllUsers();
    }

    @GetMapping("/accountlist")
    public List<Account> getAllAccounts() {
        return serviceLayer.getAllAccounts();
    }


}