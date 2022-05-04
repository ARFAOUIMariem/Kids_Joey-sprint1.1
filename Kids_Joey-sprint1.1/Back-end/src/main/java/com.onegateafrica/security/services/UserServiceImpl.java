package com.onegateafrica.security.services;

import com.onegateafrica.entity.User;
import com.onegateafrica.repository.UserRepository;
import com.onegateafrica.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.NotAcceptableStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.*;



@Service
public class UserServiceImpl {
    private UserRepository userRepository;
   @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    PasswordEncoder encoder;

    public List<User> getAllUsers() {

        List<User> users = userRepository.findAll();

        return users;
    }


    public User getUserByID(long id) {
        User user = null;
        try {
            user = userRepository.findById((int) id)
                    .orElseThrow(() -> new NotFoundException("user not found"+id));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }

        return  user;
    }

    public Optional<User> getUserByIdResponse(long id) {
        return userRepository.findById((int) id);
    }


    public User addUser(User user) {
        user.setUsername(user.getUsername());
        return userRepository.save(user);
    }


    public User updateUser(User updateuser, long id) {
        User user = userRepository.findById((int) id)
                .orElseThrow(()-> new NotAcceptableStatusException("user not found"));
        user.setId(updateuser.getId());
        user.setUsername(updateuser.getUsername());
        user.setPassword(encoder.encode(updateuser.getPassword()));
        user.setEmail(updateuser.getEmail());

        userRepository.save(user);

        return user;
    }

    public void deleteUser(long id) {
        userRepository.deleteById((int) id);
    }

}
