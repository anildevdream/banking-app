package com.anil.project.banking_app.service;

import com.anil.project.banking_app.dto.AccountDto;
import com.anil.project.banking_app.entity.Account;

import java.util.List;

/**
 * @author Anil Kumara
 * @version 1.0
 * @email anilsince99@gmail.com
 * @since 25/07/24
 */
public interface AccountService {
    AccountDto createAccount(AccountDto account);
    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id,double amount);
    AccountDto withdraw(Long id,double amount);
    List<AccountDto> getAllAccounts();
    void deleteAccount(Long id);
}
