package com.onegateafrica.security.services;


import com.onegateafrica.entity.Planning;
import com.onegateafrica.exception.NotFoundException;
import com.onegateafrica.repository.PlanningRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PlanningServiceImpl  {
    private  PlanningRepository planningRepository;

    public PlanningServiceImpl(PlanningRepository planningRepository) {
        this.planningRepository = planningRepository;
    }

    public List<Planning> getAllPlanning() {

        List<Planning> plannings = planningRepository.findAll();


        return plannings;
    }


    public Planning getPlanningByID(long id) {
        Planning planning = null;
        try {
            planning = planningRepository.findById((int) id)
                    .orElseThrow(() -> new NotFoundException("planning not found"+id));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }

        return  planning;
    }

    public Optional<Planning> getPlanningByIdResponse(long id) {
        return planningRepository.findById((int) id);
    }


    public Planning addPlanning(Planning planning) {
        planning.setDateariveplanning(planning.getDateariveplanning());


        return planningRepository.save(planning);
    }


    public Planning updatePlanning(Planning updateplanning, long id) {
        Planning planning = planningRepository.findById((int) id)
                .orElseThrow(()-> new NotAcceptableStatusException("media not found"));
        planning.setId(updateplanning.getId());
        planning.setDateariveplanning(updateplanning.getDateariveplanning());
        planning.setDatedepartplanning(updateplanning.getDatedepartplanning());
        planningRepository.save(planning);

        return planning;
    }


    public void deletePlanning(long id) {
        planningRepository.deleteById((int) id);
    }
}