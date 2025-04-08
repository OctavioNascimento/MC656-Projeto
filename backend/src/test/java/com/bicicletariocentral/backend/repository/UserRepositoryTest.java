package com.bicicletariocentral.backend.repository;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.bicicletariocentral.backend.model.User;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindByEmail_whenTheresAnUserWithThatEmail_ReturnsThatUser() {
        User standardUser = new User();
        standardUser.setEmail("user@mail.com");
        userRepository.save(standardUser);

        Optional<User> foundUser = userRepository.findByEmail("user@mail.com");
        Assertions.assertFalse(foundUser.isEmpty());
        Assertions.assertEquals("user@mail.com", foundUser.get().getEmail());
    }

    @Test
    void testFindByEmail_whenTheresNoUserWithThatEmail_ReturnsNull() {
        Optional<User> foundUser = userRepository.findByEmail("inexistentUser@mail.com");
        Assertions.assertTrue(foundUser.isEmpty());
    }
}
