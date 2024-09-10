package com.mdambro.demo.application.adapter.input.user;

import com.mdambro.demo.application.mock.UserMocked;
import com.mdambro.demo.application.adapter.output.user.SaveNewUserOutputAdapter;
import com.mdambro.validations.exception.BusinessRuleException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserSignUpInputAdapterTest {

    @Mock
    private SaveNewUserOutputAdapter saveNewUserOutputAdapter;

    private UserSignUpInputAdapter userSignUpInputAdapter;

    @Test
    void signUp_userValidated_ok() {

        when(saveNewUserOutputAdapter.saveNewUser(any()))
                .thenReturn(UserMocked.getSavedUserMocked());
        userSignUpInputAdapter =
                UserSignUpInputAdapter.builder()
                        .saveNewUserOutputAdapter(saveNewUserOutputAdapter)
                        .build();

        assertDoesNotThrow(
                () -> userSignUpInputAdapter.signUp(UserMocked.getCorrectUserMocked())
        );

    }

    @Test
    void signUp_userDidNotValidated_error() {

        userSignUpInputAdapter =
                UserSignUpInputAdapter.builder()
                        .build();

        assertThrows(
                BusinessRuleException.class,
                () -> userSignUpInputAdapter.signUp(UserMocked.getIncorrectUserMocked())
        );

    }

    @Test
    void signUp_unexpectedError() {

        when(saveNewUserOutputAdapter.saveNewUser(any())).thenThrow(RuntimeException.class);
        userSignUpInputAdapter =
                UserSignUpInputAdapter.builder()
                        .saveNewUserOutputAdapter(saveNewUserOutputAdapter)
                        .build();

        assertThrows(
                RuntimeException.class,
                () -> userSignUpInputAdapter.signUp(UserMocked.getCorrectUserMocked())
        );

    }

}
