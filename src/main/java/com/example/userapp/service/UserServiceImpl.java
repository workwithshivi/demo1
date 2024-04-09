package com.example.userapp.service;

import com.example.userapp.dto.User;
import com.example.userapp.model.UserEntity;
import com.example.userapp.repo.UserRepository;
import com.example.userapp.util.ObjectConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public User register(User userDto) {
        log.info("User Registration Service");
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        UserEntity userEntity = ObjectConverter.toUser(userDto);
        UserEntity save = userRepository.save(userEntity);
        return ObjectConverter.toUserDTO(save);
    }

    @Override
    @Transactional
    public User login(String username, String password) {
        log.info("User Login request for  {}", username);
        UserEntity user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            // enabling the user during first login or if disabled
            if (!user.isEnabled()) {
                user.setEnabled(true);
                userRepository.save(user);
            }
            log.info("Valid User: {}", username);
            return ObjectConverter.toUserDTO(user);
        }
        return null;
    }

    @Override
    public User getDetails(String username) {
        log.info("Requesting details for {}", username);
        UserEntity user = userRepository.findByUsername(username);
        return ObjectConverter.toUserDTO(user);
    }

    @Override
    public User updateDetails(User user) {
        log.info("Updating {} details", user.getUsername());
        return ObjectConverter.toUserDTO(userRepository.save(ObjectConverter.toUser(user)));
    }

    @Override
    public void deleteUser(Long id) {
        log.info("Deleting {}", id);
        userRepository.deleteById(id);
    }
}
