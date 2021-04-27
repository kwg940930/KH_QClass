package com.hello.mvc2;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hello.mvc2.dto.AddressDto;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/command.do", method=RequestMethod.GET)
	public String getCommand(Model model, @RequestParam("name") String name, String addr, String phone) {
		
		model.addAttribute("dto", new AddressDto(name, addr, phone));
		
		return "get";
	}
	
	@RequestMapping(value="/command.do", method=RequestMethod.POST)
	public String postCommand(Model model, @ModelAttribute AddressDto dto) {
		
		model.addAttribute("dto", dto);
		
		return "post";
	}
	
	@RequestMapping("/void.do")
	public void voidPage(Model model) {
		model.addAttribute("message", "viewname 안써도 넘어갑니다.");
	}
	
	
}
