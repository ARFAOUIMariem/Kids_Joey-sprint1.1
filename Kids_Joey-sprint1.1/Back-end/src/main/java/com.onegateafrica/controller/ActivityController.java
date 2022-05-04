package com.onegateafrica.controller;
import com.onegateafrica.dto.ActivityCreationDto;
import com.onegateafrica.dto.ActivityDto;
import com.onegateafrica.entity.Activity;
import com.onegateafrica.security.services.ActivityServiceImpl;
import com.onegateafrica.security.services.ImageService;
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
public class ActivityController {

    private ActivityServiceImpl activityService;
    private ImageService imageService;
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(ActivityController.class);

    @Autowired
    public ActivityController(ActivityServiceImpl activityService, ImageService imageService) {
        this.activityService = activityService;
        this.imageService = imageService;
    }

    /*@GetMapping("/homeAct")
    public String greeting() {

        return "Hello activité";
    }*/
    @GetMapping("/activities")
    public List<Activity> getAllActivity() {

        return activityService.getAllActivity();
    }

    @GetMapping("/activity/{id}")
    public ResponseEntity<ActivityDto> getActivityById(@PathVariable(value = "id") long id) {


        Optional<Activity> ActivityEntityOptional = activityService.getActivityByIdResponse(id);
        Activity activity = activityService.getActivityByID(id);
        ActivityDto activityDto = new ActivityDto();
        if (ActivityEntityOptional.isPresent()) {

            activityDto.setId(activity.getId());
            activityDto.setNameActivite(activity.getNameActivite());
            activityDto.setImageActivite(String.valueOf(activity.getImageActivite()));


            return new ResponseEntity(activityDto, HttpStatus.OK);

        } else {
            return new ResponseEntity("activité introuvable", HttpStatus.NOT_FOUND);
        }


    }


    @PutMapping("/updateactivity/{id}")
    public Activity updateActivity(@PathVariable(value = "id") long id, @ModelAttribute Activity activity,@ModelAttribute MultipartFile file) throws IOException {
        Activity foundActivity = activityService.getActivityByID(id);

        foundActivity.setNameActivite(activity.getNameActivite());
        String fileName = imageService.storeFile(file);
        //foundActivity.setImageActivite(imageService.storeFile(file));
        foundActivity.setImageActivite(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/Activity/")
                .path(fileName)
                .toUriString());
        return activityService.addActivity(foundActivity);

    }

    @RequestMapping(value = "/newactivity", method = RequestMethod.POST)
    public ResponseEntity addActivity(@ModelAttribute Activity activity, MultipartFile file){
        String fileName = imageService.storeFile(file);
        activity.setImageActivite(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/Activity/")
                .path(fileName)
                .toUriString());
        return new ResponseEntity(new ActivityCreationDto(activityService.addActivity(activity),"activity succsusfully added to database"),HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteactivity/{id}")
    public HttpStatus deleteActivityById(@PathVariable("id") long id){
        LOG.debug("deleteActivityById method started {}", id);
        activityService.deleteActivity(id);
        return HttpStatus.FORBIDDEN;
    }


    @GetMapping(value = "/image")
    public @ResponseBody byte[] getImage() throws IOException {
        FileInputStream in = new FileInputStream("C://Users//asus//Kids//Kids_Joey//Back-end//src//main//resources//images//dance.png");

        return IOUtils.toByteArray(in);

    }
    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) throws IOException {
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