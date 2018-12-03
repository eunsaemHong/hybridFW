package com.hybrid.hybrid.webController;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DownloadController {
private static final String FILE_PATH = "C:\\Users\\USER\\Desktop\\img\\tmpFiles";// 서버 파일 저장 경로 

@RequestMapping(value = "/fileDownload", method = RequestMethod.GET)
//get 방식 하이퍼링크 경로로 보낸 파일 아이디 값을 인자로 받음
	public ModelAndView reDocumentDown(@RequestParam(value="fileid") String fileid) {
	    
	//  파일 아이디로 쿼리 조회하여 전체경로 받은 후 저장
	String final_FILE_PATH =FILE_PATH+"/"+"1ef64a7b-30be-4c8f-929b-a761b9398cf1_testzip"+".zip";
	System.out.println("_______"+final_FILE_PATH);
	//  전체 경로를 인자로 넣어 파일 객체를 생성
	    File downFile = new File(final_FILE_PATH);
	    

	    return new ModelAndView("downloadView", "downloadFile", downFile);
	}


}