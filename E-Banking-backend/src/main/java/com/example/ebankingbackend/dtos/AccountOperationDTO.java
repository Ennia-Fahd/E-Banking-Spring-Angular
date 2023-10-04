package com.example.ebankingbackend.dtos;

import com.example.ebankingbackend.entities.BankAccount;
import com.example.ebankingbackend.enums.OperationType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
public class AccountOperationDTO {

    private  Long id;
    private Date operationDate;
    private double amount;
    @Enumerated(EnumType.STRING)
    private OperationType type;
    private String description;
}
