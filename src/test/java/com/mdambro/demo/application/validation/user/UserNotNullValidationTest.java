package com.mdambro.demo.application.validation.user;

import com.mdambro.demo.application.mock.UserMocked;
import com.mdambro.validations.exception.BusinessRuleException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserNotNullValidationTest {

    private UserNotNullValidation userNotNullValidation;

    @Test
    void getExecutionOrder() {

        short executionOrder = 1;

        userNotNullValidation =
                UserNotNullValidation.builder()
                        .executionOrder(executionOrder)
                        .build();

        assertEquals(1, userNotNullValidation.getExecutionOrder());

    }

    @Test
    void validate_passValidation() {

        userNotNullValidation =
                UserNotNullValidation.builder()
                        .executionOrder((short) 1)
                        .build();

        var user = UserMocked.getCorrectUserMocked();

        assertDoesNotThrow(() -> userNotNullValidation.validate(user));

    }

    @Test
    void validate_doesNotPassValidation() {

        userNotNullValidation =
                UserNotNullValidation.builder()
                        .executionOrder((short) 1)
                        .build();

        assertThrows(
                BusinessRuleException.class,
                () -> userNotNullValidation.validate(null)
        );

    }

}
