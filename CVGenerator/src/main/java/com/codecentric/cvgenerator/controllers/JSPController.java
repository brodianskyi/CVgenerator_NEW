package com.codecentric.cvgenerator.controllers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.codecentric.cvgenerator.api.entities.Ausbildung;
import com.codecentric.cvgenerator.api.entities.User;
import com.codecentric.cvgenerator.api.entities.helpers.AusbildungHelper;
import com.codecentric.cvgenerator.api.pdfhandlers.CreatePDF;
import com.codecentric.cvgenerator.model.AusbildungDao;
import com.codecentric.cvgenerator.model.UserDao;




@Controller
public class JSPController {
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	 @Autowired
	 private UserDao userDao;
	 @Autowired
	 private AusbildungDao ausbildungDao;
   
	
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
    		@ModelAttribute("ausbildung_helper")AusbildungHelper ausbildungHelper,
    		HttpServletRequest request,
    		HttpServletResponse response) throws IOException {
		
	  final ServletContext servletContext = request.getSession().getServletContext();
	  final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
	  final String temperotyFilePath = tempDirectory.getAbsolutePath();
	
	    CreatePDF create_document = new CreatePDF(userID,ausbildungHelper); 
	  
	    String fileName = "JavaHonk.pdf";
	    response.setContentType("application/pdf");
	    response.setHeader("Content-disposition", "attachment; filename="+ fileName);

	    try {
	    	Ausbildung ausbildung = null;
	        create_document.createPDF(temperotyFilePath+"\\"+fileName);
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        baos = convertPDFToByteArrayOutputStream(temperotyFilePath+"\\"+fileName);
	        OutputStream os = response.getOutputStream();
	        baos.writeTo(os);
	        
	        for(int i = 0; i < ausbildungHelper.getAusbildung_begin().size(); i++){
	        	
	        	ausbildung = new Ausbildung(ausbildungHelper.getAusbildung_begin().get(i), 
	        			ausbildungHelper.getAusbildung_end().get(i), 
	        			ausbildungHelper.getAusbildung_ort().get(i), 
	        			ausbildungHelper.getAusbildung_stelle().get(i));
	        	        userID.addAusbildung(ausbildung); 
	        }
	      
	  
	        addUserData(userID);
	        addAusbildungData(userID);
	        os.flush();
	    } catch (Exception e1) {
	        e1.printStackTrace();
	    } 
  }
  
	public String addAusbildungData(User user) {
		 try {
			
			 ausbildungDao.save(user.getAusbildung());
			
		    }catch (Exception e) {
	        	return "Error creating ausbildung table: " + e.toString();
	        }
		 return "Ausbildung succesfully created!!!"; 
	}
	
	public String addUserData(User user) {
		 try {
			 userDao.save(user);
	
		    }catch (Exception e) {
	        	return "Error creating the user: " + e.toString();
	        }
		 return "User succesfully created! (id = " + user.getUser_id() + ")"; 
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
