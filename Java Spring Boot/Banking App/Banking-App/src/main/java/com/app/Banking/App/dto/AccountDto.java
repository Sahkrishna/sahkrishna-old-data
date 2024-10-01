package com.app.Banking.App.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private  int accountId;
    private String accountHolderName;
    private Long accountNumber;
    private double balance;

}
