package com.onegateafrica.controller;

import com.onegateafrica.dto.EnfantCreationDto;
import com.onegateafrica.dto.EnfantDto;
import com.onegateafrica.entity.Enfant;

import com.onegateafrica.security.services.EnfantServiceImpl;
import com.onegateafrica.security.services.ImageService;
import lombok.NoArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.*;


import com.onegateafrica.dto.FactpaieCreationDto;
import com.onegateafrica.dto.FactpaieDto;
import com.onegateafrica.entity.Factpaie;
import com.onegateafrica.security.services.FactpaieServiceImpl;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@NoArgsConstructor
public class FactpaieController {
    private FactpaieServiceImpl factpaieService;
    private ImageService imageService;
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(FactpaieController.class);
    @Autowired
    public FactpaieController(FactpaieServiceImpl factpaieService, ImageService imageService) {
        this.factpaieService = factpaieService;
        this.imageService = imageService;
    }

    /*@GetMapping("/homefp")
    public String greeting() {

        return "Hello facture & paiement ";
    }*/

    @GetMapping("/factures")
    public List<Factpaie> getAllFactpaie() {

        return factpaieService.getAllFactpaie();
    }

    @GetMapping("/facture/{id}")
    public ResponseEntity<FactpaieDto> getFactpaieById(@PathVariable(value = "id") long id) {


        Optional<Factpaie> FactpaieEntityOptional = factpaieService.getFactpaieByIdResponse(id);
        Factpaie factpaie = factpaieService.getFactpaieByID(id)
                ;
        FactpaieDto factpaieDto = new FactpaieDto();
        if (FactpaieEntityOptional.isPresent()){

            factpaieDto.setId(factpaie.getId());
            factpaieDto.setContenu(factpaie.getContenu());
            factpaieDto.setDate(factpaie.getDate());

            return new ResponseEntity(factpaieDto,HttpStatus.OK) ;

        }else {
            return new ResponseEntity("facture introuvable",HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/updatefactpaie/{id}")
    public Factpaie updatefactpaie(@PathVariable(value = "id") long id, @ModelAttribute   Factpaie factpaie, @ModelAttribute MultipartFile file){
        Factpaie foundFactpaie = factpaieService.getFactpaieByID(id);

        String fileName = imageService.storeFile(file);
        factpaie.setContenu(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/Paiement/")
                .path(fileName)
                .toUriString());
        foundFactpaie.setDate(factpaie.getDate());

        return factpaieService.addFactpaie(foundFactpaie);

    }

    @RequestMapping(value = "/newfactpaie", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public ResponseEntity<FactpaieCreationDto> addFactpaie(@ModelAttribute   Factpaie factpaie, MultipartFile file){

        String fileName = imageService.storeFile(file);
        factpaie.setContenu(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/Paiement/")
                .path(fileName)
                .toUriString());
        return new ResponseEntity(new FactpaieCreationDto(factpaieService.addFactpaie(factpaie),"commentaire succsusfully added to database"),HttpStatus.CREATED);
    }
    @DeleteMapping("/deletefactpaie/{id}")
    public HttpStatus deleteFactpaieById(@PathVariable("id") long id){
        LOG.debug("deleteFactpaieById method started {}", id);
        factpaieService.deleteFactpaie(id);
        ;
        return HttpStatus.FORBIDDEN;
    }

    @GetMapping(value = "/getContenu")
    public @ResponseBody byte[] getContenu() throws IOException {
        FileInputStream in = new FileInputStream("C://Users//asus//Kids//Kids_Joey//Back-end//src//main//resources//images//dance.png");

        return IOUtils.toByteArray(in);

    }
    @GetMapping("/ContenuFile/{fileName:.+}")
    public ResponseEntity<Resource> ContenuFile(@PathVariable String fileName, HttpServletRequest request) throws IOException {
        // Load file as Resource
        Resource resource = imageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;

        contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}