package com.mdambro.demo.application.adapter.output.user;

import com.mdambro.demo.application.repository.UserRepository;
import com.mdambro.demo.application.validation.user.UserEmailDoesNotExistValidation;
import com.mdambro.demo.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Date;

@Builder
@AllArgsConstructor
public class SaveNewUserOutputAdapter {

    private UserRepository userRepository;

    public User saveNewUser(User user) {

        UserEmailDoesNotExistValidation.builder()
                .userRepository(userRepository)
                .build()
                .validate(user);

        user.setCreated(new Date());
        user.setModified(null);
        user.setLastLogin(new Date());

        return userRepository.saveNewUser(user);

    }

}
