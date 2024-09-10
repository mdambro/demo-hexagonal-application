package com.mdambro.demo.application.validation.user;

import com.mdambro.demo.application.mock.UserMocked;
import com.mdambro.demo.application.repository.UserRepository;
import com.mdambro.validations.exception.BusinessRuleException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserEmailDoesNotExistValidationTest {

    @Mock
    private UserRepository userRepository;

    private UserEmailDoesNotExistValidation userEmailDoesNotExistValidation;

    @Test
    void getExecutionOrder() {

        short executionOrder = 1;

        userEmailDoesNotExistValidation =
                UserEmailDoesNotExistValidation.builder()
                        .executionOrder(executionOrder)
                        .build();

        assertEquals(1, userEmailDoesNotExistValidation.getExecutionOrder());

    }

    @Test
    void validate_passValidation() {

        when(userRepository.findUserByEmail(any()))
                .thenReturn(null);

        userEmailDoesNotExistValidation =
                UserEmailDoesNotExistValidation.builder()
                        .executionOrder((short) 1)
                        .userRepository(userRepository)
                        .build();

        var user = UserMocked.getCorrectUserMocked();

        assertDoesNotThrow(() -> userEmailDoesNotExistValidation.validate(user));

    }

    @Test
    void validate_doesNotPassValidation() {

        when(userRepository.findUserByEmail(any()))
                .thenReturn(UserMocked.getSavedUserMocked());

        userEmailDoesNotExistValidation =
                UserEmailDoesNotExistValidation.builder()
                        .executionOrder((short) 1)
                        .userRepository(userRepository)
                        .build();

        var user = UserMocked.getCorrectUserMocked();

        assertThrows(
                BusinessRuleException.class,
                () -> userEmailDoesNotExistValidation.validate(user)
        );

    }

}
