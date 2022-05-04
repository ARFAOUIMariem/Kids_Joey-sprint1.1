package com.onegateafrica.controller;
import com.onegateafrica.dto.*;
import com.onegateafrica.entity.Visite;
import com.onegateafrica.security.services.VisiteServiceImpl;
import lombok.NoArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.slf4j.Logger;

@RestController
@RequestMapping("/api")
@NoArgsConstructor
public class VisiteController {

    private VisiteServiceImpl visiteService;
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(VisiteController.class);
    @Autowired
    public VisiteController(VisiteServiceImpl visiteService) {
        this.visiteService = visiteService;
    }

    /*@GetMapping("/homevisite")
    public String greeting() {

        return "Hello visite";
    }*/

    @GetMapping("/visites")
    public List<Visite> getAllvisite() {

        return visiteService.getAllVisite();
    }

    @GetMapping("/visite/{id}")
    public ResponseEntity<VisiteDto> getVisiteById(@PathVariable(value = "id") long id) {


        Optional<Visite> VisiteEntityOptional = visiteService.getVisiteByIdResponse(id);
        Visite visite = visiteService.getVisiteByID(id);
        VisiteDto visiteDto = new VisiteDto();
        if (VisiteEntityOptional.isPresent()){

            visiteDto.setId(visite.getId());
            visiteDto.setInformation(visite.getInformation());
            visiteDto.setDateVisite(visite.getDateVisite());
            visiteDto.setNomVisite(visite.getNomVisite());

            return new ResponseEntity(visiteDto,HttpStatus.OK) ;

        }else {
            return new ResponseEntity("visite introuvable",HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("updatevisite/{id}")
    public Visite updateVisite(@PathVariable(value = "id") long id, @RequestBody   Visite visite){
        Visite foundVisite = visiteService.getVisiteByID(id);

        foundVisite.setInformation(visite.getInformation());
        foundVisite.setNomVisite(visite.getNomVisite());
        foundVisite.setDateVisite(visite.getDateVisite());





        return visiteService.addVisite(foundVisite);

    }

    @RequestMapping(value = "/newvisite", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public ResponseEntity<VisiteCreationDto> addUser(@ModelAttribute   Visite visite){

//
        return new ResponseEntity(new VisiteCreationDto(visiteService.addVisite(visite),"visite succsusfully added to database"),HttpStatus.CREATED);
    }
    @DeleteMapping("deletevisite/{id}")
    public HttpStatus deleteVisiteById(@PathVariable("id") long id){
        LOG.debug("deleteVisiteById method started {}", id);
        visiteService.deleteVisite(id);
        return HttpStatus.FORBIDDEN;
    }


}

