package com.bloggingapp.BloggingApp.service;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
@Component
public interface FileService {
    String uploadImage(String path, MultipartFile file)throws IOException;
    InputStream getResource(String path,String filename)throws FileNotFoundException;


}
