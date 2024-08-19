package com.anil.project.banking_app.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.internal.build.AllowNonPortable;

/**
 * @author Anil Kumara
 * @version 1.0
 * @email anilsince99@gmail.com
 * @since 25/07/24
 */
@Data ///this will auto generate getter setter methods
@AllArgsConstructor
public class AccountDto {
    private long id;
    private String accountHolderName;
    private double balance;

}
