package com.codewithkrishna.blog.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.codewithkrishna.blog.services.FileService;
@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		
		//file name
		String filename = file.getOriginalFilename();
		
		//Full path
		String filePath=path+File.separator+filename;
		
		//create folder if not created
		File f=new File(path);
		if(!f.exists()) {
			f.mkdir();
		}
		
		//File copy
		Files.copy(file.getInputStream(), Paths.get(filePath));
		
		return filename;
		
		
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		
		
		String fullPath=path+File.separator+fileName;
		InputStream is=new FileInputStream(fullPath);
		
		//db logic to return inputstream
		
		return is;
		
		
	}

}
