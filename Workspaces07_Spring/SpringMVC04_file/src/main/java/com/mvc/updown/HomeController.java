package com.mvc.updown;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.mvc.updown.validate.FileValidator;
import com.mvc.updown.validate.UploadFile;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private FileValidator fileValidator;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/form")
	public String uploadForm() {
		return "upload";
	}
	
	@RequestMapping("/upload")
	public String fileUpload(HttpServletRequest request, Model model, UploadFile uploadFile, BindingResult result) {
		
		// BindingResult : validate에 오류가 있으면 다시 upload로 이동. 이후 명령으로 이동하지 못하게 붙잡는 역할
		fileValidator.validate(uploadFile, result);
		// upload.jsp에 form:errors랑 자동으로 연결
        if(result.hasErrors()) {
            return "upload";
        }
        
        MultipartFile file = uploadFile.getMpfile();
        String name = file.getOriginalFilename(); 
        
        // UploadFile의 setter에 값 주입
        UploadFile fileObj = new UploadFile(); 
        fileObj.setName(name);
        fileObj.setDesc(uploadFile.getDesc());
        
        InputStream inputStream = null; 
        OutputStream outputStream = null;
        
        try {
            inputStream = file.getInputStream();
            String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");
            System.out.println("업로드 실제 경로 : "+path);
            
            // 경로가 없으면(경로에 폴더가 없으면) 만들겠다.
            File storage = new File(path); 
            if(!storage.exists()) {
                storage.mkdirs();
            }
            
            // 경로에 파일이 없으면 만들겠다.
            File newFile = new File(path+"/"+name);
            if(!newFile.exists()) {
                newFile.createNewFile();
            }
            
            outputStream = new FileOutputStream(newFile);
            
            int read = 0 ; 
            byte[] b = new byte[(int)file.getSize()];
            
            while((read=inputStream.read(b)) != -1) {
                outputStream.write(b,0,read);
            }
            
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }
        
        model.addAttribute("fileObj", fileObj);
        
        return "download";
    }
	
	//@ResponseBody : 자바의 객체, 값(down)을 response객체에 바로 넣어주는 역할
	@ResponseBody
	@RequestMapping("/download")
	public byte[] fileDownload(HttpServletRequest request, HttpServletResponse response, String name) {
		
		byte[] down = null;
		
		try {
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "resources/storage");
			File file = new File(path + "/" + name);
			
			// FileCopyUtils : 파일및 스트림복사를 위한 간단한 유틸리티 메소드의 집합체
			// copyToByteArray : 지정한 inputStream의 내용을 카피하고 완료하면 stream을 닫음
			down = FileCopyUtils.copyToByteArray(file);
			String filename = new String(file.getName().getBytes(), "8859_1");
			
			// Content-Disposition : attachment -> file download 설정 (filename 설정)
			response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
			response.setContentLength(down.length);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return down;
	}
	
}
