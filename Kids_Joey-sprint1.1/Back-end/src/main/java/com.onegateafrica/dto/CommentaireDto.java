package com.onegateafrica.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CommentaireDto {
    private long id;
    private String comment;
    private String personne;
    private String reponse;
    private String Date;

    public long getCommentaireDtoId(){
        return getId();
    }

    public CommentaireDto() {
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public CommentaireDto(long id, String comment, String personne, String reponse, String Date) {
        this.id = id;
        this.comment = comment;
        this.personne = personne;
        this.reponse = reponse;
        this.Date = Date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) { this.comment = comment;}

    public String getPersonne() {
        return personne;
    }

    public void setPersonne(String personne) {
        this.personne = personne;
    }

}
