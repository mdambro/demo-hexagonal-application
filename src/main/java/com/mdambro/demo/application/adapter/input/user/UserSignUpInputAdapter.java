package com.mdambro.demo.application.adapter.input.user;

import com.mdambro.demo.application.adapter.input.user.validate.ValidateUserSignUp;
import com.mdambro.demo.application.adapter.output.user.SaveNewUserOutputAdapter;
import com.mdambro.demo.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class UserSignUpInputAdapter {

    private SaveNewUserOutputAdapter saveNewUserOutputAdapter;

    public User signUp(User user) {

        ValidateUserSignUp.validateSignUpArgument(user);

		var savedUser = saveNewUserOutputAdapter.saveNewUser(user);
		savedUser.setPassword(null); //Does not return the user's password

        return savedUser;

    }

}
