package com.onegateafrica.security.services;


import com.onegateafrica.entity.repas;
import com.onegateafrica.exception.NotFoundException;
import com.onegateafrica.repository.RepasRepository;
import lombok.SneakyThrows;
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
public class RepasServiceImpl  {
    private  RepasRepository repasRepository;
    private ImageService imageService;

    @Autowired
    public RepasServiceImpl (RepasRepository repasRepository, ImageService imageService) {
        this.repasRepository = repasRepository;
        this.imageService = imageService;
    }


    public List<repas> getAllRepas() {
        List<repas> repass = repasRepository.findAll();
        return repass;
    }

    @SneakyThrows
    public repas getRepasByID(long id) {
        repas repas =  repasRepository.findById((int) id)
                .orElseThrow(() -> new NotFoundException("user not found"+id));

        return  repas;
    }





    public repas updateRepas(repas updaterepas, long id, MultipartFile imager) {
        repas repas = repasRepository.findById((int) id)
                .orElseThrow(()-> new NotAcceptableStatusException("repas not found"));
        repas.setNom(updaterepas.getNom());
        repas.setDescription(updaterepas.getDescription());
        repas.setImage(imageService.storeFile(imager));

        return repas;
    }

    public void deleteRepas(long Id) {

        repasRepository.deleteById((int) Id);
    }

    public repas addrepas(repas repas) {
       repas.setNom(repas.getNom());
        return repasRepository.save(repas);
    }

    public Optional<repas> getRepasByIdResponse(long id) {
        return repasRepository.findById((int) id);
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