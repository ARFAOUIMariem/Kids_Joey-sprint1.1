package com.onegateafrica.dto;
import com.onegateafrica.entity.User;
public class UserCreationDto {
    private User user;


    private String message;

    public UserCreationDto(User user, String message) {
        this.user = user;

        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
