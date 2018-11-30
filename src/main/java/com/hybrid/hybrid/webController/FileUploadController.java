package com.hybrid.hybrid.webController;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	
	@RequestMapping(value = "/uploadFileview", method = RequestMethod.GET)
	public String uploadFileview(Locale locale, Model model) {

		
		return "upload";
	}

	
	@RequestMapping(value = "/uploadMultipleFileview", method = RequestMethod.GET)
	public String uploadMultipleFileview(Locale locale, Model model) {

		
		return "uploadMultiple";
	}
	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody String uploadFileHandler(@RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			 UUID uuid = UUID.randomUUID();
			 String saveName="";
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = "C:/Users/USER/Desktop/img";
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				
				
				     saveName = uuid + "_" + file.getOriginalFilename();

				    
				    
				File serverFile = new File(dir.getAbsolutePath(),saveName);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				return "You successfully uploaded file=" + saveName;
			} catch (Exception e) {
				return "You failed to upload " + saveName + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " 
					+ " because the file was empty.";
		}
	}

	/**
	 * Upload multiple file using Spring Controller
	 */
	@RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
	public @ResponseBody
	String uploadMultipleFileHandler(@RequestParam("file") MultipartFile[] files) {

		
		String message = "";
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
	
			try {
				UUID uuid = UUID.randomUUID();
				String saveName="";
				saveName = uuid + "_" + file.getOriginalFilename(); 
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = "C:/Users/USER/Desktop/img";
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath(),saveName);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

			
				message = message + "You successfully uploaded file=" + saveName
						+ "<br />";
			} catch (Exception e) {
				return "You failed to upload " +   " => " + e.getMessage();
			}
		}
		return message;
	}
}
