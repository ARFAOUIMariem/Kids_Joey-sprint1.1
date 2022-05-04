package com.onegateafrica.dto;

import com.onegateafrica.entity.Activity;

public class ActivityCreationDto {
    private Activity activity;


    private String message;

    public ActivityCreationDto(Activity activity, String message) {
        this.activity = activity;

        this.message = message;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setUser(Activity activity) {
        this.activity = activity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}