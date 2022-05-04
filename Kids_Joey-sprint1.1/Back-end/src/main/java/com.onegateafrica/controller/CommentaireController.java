package com.onegateafrica.controller;

import com.onegateafrica.dto.CommentaireCreationDto;
import com.onegateafrica.dto.CommentaireDto;
import com.onegateafrica.entity.Commentaire;
import com.onegateafrica.entity.User;
import com.onegateafrica.entity.Visite;
import com.onegateafrica.security.services.CommentaireServiceImpl;
import com.onegateafrica.security.services.UserServiceImpl;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@NoArgsConstructor
public class CommentaireController {
    private CommentaireServiceImpl commentaireService;
    private UserServiceImpl userService;
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(CommentaireController.class);
    @Autowired
    public CommentaireController(CommentaireServiceImpl commentaireService,UserServiceImpl userService) {
        this.commentaireService = commentaireService;
        this.userService = userService;
    }

    /*@GetMapping("/homec")
    public String greeting() {

        return "Hello commentaire";
    }*/

    @GetMapping("/comments")
    public List<Commentaire> getAllCommentaire() {

        return commentaireService.getAllCommentaire();
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<CommentaireDto> getCommentaireById(@PathVariable(value = "id") long id) {


        Optional<Commentaire> CommentaireEntityOptional = commentaireService.getCommentaireByIdResponse(id);
        Commentaire commentaire = commentaireService.getCommentaireByID(id)
                ;
        CommentaireDto commentaireDto = new CommentaireDto();
        if (CommentaireEntityOptional.isPresent()){

            commentaireDto.setId(commentaire.getId());
            commentaireDto.setComment(commentaire.getComment());
            commentaireDto.setPersonne(commentaire.getPersonne());
            commentaireDto.setReponse(commentaire.getReponse());
            commentaireDto.setDate(commentaire.getDate());

            return new ResponseEntity(commentaireDto,HttpStatus.OK) ;

        }else {
            return new ResponseEntity("commentaire introuvable",HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/commentuser/{id}")
    public ResponseEntity<User> getCommentUserByID(@PathVariable(value = "id") long id) {


        Optional<Commentaire> CommentaireEntityOptional = commentaireService.getCommentaireByIdResponse(id);
        Commentaire commentaire = commentaireService.getCommentaireByID(id)
                ;
        CommentaireDto commentaireDto = new CommentaireDto();
        if (CommentaireEntityOptional.isPresent()){
            commentaireDto.setId(commentaire.getId());
            commentaireDto.setComment(commentaire.getComment());
            commentaireDto.setReponse(commentaire.getReponse());
            commentaireDto.setDate(commentaire.getDate());

            return new ResponseEntity(commentaireDto,HttpStatus.OK) ;

        }else {
            return new ResponseEntity("commentaire introuvable",HttpStatus.NOT_FOUND);
        }
    }




    @RequestMapping(value = "/newcomment", method = RequestMethod.POST)
    public ResponseEntity<Commentaire> addCommentaire(@ModelAttribute   Commentaire commentaire){
        return new ResponseEntity(new CommentaireCreationDto(commentaireService.addCommentaire(commentaire),"commentaire succsusfully added to database"),HttpStatus.CREATED);
    }

    /*@PostMapping("/newcomment")

    public ResponseEntity<Commentaire> addCommentaire(@ModelAttribute Commentaire commentaire,@PathVariable(name = "id") long id){
        User user = userService.getUserByID(id);
        commentaire.setPersonne(user.getUsername());
        return commentaireService.addCommentaire(commentaire,id);
    }*/



    @PutMapping("/updatecomment/{id}")
    public ResponseEntity<Commentaire> updateCommentaire(@PathVariable(value = "id") long id, @RequestBody String reponse){
        if (commentaireService.getCommentaireByID(id)!=null) {

            return new ResponseEntity(commentaireService.updateCommentaire(id, reponse), HttpStatus.OK);
        }
       else{
                return new ResponseEntity("this appel d'offre dos not exist", HttpStatus.NOT_FOUND);
            }

    }
}


