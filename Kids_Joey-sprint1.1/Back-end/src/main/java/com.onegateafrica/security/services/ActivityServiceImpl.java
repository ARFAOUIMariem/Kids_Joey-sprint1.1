package com.onegateafrica.security.services;

import com.onegateafrica.entity.Activity;
import com.onegateafrica.exception.NotFoundException;
import com.onegateafrica.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.NotAcceptableStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
@Service
public class ActivityServiceImpl{
    private final ActivityRepository activityRepository;
    private final ImageService imageService;
    @Autowired
    public ActivityServiceImpl(ActivityRepository activityRepository, ImageService imageService) {
        this.activityRepository = activityRepository;
        this.imageService = imageService;
    }


    public List<Activity> getAllActivity() {

        List<Activity> activities = activityRepository.findAll();



        return activities;
    }

    public Activity getActivityByID(long id) {
        Activity activity = null;
        try {
            activity = activityRepository.findById((int) id)
                    .orElseThrow(() -> new NotFoundException("activity not found"+id));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }

        return  activity;
    }

    public Optional<Activity> getActivityByIdResponse(long id) {
        return activityRepository.findById((int) id);
    }


    public Activity addActivity(Activity activity) {
        activity.setNameActivite(activity.getNameActivite());
        return activityRepository.save(activity);
    }


    public Activity updateActivity(Activity updateactivity, long id,MultipartFile file) {
        Activity activity = activityRepository.findById((int) id)
                .orElseThrow(()-> new NotAcceptableStatusException("activity not found"));
        activity.setId(updateactivity.getId());
        activity.setNameActivite(updateactivity.getNameActivite());
        activity.setImageActivite(imageService.storeFile(file));

        return activity;
    }

    private static String storageDirectoryPath = System.getProperty("user.dir") + "/images/";
    public String uploadImage(MultipartFile file) {
        makeDirectoryIfNotExist(storageDirectoryPath);
        Path storageDirectory = Paths.get(storageDirectoryPath);

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path destination = Paths.get(storageDirectory.toString() + "\\" + fileName);

        try {
            Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);// we are Copying all bytes from an input stream to a file

        } catch (IOException e) {
            e.printStackTrace();
        }

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("images/getImage/")
                .path(fileName)
                .toUriString();
        // return the download image url as a response entity
        String imageLink = destination.toString();
        return imageLink;
    }

    private void makeDirectoryIfNotExist(String imageDirectory) {
        File directory = new File(imageDirectory);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    public void deleteActivity(long id) {
        activityRepository.deleteById((int) id);
    }


}

