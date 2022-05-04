package com.onegateafrica.controller;


import com.onegateafrica.dto.EnfantCreationDto;
import com.onegateafrica.dto.MediaCreationDto;
import com.onegateafrica.dto.MediaDto;
import com.onegateafrica.entity.Media;
import com.onegateafrica.security.services.ActivityServiceImpl;
import com.onegateafrica.security.services.ImageService;
import com.onegateafrica.security.services.MediaServiceImpl;
import lombok.NoArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import org.slf4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api")
@NoArgsConstructor
public class MediaController {

    private MediaServiceImpl mediaService;
    private ImageService imageService;
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(MediaController.class);
    @Autowired
    public MediaController(MediaServiceImpl mediaService,ImageService imageService) {
        this.mediaService = mediaService;
        this.imageService = imageService;
    }

    /*@GetMapping("/homeAct")
    public String greeting() {

        return "Hello activité";
    }*/
    @GetMapping("/medias")
    public List<Media> getAllMedia() {

        return mediaService.getAllMedia();
    }

    @GetMapping("/media/{id}")
    public ResponseEntity<MediaDto> getMediaById(@PathVariable(value = "id") long id) {


        Optional<Media> MediaEntityOptional = mediaService.getMediaByIdResponse(id);
        Media media = mediaService.getMediaByID(id);
        MediaDto mediaDto = new MediaDto();
        if (MediaEntityOptional.isPresent()){

            mediaDto.setId(media.getId());
            mediaDto.setDescription(media.getDescription());
            mediaDto.setGallerie(media.getGallerie());
            mediaDto.setTitre(media.getTitre());
            mediaDto.setVideo(media.getVideo());

            return new ResponseEntity(mediaDto,HttpStatus.OK) ;

        }else {
            return new ResponseEntity("media introuvable",HttpStatus.NOT_FOUND);
        }


    }
    @PutMapping("/updatemedia/{id}")
    public Media updateMedia(@PathVariable(value = "id") long id, @ModelAttribute Media media, @ModelAttribute MultipartFile image,@ModelAttribute MultipartFile videos) throws IOException {
        Media foundMedia = mediaService.getMediaByID(id);

        foundMedia.setTitre(media.getTitre());
        String fileName = imageService.storeFile(image);
        foundMedia.setGallerie(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/Media/")
                .path(fileName)
                .toUriString());

        foundMedia.setDescription(media.getDescription());
        String fileName1 = imageService.storeFile(videos);
        foundMedia.setVideo(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/Media/")
                .path(fileName1)
                .toUriString());
        return mediaService.addmedia(foundMedia);

    }

    @RequestMapping(value = "/newmedia", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public ResponseEntity<MediaCreationDto>addMedia(@ModelAttribute Media media, MultipartFile image,MultipartFile videos){
        String fileName = imageService.storeFile(image);
        media.setGallerie(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/Media/")
                .path(fileName)
                .toUriString());
        String fileName1 = imageService.storeFile(videos);
        media.setVideo(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/Media/")
                .path(fileName1)
                .toUriString());


        return new ResponseEntity(new MediaCreationDto(mediaService.addmedia(media),"media succsusfully added to database"),HttpStatus.CREATED);
    }
    @DeleteMapping("/deletemedia/{id}")
    public HttpStatus deletemediaById(@PathVariable("id") long id){
        LOG.debug("deletmedia method started {}", id);
        mediaService.deleteMedia(id);
        return HttpStatus.FORBIDDEN;
    }
    @GetMapping(value = "/getImageMedia")
    public @ResponseBody byte[] getImageMedia() throws IOException {
        FileInputStream in = new FileInputStream("C://Users//asus//Kids//Kids_Joey//Back-end//src//main//resources//images//dance.png");

        return IOUtils.toByteArray(in);

    }
    @GetMapping("/MediaFile/{fileName:.+}")
    public ResponseEntity<Resource> MediaFile(@PathVariable String fileName, HttpServletRequest request) throws IOException {
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