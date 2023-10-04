package com.example.ebankingbackend;

import com.example.ebankingbackend.dtos.CurrentBankAccountDTO;
import com.example.ebankingbackend.dtos.CustomerDTO;
import com.example.ebankingbackend.dtos.SavingBankAccountDTO;
import com.example.ebankingbackend.entities.*;
import com.example.ebankingbackend.enums.AccountStatus;
import com.example.ebankingbackend.enums.OperationType;
import com.example.ebankingbackend.repositories.AccountOperationRepository;
import com.example.ebankingbackend.repositories.BankAccountRepository;
import com.example.ebankingbackend.repositories.CustomerRepository;
import com.example.ebankingbackend.services.BankAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankingBackendApplication.class, args);
    }

    //@Bean
    CommandLineRunner commandLineRunner(BankAccountService bankAccountService) {
        return args -> {
            Stream.of("Hassan", "Yassine", "Aziz").forEach(name -> {
                CustomerDTO customer = new CustomerDTO();
                customer.setName(name);
                customer.setEmail(name + "@gmail.com");
                bankAccountService.saveCustomer(customer);
            });
            bankAccountService.listCustomers().forEach(customer -> {
                bankAccountService.saveCurrentBankAccount(Math.random() * 90000, customer.getId(), 9000);
                bankAccountService.saveSavingBankAccount(Math.random() * 120000, customer.getId(), 5.5);
                bankAccountService.bankAccountsList().forEach(b -> {
                    String s ;
                    if(b instanceof SavingBankAccountDTO) s = ((SavingBankAccountDTO) b).getId();
                    else s = ((CurrentBankAccountDTO) b).getId();
                    bankAccountService.credit(s, 10000 + Math.random() * 120000, "Credit");
                    bankAccountService.debit(s, 100 + Math.random() * 1200, "Debit");
                });
            });
        };
    }

    //@Bean
    CommandLineRunner start(CustomerRepository customerRepository, BankAccountRepository bankAccountRepository, AccountOperationRepository accountOperationRepository) {
        return args -> {
            Stream.of("Hassan","Yassine","Aziz").forEach(cust -> {
                Customer customer = new Customer();
                customer.setName(cust);
                customer.setEmail(cust+"@gmail.com");

                customerRepository.save(customer);
            });

            customerRepository.findAll().forEach(cust -> {
                CurrentAccount currentAccount = new CurrentAccount();
                currentAccount.setId(UUID.randomUUID().toString());
                currentAccount.setBalance(Math.random() * 10000);
                currentAccount.setCreateAt(new Date());
                currentAccount.setStatus(AccountStatus.CREATED);
                currentAccount.setCustomer(cust);
                currentAccount.setOverDraft(9000);

                bankAccountRepository.save(currentAccount);
            });

            customerRepository.findAll().forEach(cust -> {
                SavingAccount savingAccount = new SavingAccount();
                savingAccount
                        .setId(UUID.randomUUID().toString());
                savingAccount.setBalance(Math.random() * 10000);
                savingAccount.setCreateAt(new Date());
                savingAccount.setStatus(AccountStatus.CREATED);
                savingAccount.setCustomer(cust);
                savingAccount.setInterestRate(5);

                bankAccountRepository.save(savingAccount);
            });

            bankAccountRepository.findAll().forEach(ba -> {
                AccountOperation accountOperation = new AccountOperation();
                accountOperation.setOperationDate(new Date());
                accountOperation.setAmount(Math.random()*500);
                accountOperation.setType(Math.random() > 0.5?OperationType.DEBIT : OperationType.CREDIT);
                accountOperation.setBankAccount(ba);

                accountOperationRepository.save(accountOperation);
            });
        };
    }

}

