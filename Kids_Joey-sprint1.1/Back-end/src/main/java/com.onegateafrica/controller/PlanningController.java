package com.onegateafrica.controller;


import com.onegateafrica.dto.PlanningCreationDto;
import com.onegateafrica.dto.PlanningDto;
import com.onegateafrica.entity.Planning;
import com.onegateafrica.security.services.PlanningServiceImpl;
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
public class PlanningController {
    private PlanningServiceImpl planningService;
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(PlanningController.class);
    @Autowired
    public PlanningController(PlanningServiceImpl planningService) {
        this.planningService = planningService;
    }

    /*@GetMapping("/homep")
    public String greeting() {

        return "Hello planning";
    }*/

    @GetMapping("/plannings")
    public List<Planning> getAllplanningService() {

        return planningService.getAllPlanning();
    }

    @GetMapping("/planning/{id}")
    public ResponseEntity<PlanningDto> getPlanningById(@PathVariable(value = "id") long id) {
        Optional<Planning> PlanningEntityOptional = planningService.getPlanningByIdResponse(id);
        Planning planning = planningService.getPlanningByID(id)
                ;
        PlanningDto planningDto = new PlanningDto();
        if (PlanningEntityOptional.isPresent()){

            planningDto.setId(planning.getId());
            planningDto.setDateariveplanning(planning.getDateariveplanning());
            planningDto.setDatedepartplanning(planning.getDatedepartplanning());

            return new ResponseEntity(planningDto,HttpStatus.OK) ;

        }else {
            return new ResponseEntity("planning introuvable",HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/updateplanning/{id}")
    public Planning updateMedia(@PathVariable(value = "id") long id, @RequestBody   Planning planning){
        Planning foundPlanning = planningService.getPlanningByID(id);

        foundPlanning.setDatedepartplanning(planning.getDatedepartplanning());
        foundPlanning.setDateariveplanning(planning.getDateariveplanning());




        return planningService.addPlanning(foundPlanning);

    }

    @RequestMapping(value = "/newplanning", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public ResponseEntity<Planning> addPlanning(@ModelAttribute   Planning planning){


        return new ResponseEntity(new PlanningCreationDto(planningService.addPlanning(planning),"planning succsusfully added to database"),HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteplanning/{id}")
    public HttpStatus deletePlanningById(@PathVariable("id") long id){
        LOG.debug("deletePlanningById method started {}", id);
        planningService.deletePlanning(id);
        ;
        return HttpStatus.FORBIDDEN;
    }
}