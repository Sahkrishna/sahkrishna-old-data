package com.app.Banking.App.mapper;

import com.app.Banking.App.Entity.Account;
import com.app.Banking.App.dto.AccountDto;

public class AccountMapper {


    public static Account dtoToAccount(AccountDto accountDto){

        Account account= new Account(accountDto.getAccountId(),accountDto.getAccountHolderName(),accountDto.getAccountNumber(),accountDto.getBalance());

        return  account;

    }
    public static AccountDto accountToDto(Account account){

        AccountDto accountDto= new AccountDto(account.getAccountId(),account.getAccountHolderName(),account.getAccountNumber(),account.getBalance());

        return  accountDto;

    }
}
