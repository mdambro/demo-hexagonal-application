package com.mdambro.demo.application.adapter.input.user.validate;

import com.mdambro.demo.application.mock.UserMocked;
import com.mdambro.validations.exception.BusinessRuleException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidateUserSignUpTest {

    @Test
    void validateSignUpArgument_passValidation() {

        var userMocked = UserMocked.getCorrectUserMocked();

        assertDoesNotThrow(() -> ValidateUserSignUp.validateSignUpArgument(userMocked));

    }

    @Test
    void validateSignUpArgument_doesNotPassValidation_userNull() {

        assertThrows(
                BusinessRuleException.class,
                () -> ValidateUserSignUp.validateSignUpArgument(null)
        );

    }

    @Test
    void validateSignUpArgument_doesNotPassValidation_nameNull() {

        var userMocked = UserMocked.getCorrectUserMocked();
        userMocked.setName(null);

        assertThrows(
                BusinessRuleException.class,
                () -> ValidateUserSignUp.validateSignUpArgument(userMocked)
        );

    }

    @Test
    void validateSignUpArgument_doesNotPassValidation_passwordNull() {

        var userMocked = UserMocked.getCorrectUserMocked();
        userMocked.setPassword(null);

        assertThrows(
                BusinessRuleException.class,
                () -> ValidateUserSignUp.validateSignUpArgument(userMocked)
        );

    }

    @Test
    void validateSignUpArgument_doesNotPassValidation_emailNull() {

        var userMocked = UserMocked.getCorrectUserMocked();
        userMocked.setEmail(null);

        assertThrows(
                BusinessRuleException.class,
                () -> ValidateUserSignUp.validateSignUpArgument(userMocked)
        );

    }

    @Test
    void validateSignUpArgument_doesNotPassValidation_emailBadFormat() {

        var userMocked = UserMocked.getCorrectUserMocked();
        userMocked.setEmail("mocked@1");

        assertThrows(
                BusinessRuleException.class,
                () -> ValidateUserSignUp.validateSignUpArgument(userMocked)
        );

    }

    @Test
    void validateSignUpArgument_doesNotPassValidation_phonesNull() {

        var userMocked = UserMocked.getCorrectUserMocked();
        userMocked.setPhones(null);

        assertThrows(
                BusinessRuleException.class,
                () -> ValidateUserSignUp.validateSignUpArgument(userMocked)
        );

    }

    @Test
    void validateSignUpArgument_doesNotPassValidation_phonesEmpty() {

        var userMocked = UserMocked.getCorrectUserMocked();
        userMocked.setPhones(List.of());

        assertThrows(
                BusinessRuleException.class,
                () -> ValidateUserSignUp.validateSignUpArgument(userMocked)
        );

    }

    @Test
    void validateSignUpArgument_doesNotPassValidation_tokenNull() {

        var userMocked = UserMocked.getCorrectUserMocked();
        userMocked.setToken(null);

        assertThrows(
                BusinessRuleException.class,
                () -> ValidateUserSignUp.validateSignUpArgument(userMocked)
        );

    }

}
