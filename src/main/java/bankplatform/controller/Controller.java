package bankplatform.controller;

import bankplatform.dto.Account;
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

    @GetMapping("/userlist")
    public List<User> getAllUsers() {
        return serviceLayer.getAllUsers();
    }


}