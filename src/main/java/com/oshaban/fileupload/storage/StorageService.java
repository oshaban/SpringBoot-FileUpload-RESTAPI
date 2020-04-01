package com.oshaban.fileupload.storage;

import org.springframework.web.multipart.MultipartFile;

/**
 * Interface to store files
 */
public interface StorageService {

    void init();

    void store(MultipartFile file);

}
