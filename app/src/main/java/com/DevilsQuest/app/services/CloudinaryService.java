package com.DevilsQuest.app.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {
    /**
     * Method for uploading the file to my cloudinary. 
     * 
     * @param file object of type {@link MultipartFile}
     * @return the url to the image file as string, so i can set it to the user
     * @throws IOException
     */
    String upload(MultipartFile file) throws IOException;
}