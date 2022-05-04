package com.onegateafrica.dto;

import com.onegateafrica.entity.Media;

public class MediaCreationDto {
    private Media media;


    private String message;

    public MediaCreationDto(Media media, String message) {
        this.media = media;

        this.message = message;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}