package com.app.Banking.App.Controller;

import com.app.Banking.App.dto.AccountDto;
import com.app.Banking.App.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @PostMapping("/")
    public ResponseEntity<AccountDto> saveAccount(@RequestBody AccountDto accountDto){
        AccountDto savedAccount=this.accountService.createAccount(accountDto);

        return  new ResponseEntity<>(savedAccount, HttpStatus.CREATED);

    }
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> findAccountById(@PathVariable int id){

        return new ResponseEntity<>(this.accountService.getAccountById(id),HttpStatus.FOUND);
    }
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> depositMoney(@PathVariable int id, @RequestBody Map<String,Double> request){

        Double amount=request.get("amount");

        AccountDto account=this.accountService.deposit(id,amount);

        return  ResponseEntity.ok(account);
    }
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable int id,@RequestBody Map<String,Double> request){
       Double amount= request.get("amount");

        AccountDto account=this.accountService.withdrawMoney(id,amount);

        return  ResponseEntity.ok(account);
    }
    @GetMapping("/")
    public ResponseEntity<List<AccountDto>> getAllAccount(){

        List<AccountDto> accounts=this.accountService.getAllAccount();

        return ResponseEntity.ok(accounts);
    }
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deletedAccount(@PathVariable("id") int accountId){

        this.accountService.deleteAccount(accountId);

        return ResponseEntity.ok("Deleted account successfully");
    }
}
