package com.mdambro.demo.application.validation.user;

import com.mdambro.demo.application.mock.UserMocked;
import com.mdambro.validations.exception.BusinessRuleException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserPasswordNotNullValidationTest {

    private UserPasswordNotNullValidation userPasswordNotNullValidation;

    @Test
    void getExecutionOrder() {

        short executionOrder = 1;

        userPasswordNotNullValidation =
                UserPasswordNotNullValidation.builder()
                        .executionOrder(executionOrder)
                        .build();

        assertEquals(1, userPasswordNotNullValidation.getExecutionOrder());

    }

    @Test
    void validate_passValidation() {

        userPasswordNotNullValidation =
                UserPasswordNotNullValidation.builder()
                        .executionOrder((short) 1)
                        .build();

        var user = UserMocked.getCorrectUserMocked();

        assertDoesNotThrow(() -> userPasswordNotNullValidation.validate(user));

    }

    @Test
    void validate_doesNotPassValidation() {

        userPasswordNotNullValidation =
                UserPasswordNotNullValidation.builder()
                        .executionOrder((short) 1)
                        .build();

        var user = UserMocked.getCorrectUserMocked();
        user.setPassword(null);

        assertThrows(
                BusinessRuleException.class,
                () -> userPasswordNotNullValidation.validate(user)
        );

    }

}
