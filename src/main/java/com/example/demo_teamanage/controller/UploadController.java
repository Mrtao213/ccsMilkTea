package com.example.demo_teamanage.controller;

import com.example.demo_teamanage.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/upload")
public class UploadController {
		@Autowired
		private UploadService uploadService;


		@PostMapping("/uploadImage")
		public String uploadImg(MultipartFile file) throws IOException {
				return uploadService.uploadFile(file);
		}
}
