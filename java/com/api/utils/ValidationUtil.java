package com.api.utils;

import org.springframework.web.multipart.MultipartFile;

public class ValidationUtil {

    public static String validatePhoto(MultipartFile photo) {
        if (photo.isEmpty()) {
            return "Error: Photo file is required.";
        }
        if (photo.getSize() > 200 * 1024) {
            return "Error: Photo size must be 200KB or less.";
        }
    
        return null; // No error
    }

    public static String validateResume(MultipartFile resume) {
        if (resume.isEmpty()) {
            return "Error: Resume file is required.";
        }
        if (resume.getSize() > 100 * 1024 * 1024) {
            return "Error: Resume size must be under 100MB.";
        }
        return null; // No error
    }
}
