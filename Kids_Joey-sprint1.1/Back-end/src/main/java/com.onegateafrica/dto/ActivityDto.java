package com.onegateafrica.dto;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ActivityDto {
    private long id;
    private String nameActivite;
    private String imageActivite;
    public long getActivityDtoId(){
        return getId();
    }

    public ActivityDto() {
    }

    public ActivityDto(long id, String nameActivite, String imageActivite) {
        this.id = id;
        this.nameActivite = nameActivite;
        this.imageActivite = imageActivite;
    }

    public long getId() {
        return id;
    }

    public void setId(long id_act) {
        this.id = id;
    }

    public String getNameActivite() {
        return nameActivite;
    }

    public void setNameActivite(String nameActivite) {
        this.nameActivite = nameActivite;
    }

    public String getImageActivite() {
        return imageActivite;
    }

    public void setImageActivite(String imageActivite) {
        this.imageActivite = imageActivite;
    }
}
