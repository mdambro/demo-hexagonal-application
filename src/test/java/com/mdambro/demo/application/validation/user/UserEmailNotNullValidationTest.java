package com.mdambro.demo.application.validation.user;

import com.mdambro.demo.application.mock.UserMocked;
import com.mdambro.validations.exception.BusinessRuleException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserEmailNotNullValidationTest {

    private UserEmailNotNullValidation userEmailNotNullValidation;

    @Test
    void getExecutionOrder() {

        short executionOrder = 1;

        userEmailNotNullValidation =
                UserEmailNotNullValidation.builder()
                .executionOrder(executionOrder)
                .build();

        assertEquals(1, userEmailNotNullValidation.getExecutionOrder());

    }

    @Test
    void validate_passValidation() {

        userEmailNotNullValidation =
                UserEmailNotNullValidation.builder()
                        .executionOrder((short) 1)
                        .build();

        var user = UserMocked.getCorrectUserMocked();

        assertDoesNotThrow(() -> userEmailNotNullValidation.validate(user));

    }

    @Test
    void validate_doesNotPassValidation() {

        userEmailNotNullValidation =
                UserEmailNotNullValidation.builder()
                        .executionOrder((short) 1)
                        .build();

        var user = UserMocked.getCorrectUserMocked();
        user.setEmail(null);

        assertThrows(
                BusinessRuleException.class,
                () -> userEmailNotNullValidation.validate(user)
        );

    }

}
