package com.app.restapi.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
//  public final String File_DIR=
//		  "E:\\Spring_Boot\\RESTApiBook\\src\\main\\resources\\static\\images";
//get Dynamic path
	public final String File_DIR=new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
  public FileUploadHelper()throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
boolean f=false;
  public boolean uploadFile(MultipartFile file){
	  try {
	  //by using io packege	  
//		  InputStream inputStream = file.getInputStream();
//		  byte data[]=new byte[inputStream.available()]; 
//		  inputStream.read();
//		  FileOutputStream fos=new FileOutputStream
//				  (File_DIR+File.separator+file.getOriginalFilename());
//		  fos.write(data);
//		  fos.flush();
//		  fos.close();
		  
		  
 //by using nio package
     Files.copy(file.getInputStream(),Paths.get(File_DIR+File.separator+file.getOriginalFilename()),
    		                                                        StandardCopyOption.REPLACE_EXISTING);		  
		 
     f=true;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return f;  
  }
}
