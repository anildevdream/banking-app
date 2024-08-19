package com.anil.project.banking_app.impl;

import com.anil.project.banking_app.dto.AccountDto;
import com.anil.project.banking_app.entity.Account;
import com.anil.project.banking_app.mapper.AccountMapper;
import com.anil.project.banking_app.repository.AccountRepository;
import com.anil.project.banking_app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Anil Kumara
 * @version 1.0
 * @email anilsince99@gmail.com
 * @since 25/07/24
 */
@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired//we can ignore this annotation to indicate  constructor injection
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account Does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        //code to check Account id exist or not
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account Does not exist"));
        //logic to add amount
        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);

    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        //code to check Account id exist or not
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account Does not exist"));
        //logic to check withdraw amount>balance
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient Balance");
        }
        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(Long id) {
        //code to check Account id exist or not
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account Does not exist"));
        accountRepository.deleteById(id);
    }
}
