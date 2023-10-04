package com.example.ebankingbackend.dtos;

import com.example.ebankingbackend.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
public class SavingBankAccountDTO extends BankAccountDTO{

    private String id;
    private double balance;
    private Date createAt;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    private CustomerDTO customer;
    private double interestRate;
}
