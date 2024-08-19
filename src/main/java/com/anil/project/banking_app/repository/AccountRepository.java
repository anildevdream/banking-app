package com.anil.project.banking_app.repository;

import com.anil.project.banking_app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Anil Kumara
 * @version 1.0
 * @email anilsince99@gmail.com
 * @since 25/07/24
 */
public interface AccountRepository extends JpaRepository<Account,Long> {
}
