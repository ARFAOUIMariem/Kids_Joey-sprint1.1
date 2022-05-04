package com.onegateafrica.dto;

import com.onegateafrica.entity.Commentaire;

public class CommentaireCreationDto {
    private Commentaire commentaire;


    private String message;

    public CommentaireCreationDto(Commentaire commentaire, String message) {
        this.commentaire = commentaire;

        this.message = message;
    }

    public Commentaire getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(Commentaire commentaire) {
        this.commentaire = commentaire;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
