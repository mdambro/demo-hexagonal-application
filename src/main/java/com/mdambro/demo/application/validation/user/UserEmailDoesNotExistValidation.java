package com.mdambro.demo.application.validation.user;

import com.mdambro.demo.application.repository.UserRepository;
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
public class UserEmailDoesNotExistValidation implements BusinessLogicValidation<User> {

    private UserRepository userRepository;
    private short executionOrder;

    @Override
    public short getExecutionOrder() {

        return executionOrder;

    }

    @Override
    public void validate(User user) throws BusinessRuleException {

        User userFromBase = userRepository.findUserByEmail(user.getEmail());

        if(userFromBase != null && !userFromBase.getEmail().isBlank())
            throw new BusinessRuleException("Email was previously registered.");

    }

}
