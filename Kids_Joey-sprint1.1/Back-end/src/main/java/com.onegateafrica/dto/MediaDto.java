package com.onegateafrica.dto;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
public class MediaDto {
    private long id;
    private String titre;
    private  String description;
    private String video;
    private String gallerie;
    public long getMediaDtoId(){
        return getId();
    }

    public MediaDto(long id, String titre, String description, String video, String gallerie) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.video = video;
        this.gallerie = gallerie;
    }

    public MediaDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getGallerie() {
        return gallerie;
    }

    public void setGallerie(String gallerie) {
        this.gallerie = gallerie;
    }
}
