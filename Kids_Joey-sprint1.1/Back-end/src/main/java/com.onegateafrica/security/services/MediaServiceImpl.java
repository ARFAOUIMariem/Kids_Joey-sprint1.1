package com.onegateafrica.security.services;
import com.onegateafrica.entity.Media;
import com.onegateafrica.exception.NotFoundException;
import com.onegateafrica.repository.MediaRepository;
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
public class MediaServiceImpl  {
    private MediaRepository mediaRepository;
    private ImageService imageService;
    @Autowired
    public MediaServiceImpl (MediaRepository mediaRepository, ImageService imageService) {
        this.mediaRepository=mediaRepository;
        this.imageService = imageService;
    }


    public List<Media> getAllMedia() {
        List<Media> media = mediaRepository.findAll();
        return media;
    }

    @SneakyThrows
    public Media getMediaByID(long id) {
        Media media =  mediaRepository.findById((int) id)
                .orElseThrow(() -> new NotFoundException("media not found"+id));

        return  media;
    }





    public Media updateRepas(Media updatemedia, long id, MultipartFile imagem,MultipartFile video) {
        Media media = mediaRepository.findById((int) id)
                .orElseThrow(()-> new NotAcceptableStatusException("repas not found"));
        media.setId(updatemedia.getId());
        media.setTitre(updatemedia.getTitre());
        media.setDescription(updatemedia.getDescription());
        media.setGallerie(imageService.storeFile(imagem));
        media.setVideo(imageService.storeFile(video));
        mediaRepository.save(media);

        return media;
    }

    public void deleteMedia(long Id) {

        mediaRepository.deleteById((int) Id);
    }

    public Media addmedia(Media media) {
        media.setId(media.getId());
        return mediaRepository.save(media);
    }
    public Optional<Media> getMediaByIdResponse(long id) {
        return mediaRepository.findById((int) id);
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
