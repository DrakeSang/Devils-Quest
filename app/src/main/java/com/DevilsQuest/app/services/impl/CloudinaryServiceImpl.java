package com.DevilsQuest.app.services.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.DevilsQuest.app.services.CloudinaryService;
import com.cloudinary.Cloudinary;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {
    private final Cloudinary cloudinary;

    public CloudinaryServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public String upload(MultipartFile multipartFile) throws IOException {
        File file = File.createTempFile("temp_file", multipartFile.getOriginalFilename());
        multipartFile.transferTo(file);

        HashMap<String, String> config = new HashMap<>();
        config.put("folder", "DevilsQuest/auth/users/profile_pics");
        
        return this.cloudinary.uploader().upload(file, config).get("url").toString();
    }
}