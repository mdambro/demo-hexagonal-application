package com.mdambro.demo.application.validation.user;

import com.mdambro.demo.application.mock.UserMocked;
import com.mdambro.validations.exception.BusinessRuleException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserNameNotNullValidationTest {

    private UserNameNotNullValidation userNameNotNullValidation;

    @Test
    void getExecutionOrder() {

        short executionOrder = 1;

        userNameNotNullValidation =
                UserNameNotNullValidation.builder()
                .executionOrder(executionOrder)
                .build();

        assertEquals(1, userNameNotNullValidation.getExecutionOrder());

    }

    @Test
    void validate_passValidation() {

        userNameNotNullValidation =
                UserNameNotNullValidation.builder()
                        .executionOrder((short) 1)
                        .build();

        var user = UserMocked.getCorrectUserMocked();

        assertDoesNotThrow(() -> userNameNotNullValidation.validate(user));

    }

    @Test
    void validate_doesNotPassValidation() {

        userNameNotNullValidation =
                UserNameNotNullValidation.builder()
                        .executionOrder((short) 1)
                        .build();

        var user = UserMocked.getCorrectUserMocked();
        user.setName(null);

        assertThrows(
                BusinessRuleException.class,
                () -> userNameNotNullValidation.validate(user)
        );

    }

}
