package com.mdambro.demo.application.validation.user;

import com.mdambro.demo.application.mock.UserMocked;
import com.mdambro.validations.exception.BusinessRuleException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserPhonesListNotEmptyValidationTest {

    private UserPhonesListNotEmptyValidation userPhonesListNotEmptyValidation;

    @Test
    void getExecutionOrder() {

        short executionOrder = 1;

        userPhonesListNotEmptyValidation =
                UserPhonesListNotEmptyValidation.builder()
                        .executionOrder(executionOrder)
                        .build();

        assertEquals(1, userPhonesListNotEmptyValidation.getExecutionOrder());

    }

    @Test
    void validate_passValidation() {

        userPhonesListNotEmptyValidation =
                UserPhonesListNotEmptyValidation.builder()
                        .executionOrder((short) 1)
                        .build();

        var user = UserMocked.getCorrectUserMocked();

        assertDoesNotThrow(() -> userPhonesListNotEmptyValidation.validate(user));

    }

    @Test
    void validate_doesNotPassValidation() {

        userPhonesListNotEmptyValidation =
                UserPhonesListNotEmptyValidation.builder()
                        .executionOrder((short) 1)
                        .build();

        var user = UserMocked.getCorrectUserMocked();
        user.setPhones(List.of());

        assertThrows(
                BusinessRuleException.class,
                () -> userPhonesListNotEmptyValidation.validate(user)
        );

    }

}
