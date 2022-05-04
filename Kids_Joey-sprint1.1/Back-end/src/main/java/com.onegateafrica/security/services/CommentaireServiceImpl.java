package com.onegateafrica.security.services;

import com.onegateafrica.entity.Commentaire;
import com.onegateafrica.entity.User;
import com.onegateafrica.entity.Visite;
import com.onegateafrica.exception.NotFoundException;
import com.onegateafrica.repository.CommentaireRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CommentaireServiceImpl {
    private final CommentaireRepository commentaireRepository;
    private final UserServiceImpl userService;


    public CommentaireServiceImpl(CommentaireRepository commentaireRepository,UserServiceImpl userService ) {
        this.commentaireRepository = commentaireRepository;
        this.userService = userService;
    }

    public List<Commentaire> getAllCommentaire() {

        List<Commentaire> commentaires = commentaireRepository.findAll();

        return commentaires;
    }

    public Commentaire getCommentaireByID(long id) {
        Commentaire commentaire = null;
        try {
            commentaire = commentaireRepository.findById((int) id)
                    .orElseThrow(() -> new NotFoundException("commentaire not found" + id));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }


        return commentaire;
    }

    public String getCommentUserByID(long id) {
        Commentaire commentaire = null;
        try {
            commentaire = commentaireRepository.findById((int) id)
                    .orElseThrow(() -> new NotFoundException("commentaire not found" + id));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }


        return commentaire.getPersonne();
    }

    public Optional<Commentaire> getCommentaireByIdResponse(long id) {
        return commentaireRepository.findById((int) id);
    }
    public ResponseEntity<Commentaire> updateCommentaire(long id, String reponse) {

        Commentaire commentaire = getCommentaireByID(id);
        if (commentaire != null){
            commentaire.setReponse(reponse);

            commentaireRepository.save(commentaire);

            return new ResponseEntity(commentaire,HttpStatus.OK);

        }else{
            return new ResponseEntity("this comment dosNot exist",HttpStatus.NOT_FOUND);
        }

    }


    public Commentaire addCommentaire(Commentaire commentaire) {
        commentaire.setComment(commentaire.getComment());

        return commentaireRepository.save(commentaire);
    }
}


