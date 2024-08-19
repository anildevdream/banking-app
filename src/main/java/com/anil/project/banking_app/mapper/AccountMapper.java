package com.anil.project.banking_app.mapper;

import com.anil.project.banking_app.dto.AccountDto;
import com.anil.project.banking_app.entity.Account;

/**
 * @author Anil Kumara
 * @version 1.0
 * @email anilsince99@gmail.com
 * @since 25/07/24
 */
public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto) {
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );
        return account;
    }

    public static AccountDto mapToAccountDto(Account account) {
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountDto;
    }
}
