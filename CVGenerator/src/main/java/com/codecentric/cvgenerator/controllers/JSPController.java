package com.codecentric.cvgenerator.controllers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.codecentric.cvgenerator.api.entities.User;
import com.codecentric.cvgenerator.api.pdfhandlers.CreatePDF;

@Controller
public class JSPController {
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
     
   
	
	@RequestMapping("/home")
    public ModelAndView jspSpringboot() {
		 logger.info("Hey man if you see this !!!");
		 
		 
		ModelAndView modelAndView = new ModelAndView("jsp-spring-boot");
	  
	  return modelAndView;
	}
	
	@RequestMapping("/test")
    public ModelAndView jspSpringboot_test() {
		 logger.info("Hey man if you see this !!!");
		 
		 
		ModelAndView modelAndView = new ModelAndView("test");
	  
	  return modelAndView;
	}
	
	
	
	@RequestMapping(value = "/result", method = RequestMethod.POST)
    public void result(@ModelAttribute("user")User userID,
    		HttpServletRequest request,
    		HttpServletResponse response) throws IOException {
		
	  final ServletContext servletContext = request.getSession().getServletContext();
	  final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
	  final String temperotyFilePath = tempDirectory.getAbsolutePath();
        
	    CreatePDF create_document = new CreatePDF(userID); 
	    
	    
	    String fileName = "JavaHonk.pdf";
	    response.setContentType("application/pdf");
	    response.setHeader("Content-disposition", "attachment; filename="+ fileName);

	    try {

	        create_document.createPDF(temperotyFilePath+"\\"+fileName);
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        baos = convertPDFToByteArrayOutputStream(temperotyFilePath+"\\"+fileName);
	        OutputStream os = response.getOutputStream();
	        baos.writeTo(os);
	        os.flush();
	    } catch (Exception e1) {
	        e1.printStackTrace();
	    }
        
        
  }
  
  private ByteArrayOutputStream convertPDFToByteArrayOutputStream(String fileName) {

		InputStream inputStream = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {

			inputStream = new FileInputStream(fileName);
			byte[] buffer = new byte[1024];
			baos = new ByteArrayOutputStream();

			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesRead);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return baos;
	}
  
    
}
