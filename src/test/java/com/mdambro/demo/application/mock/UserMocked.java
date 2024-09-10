package com.mdambro.demo.application.mock;

import com.mdambro.demo.domain.Phone;
import com.mdambro.demo.domain.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMocked {

    public static User getCorrectUserMocked() {

        return User.builder()
                .name("Mocked Name")
                .email("mocked@mocked.com")
                .password("m0ck3d_passw0rd")
                .token("x2cvG5dsd858S")
                .phones(List.of(
                        Phone.builder()
                                .countryCode("+54")
                                .cityCode("11")
                                .number("111111")
                                .build()
                )).build();

    }

    public static User getIncorrectUserMocked() {

        return User.builder()
                .name("")
                .email("mocked@mocked.com")
                .password("m0ck3d_passw0rd")
                .phones(List.of(
                        Phone.builder()
                                .countryCode("+54")
                                .cityCode("11")
                                .number("111111")
                                .build()
                )).build();

    }

    public static User getSavedUserMocked() {

        return User.builder()
                .id(UUID.randomUUID())
                .name("Mocked Name")
                .email("mocked@mocked.com")
                .password("m0ck3d_passw0rd")
                .token("x2cvG5dsd858S")
                .phones(List.of(
                        Phone.builder()
                                .countryCode("+54")
                                .cityCode("11")
                                .number("111111")
                                .build()
                )).created(new Date())
                .isActive(true)
                .modified(new Date())
                .build();

    }

}
