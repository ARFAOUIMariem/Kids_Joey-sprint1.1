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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
public class EnfantController {
    private EnfantServiceImpl enfantService;
    private ImageService imageService;
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(EnfantController.class);
    @Autowired
    public EnfantController(EnfantServiceImpl enfantService, ImageService imageService) {
        this.enfantService = enfantService;
        this.imageService = imageService;
    }

    /*@GetMapping("/home")
    public String greeting() {

        return "Hello Enfant";
    }*/

    @GetMapping("/enfants")
    public List<Enfant> getAllEnfants() {

        return enfantService.getAllEnfant();
    }

    @GetMapping("/enfant/{id}")
    public ResponseEntity<EnfantDto> getEnfantById(@PathVariable(value = "id") long id) {


        Optional<Enfant> enfantEntityOptional = enfantService.getEnfantByIdResponse(id)
                ;
        Enfant enfant = enfantService.getEnfantByID(id);
        ;
        EnfantDto enfantDto = new EnfantDto();
        if (enfantEntityOptional.isPresent()){

            enfantDto.setId(enfant.getId());
            enfantDto.setNom(enfant.getNom());
            enfantDto.setImageEnfant(enfant.getImageEnfant());
            enfantDto.setPrenon(enfant.getPrenon());
            enfantDto.setNum_inscription(enfant.getNum_inscription());

            return new ResponseEntity(enfantDto,HttpStatus.OK) ;

        }else {
            return new ResponseEntity("ENFANT introuvable",HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/updateenfant/{id}")
    public Enfant updateEnfant(@PathVariable(value = "id") long id, @ModelAttribute Enfant enfant, @ModelAttribute MultipartFile image){
        Enfant foundEnfant = enfantService.getEnfantByID(id);

        foundEnfant.setNom(enfant.getNom());
        String fileName = imageService.storeFile(image);
        foundEnfant.setImageEnfant(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/Enfant/")
                .path(fileName)
                .toUriString());
        foundEnfant.setPrenon(enfant.getPrenon());
        foundEnfant.setAllergie(enfant.isAllergie());
        foundEnfant.setTypeAllergie(enfant.getTypeAllergie());
        foundEnfant.setDescription(enfant.getDescription());
        foundEnfant.setIdParent(enfant.getIdParent());


        return enfantService.addEnfant(foundEnfant);

    }

    @RequestMapping(value = "/newenfant", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public ResponseEntity<EnfantCreationDto> addEnfant(@ModelAttribute   Enfant enfant, MultipartFile image){
        String fileName = imageService.storeFile(image);
        enfant.setImageEnfant(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/Enfant/")
                .path(fileName)
                .toUriString());

        return new ResponseEntity(new EnfantCreationDto(enfantService.addEnfant(enfant),"Enfant succsusfully added to database"),HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteenfant/{id}")
    public HttpStatus deleteEnfantById(@PathVariable("id") long id){
        LOG.debug("deleteEnfantById method started {}", id);
        enfantService.deleteEnfant(id)
        ;
        return HttpStatus.FORBIDDEN;
    }
    @GetMapping(value = "/getImageEnfant")
    public @ResponseBody byte[] getImageEnfant() throws IOException {
        FileInputStream in = new FileInputStream("C://Users//asus//Kids//Kids_Joey//Back-end//src//main//resources//images//dance.png");

        return IOUtils.toByteArray(in);

    }
    @GetMapping("/EnfantFile/{fileName:.+}")
    public ResponseEntity<Resource> EnfantFile(@PathVariable String fileName, HttpServletRequest request) throws IOException {
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
