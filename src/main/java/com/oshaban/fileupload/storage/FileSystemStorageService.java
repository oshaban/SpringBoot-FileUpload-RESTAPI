package com.oshaban.fileupload.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileSystemStorageService implements StorageService  {

    private final Path rootLocation;

    @Autowired
    public FileSystemStorageService(FileSystemStorageProperties storageProperties) {
        this.rootLocation = Paths.get(storageProperties.getLocation());
    }

    @Override
    public void store(MultipartFile file) {
        try {
            String filename = StringUtils.cleanPath(file.getOriginalFilename());
            if (file.isEmpty()) {
                throw new FileStorageException("File is empty:" + file.getOriginalFilename());
            }

            InputStream inputStream = file.getInputStream();
            Files.copy(inputStream, this.rootLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            throw new FileStorageException("Failed to store file" + file.getOriginalFilename());
        }
    }

    @Override
    public void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new FileStorageException("Could not initialize storage");
        }
    }

}
