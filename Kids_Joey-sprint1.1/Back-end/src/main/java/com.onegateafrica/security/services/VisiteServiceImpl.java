package com.onegateafrica.security.services;

import com.onegateafrica.entity.Visite;
import com.onegateafrica.exception.NotFoundException;
import com.onegateafrica.repository.VisiteRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class VisiteServiceImpl  {
    private final VisiteRepository visiteRepository;

    public VisiteServiceImpl(VisiteRepository visiteRepository) {
        this.visiteRepository = visiteRepository;
    }

    public List<Visite> getAllVisite() {

        List<Visite> visite = visiteRepository.findAll();



        return visite;
    }


    public Visite getVisiteByID(long id) {
        Visite visite = null;
        try {
            visite = visiteRepository.findById((int) id)
                    .orElseThrow(() -> new NotFoundException("visite not found"+id));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }

        return  visite;
    }

    public Optional<Visite> getVisiteByIdResponse(long id) {
        return visiteRepository.findById((int) id);
    }


    public Visite addVisite(Visite visite) {
        visite.setNomVisite(visite.getNomVisite());
        // user.setPassword(encoder.encode(user.getPassword()));

        return visiteRepository.save(visite);
    }


    public Visite updateVisite(Visite updatevisite, long id) {
        Visite visite = visiteRepository.findById((int) id)
                .orElseThrow(()-> new NotAcceptableStatusException("visite not found"));
        visite.setId(updatevisite.getId());
        visite.setInformation(updatevisite.getInformation());
        visite.setNomVisite(updatevisite.getNomVisite());
        visite.setDateVisite(updatevisite.getDateVisite());
        visiteRepository.save(visite);

        return visite;
    }


    public void deleteVisite(long id) {
        visiteRepository.deleteById((int) id);
    }
}

