package com.proj3.videoapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface userService {
    String uploadfile(MultipartFile file,String type);
}
