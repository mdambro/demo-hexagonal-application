package com.mdambro.demo.application.validation.user;

import com.mdambro.demo.application.mock.UserMocked;
import com.mdambro.validations.exception.BusinessRuleException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserTokenNotNullValidationTest {

    private UserTokenNotNullValidation userTokenNotNullValidation;

    @Test
    void getExecutionOrder() {

        short executionOrder = 1;

        userTokenNotNullValidation = UserTokenNotNullValidation.builder()
                .executionOrder(executionOrder)
                .build();

        assertEquals(1,userTokenNotNullValidation.getExecutionOrder());

    }

    @Test
    void validate_passValidation() {

        userTokenNotNullValidation = UserTokenNotNullValidation.builder()
                .executionOrder((short) 1)
                .build();
    }

    @Test
    void validate_doesNotPassValidation() {

        userTokenNotNullValidation = UserTokenNotNullValidation.builder()
                .executionOrder((short) 1)
                .build();

        var user = UserMocked.getCorrectUserMocked();
        user.setToken(null);

        assertThrows(
                BusinessRuleException.class,
                () -> userTokenNotNullValidation.validate(user)
         );

    }

}
