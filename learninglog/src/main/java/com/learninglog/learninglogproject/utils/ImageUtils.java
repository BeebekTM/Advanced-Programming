package com.learninglog.learninglogproject.utils;

import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

public class ImageUtils {
    public static String saveImageInDirectory(Part imagePart) throws IOException {
        String location = "C:\\Users\\ig_beebek\\Documents\\Second Year" +
                "\\Advanced Programming CS5054\\Week 5\\learninglog\\src\\main\\webapp";
        File imageUploadLocation = new File(location);
        if(!imageUploadLocation.exists()){
            imageUploadLocation.mkdirs();
        }
        String fileName = imagePart.getSubmittedFileName();
        imagePart.write(location + File.separator + fileName);
        return "image/"+fileName;
    }
}
