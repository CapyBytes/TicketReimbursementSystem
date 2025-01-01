package com.capybytes.reimbursement_system.repository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.capybytes.reimbursement_system.model.User;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUsername() {
        // Arrange: Create a user and save it in the repository
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password123");
        user.setRole("EMPLOYEE");
        userRepository.save(user);

        // Act: Retrieve the user by username
        Optional<User> retrievedUser = userRepository.findByUsername("testuser");

        // Assert: Verify the user is retrieved successfully
        assertTrue(retrievedUser.isPresent());
        assertEquals("testuser", retrievedUser.get().getUsername());
    }
}
