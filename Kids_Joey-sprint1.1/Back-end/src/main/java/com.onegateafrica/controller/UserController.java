package com.onegateafrica.controller;
import com.onegateafrica.entity.User;
import com.onegateafrica.dto.UserDto;
import com.onegateafrica.dto.UserCreationDto;

import com.onegateafrica.dto.UserCreationDto;
import com.onegateafrica.security.services.UserServiceImpl;
import lombok.NoArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import org.slf4j.Logger;

@RestController
@RequestMapping("/api")
@NoArgsConstructor
public class UserController {

    private UserServiceImpl userService;
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(UserController.class);
    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
    @Autowired
    PasswordEncoder encoder;
    /*@GetMapping("/home")
    public String greeting() {

        return "Hello User";
    }*/

    @GetMapping("/users")

    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }

    @GetMapping("user/{id}")

    public ResponseEntity<UserDto> getUserById(@PathVariable(value = "id") long id) {


        Optional<User> userEntityOptional = userService.getUserByIdResponse(id);
        User user = userService.getUserByID(id);
        UserDto userDto = new UserDto();
        if (userEntityOptional.isPresent()){

            userDto.setId(user.getId());
            userDto.setUsername(user.getUsername());
            userDto.setPassword(user.getPassword());
            userDto.setEmail(user.getEmail());
            return new ResponseEntity(userDto,HttpStatus.OK) ;

        }else {
            return new ResponseEntity("Utilisateur introuvable",HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("updateuser/{id}")

    public User updateUser(@PathVariable(value = "id") long id, @RequestBody   User user){
        User foundUser = userService.getUserByID(id);

        //foundUser.setImage(imageService.storeFile(file));
        foundUser.setUsername(user.getUsername());
        foundUser.setPassword(encoder.encode(user.getPassword()));
        foundUser.setRoles(user.getRoles());
        foundUser.setEmail(user.getEmail());

        return userService.addUser(foundUser);

    }

    /*@RequestMapping(value = "/newuser", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public ResponseEntity<UserCreationDto> addUser(@ModelAttribute   User user){

        return new ResponseEntity(new UserCreationDto(userService.addUser(user),"user succsusfully added to database"),HttpStatus.CREATED);
    }*/

    @DeleteMapping("deleteuser/{id}")

    public HttpStatus deleteEmployeeById(@PathVariable("id") long id){
        LOG.debug("deleteUserById method started {}", id);
        userService.deleteUser(id);
        return HttpStatus.FORBIDDEN;
    }


}
