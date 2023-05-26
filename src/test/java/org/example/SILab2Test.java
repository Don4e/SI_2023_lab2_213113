package org.example;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;


import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    User nullUser = null;
    User donce = new User("Donce", "password123@", "mail@gmail.com");
    User noUsernameUser = new User(null, "the password", "donce123@gmail.com");
    User noPasswordUser = new User("Chorap", null,"mail@gmail.com");
    User noMailUser = new User("Chorap", "#chorap1",null);
    User []allUsers2 = {new User("donce123@gmail.com", "nekojPassword123@1", "donce123@gmail.com"), new User("username", "userPassword123!", "user@gmail.com")};
    User marcus = new User("marcus", "marcus123", "mail!gmail.com");
    User noUsernameBadPassword = new User(null, "thepassword", "donce123@gmail.com");

    @Test
    void multipleCondition() {
        assertThrows(RuntimeException.class, ()->SILab2.function(nullUser, new ArrayList<>()));
        assertThrows(RuntimeException.class, ()->SILab2.function(noPasswordUser, new ArrayList<>()));
        assertThrows(RuntimeException.class, ()->SILab2.function(noMailUser, new ArrayList<>()));
//        assertDoesNotThrow(()->SILab2.function(new User("Chorap", "#chorap1", "mail@gmail.com"), new ArrayList<>()));
        assertFalse(()->SILab2.function(new User("Chorap", "#chorap1", "mail@gmail.com"), new ArrayList<>()));

    }
    @Test
    void everyBranch() {
        assertThrows(RuntimeException.class, ()->SILab2.function(nullUser, null));
        assertTrue(()->SILab2.function(donce, new ArrayList<>()));
        assertFalse(()->SILab2.function(noUsernameUser, Arrays.stream(allUsers2).toList()));
        assertFalse(()->SILab2.function(marcus, new ArrayList<>()));
        assertFalse(()->SILab2.function(noUsernameBadPassword, List.of(allUsers2)));
    }


}