package com.onegateafrica.security.services;


import com.onegateafrica.entity.Factpaie;
import com.onegateafrica.exception.NotFoundException;
import com.onegateafrica.repository.FactpaieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.NotAcceptableStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class FactpaieServiceImpl {
    private final FactpaieRepository factpaieRepository;
    private final ImageService imageService;
@Autowired
    public FactpaieServiceImpl(FactpaieRepository factpaieRepository, ImageService imageService) {
        this.factpaieRepository = factpaieRepository;
        this.imageService = imageService;
    }

    public List<Factpaie> getAllFactpaie() {

        List<Factpaie> factpaies = factpaieRepository.findAll();

        return factpaies;
    }


    public Factpaie getFactpaieByID(long id) {
        Factpaie factpaie = null;
        try {
            factpaie = factpaieRepository.findById((int) id)
                    .orElseThrow(() -> new NotFoundException("facture not found"+ id));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }

        return  factpaie;
    }

    public Optional<Factpaie> getFactpaieByIdResponse(long id) {
        return factpaieRepository.findById((int) id);
    }


    public Factpaie addFactpaie(Factpaie factpaie) {
    factpaie.setId(factpaie.getId());
        return factpaieRepository.save(factpaie);
    }


    public Factpaie updateFactpaie(Factpaie updatefactpaie, long id,MultipartFile file) {
        Factpaie factpaie = factpaieRepository.findById((int) id)
                .orElseThrow(()-> new NotAcceptableStatusException("factpaie not found"));
        factpaie.setId(updatefactpaie.getId());
        factpaie.setContenu(imageService.storeFile(file));
        factpaie.setDate(updatefactpaie.getDate());
        factpaieRepository.save(factpaie);

        return factpaie;
    }


    public void deleteFactpaie(long id) {
        factpaieRepository.deleteById((int) id);
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
}


