package com.example.demo_teamanage.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadService {
		public String uploadFile(MultipartFile file) throws IOException;
}
