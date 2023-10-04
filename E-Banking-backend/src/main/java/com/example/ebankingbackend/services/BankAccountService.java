package com.example.ebankingbackend.services;

import com.example.ebankingbackend.dtos.*;
import com.example.ebankingbackend.entities.BankAccount;
import com.example.ebankingbackend.entities.Customer;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
public interface BankAccountService {

    //Logger log = LoggerFactory.getLogger(this.getClass().getName());
    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    CurrentBankAccountDTO saveCurrentBankAccount(double InitialBalance, Long customerId, double overDraft);
    SavingBankAccountDTO saveSavingBankAccount(double InitialBalance, Long customerId, double interestRate);
    List<CustomerDTO> listCustomers();
    BankAccountDTO getBankAccoount(String accountId);
    void debit(String accountId,double amount,String description);
    void credit(String accountId,double amount,String description);
    void transfert(String accountIdSource,String accountIdDestination,double amount);
    List<BankAccountDTO> bankAccountsList();
    public CustomerDTO getCustomer(Long CustomerId) throws Exception;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long CustomerId);

    List<AccountOperationDTO> AccountHistory(String accountId);

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size);

    List<CustomerDTO> searchCustomers(String keyword);

    List<BankAccount> getaccountsCustomer(Long CustomerId);
}
