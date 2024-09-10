package com.mdambro.demo.application.validation.user;

import com.mdambro.demo.domain.User;
import com.mdambro.validations.BusinessLogicValidation;
import com.mdambro.validations.exception.BusinessRuleException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.regex.Pattern;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class UserEmailFormatValidation implements BusinessLogicValidation<User> {

    private short executionOrder;

    @Override
    public short getExecutionOrder() {

        return executionOrder;

    }

    @Override
    public void validate(User user) throws BusinessRuleException {

        if(!user.getEmail().matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b"))
            throw new BusinessRuleException("Email invalid");

    }

}
