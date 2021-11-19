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

    @PostMapping("/begin")
    @ResponseStatus(HttpStatus.CREATED)
    public void createGame(User user, Account account){
        serviceLayer.createAccount(user,account);
    }
}