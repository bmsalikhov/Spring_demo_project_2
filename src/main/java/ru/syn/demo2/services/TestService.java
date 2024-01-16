package ru.syn.demo2.services;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Locale;
import java.util.Map;

@Component
public class TestService {

    public String appleName = "Apple";
    public String userFirstName = "UserFirstName";
    public String userLastName = "UserLastName";

    public boolean setAppleName(String appleName) {
        this.appleName = appleName.toUpperCase(Locale.ROOT);
        return true;
    }

    public boolean setUserBioToUpperCase(String firstName, String lastName) {
        this.userFirstName = firstName.toUpperCase(Locale.ROOT);
        this.userLastName = lastName.toUpperCase(Locale.ROOT);
        return true;
    }

    public boolean setUserBioToLowerCase(String firstName, String lastName) {
        this.userFirstName = firstName.toLowerCase(Locale.ROOT);
        this.userLastName = lastName.toLowerCase(Locale.ROOT);
        return true;
    }
}
