package com.mdambro.demo.application.adapter.input.user.validate;

import com.mdambro.demo.application.validation.user.*;
import com.mdambro.demo.domain.User;

import com.mdambro.validations.util.BusinessLogicValidationUtils;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidateUserSignUp {

    public static void validateSignUpArgument(User user) {

        var validationsList = List.of(
                UserNotNullValidation.builder()
                        .executionOrder((short) 1)
                        .build(),
                UserNameNotNullValidation.builder()
                        .executionOrder((short) 2)
                        .build(),
                UserPasswordNotNullValidation.builder()
                        .executionOrder((short) 3)
                        .build(),
                UserEmailNotNullValidation.builder()
                        .executionOrder((short) 4)
                        .build(),
                UserEmailFormatValidation.builder()
                        .executionOrder((short) 5)
                        .build(),
                UserPhonesNotNullValidation.builder()
                        .executionOrder((short) 6)
                        .build(),
                UserPhonesListNotEmptyValidation.builder()
                        .executionOrder((short) 7)
                        .build(),
                UserTokenNotNullValidation.builder()
                        .executionOrder((short) 8)
                        .build()
        );

        BusinessLogicValidationUtils.startValidations(validationsList, user);

    }

}
