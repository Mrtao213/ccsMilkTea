package com.example.demo_teamanage.service.impl;

import com.example.demo_teamanage.service.UploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {
		@Value("${img.path}")
		private String localPath;
		@Override
		public String uploadFile(MultipartFile file) throws IOException {
//				获取文件原来的名称
				String originalFileName = file.getOriginalFilename();

//        用UUID生成新的文件名称，截取原文件后缀名
				String name = UUID.randomUUID().toString().substring(1,8);
				String suffix = originalFileName.substring(originalFileName.indexOf('.'));

//				判断保存路径是否存在，如果不存在则创建
				File dir = new File(localPath);
				if(!dir.exists())
						dir.mkdir();

//					用生成的文件名+后缀组成新的文件名
				String fileName = name+suffix;
				file.transferTo(new File(localPath+fileName));

//					返回文件名
				return fileName;
		}
}
