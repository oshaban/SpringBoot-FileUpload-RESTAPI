package com.oshaban.fileupload;

import com.oshaban.fileupload.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FileUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileUploadApplication.class, args);
    }

    /**
     * Runs once during application startup to init storageService
     */
    @Bean
    CommandLineRunner init(StorageService storageService) {
        return args -> storageService.init();
    }

}
