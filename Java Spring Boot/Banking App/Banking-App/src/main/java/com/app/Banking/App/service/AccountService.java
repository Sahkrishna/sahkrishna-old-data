package com.app.Banking.App.service;

import com.app.Banking.App.dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(int accountId);

    AccountDto deposit(int accountId, double amount);

    AccountDto withdrawMoney(int accountId,double amount);

    List<AccountDto> getAllAccount();

    void deleteAccount(int accountId);
}
