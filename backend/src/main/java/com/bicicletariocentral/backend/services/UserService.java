package com.bicicletariocentral.backend.services;

import com.bicicletariocentral.backend.dto.*;
import com.bicicletariocentral.backend.model.*;
import com.bicicletariocentral.backend.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public UserDTO createUserWithEmail(String email) {
        User user = new User();
        user.setEmail(email);
        user.setActive(true);
        
        User savedUser = userRepository.save(user);
        return convertToDTO(savedUser);
    }
    
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public boolean emailAlreadyUsed(String email){
        return userRepository.existsByEmail(email);
    }
    
    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setUsername(user.getUsername());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setBirthDate(user.getBirthDate());
        userDTO.setActive(user.isActive());
        return userDTO;
    }
}