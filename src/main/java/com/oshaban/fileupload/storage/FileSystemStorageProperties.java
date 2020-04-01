package com.oshaban.fileupload.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("storage")
public class FileSystemStorageProperties {

    /**
     * File storage location
     */
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

}
