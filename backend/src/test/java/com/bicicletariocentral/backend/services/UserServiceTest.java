package com.bicicletariocentral.backend.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bicicletariocentral.backend.dto.UserDTO;
import com.bicicletariocentral.backend.model.User;
import com.bicicletariocentral.backend.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testCreateUserWithEmail_AllParams_ReturnsSavedUser() {
        User mockUser = new User();
        mockUser.setEmail("mockedUser@mail.com");
        when(userRepository.save(Mockito.any())).thenReturn(mockUser);

        UserDTO savedUserDTO = userService.createUserWithEmail("mockedUser@mail.com");
        Assertions.assertNotNull(savedUserDTO);
        Assertions.assertEquals(mockUser.getEmail(), savedUserDTO.getEmail());
    }

    @Test
    void testEmailAlreadyUsed_IsNotUsed_ReturnFalse() {
        when(userRepository.findByEmail(Mockito.anyString())).thenReturn(Optional.empty());
    
        boolean result = userService.emailAlreadyUsed("user@mail.com");
        Assertions.assertFalse(result);
    }

    @Test
    void testEmailAlreadyUsed_IsUsed_ReturnTrue() {
        User mockUser = new User();
        when(userRepository.findByEmail(Mockito.anyString())).thenReturn(Optional.of(mockUser));
    
        boolean result = userService.emailAlreadyUsed("user@mail.com");
        Assertions.assertTrue(result);
    }

    @Test
    void testGetAllUsers_NoUsers_ReturnEmptyList() {
        when(userRepository.findAll()).thenReturn(new ArrayList<>());

        List<UserDTO> result = userService.getAllUsers();
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    void testGetAllUsers_SomeUsers_ReturnUsersDTOList() {
        List<User> usersList = Arrays.asList(new User(), new User());
        when(userRepository.findAll()).thenReturn(usersList);

        List<UserDTO> result = userService.getAllUsers();
        Assertions.assertFalse(result.isEmpty());        
        Assertions.assertEquals(2, result.size());
    }
}
