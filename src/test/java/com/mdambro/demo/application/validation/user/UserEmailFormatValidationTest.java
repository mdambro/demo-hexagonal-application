package com.mdambro.demo.application.validation.user;

import com.mdambro.demo.application.mock.UserMocked;
import com.mdambro.validations.exception.BusinessRuleException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserEmailFormatValidationTest {

    private UserEmailFormatValidation userEmailFormatValidation;

    @Test
    void getExecutionOrder() {

        short executionOrder = 1;

        userEmailFormatValidation =
                UserEmailFormatValidation.builder()
                .executionOrder(executionOrder)
                .build();

        assertEquals(1, userEmailFormatValidation.getExecutionOrder());

    }

    @Test
    void validate_passValidation() {

        userEmailFormatValidation =
                UserEmailFormatValidation.builder()
                        .executionOrder((short) 1)
                        .build();

        var user = UserMocked.getCorrectUserMocked();

        assertDoesNotThrow(() -> userEmailFormatValidation.validate(user));

    }

    @Test
    void validate_doesNotPassValidation() {

        userEmailFormatValidation =
                UserEmailFormatValidation.builder()
                        .executionOrder((short) 1)
                        .build();

        var user = UserMocked.getCorrectUserMocked();
        user.setEmail("mocked@1");

        assertThrows(
                BusinessRuleException.class,
                () -> userEmailFormatValidation.validate(user)
        );

    }

}
