package com.mdambro.demo.application.validation.user;

import com.mdambro.demo.domain.User;
import com.mdambro.validations.BusinessLogicValidation;
import com.mdambro.validations.exception.BusinessRuleException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class UserPhonesNotNullValidation implements BusinessLogicValidation<User> {

    private short executionOrder;

    @Override
    public short getExecutionOrder() {

        return executionOrder;

    }

    @Override
    public void validate(User user) throws BusinessRuleException {

        if(user.getPhones() == null)
            throw new BusinessRuleException("Phones list is null.");

    }

}
