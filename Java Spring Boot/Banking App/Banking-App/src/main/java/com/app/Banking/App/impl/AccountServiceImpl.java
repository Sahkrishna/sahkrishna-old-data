package com.app.Banking.App.impl;

import com.app.Banking.App.Entity.Account;
import com.app.Banking.App.dto.AccountDto;
import com.app.Banking.App.exception.ResourceNotFoundException;
import com.app.Banking.App.mapper.AccountMapper;
import com.app.Banking.App.repository.AccountRepository;
import com.app.Banking.App.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }



    @Override
    public AccountDto createAccount(AccountDto accountDto) {

       Account account= AccountMapper.dtoToAccount(accountDto);
       Account saveAccount=this.accountRepository.save(account);

        return AccountMapper.accountToDto(saveAccount);
    }

    @Override
    public AccountDto getAccountById(int accountId) {

        Account account=this.accountRepository.findById(accountId).orElseThrow(()-> new ResourceNotFoundException("Customer","bank"));
        return AccountMapper.accountToDto(account);
    }

    @Override
    public AccountDto deposit(int accountId, double amount) {
        Account account=this.accountRepository.findById(accountId).orElseThrow(()->new ResourceNotFoundException("Customer","bank"));

       double total= account.getBalance()+amount;

       account.setBalance(total);

       Account updateAmount=this.accountRepository.save(account);
        return AccountMapper.accountToDto(updateAmount);
    }

    @Override
    public AccountDto withdrawMoney(int accountId, double amount) {

        Account account=this.accountRepository.findById(accountId).orElseThrow(()-> new ResourceNotFoundException("Customer","bank"));

        double currentBalance=account.getBalance();
        if(currentBalance>=amount){
            double total=currentBalance-amount;
            account.setBalance(total);
            this.accountRepository.save(account);
            return AccountMapper.accountToDto(account);
        }
        else {
            System.out.println("Insufficient Balance");
            throw new RuntimeException("Insufficient Balance");

        }


    }

    @Override
    public List<AccountDto> getAllAccount() {

        List<Account> accounts=this.accountRepository.findAll();

        return accounts.stream().map((account)->AccountMapper.accountToDto(account)).collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(int accountId) {
        Account account=this.accountRepository.findById(accountId).orElseThrow(()->new ResourceNotFoundException("Account","bank"));

        this.accountRepository.deleteById(accountId);
    }
}
