package com.mdambro.demo.application.validation.user;

import com.mdambro.demo.application.mock.UserMocked;
import com.mdambro.validations.exception.BusinessRuleException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserPhonesNotNullValidationTest {

    private UserPhonesNotNullValidation userPhonesNotNullValidation;

    @Test
    void getExecutionOrder() {

        short executionOrder = 1;

        userPhonesNotNullValidation =
                UserPhonesNotNullValidation.builder()
                        .executionOrder(executionOrder)
                        .build();

        assertEquals(1, userPhonesNotNullValidation.getExecutionOrder());

    }

    @Test
    void validate_passValidation() {

        userPhonesNotNullValidation =
                UserPhonesNotNullValidation.builder()
                        .executionOrder((short) 1)
                        .build();

        var user = UserMocked.getCorrectUserMocked();

        assertDoesNotThrow(() -> userPhonesNotNullValidation.validate(user));

    }

    @Test
    void validate_doesNotPassValidation() {

        userPhonesNotNullValidation =
                UserPhonesNotNullValidation.builder()
                        .executionOrder((short) 1)
                        .build();

        var user = UserMocked.getCorrectUserMocked();
        user.setPhones(null);

        assertThrows(
                BusinessRuleException.class,
                () -> userPhonesNotNullValidation.validate(user)
        );

    }

}
