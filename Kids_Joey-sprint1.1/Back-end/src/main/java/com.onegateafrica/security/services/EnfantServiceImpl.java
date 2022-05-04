package com.onegateafrica.security.services;

import com.onegateafrica.entity.Enfant;
import com.onegateafrica.entity.User;
import com.onegateafrica.exception.NotFoundException;
import com.onegateafrica.repository.EnfantRepository;
import com.onegateafrica.repository.UserRepository;
import lombok.SneakyThrows;
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
public class EnfantServiceImpl {
    private  EnfantRepository enfantRepository;
    private ImageService imageService ;
    private UserServiceImpl userRepository;
    public EnfantServiceImpl(EnfantRepository enfantRepository, UserServiceImpl userRepository,ImageService imageService) {
        this.enfantRepository = enfantRepository;
        this.userRepository = userRepository;
        this.imageService= imageService;
    }


    public List<Enfant> getAllEnfant() {
        List<Enfant> enfants = enfantRepository.findAll();

        return enfants;
    }
    @SneakyThrows
    public Enfant getEnfantByID(long id) {
        Enfant enfant =  enfantRepository.findById((int) id)
                .orElseThrow(() -> new NotFoundException("user not found"+id));

        return  enfant;
    }

    public Enfant addEnfant(Enfant enfant) {
        Integer id_parent = enfant.getIdParent();
        User user = userRepository.getUserByID( id_parent);
        enfant.setNom(enfant.getNom());
            return enfantRepository.save(enfant);
        }


    public Enfant updateEnfant(Enfant updateEnfant, long id,MultipartFile imagee) {
        Enfant enfant = enfantRepository.findById((int) id)
                .orElseThrow(()-> new NotAcceptableStatusException("enfant not found"));
        enfant.setId(updateEnfant.getId());
        enfant.setNom(updateEnfant.getNom());
        enfant.setPrenon(updateEnfant.getPrenon());
        enfant.setDate_naissance(updateEnfant.getDate_naissance());
        enfant.setDescription(updateEnfant.getDescription());
        enfant.setAllergie(updateEnfant.isAllergie());
        enfant.setTypeAllergie(updateEnfant.getTypeAllergie());
        enfant.setNum_inscription(updateEnfant.getNum_inscription());
        enfant.setImageEnfant(imageService.storeFile(imagee));
        enfant.setIdParent(updateEnfant.getIdParent());
        enfantRepository.save(enfant);

        return enfant;
    }

    public void deleteEnfant(long id) {

        enfantRepository.deleteById((int) id);
    }

    public Optional<Enfant> getEnfantByIdResponse(long id) {
        return enfantRepository.findById((int) id);
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