package com.onegateafrica.controller;


import com.onegateafrica.dto.RepasCreationDto;
import com.onegateafrica.dto.RepasDto;
import com.onegateafrica.entity.repas;

import com.onegateafrica.security.services.ImageService;
import com.onegateafrica.security.services.RepasServiceImpl;
import lombok.NoArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@NoArgsConstructor
public class RepasController {
    private RepasServiceImpl repasService;
    private ImageService imageService;
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(RepasController.class);
    @Autowired
    public RepasController(RepasServiceImpl repasService,ImageService imageService) {
        this.repasService = repasService;
        this.imageService = imageService;
    }

    /*@GetMapping("/home")
    public String greeting() {

        return "Hello repas";
    }*/

    @GetMapping("/repass")
    public List<repas> getAllUsers() {

        return repasService.getAllRepas();
    }

    @GetMapping("/repas/{id}")
    public ResponseEntity<RepasDto> getRepasById(@PathVariable(value = "id") long id) {


        Optional<repas> RepasEntityOptional = repasService.getRepasByIdResponse(id)
                ;
        repas repas = repasService.getRepasByID(id)
                ;
        RepasDto repasDto = new RepasDto();
        if (RepasEntityOptional.isPresent()){

            repasDto.setId(repas.getId());
            repasDto.setNom(repas.getNom());
            repasDto.setDescription(repas.getDescription());
            repasDto.setImage(repas.getImage());

            return new ResponseEntity(repasDto,HttpStatus.OK) ;

        }else {
            return new ResponseEntity("Repas introuvable",HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/repass/{id}")
    public repas updateRepas(@PathVariable(value = "id") long id, @ModelAttribute   repas repas,@ModelAttribute MultipartFile imager){
        repas foundRepas = repasService.getRepasByID(id);

        foundRepas.setNom(repas.getNom());
        foundRepas.setDescription(repas.getDescription());
        String fileName = imageService.storeFile(imager);

        foundRepas.setImage(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/Repas/")
                .path(fileName)
                .toUriString());

        return repasService.addrepas(foundRepas);

    }

    @RequestMapping(value = "/newrepas", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public ResponseEntity<repas> addRepas(@ModelAttribute  repas repas,MultipartFile imager){
        String fileName = imageService.storeFile(imager);
        repas.setImage(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/Repas/")
                .path(fileName)
                .toUriString());
        return new ResponseEntity(new RepasCreationDto(repasService.addrepas(repas),"repas succsusfully added to database"),HttpStatus.CREATED);
    }
    @DeleteMapping("/deleterepas/{id}")
    public HttpStatus deleteRepasById(@PathVariable("id") long id){
        LOG.debug("deleteRepasById method started {}", id);
        repasService.deleteRepas(id);
        ;
        return HttpStatus.FORBIDDEN;
    }

    @GetMapping(value = "/getImageRepas")
    public @ResponseBody byte[] getImageRepas() throws IOException {
        FileInputStream in = new FileInputStream("C://Users//asus//Kids//Kids_Joey//Back-end//src//main//resources//images//dance.png");

        return IOUtils.toByteArray(in);

    }
    @GetMapping("/RepasFile/{fileName:.+}")
    public ResponseEntity<Resource> RepasFile(@PathVariable String fileName, HttpServletRequest request) throws IOException {
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
