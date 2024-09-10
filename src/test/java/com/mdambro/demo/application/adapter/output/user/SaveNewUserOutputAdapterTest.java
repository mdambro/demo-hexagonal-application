package com.mdambro.demo.application.adapter.output.user;

import com.mdambro.demo.application.mock.UserMocked;
import com.mdambro.demo.application.repository.UserRepository;
import com.mdambro.demo.domain.User;
import com.mdambro.validations.exception.BusinessRuleException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SaveNewUserOutputAdapterTest {

    @Mock
    private UserRepository userRepository;

    private SaveNewUserOutputAdapter saveNewUserOutputAdapter;

    @Test
    void saveNewUser_newUser_ok() {

        when(userRepository.findUserByEmail(anyString()))
                .thenReturn(null);
        when(userRepository.saveNewUser(any()))
                .thenReturn(UserMocked.getSavedUserMocked());

        saveNewUserOutputAdapter =
                SaveNewUserOutputAdapter.builder()
                        .userRepository(userRepository)
                        .build();

        assertDoesNotThrow(
                () -> saveNewUserOutputAdapter.saveNewUser(
                        User.builder()
                                .email("mack@mock.com")
                                .build()
                )
        );

    }

    @Test
    void saveNewUser_existentUser_error() {

        when(userRepository.findUserByEmail(anyString()))
                .thenReturn(UserMocked.getSavedUserMocked());

        saveNewUserOutputAdapter =
                SaveNewUserOutputAdapter.builder()
                        .userRepository(userRepository)
                        .build();

        assertThrows(
                BusinessRuleException.class,
                () -> saveNewUserOutputAdapter.saveNewUser(UserMocked.getCorrectUserMocked())
        );

    }

    @Test
    void saveNewUser_unexpectedError() {

        when(userRepository.findUserByEmail(anyString()))
                .thenReturn(null);
        when(userRepository.saveNewUser(any()))
                .thenThrow(RuntimeException.class);

        saveNewUserOutputAdapter =
                SaveNewUserOutputAdapter.builder()
                        .userRepository(userRepository)
                        .build();

        assertThrows(
                RuntimeException.class,
                () -> saveNewUserOutputAdapter.saveNewUser(UserMocked.getCorrectUserMocked())
        );

    }

}
